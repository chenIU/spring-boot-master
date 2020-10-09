package com.ruida.springbootdemo.service.impl;

import com.ruida.springbootdemo.entity.Order;
import com.ruida.springbootdemo.mapper.OrderMapper;
import com.ruida.springbootdemo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Resource
    OrderMapper orderMapper;

    @Override
    public Order queryOrder(Integer orderId) {
        return orderMapper.queryOrder(orderId);
    }
}
