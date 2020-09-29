package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.entity.User;
import org.junit.Test;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * java中引用数据类型：
 *                  class type：类类型
 *                  interface ：接口
 *                  array type：数组
 *                  null type ：null类型
 *
 * 引用类型强弱关系：强引用>软引用>弱引用>虚引用
 * @author: chenjy
 * @create: 2020-09-29 11:51
 */
public class ReferenceTest {

    public static void main(String[] args) {
        int i = 100;
        int c = i;
        i = 200;
        System.out.println(i); //200
        System.out.println(c); //100

        User user = new User();
        user.setAge(30);
        User user1 = user;
        user.setAge(50);
        System.out.println(user.getAge()); //50
        System.out.println(user1.getAge());//50

        /* 解释：
         * 普通类型存储在栈上,引用类型对象存在堆上
         * User user = new User();是将User对象所在的内存地址赋值给user,user称为对象引用(Object Reference)。new的作用是在内存上为User开辟空间
         * User user1 = user;是将user的引用地址赋值给user1
         * user和User1都不是对象,而是对象的引用
         */

        int[] array = {1,2,3,4,5};
        int[] array2 = array;
        System.out.println(array2[1]);//2
        array[1] = 100;
        System.out.println(array[1]); //100
        System.out.println(array2[1]);//100
    }

    /*
     * java中默认的引用类型就是强引用
     */
    @Test
    public void finalReference(){
        User user = new User(); //只要user还指向User对象,User对象就不会被回收
        user = null;
    }

    /*
     * 软引用是除了强引用之外最强的引用类型
     * 在内存足够的时候,软引用对象不会被回收;只有在内存不足时,系统才会回收软引用对象
     */
    @Test
    public void softReference(){
        User user = new User();
        SoftReference sf = new SoftReference(user);

        user = null;
        System.gc();

       /* byte[] bytes = new byte[10];
        System.gc();*/
        System.out.println("是否被回收："+sf.get());
    }

    /*
     * 弱引用比软引用更弱一些
     * 无论内存是否足够,只要JVM进行垃圾回收,那么被弱引用关联的对象都会被回收
     */
    @Test
    public void weakReference(){
        User user = new User();
        WeakReference sf = new WeakReference(user);
        user = null;
        System.out.println("是否被回收"+sf.get());
        System.gc();
        System.out.println("是否被回收"+sf.get());
    }

    /*
     * 虚引用是最弱的一种引用关系,如果一个对象仅持有虚引用,那么它就和没有引用一样,随时都有可能被回收
     * 虚引用必须要和ReferenceQueue一起使用,它的作用在于跟踪垃圾回收过程
     */
    @Test
    public void phantomReference(){
        User user = new User();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference sf = new PhantomReference<>(user,referenceQueue);
        user = null;
        System.out.println("是否被回收"+sf.get());
        System.gc();
        System.out.println("是否被回收"+sf.get());
    }
}
