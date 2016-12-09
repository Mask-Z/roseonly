package com.mask.dao;

import com.mask.bean.Indent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mr丶周 on 2016/12/9.
 */
@Repository
public interface IndentDaoI extends JpaRepository<Indent,Integer> {
}
