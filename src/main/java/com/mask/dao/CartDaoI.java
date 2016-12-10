package com.mask.dao;


import com.mask.bean.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mr丶周 on 2016/12/6.
 */
public interface CartDaoI extends JpaRepository<Cart,Integer> {

}
