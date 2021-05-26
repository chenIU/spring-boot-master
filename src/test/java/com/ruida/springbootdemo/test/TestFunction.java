package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.entity.User;
import org.junit.Test;

import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Chen.J.Y
 * @date 2021/5/12
 * function.apply() 中的 apply 可以看作应用此函数
 */
public class TestFunction {

    /**
     * 输入T类型的数据，进行相关逻辑后，返回R类型结果
     */
    @Test
    public void testFunction() {
        Function<String, User> function = x -> {
            User u = new User();
            u.setUsername(x);
            return u;
        };

        User user = function.apply("李小龙");
        System.out.println(user);
    }

    /**
     * @see Function#compose(Function)
     * 先执行调用者，再执行参数
     */
    @Test
    public void testFunctionCompose() {
        Function<Integer, Integer> times = x -> x * 2;

        Function<Integer, Integer> squared = x -> x * x;

        System.out.println(times.compose(squared).apply(4));
    }

    /**
     * @see Function#andThen(Function)
     * 先执行参数，再执行调用者
     */
    @Test
    public void testFunctionAndThen() {
        Function<Integer, Integer> times = x -> x * 2;

        Function<Integer, Integer> squared = x -> x * x;

        System.out.println(times.andThen(squared).apply(4));
    }

    /**
     * @see Function#identity()
     * 将输入输出
     */
    @Test
    public void testFunctionIdentity() {
        Map<Integer, String> mapOne = Stream.of("a", "ab", "abc", "abcd").collect(Collectors.toMap(String::length, x -> x));
        System.out.println(mapOne);

        Map<Integer, String> mapTwo = Stream.of("a", "ab", "abc", "abcd").collect(Collectors.toMap(String::length, Function.identity()));
        System.out.println(mapTwo);
    }

    /**
     * IntFunction 输入int类型，输出R类型
     * 其他类似：
     * DoubleFunction：输入double类型，输出R类型
     * LongFunction：输入long类型，输出R类型
     */
    @Test
    public void testIntFunction() {
        IntFunction<User> intFunction = x -> {
            User user = new User();
            user.setAge(x);
            return user;
        };

        User user = intFunction.apply(30);
        System.out.println(user);
    }

    /**
     * 输入T类型，输出int类型
     * 其他类似：
     * ToDoubleFunction
     * ToLongFunction
     */
    @Test
    public void testToIntFunction() {
        ToIntFunction<String> toIntFunction = x -> x == null ? 0 : x.length();
        System.out.println(toIntFunction.applyAsInt("蚂蚁牙黑"));
    }

    /**
     * 输入int，输出double类型
     * 其他类似：
     * IntToLongFunction
     * LongToDoubleFunction
     * LongToIntFunction
     * DoubleToIntFunction
     * DoubleToLongFunction
     */
    @Test
    public void testIntToDoubleFunction() {
        IntToDoubleFunction intToDoubleFunction = x -> x + 88.88;
        System.out.println(intToDoubleFunction.applyAsDouble(100));
    }

    /**
     * 输入T类型和U类型，输出R类型
     */
    @Test
    public void testBiFunction() {
        BiFunction<Integer, String, User> biFunction = (x, y) -> {
            User user = new User();
            user.setAge(x);
            user.setUsername(y);
            return user;
        };

        System.out.println(biFunction.apply(30, "李小龙"));
    }

    /**
     * 输入是T和U，输出是int类型
     * 其他类似：
     * ToLongBiFunction
     * ToDoubleBiFunction
     */
    @Test
    public void testToIntBiFunction() {
        ToIntBiFunction<Integer, String> toIntBiFunction = (x, y) -> 100;
        System.out.println(toIntBiFunction.applyAsInt(30, "李小龙"));
    }
}
