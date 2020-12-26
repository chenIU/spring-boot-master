package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.lombok.XiaoMiTV;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @description: set测试类
 * <p>
 *     测试ConcurrentModificationException
 * </p>
 * @author: chenjy
 * @create: 2020-04-28 10:13
 */
public class SetTest {
    public static void main(String[] args) {

        //HashSet 无序不能重复
        Set<String> s1 = new HashSet<>();
        s1.add("jack");
        s1.add("mike");
        s1.add("tom");
        s1.forEach(e -> System.out.printf("%s ",e));

        System.out.println();

        //LinkedHashSet 有序不能重复
        Set<String> s2 = new LinkedHashSet<>();
        s2.add("jack");
        s2.add("mike");
        s2.add("tom");
        s2.forEach(e -> System.out.printf("%s ",e));

        System.out.println();

        //TreeSet有排序功能
        Set<String> s3 = new TreeSet<>();
        s3.add("jack");
        s3.add("mike");
        s3.add("tom");
        s3.add("amy");
        s3.forEach(e -> System.out.printf("%s ",e));

        System.out.println();

        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("hello");
        System.out.println(set.size());

        /*
         * set去利用了map的put方法,key的hashCode不能重复的原理
         */
        Set<XiaoMiTV> set1 = new HashSet<>();
        XiaoMiTV v1 = new XiaoMiTV(1,"小米电视1",10000L,"白色");
        XiaoMiTV v2 = new XiaoMiTV(2,"小米电视2",10000L,"白色");
        System.out.println(v1.hashCode());
        System.out.println(v2.hashCode());
        set1.add(v1);
        set1.add(v2);
        System.out.println(set1.size());

       /* set.add("jack");
        set.add("mike");
        set.add("tom");
        set.add("john");
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            set.remove("jack");
            String value = it.next();
            System.out.println(value);
        }*/
    }
}
