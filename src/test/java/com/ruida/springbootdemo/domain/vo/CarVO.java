package com.ruida.springbootdemo.domain.vo;

import lombok.Data;

/**
 * @author chenjy
 * @since 2021/1/23 13:35
 */
@Data
public class CarVO {
    
    private String id;

    private String brandName;
    
    private String price;

    private String color;
    
    private String publishedDate;

    private DriverVO driverVO;

    private Boolean hasDriver;
    
}
