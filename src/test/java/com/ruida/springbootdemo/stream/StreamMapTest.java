package com.ruida.springbootdemo.stream;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-11 13:49
 */
public class StreamMapTest {

    public static void main(String[] args) {
        List<Staff> staffList = Arrays.asList(new Staff(1,"Jack",new BigDecimal(100)),
                new Staff(2,"Mike",new BigDecimal(200)),
                new Staff(3,"Tom",new BigDecimal(300)));

        /**
         * 利用stream map抽离对象的属性
         */
        List<String> nameList = staffList.stream().map(Staff::getName).collect(Collectors.toList());
        nameList.forEach(x-> System.out.println(x));

        /**
         * 利用stream map将一个对象转换成另一个对象
         */
        List<StaffExtra> staffExtraList = staffList.stream().map(staff ->{
            StaffExtra extra = new StaffExtra();
            extra.setId(staff.getId());
            extra.setName(staff.getName());
            extra.setSalary(staff.getSalary());
            extra.setExtra("extra about "+staff.getName());
            return extra;
        }).collect(Collectors.toList());
        staffExtraList.forEach(x -> System.out.println(x));
    }
}

@Data
class Staff{
    private int id;

    private String name;

    private BigDecimal salary;

    public Staff(int id, String name, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

@Data
@EqualsAndHashCode(callSuper = false)
class StaffExtra{

    private int id;

    private String name;

    private BigDecimal salary;

    private String extra;

    public StaffExtra( ) {

    }
}
