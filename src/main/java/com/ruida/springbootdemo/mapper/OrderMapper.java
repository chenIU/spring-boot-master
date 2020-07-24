package com.ruida.springbootdemo.mapper;

import com.ruida.springbootdemo.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * OrderMapper继承基类
 */
@Repository
public interface OrderMapper extends MyBatisBaseDao<Order, Integer> {

    Order queryOrder(Integer orderId);
}