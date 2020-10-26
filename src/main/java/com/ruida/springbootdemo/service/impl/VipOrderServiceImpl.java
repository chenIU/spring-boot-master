package com.ruida.springbootdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruida.springbootdemo.entity.Order;
import com.ruida.springbootdemo.mapper.OrderMapper;
import com.ruida.springbootdemo.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-26 09:41
 */
@Service
public class VipOrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    public Order queryOrder(Integer orderId) {
        return null;
    }
}
