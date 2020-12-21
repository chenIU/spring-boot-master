package com.ruida.springbootdemo.stream;

import com.google.common.collect.Lists;
import com.ruida.springbootdemo.entity.User;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: filter的作用是留下满足条件的元素
 * @author: chenjy
 * @create: 2020-12-21 14:17
 */
public class StreamFilterTest {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //保留所有的偶数
        integerList.stream().filter(x -> x%2 == 0).collect(Collectors.toList()).stream().forEach(System.out::println);

        //保留所有年龄大于20岁的用户
        List<User> userList = Lists.newArrayList(
                new User("chenjy",26),
                new User("liuxy",22),
                new User("chensx",16)
        );
        userList.stream().filter(x -> x.getAge() > 20).collect(Collectors.toList()).stream().forEach(System.out::println);
    }
}
