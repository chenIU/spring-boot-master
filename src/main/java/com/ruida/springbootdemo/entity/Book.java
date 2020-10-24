package com.ruida.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
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

    @TableField(select = false)
    private BigDecimal price;

    private StatusEnum status;

    @Version
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    private Integer deleted;
}
