package com.example.takeout.mapper;

import com.example.takeout.entity.Restaurant;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * RestaurantMapper继承基类
 */
@Repository
public interface RestaurantMapper extends MyBatisBaseDao<Restaurant, Integer> {


    int updateMerchantsInfo(Restaurant restaurant);

    @Select(value = {"SELECT * FROM restaurant"})
    List<Restaurant> findAllRestaurant();

    @Select(value = {"SELECT COUNT(restaurant_id) FROM restaurant"})
    int findRestaurantCount();

    Restaurant selectByPrimaryKey(Integer id);
}