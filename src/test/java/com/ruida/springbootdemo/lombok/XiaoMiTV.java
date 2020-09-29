package com.ruida.springbootdemo.lombok;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Builder 默认构造一个包含全部参数的私有构造方法，无参构造方法消失
 * @EqualsAndHashCode(callSuper = true)表示子类使用父类中的属性,一般在判断两个对象的时候,不指定此属性可能会出现意想不到的问题。父类不是object的时候可以考虑需不需要指定
 * @Data = @Getter+@Setter+@RequiredArgsConstructor+@ToString+@EqualsAndHashCode
 * @author: chenjy
 * @create: 2020-09-29 09:39
 */
@Data
//@Builder
@EqualsAndHashCode(callSuper = true)
public class XiaoMiTV extends TV{

    private long price;

    private String color;

    public XiaoMiTV(int id, String name, long price, String color) {
        super(id, name);
        this.price = price;
        this.color = color;
    }
}
