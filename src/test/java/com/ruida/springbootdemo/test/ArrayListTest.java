package com.ruida.springbootdemo.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

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
}
