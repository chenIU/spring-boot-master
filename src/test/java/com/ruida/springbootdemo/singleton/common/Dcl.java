package com.ruida.springbootdemo.singleton.common;

/**
 * @desc 双重检测锁
 * @author chenjy
 * @since 2021/1/3 9:32
 */
public class Dcl {

    private Dcl(){
        System.out.println(Thread.currentThread().getName() + " ok");
    }

    private static Dcl instance;//必须加上volatile才是完整的DCL单例模式

    public static Dcl getInstance(){
        if(instance == null){
            synchronized (Dcl.class){
                if(instance == null){
                    instance = new Dcl();//不是一个原子性操作
                    /*
                     * 1.分配内存空间
                     * 2.执行构造方法，初始化对象
                     * 3.把这个对象指向这个空间
                     */
                }
            }
        }
        return instance;
    }

    //单线程下没问题,多线程下有问题
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(Dcl::getInstance).start();
        }
    }
}
