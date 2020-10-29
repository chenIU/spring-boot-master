package com.ruida.springbootdemo.controller.order;

import com.ruida.springbootdemo.annotation.DataSource;
import com.ruida.springbootdemo.entity.Order;
import com.ruida.springbootdemo.entity.result.CommonResult;
import com.ruida.springbootdemo.entity.result.ListResult;
import com.ruida.springbootdemo.enums.DataSourceType;
import com.ruida.springbootdemo.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order/")
public class OrderController {

//    @Autowired
//    @Qualifier("orderServiceImpl")
    @Resource(name = "orderServiceImpl")
    OrderService orderService;

    @RequestMapping(value = "queryOrder/{orderId}",method = RequestMethod.GET)
    public Order queryOrder(@PathVariable Integer orderId){
        return orderService.queryOrder(orderId);
    }

    @DataSource(DataSourceType.SLAVE)
    @GetMapping("list")
    public ListResult<Order> list(){
        ListResult<Order> result = new ListResult<>();
        result.setContent(orderService.list(null));
        result.setSuccess(true);
        result.setErrorMsg("查询成功!");
        return result;
    }

    @PostMapping("add")
    public CommonResult add(@RequestBody Order order){
        orderService.save(order);
        CommonResult result = new CommonResult();
        result.setSuccess(true);
        result.setErrorMsg("插入成功!");
        return result;
    }
}
