package com.vipshop.mybatis.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.vipshop.mybatis.bo.User;

public interface UserMapper  {
	@Insert("insert into $[user]$ (id, name) values (#{id}, #{name})")
	void save(User User);

	@Delete("DELETE FROM $[user]$ WHERE id = #{id}")
	void deleteById(Long id);

	@Select("SELECT * FROM $[user]$ WHERE id = #{id}")
	@Results({ @Result(property = "id", column = "id"), @Result(property = "name", column = "name") })
	User getById(Long id);

	@Update("update $[user]$ set name = #{name} where id = #{id}")
	void update(User user);
}
