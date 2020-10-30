package com.ruida.springbootdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruida.springbootdemo.entity.Order;

public interface OrderService extends IService<Order> {

    Order queryOrder(Integer orderId);
}
