package com.ruida.springbootdemo;

public class FloatTest {

    public static void main(String[] args) {
        float f1 = 0.1f;
        float f2 = 0.2f;
        if(f1 == f2){
            System.out.println("f1和f2相等");
        }else {
            System.out.println("f1和f2不相等");
        }

        Float f3 = Float.valueOf(f1);
        Float f4 = Float.valueOf(f2);
        if(f3.equals(f4)){
            System.out.println("f3和f4相等");
        }else {
            System.out.println("f3和f4不相等");
        }
    }
}
