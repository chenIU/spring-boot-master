package com.ruida.springbootdemo.stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.ruida.springbootdemo.entity.Room;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-28 15:43
 */
public class FinalStreamTest {

    public static void main(String[] args) {
        Random random = new Random();
        //random.ints().limit(10).sorted().forEach(System.out::println);

        List<String> strList = Arrays.asList("abc","bcd","eee","aaa");

        List<String> filterList = strList.stream().filter(x -> x.startsWith("a")).collect(Collectors.toList());
        filterList.forEach(System.out::println);

        String merge = strList.stream().filter(x -> x.startsWith("a")).collect(Collectors.joining(","));
        System.out.println(merge);

        //统计
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics statistics = numbers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("最大的数："+statistics.getMax());
        System.out.println("最小的数："+statistics.getMin());
        System.out.println("求和："+statistics.getSum());
        System.out.println("平均数："+statistics.getAverage());
        System.out.println(statistics);

        //聚合操作
        List<Integer> hearList = Lists.newArrayList();
        hearList.add(15);
        hearList.add(32);
        hearList.add(5);
        hearList.add(232);
        hearList.add(56);
        hearList.add(29);
        hearList.add(94);
        Integer maxItem = hearList.stream().max(Integer::compareTo).get();
        Integer minItem = hearList.stream().min(Integer::compareTo).get();
        System.out.println("max:"+maxItem+"，min:"+minItem);

        //收集结果
        //1.收集到List
        List<Integer> thereList = hearList.stream().collect(Collectors.toList());

        //2.收集到Set
        Set<Integer> thereSet = hearList.stream().collect(Collectors.toSet());

        //3.收集到集合并指定集合的类型
        TreeSet<Integer> treeSet = hearList.stream().collect(Collectors.toCollection(TreeSet::new));

        //收集到map
        List<Room> roomList = Lists.newArrayList(
          new Room(String.valueOf(5.00),4.00,3.00),
          new Room(String.valueOf(5.01),4.01,3.01),
          new Room(String.valueOf(5.02),4.02,3.02)
        );

        //利用对象的属性作为map的key和value
        Map<String,Double> map = roomList.stream().collect(Collectors.toMap(Room::getLength,Room::getWidth));
        System.out.println(JSON.toJSONString(map));

        //利用对象本身作为map的value(这种情况居多)
        Map<String,Room> rooMap = roomList.stream().collect(Collectors.toMap(Room::getLength, Function.identity()));
        System.out.println(JSON.toJSONString(rooMap,true));

        //当key重复时，可以通过Collectors.toMap的第三个参数来指定保留逻辑
        Map<String,Room> newMap = roomList.stream().collect(Collectors.toMap(Room::getLength, Function.identity(),(oldValue,newValue) -> newValue));
        System.out.println(JSON.toJSONString(newMap,true));

        //生成指定类型的map
        TreeMap<String,Room> defMap = roomList.stream().collect(Collectors.toMap(Room::getLength, Function.identity(),(oldValue,newValue) -> newValue,TreeMap::new));
        System.out.println(JSON.toJSONString(defMap,true));

        //分组分片
        List<Room> secondRoomList = Lists.newArrayList(
                new Room(String.valueOf(5.00),4.00,3.00),
                new Room(String.valueOf(5.00),4.01,3.01),
                new Room(String.valueOf(6.00),4.01,3.01),
                new Room(String.valueOf(6.00),4.01,3.01),
                new Room(String.valueOf(6.00),4.01,3.01),
                new Room(String.valueOf(7.00),4.02,3.02)
        );

        //1.分组
        Map<String,List<Room>> groupMap = secondRoomList.stream().collect(Collectors.groupingBy(Room::getLength));
        System.out.println(JSON.toJSONString(groupMap,true));

        //2.分片
        Map<Boolean,List<Room>> partitionMap = secondRoomList.stream().collect(Collectors.partitioningBy(x -> x.getHeight() == 3.01));
        System.out.println(JSON.toJSONString(partitionMap,true));
    }
}
