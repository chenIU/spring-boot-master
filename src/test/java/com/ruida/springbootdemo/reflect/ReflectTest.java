package com.ruida.springbootdemo.reflect;

import com.ruida.springbootdemo.annotation.MyAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-11 08:58
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {
        Class<Son> clazz = Son.class;

        Field[] fs1 = clazz.getDeclaredFields();
        for(Field field:fs1){
            System.out.println(field);
        }
        System.out.println("---------------------------");

        Field[] fs2 = clazz.getFields();
        for(Field field:fs2){
            System.out.println(field);
        }
        System.out.println("---------------------------");

        /**
         * 总结：getDeclaredFields得到所有的属性，不区分修饰符，不包含父类；getFields只能得到public修饰的属性，包含父类
         */

        Field f1 = clazz.getField("t");
        System.out.println(f1);
        System.out.println("---------------------------");

        //以下代码会报错
        /*Field f2 = clazz.getDeclaredField("t");
        System.out.println(f2);*/

        Field f3 = clazz.getDeclaredField("d");
        System.out.println(f3);
        Son son = clazz.newInstance();
        f3.setAccessible(true); //setAccessible(true)：提高访问权限
        f3.set(son,"english");
        System.out.println(son.getD());
        System.out.println("---------------------------");

        /**
         * 总结：getField根据属性名称获取属性，包含父类中的属性；getDeclaredField只能获取当前类中的属性。且都不区分修饰符
         */

        Method[] ms1 = clazz.getMethods();
        for (Method method : ms1){
            System.out.println(method);
        }
        System.out.println("---------------------------");

        Method[] ms2 = clazz.getDeclaredMethods();
        for (Method method : ms2){
            System.out.println(method);
        }
        System.out.println("---------------------------");

        /**
         * 总结：getMethods获取当前类和父类中所有public修饰的方法；getDeclaredMethods获取当前类中的所有方法
         */

        Method m1 = clazz.getDeclaredMethod("eat", String.class);
        m1.invoke(son,"rice");
        System.out.println("---------------------------");

        //以下代码会报错
       /* Method m2 = clazz.getMethod("sleep");
        m2.invoke(son);
        System.out.println("---------------------------");*/

        Method m3 = clazz.getMethod("sleep", long.class);
        m3.invoke(son,100L);
        System.out.println("---------------------------");

        /**
         * 总结：getDeclaredMethod获取当前类中所有的方法；getMethod获取当前类和父类中的所有public修饰的方法
         */

        Constructor[] cs1 = clazz.getConstructors();
        for (Constructor constructor:cs1){
            System.out.println(constructor);
        }
        System.out.println("---------------------------");

        Constructor[] cs2 = clazz.getDeclaredConstructors();
        for (Constructor constructor:cs2){
            System.out.println(constructor);
        }
        System.out.println("---------------------------");

        /**
         * 总结：getConstructors获取当前类的所有public修饰的构造方法；getDeclaredConstructors获取当前类的所有构造方法
         */

        Constructor c1 = clazz.getDeclaredConstructor(String.class,int.class);
        Son s1 = (Son) c1.newInstance("zhangsan",25);
        System.out.println(s1);
        System.out.println("---------------------------");

        //以下代码会报错，getConstructor只能获取public修饰的构造方法
       /* Constructor c2 = clazz.getConstructor(String.class,int.class,String.class,String.class,String.class,String.class);
        Son s2 = (Son) c2.newInstance("zhangsan",25,"a","b","c","d");
        System.out.println(s2);*/

        //反射获取注解
        System.out.println("Son has MyAnnotation："+clazz.isAnnotationPresent(MyAnnotation.class));
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields){
            MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
            if(annotation != null){
                System.out.println(field.getName()+"  has MyAnnotation,the value is："+annotation.value());
            }
        }

        //方法注解和属性注解类似

    }
}
