package com.mask.dao;

import com.mask.bean.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mr丶周 on 2016/12/8.
 */
@Repository
public interface FlowerDaoI extends JpaRepository<Flower,Integer> {
}
