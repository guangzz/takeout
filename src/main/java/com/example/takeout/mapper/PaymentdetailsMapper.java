package com.example.takeout.mapper;

import com.example.takeout.entity.Paymentdetails;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * PaymentdetailsMapper继承基类
 */
@Repository
public interface PaymentdetailsMapper extends MyBatisBaseDao<Paymentdetails, Integer> {

    public static final String TABLE = "paymentdetails";

    public static final String SELECT_FIELD =
    "payment_details_id as paymentDetailsId, user_id as userId, order_money as orderMoney, status as status, order_id as orderId";


//    @Update(value = {"UPDATE ", TABLE, " SET status=501 WHERE order_id=#{orderID}"})
//    int refund(@Param("orderID") Integer orderID);

    @Select(value = {"SELECT ",SELECT_FIELD, " FROM ", TABLE, " WHERE order_id=#{orderID}"})
    Paymentdetails findPaymentById(@Param("orderID") Integer id);


    int updateByPrimaryKeySelective(Paymentdetails paymentdetails);


    @Select(value = {"SELECT SUM(order_money) FROM ",TABLE, " WHERE status!=501 AND user_id=#{userID}"})
    BigDecimal consumption(@Param("userID") Integer userId);
}