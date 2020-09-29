package com.ruida.springbootdemo.lombok;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-29 09:36
 */
public class LombokTest {

    public static void main(String[] args) {
        //XiaoMiTV xiaomi = new XiaoMiTV();

        XiaoMiTV v1 = new XiaoMiTV(1,"小米电视1",10000L,"白色");
        XiaoMiTV v2 = new XiaoMiTV(2,"小米电视2",10000L,"白色");

        System.out.println(v1.equals(v2));
    }
}
