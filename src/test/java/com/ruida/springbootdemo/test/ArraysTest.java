package com.ruida.springbootdemo.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-28 13:58
 */
public class ArraysTest {
    public static void main(String[] args) {
        String[][] arr = new String[2][2];
        arr[0][0] = "a";
        arr[0][1] = "b";
        arr[1][0] = "c";
        arr[1][1] = "d";
        System.out.println(Arrays.deepToString(arr));

        String[] ss = new String[]{"jack","mike"};
        String _t = Arrays.deepToString(ss);
        System.out.println(_t.substring(1,_t.length() - 1));

        //扩充知识点
        //Q：为什么数组打印时内容被中括号包围
        //A：查看Arrays.toString源码可得到答案
    }

    /**
     * 将数组转换成集合推荐使用Guava的Lists.newArrayList()方法
     * 使用Lists的asList转换成的ArrayList是java.Arrays.ArrayList而非java.util.ArrayList
     */
    @Test
    public void test(){
        Integer[] array = new Integer[]{1,2,3,4};
        List<Integer> integers = Arrays.asList(array);
//        System.out.println(integers.add(5));
        System.out.println(integers);

        List<Integer> list = Lists.newArrayList(array);
        list.add(5);
        System.out.println(list);
    }

    /**
     * System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
     */
    @Test
    public void testArrayCopy(){
        int[] src = new int[]{1,2,3,4,5};
        int[] dest;

        // 数组截取
        System.arraycopy(src, 0, dest = new int[3], 0, 3);
        System.out.println(Arrays.toString(dest));

        // 数组扩容
        System.arraycopy(src, 0, dest = new int[10], 0, src.length);
        System.out.println(Arrays.toString(dest));
    }
}
