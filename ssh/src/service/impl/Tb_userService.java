package service.impl;

import java.util.List;

import model.Tb_user;

import org.springframework.transaction.annotation.Transactional;

import service.interf.ITb_userService;
import dao.interf.ITb_userDao;

public class Tb_userService implements ITb_userService
{
	private ITb_userDao dao;

	public ITb_userDao getDao()
	{
		return dao;
	}

	public void setDao(ITb_userDao dao)
	{
		this.dao = dao;
	}

	@Override
	@Transactional
	public void delete(Tb_user model)
	{
		dao.delete(model);
	}

	@Override
	@Transactional
	public void deleteById(int id)
	{
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public Tb_user get(int id)
	{
		return dao.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List getAll()
	{
		return dao.getAll();
	}

	@Override
	@Transactional
	public void save(Tb_user model)
	{
		dao.save(model);
	}

	@Override
	@Transactional
	public void update(Tb_user model)
	{
		dao.update(model);
	}

}