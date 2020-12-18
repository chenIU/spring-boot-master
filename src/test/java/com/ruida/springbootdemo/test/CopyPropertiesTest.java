package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.model.Book;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import java.lang.reflect.InvocationTargetException;

/**
 * @description: 建议使用Spring中的BeanUtils工具包而不是Apache
 * @author: chenjy
 * @create: 2020-12-17 15:48
 */
public class CopyPropertiesTest {

    public static void main(String[] args) throws Exception{
        Book A = new Book();
        A.setName("三国演义");

        Book B = new Book();
        B.setName("三国演义-罗贯中");

        //org.apache.commons.beanutils.BeanUtils包中的BeanUtils.copyProperties(target,source)
        //org.springframework.beans.BeanUtils中的BeanUtils.copyProperties(source,target)
        //注意不同的包中，参数表示的含义不同（刚好相反）
        try {
            BeanUtils.copyProperties(A,B);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        org.springframework.beans.BeanUtils.copyProperties(A,B);
        Book C = new Book();
        PropertyUtils.copyProperties(C,A);
        System.out.println(C);
        System.out.println(A);
    }
}
