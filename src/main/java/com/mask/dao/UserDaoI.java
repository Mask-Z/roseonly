package com.mask.dao;

import com.mask.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mr丶周 on 2016/12/6.
 */
@Repository
public interface UserDaoI extends JpaRepository<User, Integer> {
	@Modifying      // 说明该方法是修改操作
	@Transactional  // 说明该方法是事务性操作
	// 定义查询
	// @Param注解用于提取参数
	@Query("update User us set us.name=:qname, us.password=:qpassword, us.city=:qcity, us.role=:qrole" +
			",us.number=:qnumber,us.realname=:qrealname where us.id=:qId")
	public void updateUser(@Param("qname") String name, @Param("qpassword") String password, @Param("qcity") String city, @Param("qrole") Integer role,
						   @Param("qnumber") String number, @Param("qrealname") String realname, @Param("qId") Integer id);

	//根据用户名查询密码
	@Query("select u.password from User u where u.name=:qname")
	public String  findPassWordByName(@Param("qname") String name);


	//根据用户名查询ID
	@Query("select u.id from User u where u.name=:qname")
	public int  findIdByName(@Param("qname") String name);

	/**
	 * 根据用户名查询实体类
	 */
//	@Query("select User from User u where u.name=:qname")
//	public User  findUserByName(@Param("qname") String name);
}
