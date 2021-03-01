package com.ruida.springbootdemo.stream;

import com.google.common.collect.Lists;
import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.model.Person;
import com.ruida.springbootdemo.model.PersonCountry;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiTest {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("欧阳雪",18,"中国",'F'));
        personList.add(new Person("Tom",24,"美国",'M'));
        personList.add(new Person("Harley",22,"英国",'F'));
        personList.add(new Person("向天笑",20,"中国",'M'));
        personList.add(new Person("李康",22,"中国",'M'));
        personList.add(new Person("小梅",20,"中国",'F'));
        personList.add(new Person("何雪",21,"中国",'F'));
        personList.add(new Person("李康",22,"中国",'M'));

        /**
         * 筛选与切片
         */

        // 1 filter
        // 1.1 找出年龄大于18岁的人
        personList.stream().filter((p) -> p.getAge() > 18).forEach(System.out::println);
        // 1.2 找出中国人的数量
        long count = personList.stream().filter(p -> p.getCountry().equals("中国")).count();
        System.out.println("中国人的数量："+count);


        // 2 limit
        System.out.println("=======================limit");
        personList.stream().filter(p -> p.getSex() == 'F').limit(2).forEach(System.out::println);

        // 3 skip
        System.out.println("=======================skip");
        personList.stream().filter(p -> p.getSex() == 'F').skip(1).forEach(System.out::println);

        //4 distinct
        System.out.println("=======================distinct");
        personList.stream().filter(p -> p.getSex() == 'M').distinct().forEach(System.out::println);

        // 5 sorted
        System.out.println("=======================sorted");
        // 5.1 自然排序
        System.out.println("========================自然排序");
        personList.stream().sorted(Comparator.comparing(Person::getAge).reversed()).forEach(System.out::println);
        // 5.2 定制排序
        System.out.println("========================定制排序");
        Stream<Person> sorted = personList.stream().sorted((p1,p2) -> {
            if(p1.getAge().equals(p2.getAge())){
                return p1.getName().compareTo(p2.getName());
            }else {
                return p1.getAge().compareTo(p2.getAge());
            }
        });
        sorted.forEach(System.out::println);

        // 6 map
        System.out.println("========================map");
        personList.stream().map(p -> {
            PersonCountry country = new PersonCountry();
            country.setCountry(p.getCountry());
            return country;
        }).distinct().forEach(System.out::println);

        List<String> strList = Arrays.asList("aaa","bbb","ccc","ddd","ddd");
        /**
         * 6.1 普通map
         * map--接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
         */
        System.out.println("=========================普通map");
        Stream<Stream<Character>> streamStream = strList.stream().map(StreamApiTest::getCharacterByString);
        //streamStream.forEach(System.out::println);
        streamStream.forEach(ss -> ss.forEach(System.out::print));
        System.out.println();
        /**
         * 6.2 flatMap
         * flatMap--接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
         */
        System.out.println("==========================flatMap");
        Stream<Character> stream = strList.stream().flatMap(StreamApiTest::getCharacterByString);
        stream.forEach(System.out::print);
        System.out.println();


        /**
         * 终止操作 查找与匹配
         * allMatch  检查是否匹配所有元素
         * anyMatch  检查是否至少匹配一个元素
         * noneMatch 检查是否没有匹配所有元素
         * findFirst 返回第一个元素
         * findAny   返回当前流中的任一元素
         * count     返回流中的元素个数
         * max       返回流中的最大值
         * min       返回流中的最小值
         */
        boolean adult = personList.stream().allMatch(p -> p.getAge() >= 18);
        System.out.println("是否都是成年人："+adult);
        boolean chinese = personList.stream().allMatch(p -> p.getCountry().equals("中国"));
        System.out.println("是否都是中国人："+chinese);
        Optional<Person> maxAge = personList.stream().max(Comparator.comparing(Person::getAge));
        System.out.println("年龄最大的人信息："+maxAge);
        Optional<Person> minAge = personList.stream().min(Comparator.comparing(Person::getAge));
        System.out.println("年龄最大的人信息："+minAge);


        /**
         * reduce 规约
         */
        // 求1到100的和
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=100;i++){
            list.add(i);
        }
        Integer reduce = list.stream().reduce(0,(x,y) -> x+y);
        System.out.println("1到100的和为："+reduce);
        Optional<Integer> sum = personList.stream().map(Person::getAge).reduce(Integer::sum);
        System.out.println("年龄总和为："+sum);

        /**
         * collect 收集
         */
        // 计算平均年龄
        double avg = personList.stream().collect(Collectors.averagingDouble(Person::getAge));
        System.out.println("平均年龄是："+avg);

    }

    public static Stream<Character> getCharacterByString(String str) {

        List<Character> characterList = new ArrayList<>();

        for (Character character : str.toCharArray()) {
            characterList.add(character);
        }

        return characterList.stream();
    }

    /**
     * peek & map
     */
    @Test
    public void test1(){
        Stream.of("one","two","three","four")
                .filter(e -> e.length() >3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("mapped value: " + e))
                .collect(Collectors.toList());

        /*
         * peek操作string
         */
        List<String> strList = new ArrayList<>(Arrays.asList("one","two","three"));
        List<String> stringList = strList.stream().peek(e -> e = e.toUpperCase()).collect(Collectors.toList());
        stringList.forEach(System.out::println);

        //不能改变的原因是peek没有返回值，不会对stream流做修改

        /*
         * peek操作引用类型
         */
        List<User> userList = Lists.newArrayList(
                new User("jack",18),
                new User("mike",20)
        );
        List<User> users = userList.stream().peek(e -> e.setUsername(e.getUsername().toUpperCase())).collect(Collectors.toList());
        users.forEach(System.out::println);

        //引用类型字段被修改，和上面并不矛盾，被修改的原因是Java中参数传递类型是值传递，引用类型作为参数的时候，传递的是引用地址，当引用地址上的内容被修改时，对象自然被修改。但是stream并没有被修改

        /*
         * peek和map的使用场景
         * 当我们只需要对元素内部进行处理，使用peek比较合适。如果需要返回一个新的Stream，使用map比较合适
         * 一般peek在debug场景使用比较方便
         * peek和map操作都不回终端流，但foreach会中断流，只能进行遍历操作
         */
    }

}
