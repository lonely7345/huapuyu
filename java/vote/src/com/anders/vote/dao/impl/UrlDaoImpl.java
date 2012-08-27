package com.anders.vote.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anders.vote.bo.Url;
import com.anders.vote.dao.UrlDao;
import com.anders.vote.mapper.GenericMapper;
import com.anders.vote.mapper.UrlMapper;

@Repository
public class UrlDaoImpl extends GenericDaoImpl<Long, Url> implements UrlDao {

	@Autowired
	private UrlMapper urlMapper;

	public UrlMapper getUrlMapper() {
		return urlMapper;
	}

	public void setUrlMapper(UrlMapper urlMapper) {
		this.urlMapper = urlMapper;
	}

	@Override
	public GenericMapper<Long, Url> getMapper() {
		return urlMapper;
	}

}