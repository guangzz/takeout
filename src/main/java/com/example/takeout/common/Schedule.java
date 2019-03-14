package com.example.takeout.common;

import com.example.takeout.mapper.OrdersMapper;
import com.example.takeout.mapper.PreferentialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private PreferentialMapper preferentialMapper;

    /**
     * 扫描过期的订单,将超过有效时间的订单状态修改
     */
    @Scheduled(fixedDelay = 5000)
    public void start(){
        ordersMapper.updateOverdueOrders();
    }

    /**
     * 扫描活动表,将过期的活动从数据库删除
     */
    @Scheduled(fixedDelay = 5000)
    public void deletePreferentia(){
        preferentialMapper.deletePreferentia();
    }


}
