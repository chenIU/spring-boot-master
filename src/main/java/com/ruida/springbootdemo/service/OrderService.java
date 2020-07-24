package com.ruida.springbootdemo.service;

import com.ruida.springbootdemo.entity.Order;

public interface OrderService {

    Order queryOrder(Integer orderId);
}
