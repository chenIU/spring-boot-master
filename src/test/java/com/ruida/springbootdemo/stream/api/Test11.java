package com.ruida.springbootdemo.stream.api;

import com.google.common.collect.Lists;
import com.ruida.springbootdemo.entity.Room;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: 收集聚合
 * @author: chenjy
 * @create: 2020-12-17 17:32
 */
public class Test11 {
    public static void main(String[] args) {
        List<Integer> hereList = Lists.newArrayList();
        hereList.add(15);
        hereList.add(32);
        hereList.add(5);
        hereList.add(232);
        hereList.add(56);
        hereList.add(29);
        hereList.add(104);

        //总和、平均值，最大值，最小值
        int sum = hereList.stream().collect(Collectors.summingInt(Integer::intValue));
        Double ave = hereList.stream().collect(Collectors.averagingInt(Integer::intValue));
        Integer max = hereList.stream().collect(Collectors.maxBy(Integer::compare)).get();
        Integer min = hereList.stream().collect(Collectors.minBy(Integer::compare)).get();
        System.out.println("sum:"+sum+",ave:"+ave+",max:"+max+",min:"+min);

        List<Room> roomList = Lists.newArrayList(
                new Room(String.valueOf(5.00),4.00,3.00),
                new Room(String.valueOf(5.01),4.01,3.01),
                new Room(String.valueOf(5.02),4.02,3.02)
        );
        Map<String,Double> roomMap = roomList.stream().collect(Collectors.toMap(Room::getLength,Room::getWidth));
        System.out.println(roomMap);

    }
}
