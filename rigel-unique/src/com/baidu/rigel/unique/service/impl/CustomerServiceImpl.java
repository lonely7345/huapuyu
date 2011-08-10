package com.baidu.rigel.unique.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.rigel.platform.dao.SqlMapDao;
import com.baidu.rigel.platform.service.impl.GenericSqlMapServiceImpl;
import com.baidu.rigel.unique.bo.Customer;
import com.baidu.rigel.unique.dao.CustomerDao;
import com.baidu.rigel.unique.service.CustomerService;
import com.baidu.rigel.unique.utils.Constant;
import com.baidu.rigel.unique.utils.CustType;
import com.baidu.rigel.unique.utils.FieldConstant;
import com.baidu.rigel.unique.utils.MsgConstant;
import com.baidu.rigel.unique.utils.Utils;

@Service("customerService")
public class CustomerServiceImpl extends GenericSqlMapServiceImpl<Customer, Long> implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public List<Long> equalCustFullName(String custFullName) {
		if (Utils.isNull(custFullName))
			return new ArrayList<Long>(0);
		return customerDao.selectCustIdByCustFullName(custFullName);
	}

	public Customer findById(Long id) {
		if (Utils.isNull(id))
			return null;
		return customerDao.findById(id);
	}

	public List<Long> equalCustBranchNameOrCustName(String name, CustType custType) {
		if (Utils.isNull(name) || Utils.isNull(custType))
			return new ArrayList<Long>(0);
		switch (custType) {
		case SPECIAL_ENTERPRISE:
			return customerDao.selectCustIdByCustName(name, custType);
		case ADVERTISING_AGENCY:
			return customerDao.selectCustIdByCustBranchName(name, custType);
		default:
			throw new IllegalArgumentException(MsgConstant.CUSTOMER_SERVICE_PARAM_CUSTTYPE);
		}
	}

	public Map<Long, Long> findCustIdPosIdByCustIds(Long... custIds) {
		Map<Long, Long> resultMap = new HashMap<Long, Long>();

		if (Utils.isEmpty(custIds))
			return resultMap;

		List<Map<String, Long>> list = customerDao.selectCustIdPoseIdByCustIdList(Arrays.asList(custIds));

		if (CollectionUtils.isNotEmpty(list))
			for (Map<String, Long> map : list)
				resultMap.put(map.get(FieldConstant.CUST_ID), map.get(FieldConstant.POSE_ID));

		return resultMap;
	}

	public Map<Long, String> findCustIdFullNameByCustIds(Long... custIds) {
		Map<Long, String> resultMap = new HashMap<Long, String>();

		if (Utils.isEmpty(custIds))
			return resultMap;

		List<Map<String, Object>> list = customerDao.selectCustIdFullNameByCustIdList(Arrays.asList(custIds));

		if (CollectionUtils.isNotEmpty(list))
			for (Map<String, Object> map : list)
				resultMap.put((Long) map.get(FieldConstant.CUST_ID), (String) map.get(FieldConstant.CUST_FULL_NAME));

		return resultMap;
	}

	public boolean isCustIdsExist(List<Long> custIdList, Long posId, Long custId) {
		if (CollectionUtils.isEmpty(custIdList))
			return Boolean.FALSE;

		return Utils.isGreaterThanZero(customerDao.selectCountByCustIdListPoseIdCustId(custIdList, posId, custId));
	}

	public List<Map<String, Object>> findCustomerFollowDistributeByCustIdList(List<Long> custIdList) {
		if (CollectionUtils.isEmpty(custIdList))
			return new ArrayList<Map<String, Object>>(0);
		return customerDao.selectCustomerFollowDistributeByCustIdList(custIdList);
	}

	public Map<String, Object> findCustIdFullNamePoseIdInputTypeByCustId(Long custId) {
		if (Utils.isNull(custId) || Utils.isEqualZero(custId))
			return new HashMap<String, Object>();
		Map<String, Object> map = customerDao.selectCustIdFullNamePoseIdInputTypeByCustId(custId);
		if (Utils.isNull(map))
			return new HashMap<String, Object>();
		return map;
	}

	public List<Map<String, Object>> containCustUrlName(String custUrlName, int count) {
		if (StringUtils.isBlank(custUrlName) || Utils.isLessEqualThanZero(count))
			return new ArrayList<Map<String, Object>>(0);
		return customerDao.selectCustIdFullNameLikeByCustUrlName(Utils.addRightWildcard(Utils.escapeWildcard(custUrlName)), count);
	}

	public List<Map<String, Object>> equalCustUrlName(String custUrlName) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>(0);
		if (StringUtils.isBlank(custUrlName))
			return resultList;

		resultList = customerDao.selectCustIdFullNameByCustUrlName(custUrlName);
		if (CollectionUtils.isNotEmpty(resultList))
			for (Iterator<Map<String, Object>> it = resultList.iterator(); it.hasNext();) {
				Map<String, Object> map = it.next();
				Long count = customerDao.selectCountByCustIdStat1((Long) map.get(FieldConstant.CUST_ID), Constant.SALE_SIGN);
				if (Utils.isGreaterThanZero(count))
					it.remove();
			}

		return resultList;
	}

	public List<Map<String, Object>> equalDomain(String domain) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>(0);
		if (StringUtils.isBlank(domain))
			return resultList;

		resultList = customerDao.selectCustIdFullNameByDomain(domain);
		if (CollectionUtils.isNotEmpty(resultList))
			for (Iterator<Map<String, Object>> it = resultList.iterator(); it.hasNext();) {
				Map<String, Object> map = it.next();
				Long count = customerDao.selectCountByCustIdStat1((Long) map.get(FieldConstant.CUST_ID), Constant.SALE_SIGN);
				if (Utils.isGreaterThanZero(count))
					it.remove();
			}

		return resultList;
	}

	public List<Map<String, Object>> containDomain(String domain) {
		if (StringUtils.isBlank(domain))
			return new ArrayList<Map<String, Object>>(0);

		domain = Utils.addRightWildcard(Utils.escapeWildcard(domain));
		if (Utils.isLessEqualThanZero(domain.length()))
			return new ArrayList<Map<String, Object>>(0);

		return customerDao.selectCustIdFullNameLikeByDomain(domain);
	}

	@Override
	public SqlMapDao<Customer, Long> getDao() {
		return customerDao;
	}

	public void delete(Long custId) {
		if (Utils.isNull(custId))
			return;

		customerDao.delete(custId);
	}
}