package com.ruida.springbootdemo.test;

import com.google.common.collect.Lists;
import com.ruida.springbootdemo.entity.Room;
import org.junit.Test;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @desc 测试Collections工具类的常用方法
 * @author chenjy
 * @since 2020/12/26 22:13
 */
public class CollectionsTest {

    /**
     * 向集合中添加元素
     */
    @Test
    public void addAll(){
        List<String> list = Lists.newArrayList("刘备");
        Collections.addAll(list,"关羽","张飞");
        System.out.println(list);
    }

    /**
     * 反转集合
     */
    @Test
    public void reverse(){
        List<String> list = Lists.newArrayList("刘备","关羽","张飞");
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);
    }

    /**
     * 对集合进行排序
     */
    @Test
    public void sort(){
        List<String> list = Lists.newArrayList("tom","mike","jack");
        Collections.sort(list);
        System.out.println(list);

        List<Room> roomList = Lists.newArrayList(
                new Room(String.valueOf(5.00), 4.00, 2.00),
                new Room(String.valueOf(5.00), 4.01, 3.01),
                new Room(String.valueOf(6.00), 4.01, 5.00),
                new Room(String.valueOf(6.00), 4.01, 4.50),
                new Room(String.valueOf(6.00), 4.01, 6.00),
                new Room(String.valueOf(7.00), 4.02, 3.05)
        );
        System.out.println("自定义类排序前:"+roomList);
        //使用实体类自带的排序规则(升序)
//        Collections.sort(roomList);

        //自定义排序规则(降序)
        //自定义的排序规则优先级高
        Collections.sort(roomList, new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return o2.getHeight().compareTo(o1.getHeight());
            }
        });
        System.out.println("自定义类排序前:"+roomList);
    }

    /**
     * 对集合中的元素进行打散(洗牌)
     */
    @Test
    public void shuffle(){
        List<String> list = Lists.newArrayList("tom","mike","jack");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }

    /**
     * 二分查找
     */
    @Test
    public void binarySearch(){
        List<String> list = Lists.newArrayList("tom","mike","jack","amy","curry");
        Collections.sort(list);
        System.out.println(list);
        int i = Collections.binarySearch(list,"curry");
        System.out.println(i);
    }
}
