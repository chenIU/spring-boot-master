package com.ruida.springbootdemo.domain;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-11 14:51
 */
public class Son extends Father {

    private String name;

    public Son(){
        System.out.println("son constructor");
    }

    public Son(int id,String name){
        super(id);
        this.name = name;
    }

    public static void main(String[] args) {
      /*  Son son = new Son(25,"jack");
        System.out.println(son);
        son.eat();*/

      Son s1 = new Son();
    }

    @Override
    public void eat(){
        System.out.println("son eating...");
    }

    @Override
    public String toString() {
        return "Son{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}
