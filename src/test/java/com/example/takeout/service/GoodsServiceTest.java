package com.example.takeout.service;

import com.alibaba.fastjson.JSON;
import com.example.takeout.common.JSONResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsServiceTest {

    @Autowired
    private GoodsService goodsService;


    @Test
    public void findProductByRestaurantTest(){
        JSONResult productByRestaurant = goodsService.findProductByRestaurant(1);

        System.out.println(JSON.toJSON(productByRestaurant));

    }
}
