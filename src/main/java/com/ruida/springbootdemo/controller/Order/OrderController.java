package com.ruida.springbootdemo.controller.Order;

import com.ruida.springbootdemo.entity.Order;
import com.ruida.springbootdemo.service.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    OrderService orderService;

    @RequestMapping("queryOrder/{orderId}")
    public Order queryOrder(@PathVariable Integer orderId){
        return orderService.queryOrder(orderId);
    }
}
