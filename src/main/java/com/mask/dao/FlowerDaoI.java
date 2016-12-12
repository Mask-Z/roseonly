package com.mask.dao;

import com.mask.bean.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Mr丶周 on 2016/12/8.
 */
@Repository
public interface FlowerDaoI extends JpaRepository<Flower,Integer> {
	//根据花名查询ID
	@Query("select f.id from Flower f where f.name=:qname")
	public int  findIdByName(@Param("qname") String name);

	//根据花名查询ID
	@Query("select f from Flower f where f.name=:qname")
	public Flower  findFlowerByName(@Param("qname") String name);
}
