package com.ruida.springbootdemo.component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * 1.ignoreInvalidFields：忽略无法转换的属性(默认false) 如:string-->boolean
 * 2.ignoreUnknownFields：忽略位置的属性(默认true)
 * 3.此注解通过属性的set方法设置值
 * @author: chenjy
 * @create: 2020-10-30 16:28
 */
@Component
@Setter
@Getter
@ToString
@Validated
@ConfigurationProperties(prefix = "app.mail",ignoreInvalidFields = true)
public class MailModuleProperties {

    @NotNull private Boolean enabled;

    @NotEmpty private String defaultSubject;

    private List<String> smtpServer;

    @DurationUnit(ChronoUnit.SECONDS)
    private Duration pauseBetweenMails;

    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize maxAttachmentSize;

    //启动前校验(@Validated,@NotNull,@NotEmpty)

    //smtpServer：复杂属性类型

    //Duration 不写单位，默认毫秒

    //DataSize 默认byte
}
