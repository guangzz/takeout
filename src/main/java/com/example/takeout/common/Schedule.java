package com.example.takeout.common;

import com.example.takeout.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {

    @Autowired
    private OrdersMapper ordersMapper;

    @Scheduled(fixedDelay = 5000)
    public void start(){
        ordersMapper.updateOverdueOrders();
    }




}
