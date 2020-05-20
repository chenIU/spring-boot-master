/*
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.ruida.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: 顶级测试类
 * @author: chenjy
 * @create: 2020-04-24 16:04
 */
public class TopTest {

    private static final Logger logger = LoggerFactory.getLogger(TopTest.class);


    public static void main(String[] args) {

    }


    /*public static void main(String[] args) {
        String s = "100";
        int i = Integer.parseInt(s);
        int j = Integer.valueOf(s);
        System.out.println(i);
        System.out.println(j);

        float f1 = 0.1f;
        float f2 = 0.2f;
        System.out.println(f1+f2);
        System.out.println(0.1+0.2);

        Map<String,Object> map = new HashMap();
        map.put("name","chenjy");
        System.out.println(map.get("name"));
        map.remove("name");
        System.out.println(map.get("name"));

        BigDecimal b1 = new BigDecimal(0.1);
        System.out.println(b1);
        BigDecimal b2 = new BigDecimal("0.1");
        System.out.println(b2);
        BigDecimal b3 = BigDecimal.valueOf(0.1);
        System.out.println(b3);
        add(100,200);
        logger.info("hello");
        logger.info("{}","hello world");

        System.out.println(String.format(SystemConstant.LOGIN_KEY, "chenjy"));

        //子类可以显示转换为父类
        Father father = new Son();
        father.say();
        ((Son) father).eat();
        System.out.println(father);

        //父类转换成子类需要强转
        Son son = (Son) father;
        son.say();
        son.eat();
        System.out.println(son);

        Father f = new Father();
        Son so = (Son) f;
        so.say();
        so.eat();

    }

    private static void add(int a,int b){
        System.out.println("TopTest.add linenum:44, param:{a = [" + a + "], b = [" + b + "]} info:");
    }*/



}
