package com.ruida.springbootdemo.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author chenjy
 * @since 2021/1/23 13:35
 */
@Data
public class CarDTO {

    private long id;

    private String brand;

    private double price;

    private String color;

    private Date publishedDate;

    private DriverDTO driverDTO;
}
