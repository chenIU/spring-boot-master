package com.ruida.springbootdemo.test;

/**
 * @description: 异常测试类
 * @author: chenjy
 * @create: 2020-04-29 16:42
 */
public class TestException {

    public static void main(String[] args) {

//        System.out.println(divide(0.1,0));

        try {
//            throw new IllegalArgumentException("参数不合法");
            throw new OutOfMemoryError("内存溢出");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }catch (Error e){
            System.out.println(e.getMessage());
        }
        // 总结：Error和Exception时Throwable接口的两个实现类,Exception无法接住Error类型的错误,反之亦然

    }

    public static double divide(double a,double b){
        if(b==0){
            throw new RuntimeException("被除数不能为0");
        }
        return a/b;
    }

}
