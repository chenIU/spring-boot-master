package com.ruida.springbootdemo.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-28 16:57
 */
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<String> list = Lists.newArrayList("a","a","b","b","c","c");

        for (int i = 0; i < list.size(); i++) {
            if("b".equals(list.get(i))){
                list.remove(i);
            }
        }
        System.out.println(list);

        //原因：System.arraycopy,在进行数据移除的时候,是对原数组进行拷贝
    }

    @Test
    public void test(){
        ArrayList<Integer> list1 = Lists.newArrayList(1,2,3);
        ArrayList<Integer> list2 = Lists.newArrayList(0,1,2,3,4,5);
        list2.removeAll(list1);
        System.out.println(list2);

        //removeAll可以理解为批量移除,先求两个集合的交集,移除之,保留剩下的部分

        list2.clear();
        System.out.println(list2);
        System.out.println(list2 == null);
        //clear即是字面意思,将集合中所有元素清空
    }

    @Test
    public void test3(){
        List<Integer> list = Lists.newArrayList(10,8,20,3,89,30);
        list = list.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public  void  test4(){
        List<Integer>  list  = Lists.newArrayList();
        for(int i=1;i<=5;i++){
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==3)
                list.remove(integer);
        }
    }

    @Test
    public void test5() {
        List<Integer> list = Lists.newArrayList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2)
                iterator.remove();
        }
    }

    /**
     * int getDays(int month){
     *         if (month == 1)  return 31;
     *         if (month == 2)  return 29;
     *         if (month == 3)  return 31;
     *         if (month == 4)  return 30;
     *         if (month == 5)  return 31;
     *         if (month == 6)  return 30;
     *         if (month == 7)  return 31;
     *         if (month == 8)  return 31;
     *         if (month == 9)  return 30;
     *         if (month == 10)  return 31;
     *         if (month == 11)  return 30;
     *         if (month == 12)  return 31;
     *     }
     */
    int[] monthDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    int getDays(int month){
        return monthDays[--month];
    }

    @Test
    public void test6(){
        System.out.println(getDays(2));
    }
}
