package com.ruida.springbootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruida.springbootdemo.entity.Order;

/**
 * OrderMapper继承基类
 */
public interface OrderMapper extends BaseMapper<Order> {

    Order queryOrder(Integer orderId);
}