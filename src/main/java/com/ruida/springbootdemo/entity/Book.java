package com.ruida.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruida.springbootdemo.enums.StatusEnum;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 1.@TableLogic：逻辑删除
 * 2.@Version：乐观锁
 */
@Data
@TableName(value = "t_book")
public class Book {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String bookName;

    private BigDecimal price;

    private StatusEnum status;

    @Version
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date updateTime;

    @TableLogic
    private Integer deleted;
}
