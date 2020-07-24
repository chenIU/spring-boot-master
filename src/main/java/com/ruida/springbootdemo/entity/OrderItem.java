package com.ruida.springbootdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.Date;

@Data
@JsonIgnoreProperties({"orderId","createUser","createTime"})
public class OrderItem {

    private Integer itemId;

    private Integer orderId;

    private String itemName;

    private Integer createUser;

    private Date createTime;
}
