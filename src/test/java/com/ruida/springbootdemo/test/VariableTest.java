package com.ruida.springbootdemo.test;

/**
 * @description: 成员变量&局部变量
 * @author: chenjy
 * @create: 2020-10-09 15:20
 */
public class VariableTest {

    /**
     * 对于成员变量，Java虚拟机会对它们进行默认初始化
     */

    //String类型的变量，默认值是"null"字符串
    private String v1;

    //Boolean类型的变量，默认值是null
    private Boolean v2;

    //boolean类型的变量，默认值是false
    private boolean v3;

    //Integer类型的变量，默认值是null
    private Integer v4;

    //int类型的变量，默认值是0
    private int v5;

    public static void main(String[] args) {
        VariableTest vt = new VariableTest();
        vt.test();
    }

    public void test(){
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v5);
    }

    public void add(int a,int b){
        /**
         * 局部变量声明之后，Java虚拟机不会给它们初始化为默认值，因此局部变量需要显示的初始化
         */

        //1.参与输出
        int i = 0;
        System.out.println(i);

        //2.参与运算
        int i2 = 0;
        int tmp = i2 + a;

        /**
         * 对于一个只接受表达式的局部变量，可以不初始化
         */
        int i3 = a>b?0:1;
    }
}
