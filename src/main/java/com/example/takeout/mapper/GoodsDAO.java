package com.example.takeout.mapper;


import com.example.takeout.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * GoodsDAO继承基类
 */
@Repository
public interface GoodsDAO extends MyBatisBaseDao<Goods, Integer> {

    public static final String TABLE = "goods";
    public static final String SELECT_FIELD = "goods_id as goodsId, type_id as typeId, goods_stock as goodsStock, goods_price as goodsPrice," +
            "goods_releaseTime as goodsReleasetime, goods_name as goodsName, goods_describe as goodsDescribe, restaurant_id as restaurantId," +
            "goods_status as goodsStatus";

    @Select(value = {"SELECT ", SELECT_FIELD, "FROM ", TABLE, " WHERE goods_status=0"})
    List<Goods> findNOtAudit();


    @Update(value = {"UPDATE ",TABLE, "SET goods_status=1 WHERE goods_id=#{goodsId}"})
    int updataStatusById(@Param("goodsId") Integer id);


    @Select(value = {"SELECT ",SELECT_FIELD, "FROM ",TABLE, "WHERE goods_id=#{goodsId}"})
    Goods findGoodsById(@Param("goodsId") Integer id);


    @Select(value = {"SELECT ", SELECT_FIELD, " FROM ", TABLE})
    List<Goods> findAllProducts();


    @Select(value = {"SELECT ",SELECT_FIELD, " FROM ", TABLE, "WHERE restaurant_id=#{restaurantID}"})
    List<Goods> findProductByRestaurant(@Param("restaurantID") Integer restaurantID);


}