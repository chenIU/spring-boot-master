package com.ruida.springbootdemo.lambda;

import java.util.Arrays;
import java.util.function.IntFunction;

/**
 * @description: 在jdk1.8中，通常使用lambda表示式创建匿名方法。然而，有时候仅仅只需要调用一个已存在的方法。
 * Q：什么是方法引用?
 * A：方法引用是用来直接访问类或者实例的已经存在的方法或者构造方法。方法引用提供了一种引用而不执行方法的方式，它需要由兼容的函数式接口构成的目标类型上下文。计算时，方法引用会创建函数式接口的一个实例。
 *
 * 当Lambda表达式中只是执行一个方法调用时，不用Lambda表达式，直接通过方法引用的形式可读性更高一些。方法引用是一种更简洁易懂的Lambda表达式。
 *
 * 注意方法引用是一个Lambda表达式，其中方法引用的操作符是双冒号"::"。
 *
 * ============================================================================
 *
 * 简单地说，就是一个Lambda表达式。在Java 8中，我们会使用Lambda表达式创建匿名方法，但是有时候，我们的Lambda表达式可能仅仅调用一个已存在的方法，而不做任何其它事，
 *
 * 对于这种情况，通过一个方法名字来引用这个已存在的方法会更加清晰，Java 8的方法引用允许我们这样做。方法引用是一个更加紧凑，易读的Lambda表达式，注意方法引用是一个Lambda表达式，
 *
 * 其中方法引用的操作符是双冒号"::"。
 *
 * @author: chenjy
 * @create: 2020-12-21 13:49
 */
public class MethodReferenceTest {

    public static void main(String[] args) {
        //给字符串排序
        String[] arr = {"chenjy","wangman","liuxy","amy"};

        //1.传统方式排序
        Arrays.sort(arr,(s1,s2) -> s1.compareToIgnoreCase(s2));
        System.out.println(Arrays.toString(arr));

        //2.方法引用排序
        Arrays.sort(arr,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(arr));


        //方法引用的类型
        //1.引用静态方法
        //2.引用某个对象的实例方法
        //3.引用某个类型的任意对象的实例方法
        //4.引用构造方法

        IntFunction<int[]> arrayMaker = int[]::new;
        int[] array = arrayMaker.apply(10); // 创建数组 int[10]
        System.out.println(array.length);
    }
}
