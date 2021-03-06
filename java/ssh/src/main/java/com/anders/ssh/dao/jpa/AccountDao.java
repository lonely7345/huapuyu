package com.anders.ssh.dao.jpa;

import org.springframework.orm.jpa.JpaTemplate;

import com.anders.ssh.bo.test.Account;
import com.anders.ssh.dao.GenericDao;

public interface AccountDao extends GenericDao<Long, Account> {
	JpaTemplate getJpaTemplate();
}
