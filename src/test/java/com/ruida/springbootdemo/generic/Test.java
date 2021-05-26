/*
 * 泛型方法总结
 *
 * 无论何时，如果你能做到，你就该尽量使用泛型方法。也就是说，如果使用泛型方法将整个类泛型化，那么就应该使用泛型方法
 *
 * 另外，对于一个static的方法而言，无法访问泛型类型参数，如果static方法要使用泛型能力，就必须使其成为泛型方法
 */
package com.ruida.springbootdemo.generic;

import org.apache.poi.ss.formula.functions.T;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-10 16:33
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Test test = new Test();

        Box<Integer> box = new Box<>();
        box.set(100);
        System.out.println(box.get());

        Generic<Integer> generic = new Generic<>(100);
        test.showKey(generic);

        System.out.println(test.genericMethod((Class<T>) Class.forName("com.ruida.springbootdemo.entity.User")));
    }

    public void showKey(Generic<? extends Number> obj){
        System.out.println("key is : " + obj.getKey());
    }

    /**
     * 泛型方法的基本介绍
     * 说明：
     *  1)public与返回值之间的<T>非常重要，可以理解为声明此方法为泛型方法
     *  2)只有声明了<T>的方法才是泛型方法，泛型类中使用了泛型的成员方法并不是泛型方法
     *  3)<T>表明该方法将使用泛型T，此时才可以在方法中使用泛型T
     *  4)与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
     * @param clazz
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public <T> T genericMethod(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T t = clazz.newInstance();
        return t;
    }

}
