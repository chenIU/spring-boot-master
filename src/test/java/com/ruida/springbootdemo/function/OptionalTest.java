package com.ruida.springbootdemo.function;

import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.exception.BaseException;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {

        String str = "hello";

        Optional optional = Optional.ofNullable(str);
        optional.ifPresent(System.out::println);

        Optional name1 = Optional.of("jack");
        System.out.println(name1);

        Optional name2 = Optional.empty();
        System.out.println(name2);

        String name = null;
        Optional name3 = Optional.ofNullable(name);
        System.out.println(name3);

        System.out.println(name3.orElseGet(() -> "hello"));
        //System.out.println(Optional.ofNullable(name).orElseThrow(() -> new BizException("500","illegal argument")));
        try {
            name3.orElseThrow(() -> new BaseException(500,"error"));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println(Optional.ofNullable(str).orElse("default value"));

        User user = new User();

        /**
         * 创建Optional容器
         */
        //empty返回空的Optional
        //Optional.empty();

        //of只有在确定放入容器的对象不为null的时候调用，否则会产生NPE问题
        //Optional.of(user);

        //ofNullable在上下文中不确定要放入容器的对象是否为null，使用最多构造Optional容器的方法
        //Optional.ofNullable(user);

        /**
         * 取值
         */
        //orElse不管user是否为空都会执行createUser
        //User u = Optional.ofNullable(user).orElse(createUser());

        //orElseGet只有在user对象为空的时候才会执行createUser
        User u = Optional.ofNullable(user).orElseGet(() -> createUser());

        System.out.println(u);
    }

    private static User createUser(){
        System.out.println("执行createUser方法");
        User user = new User();
        user.setUsername("zhangsan");
        return user;
    }

    /**
     * 创建一个空的Optional对象
     */
    @Test
    public void test(){
        Optional<User> opt = Optional.empty();
        opt.get();
    }

    /**
     * 如果确定对象不为空，调用of；如果不确定对象是否为空，调用ofNullable
     */
    @Test
    public void test2(){
        User user = new User();
        user.setId(100);
        user.setUsername("zhangsan");
        Optional<User> opt = Optional.of(user);
        System.out.println(opt.get());

        Optional<User> opt2 = Optional.ofNullable(null);
        System.out.println(opt2.get());
    }

    /**
     * isPresent判断optional对象是否为空
     */
    @Test
    public void test3(){
        Optional<User> opt = Optional.ofNullable(null);
        System.out.println(opt.isPresent());

        User user = new User();
        user.setId(100);
        user.setUsername("zhangsan");
        Optional<User> opt2 = Optional.ofNullable(user);
        System.out.println(opt2.isPresent());
    }

    /**
     * 返回默认值
     *
     * orElse 不管Optional对象是否为空，都创建对象
     * orElseGet 只有在Optional对象为空时，才创建对象
     *
     * 基于性能考虑，建议使用orElseGet返回默认值
     *
     */
    @Test
    public void test4(){
        User user = null;
        User user1 = new User();
        user1.setId(200);
        user1.setUsername("lisi");
        User user2 = Optional.ofNullable(user).orElse(user1);
        System.out.println(user2);

        User user3 = Optional.ofNullable(user).orElseGet(() -> user1);
        System.out.println(user3);
    }

    /**
     * orElseThrow 返回异常
     */
    @Test
    public void test5(){
        User user = null;
        User user2 = Optional.ofNullable(user).orElseThrow( () -> new BaseException(500, "系统异常"));
        System.out.println(user2);
    }

    /**
     * map 转换
     */
    @Test
    public void test6(){
        User user = new User();
        user.setId(100);
        user.setUsername("zhangsan");
        String username = Optional.ofNullable(user).map(value -> value.getUsername()).orElse("default");
        System.out.println(username);
    }

    /**
     * filter 过滤
     */
    @Test
    public void test7(){
        User user = new User();
        user.setAge(15);
        user.setUsername("zhangsan");

        Optional<User> user1 = Optional.of(user).filter(e -> e.getAge() > 20);
        user1.ifPresent(System.out::println);
    }
}
