package com.ruida.springbootdemo.model;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-30 13:20
 */
public class Cat {

    public static final String TAG = Cat.class.getSimpleName();

    private String name;

    @Deprecated
    public Integer age;

    public Cat(String name, Integer age) {
        System.out.println("调用构造方法...");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void eat(String food){
        System.out.println("eat food: " + food);
    }

    public void eat(String... foods){
        StringBuilder stringBuilder = new StringBuilder();
        for(String food:foods){
            stringBuilder.append(food);
            stringBuilder.append(" ");
        }
        System.out.println("eat food: " + stringBuilder.toString());
    }

    public void sleep(){
        System.out.println("sleep...");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
