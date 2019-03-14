package com.example.takeout.service;

import com.example.takeout.common.JSONResult;
import com.example.takeout.entity.Goods;
import com.example.takeout.entity.Preferential;
import com.example.takeout.entity.Restaurant;
import com.example.takeout.idworker.Sid;
import com.example.takeout.mapper.GoodsDAO;
import com.example.takeout.mapper.OrdersMapper;
import com.example.takeout.mapper.PreferentialMapper;
import com.example.takeout.mapper.RestaurantMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Autowired
    private GoodsDAO goodsDAO;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private PreferentialMapper preferentialMapper;


    /**
     * 餐厅的注册申请，并随即生成一条识别码用于登陆
     * @param restaurant
     * @return
     */
    public JSONResult merchantsRegister(Restaurant restaurant){
        Sid sid = new Sid();
        restaurant.setRestaurantUser(sid.account());
        return JSONResult.ok(restaurantMapper.insert(restaurant));
    }


    /**
     * 修改餐厅基本信息
     * @param restaurant
     * @return
     */
    public JSONResult updateMerchantsInfo(Restaurant restaurant){
        int matched = restaurantMapper.updateMerchantsInfo(restaurant);
        if(matched == 1)
            return JSONResult.ok();
        else
            return JSONResult.errorMsg("修改出错了");
    }


    /**
     * 发布商品
     * @param product
     * @return
     */
    public JSONResult productRelease(Goods product){
        int count = goodsDAO.insert(product);
        if (count == 1)
            return JSONResult.ok();
        else
            return JSONResult.errorMsg("发布信息不合法");
    }


    /**
     * 添加一条优惠活动信息
     * @param preferential
     * @return
     */
    public JSONResult addPreferential(Preferential preferential){
        return JSONResult.ok(preferentialMapper.insert(preferential));
    }


    /**
     * 按照时间段查询该区间内所销售的金额
     * @param start
     * @param end
     * @return
     */
    public JSONResult findByInterval(Integer restaurantID,Timestamp start,Timestamp end){
        return JSONResult.ok(ordersMapper.findByInterval(restaurantID,start,end));
    }


    /**
     *分页查询商品
     * @param number
     * @return
     */
    public JSONResult findAllProduct(Integer number){
        PageHelper.startPage(number,10);
        List<Goods> allProducts = goodsDAO.findAllProducts();
        PageInfo<Goods> pageInfo = new PageInfo<>(allProducts, 10);
        return JSONResult.ok(pageInfo);
    }


    /**
     * 分页查询所有商家
     * @param page
     * @return
     */
    public JSONResult findAllRestaurant(Integer page){
        PageHelper.startPage(page,10);
        List<Restaurant> allRestaurant = restaurantMapper.findAllRestaurant();
        PageInfo<Restaurant> restaurantPageInfo = new PageInfo<>(allRestaurant, 10);
        return JSONResult.ok(restaurantPageInfo);
    }

    /**
     * 根据id查询商家信息
     * @param id
     * @return
     */
    public JSONResult findRestaurantById(Integer id){
        return JSONResult.ok(restaurantMapper.selectByPrimaryKey(id));
    }

}
