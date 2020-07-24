package com.ruida.springbootdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 
 * 
 */
@Data
@JsonIgnoreProperties({"createUser","createTime"})
public class Order implements Serializable {
    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 订单明细
     */
    List<OrderItem> orderItemList;
}