package com.ruida.springbootdemo.entity.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @description: 档案类型
 * @author: chenjy
 * @create: 2020-09-29 15:04
 */
@Getter
@Setter
public class ArchiveInfoRequest {

    @Range(min =1,max = 10,message = "档案类型错误")
    private Integer archiveType;

    @NotBlank(message = "档案主体名称不能为空")
    private String subjectName;

    @Email
    private String email;
}
