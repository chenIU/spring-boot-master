package com.ruida.springbootdemo.mapper;

import com.ruida.springbootdemo.entity.Order;

/**
 * OrderMapper继承基类
 */
public interface OrderMapper extends MyBatisBaseDao<Order, Integer> {

    Order queryOrder(Integer orderId);
}