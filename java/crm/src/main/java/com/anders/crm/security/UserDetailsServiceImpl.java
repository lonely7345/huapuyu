package com.anders.crm.security;

import java.util.HashSet;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.anders.crm.bo.Role;
import com.anders.crm.bo.User;
import com.anders.crm.service.RoleService;
import com.anders.crm.service.UserService;

/**
 * 用户信息Service实现类
 * 
 * @author Anders Zhu
 * 
 */
// @Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO 测试是否返回null
		User user = userService.getByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username + " is not exist");
		}

		if (StringUtils.isNotBlank(username)) {
			username = username.substring(0, username.length() - 1);
		}

		List<Role> roleList = roleService.getRolesByUsername(username);
		if (CollectionUtils.isEmpty(roleList)) {
			throw new UsernameNotFoundException(username + " has no granted authority");
		}

		// Set<GrantedAuthority> grantedAuthoritySet = new HashSet<GrantedAuthority>();
		// for (Role role : roleList)
		// grantedAuthoritySet.add(role);

		user.setAuthorities(new HashSet<GrantedAuthority>(roleList));

		return user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
}
