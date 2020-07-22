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

import com.ruida.springbootdemo.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description: 顶级测试类
 * @author: chenjy
 * @create: 2020-04-24 16:04
 */
public class TopTest {

    private static final Logger logger = LoggerFactory.getLogger(TopTest.class);

    int count;

    public static void main(String[] args) {

        Employee e = new Employee(1,"chenjy");
        System.out.println(e);

        Employee employee = new Employee();
        System.out.println(employee);

        Integer i1 = 22;
        Integer i2 = 22;
        System.out.println(i1 == i2);

        Integer i3 = 222;
        Integer i4 = 222;
        System.out.println(i3 == i4);

        String str = "chenjianyin+";
        System.out.println(str.substring(0,str.length()-1));

        TopTest t = new TopTest();
        System.out.println(BigDecimal.ZERO);
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Calendar c = Calendar.getInstance();
        c.set(2019,Calendar.DECEMBER,31);
        Date date = c.getTime();
        System.out.println(sdf.format(date));

        int count = 0;
        System.out.println(count);

        t.dosomething();

        BigDecimal a = new BigDecimal("9.789");
        BigDecimal b = new BigDecimal("1.120");
        System.out.println(a.subtract(b));

        BigDecimal aa = new BigDecimal("0.01");
        System.out.println(aa);
        System.out.println(aa.compareTo(BigDecimal.ZERO)==0);
      /*  TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "val");
        map.put(2, "val");
        map.put(1, "val");
        map.put(5, "val");
        map.put(4, "val");
        System.out.println(map); // {5=val, 4=val, 3=val, 2=val, 1=val}

        Map<String,Object> hashMap = new HashMap();
        hashMap.put("name1","chenjy");
        hashMap.put("name3","wangman");
        hashMap.put("name2","liuxy");
        hashMap.put("school","MIT");
        System.out.println(hashMap);

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("name1","chenjy");
        linkedHashMap.put("name2","liuxy");
        linkedHashMap.put("name3","wangman");
        System.out.println(linkedHashMap);*/

       /* String str = "123r";
        long l = 0;
        try {
            l = Long.valueOf(str);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        System.out.println(l);
        System.out.println("end...");*/

       /*Map<String,Object> map = new HashMap();
       map.put("name",2.1d);
       BigDecimal b = (BigDecimal) map.get("name");
       System.out.println(b);*/

       /*Map<String,Object> map = new HashMap();
       map.put("name",null);
       String name = String.valueOf(map.get("name"));
       if("null".equals(name)){
           System.out.println(1);
       }else {
           System.out.println(2);
       }
       System.out.println(name);*/

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



    public void dosomething(){
        System.out.println(count);
    }




}
