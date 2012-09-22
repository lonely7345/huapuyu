package com.anders.vote.security;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;

import org.apache.commons.collections.MapUtils;
import org.apache.shiro.config.Ini;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.Nameable;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.FilterChainManager;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.anders.vote.service.UrlService;

public class VoteShiroFilterFactoryBean implements FactoryBean<Object>, BeanPostProcessor {

	private static transient final Logger log = LoggerFactory.getLogger(VoteShiroFilterFactoryBean.class);

	private SecurityManager securityManager;

	private Map<String, Filter> filters;

	private Map<String, String> filterChainDefinitionMap;

	private String loginUrl;
	private String successUrl;
	private String unauthorizedUrl;

	private AbstractShiroFilter instance;

	@Autowired
	private UrlService urlService;

	public VoteShiroFilterFactoryBean() {
		this.filters = new LinkedHashMap<String, Filter>();
		this.filterChainDefinitionMap = new LinkedHashMap<String, String>();
	}

	public SecurityManager getSecurityManager() {
		return securityManager;
	}

	public void setSecurityManager(SecurityManager securityManager) {
		this.securityManager = securityManager;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getSuccessUrl() {
		return successUrl;
	}

	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}

	public String getUnauthorizedUrl() {
		return unauthorizedUrl;
	}

	public void setUnauthorizedUrl(String unauthorizedUrl) {
		this.unauthorizedUrl = unauthorizedUrl;
	}

	public Map<String, Filter> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, Filter> filters) {
		this.filters = filters;
	}

	public Map<String, String> getFilterChainDefinitionMap() {
		return filterChainDefinitionMap;
	}

	public void setFilterChainDefinitionMap(Map<String, String> filterChainDefinitionMap) {
		this.filterChainDefinitionMap = filterChainDefinitionMap;
	}

	public void setFilterChainDefinitions(String definitions) {
		Ini ini = new Ini();
		ini.load(definitions);
		Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);

		if (CollectionUtils.isEmpty(section)) {
			section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		}

		Map<String, Set<String>> urlMap = urlService.getUrlWithRoleNames();
		if (MapUtils.isNotEmpty(urlMap)) {
			for (Iterator<String> iterator = urlMap.keySet().iterator(); iterator.hasNext();) {
				String url = iterator.next();
				String roles = StringUtils.EMPTY_STRING;
				if (CollectionUtils.isEmpty(urlMap.get(url))) {
					section.put(url, "authc");
				}
				else {
					for (String role : urlMap.get(url)) {
						roles += role + ",";
					}
					roles = roles.substring(0, roles.length() - 1);
					section.put(url, String.format("authc, roles[%s]", roles));
				}
			}

		}

		setFilterChainDefinitionMap(section);
	}

	public Object getObject() throws Exception {
		if (instance == null) {
			instance = createInstance();
		}
		return instance;
	}

	public Class<SpringShiroFilter> getObjectType() {
		return SpringShiroFilter.class;
	}

	public boolean isSingleton() {
		return true;
	}

	protected FilterChainManager createFilterChainManager() {

		DefaultFilterChainManager manager = new DefaultFilterChainManager();
		Map<String, Filter> defaultFilters = manager.getFilters();
		for (Filter filter : defaultFilters.values()) {
			applyGlobalPropertiesIfNecessary(filter);
		}

		Map<String, Filter> filters = getFilters();
		if (!CollectionUtils.isEmpty(filters)) {
			for (Map.Entry<String, Filter> entry : filters.entrySet()) {
				String name = entry.getKey();
				Filter filter = entry.getValue();
				applyGlobalPropertiesIfNecessary(filter);
				if (filter instanceof Nameable) {
					((Nameable) filter).setName(name);
				}
				manager.addFilter(name, filter, false);
			}
		}

		Map<String, String> chains = getFilterChainDefinitionMap();
		if (!CollectionUtils.isEmpty(chains)) {
			for (Map.Entry<String, String> entry : chains.entrySet()) {
				String url = entry.getKey();
				String chainDefinition = entry.getValue();
				manager.createChain(url, chainDefinition);
			}
		}

		return manager;
	}

	protected AbstractShiroFilter createInstance() throws Exception {

		log.debug("Creating Shiro Filter instance.");

		SecurityManager securityManager = getSecurityManager();
		if (securityManager == null) {
			String msg = "SecurityManager property must be set.";
			throw new BeanInitializationException(msg);
		}

		if (!(securityManager instanceof WebSecurityManager)) {
			String msg = "The security manager does not implement the WebSecurityManager interface.";
			throw new BeanInitializationException(msg);
		}

		FilterChainManager manager = createFilterChainManager();

		PathMatchingFilterChainResolver chainResolver = new PathMatchingFilterChainResolver();
		chainResolver.setFilterChainManager(manager);

		return new SpringShiroFilter((WebSecurityManager) securityManager, chainResolver);
	}

	private void applyLoginUrlIfNecessary(Filter filter) {
		String loginUrl = getLoginUrl();
		if (StringUtils.hasText(loginUrl) && (filter instanceof AccessControlFilter)) {
			AccessControlFilter acFilter = (AccessControlFilter) filter;
			String existingLoginUrl = acFilter.getLoginUrl();
			if (AccessControlFilter.DEFAULT_LOGIN_URL.equals(existingLoginUrl)) {
				acFilter.setLoginUrl(loginUrl);
			}
		}
	}

	private void applySuccessUrlIfNecessary(Filter filter) {
		String successUrl = getSuccessUrl();
		if (StringUtils.hasText(successUrl) && (filter instanceof AuthenticationFilter)) {
			AuthenticationFilter authcFilter = (AuthenticationFilter) filter;
			String existingSuccessUrl = authcFilter.getSuccessUrl();
			if (AuthenticationFilter.DEFAULT_SUCCESS_URL.equals(existingSuccessUrl)) {
				authcFilter.setSuccessUrl(successUrl);
			}
		}
	}

	private void applyUnauthorizedUrlIfNecessary(Filter filter) {
		String unauthorizedUrl = getUnauthorizedUrl();
		if (StringUtils.hasText(unauthorizedUrl) && (filter instanceof AuthorizationFilter)) {
			AuthorizationFilter authzFilter = (AuthorizationFilter) filter;
			String existingUnauthorizedUrl = authzFilter.getUnauthorizedUrl();
			if (existingUnauthorizedUrl == null) {
				authzFilter.setUnauthorizedUrl(unauthorizedUrl);
			}
		}
	}

	private void applyGlobalPropertiesIfNecessary(Filter filter) {
		applyLoginUrlIfNecessary(filter);
		applySuccessUrlIfNecessary(filter);
		applyUnauthorizedUrlIfNecessary(filter);
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Filter) {
			log.debug("Found filter chain candidate filter '{}'", beanName);
			Filter filter = (Filter) bean;
			applyGlobalPropertiesIfNecessary(filter);
			getFilters().put(beanName, filter);
		}
		else {
			log.trace("Ignoring non-Filter bean '{}'", beanName);
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	private static final class SpringShiroFilter extends AbstractShiroFilter {

		protected SpringShiroFilter(WebSecurityManager webSecurityManager, FilterChainResolver resolver) {
			super();
			if (webSecurityManager == null) {
				throw new IllegalArgumentException("WebSecurityManager property cannot be null.");
			}
			setSecurityManager(webSecurityManager);
			if (resolver != null) {
				setFilterChainResolver(resolver);
			}
		}
	}
}
