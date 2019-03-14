package com.example.takeout.vo;

import com.example.takeout.entity.Orders;

public class OrdersVO extends Orders {
    private String restaurantName;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
}
