package com.example.takeout.mapper;

import com.example.takeout.entity.Preferential;
import org.springframework.stereotype.Repository;

/**
 * PreferentialMapper继承基类
 */
@Repository
public interface PreferentialMapper extends MyBatisBaseDao<Preferential, Integer> {

}