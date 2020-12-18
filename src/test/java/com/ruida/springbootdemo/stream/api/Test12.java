package com.ruida.springbootdemo.stream.api;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.ruida.springbootdemo.entity.Room;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: 分组分片
 * @author: chenjy
 * @create: 2020-12-18 14:31
 */
public class Test12 {
    public static void main(String[] args) {
        List<Room> roomList = Lists.newArrayList(
                new Room(String.valueOf(5.00),4.00,3.00),
                new Room(String.valueOf(5.00),4.01,3.01),
                new Room(String.valueOf(6.00),4.01,3.01),
                new Room(String.valueOf(6.00),4.01,3.01),
                new Room(String.valueOf(6.00),4.01,3.01),
                new Room(String.valueOf(7.00),4.02,3.02)
        );

        //分组
        Map<String, List<Room>> collect = roomList.stream().collect(Collectors.groupingBy(Room::getLength));
        System.out.println(JSON.toJSONString(collect,true));

        //分片
        Map<Boolean, List<Room>> partition = roomList.stream().collect(Collectors.partitioningBy(x -> x.getHeight() == 3.01));
        System.out.println(JSON.toJSONString(partition,true));
    }
}
