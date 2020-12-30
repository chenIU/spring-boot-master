package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.entity.User;

/**
 * @description: 类型转换测试
 * @author: chenjy
 * @create: 2020-12-30 08:57
 */
public class TypeConvertTest {

    public void test(){
        User user = new User();
        //类型高的向类型底的转换是编译器自动转换(平行四边形可以说是四边形)
        Object object = user;

        //类型底的向类型高的转换需要强制类型转换(四边形不能说一定就是平行四边形)
        User user1 = (User) object;
    }
}
