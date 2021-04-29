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

package com.ruida.springbootdemo.test;

import cn.hutool.core.util.IdUtil;
import com.google.common.collect.Lists;
import com.ruida.springbootdemo.constant.MIMEType;
import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.entity.dto.UserDTO;
import com.ruida.springbootdemo.entity.fruit.Apple;
import com.ruida.springbootdemo.enums.ErrorEnum;
import com.ruida.springbootdemo.exception.BaseException;
import com.ruida.springbootdemo.generic.A;
import com.ruida.springbootdemo.model.Book;
import com.ruida.springbootdemo.model.Cat;
import com.ruida.springbootdemo.model.Person;
import com.ruida.springbootdemo.model.Son;
import com.ruida.springbootdemo.utils.TimeUtil;
import com.ruida.springbootdemo.utils.ValidateMT;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: 顶级测试类
 * @author: chenjy
 * @create: 2020-04-24 16:04
 */
public class TopTest {

    private static final Logger logger = LoggerFactory.getLogger(TopTest.class);

    final String TAG = null;//final类型的变量必须立即初始化

    int count;//非final类型的变量不必初始化,编译器会为此变量赋默认值

    public static void main(String[] args) {

        System.out.println(IdUtil.fastUUID());

        System.out.println(20302 / 100);//203
        System.out.println(20302 % 100);//2

        System.out.println(System.currentTimeMillis());//系统时间毫秒数13位

        List<String> nameList = Stream.of("jack").collect(Collectors.toList());
        System.out.println(nameList);

        //source tree
        System.out.println(URLEncoder.encode("编码"));

        System.out.println(Apple.class.getName());

        String empName = "jack";

        System.out.println(CharSequence.class.isAssignableFrom(empName.getClass()));

        //class1.isAssignableFrom(class2)：判断class2是不是class1的子类或者子接口

        Son son = new Son(1001, "Tom");

        //重写hashcode使用31的原因
        System.out.println(31 * 3);//93
        System.out.println((3<<5) - 3);//0000 0011 -> 0110 0000 -> 0101 1101

        Cat tom = new Cat("Tom", 3);
        System.out.println(tom);

        //System.getenv():获取系统环境变量
//        Map<String, String> env = System.getenv();
//        env.forEach((k,v) -> {
//            System.out.println("key==" + k + " value==" + v);
//        });

        long max = Runtime.getRuntime().maxMemory();
        long total = Runtime.getRuntime().totalMemory();
        long free = Runtime.getRuntime().freeMemory();
        System.out.println("最大内存空间:" + ((double)max / 1024 /1024) + "M");
        System.out.println("初始化总内存空间:" + ((double)total / 1024 /1024) + "M");
        System.out.println("可用空间:" + ((double)free / 1024 / 1024) + "M");

        System.out.println(Book.class.getClassLoader());
        System.out.println(String.class.getClassLoader());

        Class<? extends Object[]> classArray = new Object[1].getClass();
        System.out.println(classArray.getCanonicalName()); // java.lang.Object[] (获取所传类从java语言规范定义的格式输出)
        System.out.println(classArray.getName()); // [Ljava.lang.object; (实体类型名称)
        System.out.println(classArray.getSimpleName()); // object[] (返回从源代码中返回实例的名称)

        //集合的isEmpty方法只能判断集合中的元素是否为空,不能用于判断集合对象本身是否为null
        ArrayList<String> arrayList = null;
//        System.out.println(arrayList.isEmpty());
        arrayList = new ArrayList<>();
        System.out.println(arrayList.isEmpty());

        //StringUtils.hasText(),null、""、" "三种情况为false,其他情况为true
        System.out.println(org.springframework.util.StringUtils.hasText(null));
        System.out.println(org.springframework.util.StringUtils.hasText(""));
        System.out.println(org.springframework.util.StringUtils.hasText(" "));

        String name = "李白";
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String s = Integer.toHexString(chars[i]);
            System.out.println("字符："+chars[i] + ",对应的unicode编码是：" + s);
        }

        printArgs(1,2,3);
        System.out.println();
        printArgs(1,2,3,4,5);
        System.out.println();

        //获取自1970.1.1 0时0分0秒到现在的毫秒数
        System.out.println(System.currentTimeMillis());

        //方法一
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTimeInMillis());

        //方法二
        System.out.println(Clock.systemDefaultZone().millis());

        //方法三
        //yyyy-MM-dd HH:mm:ss.SSS 带毫秒的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(sdf.format(new Date()));

        char[] value = null;
//        System.out.println(value.length);

        //编程习惯问题，equals最好不要将变量放在前面，否则变量为空的时候会报空指针异常
        String username = null;
//        System.out.println(username.equals("chenjy"));
        System.out.println("chenjy".equals(username));

        //和null的比较，null放在前面
        System.out.println(null == username);

        Integer num = 2;
        System.out.println(num);
        System.out.println(num << 2);

        String open = "true";
        System.out.println(open);//String类型的"true"字符串
        System.out.println(Boolean.valueOf(open));//Boolean类型的true

        System.out.println(MIMEType.getSuffix("image/gif"));
        MIMEType.types.forEach((k,v) -> {
            System.out.println("key=="+k);
            System.out.println("value=="+v);
        });

        String testStr = "";
        System.out.println(ValidateMT.isNotNull(testStr));

        List<String> testList = new ArrayList<>();
        System.out.println(ValidateMT.isNotNull(testList));

        Map<String,Object> map = new HashMap();
        System.out.println(ValidateMT.isNotNull(map));

        System.out.print("chenjy");
        System.out.print("\n");
        System.out.print("liuxy");
        System.out.print("\n");

        //final修饰的基本数据类型值不能改变;final修饰的引用类型，指针地址不能改变
        final int count = 0;
        //count = count + 1;

        final Book book = new Book();
        book.setAuthor("罗贯中");
        book.setId(1l);
        book.setName("三国演义");
        System.out.println(book);

        book.setId(2l);
        System.out.println(book);

        double d = 0;
        System.out.println(d);

        System.out.println(Math.round(-2.5));
        System.out.println(Math.round(-2.6));
        System.out.println(Math.round(2.6));

        String str1 = null;
        System.out.println(StringUtils.isEmpty(str1));
        System.out.println(StringUtils.isBlank(str1));

        String str2 = "";
        System.out.println(StringUtils.isEmpty(str2));
        System.out.println(StringUtils.isBlank(str2));

        String str3 = " ";
        System.out.println(str3.length());
        System.out.println(StringUtils.isEmpty(str3));
        System.out.println(StringUtils.isBlank(str3));

        Person person = new Person();
        person.setName("Jack");
        person.setAge(26);
        person.setCountry("China");
        person.setSex('M');

        System.out.println(person);

        String test = "hello";
        System.out.println(test.getClass().getName());
        System.out.println(test.getClass().getSimpleName());
        System.out.println(test.getClass().getTypeName());
        System.out.println(test.getClass().getSuperclass());
        System.out.println(test.getClass().getGenericSuperclass());

        System.out.println("HashMap=======");
        System.out.println(HashMap.class.getSuperclass());
        System.out.println(HashMap.class.getGenericSuperclass());

        System.out.println("String=======");
        System.out.println(String.class.getSuperclass());
        System.out.println(String.class.getGenericSuperclass());

        System.out.println("Integer=======");
        System.out.println(Integer.class.getSuperclass());
        System.out.println(Integer.class.getGenericSuperclass());

        //getSuperclass：返回直接继承的父类(由于编译擦除,没有显示泛型参数)
        //getGenericSuperclass：返回直接继承的父类(显示泛型参数)

        System.out.println("数组===========");

        //比较getName和getTypeName的区别
        System.out.println(String[].class.getName());
        System.out.println(String[].class.getTypeName());

        System.out.println(String[].class.getSimpleName());
        System.out.println(String[].class.getCanonicalName());

        Object object = Object.class;
        System.out.println(object);

        System.out.println("---------------");

        Integer integer = new Integer(3);
        System.out.println(integer.equals(3));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTime.now());
        System.out.println(formatter.format(LocalDateTime.now()));

        String s1 = "jack";
        String s2 = "jack";
        String s3 = new String("jack");
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s2 == s3);//false

        /**
         * 以下代码将抛出异常，因为string和Integer没有继承关系
         */
        /*Object o = Integer.valueOf(100);
        String s = (String) o;
        System.out.println(s);*/

        String[] strArray = {"zhangsan","lisi","wangwu"};
        for(String str: Arrays.asList(strArray)){
            System.out.println(str);
        }

        List<String> strList = new ArrayList<>();
        Collections.addAll(strList,"China","USA","UK");
        Object[] countryArray = strList.toArray();
        for(int i=0;i<countryArray.length;i++){
            System.out.println(countryArray[i]);
        }

        TopTest.div(1,0);

        TopTest.show("zhangsan",25);
        TopTest.show(null,25);

        String className = "Train";
        System.out.println(className);
        System.out.println(StringUtils.uncapitalize(className));

        A<String> a = new A();
        a.setId(10);
        a.setT("hello");
        System.out.println(a.toString());

        Class c1 = Object.class;
        System.out.println(c1.getTypeName());
        System.out.println(String.class.getTypeName());

        Integer i1 = 300;
        Integer i2 = 300;
        System.out.println(i1 == i2);

        Class[] cls = new Class[]{String.class,int.class};
        for(Class clazz:cls){
            System.out.println(clazz.getName());
        }

       /* Field field = null;
        field.getAnnotation(Annotation.class);*/

        String[] arr = {"hello","world"};
        Stream.of(arr).collect(Collectors.toList()).forEach(x -> System.out.println(x));

        int[] tmp = {1,2,3,4,5};
        Class<?> clazz = tmp.getClass().getComponentType();
        Object newArr = Array.newInstance(clazz,15);
        int len = tmp.length;
        System.arraycopy(tmp,0,newArr,0,len);

        Stream.of(newArr).collect(Collectors.toList()).forEach(x -> System.out.println(x));

        for (int i:tmp){
            System.out.println(i);
        }
        System.out.println(tmp.length);

        System.out.println("===================");


        System.out.println(TopTest.randomInt(5, 10));

        StringBuffer sb = new StringBuffer("hello");
        System.out.println(sb.deleteCharAt(0));

        /*
         *DecimalFormat
         */
        DecimalFormat df = new DecimalFormat("0");
        df.setRoundingMode(RoundingMode.DOWN);
        System.out.println(df.format(100.56545f));
        System.out.println(df.format((float) 1/3));
        System.out.println(NumberFormat.getCurrencyInstance().getCurrency().getDisplayName());
        System.out.println(NumberFormat.getCurrencyInstance().getCurrency().getSymbol());

        /*Student stu = new Student(1,"chenjy",27);
        Student stu2 = stu;
        stu2.setAge(100);
        System.out.println(stu2.getAge());
        System.out.println(stu.getAge());

        int a=10;
        int b=a;
        System.out.println(b);
        b = 100;
        System.out.println(b);
        System.out.println(a);

        System.out.println("===================");
        System.out.println(System.identityHashCode(stu));
        System.out.println(System.identityHashCode(stu2));
        System.out.println(stu==stu2);*/

       /* Employee employee = new Employee(1,"chenjy");
        System.out.println(employee.hashCode());
        System.out.println(employee);

        Employee clone = null;
        Employee clone2 = null;
        try {
            clone = (Employee) employee.clone();
            clone2 = (Employee) employee.clone();
            System.out.println(clone.hashCode());
            System.out.println(clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(employee == clone);
        System.out.println("克隆值比较==="+(clone == clone2));


        char c = '1';
        System.out.println(Character.isDigit(c));

        ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
            @Override
            protected String initialValue() {
                return Thread.currentThread().getName();
            }
        };
        System.out.println(threadLocal.get());

        // shiro MD5加盐hash算法
        Md5Hash md5 = new Md5Hash(SystemConstant.DEFAULT_PASSWORD,SystemConstant.MD5_SALT,1);
        System.out.println(md5);*/

        /*String html = "<html><body><h1>hello world</body></html>";
        System.out.println(html);
        System.out.println(StringEscapeUtils.escapeHtml4(html));*/

        /*Employee e = new Employee(1,"chenjy");
        System.out.println(e);
        System.out.println(e.getEname().getClass().toString());

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
        System.out.println(aa.compareTo(BigDecimal.ZERO)==0);*/

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

    private static int randomInt(int min, int max){
        return new Random().nextInt(max)%(max-min+1) + min;
    }

    public static void show(String name, int age){
        System.out.println("name="+name+",age="+age);
    }

    public static void div(int a,int b){
        try {
            System.out.println(a/b);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getSimpleName());
            //e.printStackTrace();
        }
    }

    public static void printArgs(Object... args){
        for(Object obj:args){
            System.out.printf("%s ",obj);
        }
    }

    /**
     * @see Test#say(java.lang.String, java.lang.String)
     * @see com.ruida.springbootdemo.test.Test#say(String, String)
     * @param a
     */
    @Deprecated
    public void say(String a){
        System.out.println(a);
    }

    public  List<Object> getUserInfo(){
        //返回集合的数组建议返回空集合而不是null,调用端不用进行null值判断
        return Collections.emptyList();
    }

    @org.junit.Test
    public void test1(){
        System.out.println(getUserInfo().size());
    }

    public void aaa(Object obj){
//        assert obj != null : "input args can not be null!";
//        Assert.notNull(obj,"入参不能为空");
        Objects.requireNonNull(obj,"obj can not be null");
    }

    @org.junit.Test
    public void testAssert(){
        aaa(null);
    }

    //模拟Arrays.toString(int[] a)
    public String arraysToString(int[] a){
        if(a == null)
            return "null";

        int iMax = a.length - 1;
        if(iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if(i == iMax)
                return b.append("]").toString();
            b.append(", ");
        }
    }

    @org.junit.Test
    public void test2(){
//        int[] arr = null; // null
        int [] arr = new int[0]; // 空
//        int[] arr = new int[]{1,2,3}; // 有数据
        System.out.println(arraysToString(arr));
    }

    @org.junit.Test
    public void test3(){
        for (int i = 0; i < 10; i++) {
            if(i == 5){
                System.out.println(i);
                break;
                //continue;
            }
            System.out.println(i);
        }
    }

    @org.junit.Test
    public void test4(){
        Map<String,Object> map = new HashMap();
        map.put("status",0);
        System.out.println(Objects.equals(map.get("status"),"0"));

        String a = "0";
        System.out.println(a.equals("0"));
    }

    @org.junit.Test
    public void test5(){
        List<String> list = Arrays.asList("jack", "mike", "tom");
        System.out.println(StringUtils.join(list,"|"));
    }

    @org.junit.Test
    public void test6(){
        System.out.println(TimeUtil.getDateFormat(new Date()));

        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR,2021);
        instance.set(Calendar.MONTH,2);
        instance.set(Calendar.DAY_OF_MONTH,1);
        instance.set(Calendar.HOUR_OF_DAY,12);
        System.out.println(instance.getTime());
        System.out.println(TimeUtil.getDateFormat(instance.getTime()));
    }

    /**
     * jdk1.8新增方法
     */
    @org.junit.Test
    public void test7(){
        ArrayList<User> users = Lists.newArrayList(
                new User("Jack", 21),
                new User("Mike", 35),
                new User("Amy", 13)
        );

        users.removeIf(e -> e.getAge() < 20);
        System.out.println(users);
    }

    @org.junit.Test
    public void test8(){
//        1 != "1"
        System.out.println(Objects.equals(String.valueOf(1),"1"));
    }

    @org.junit.Test
    public void test9(){
        User user = new User("Jack",21);
        UserDTO userDTO = new UserDTO();
        System.out.println(userDTO);
        BeanUtils.copyProperties(user,userDTO);
        System.out.println(userDTO);

        User user1 = null;
        UserDTO userDTO1 = new UserDTO();
        BeanUtils.copyProperties(user1,userDTO1);
        System.out.println(userDTO1);

        User user2 = new User("Mike",22);
        UserDTO userDTO2 = null;
        BeanUtils.copyProperties(user2,userDTO2);
        System.out.println(userDTO2);

        //SpringFramework BeanUtils.copyProperties方法source和target都不能为null

        //另外，阿里巴巴代码规范不建议使用Apache 的BeanUtils.copyProperties，原因是性能较差。建议使用Spring BeanUtils 或者Cglib BeanCopier
    }

    @org.junit.Test
    public void test10(){
        List<User> userList = Lists.newArrayList(
                new User("Jack",10),
                new User("Mike",30)
        );

        //使用list.clear效率比list.removeAll(list)高
        userList.clear();
        System.out.println(userList);
        System.out.println(userList.size());
    }

    @org.junit.Test
    public void test(){
        throw new BaseException(ErrorEnum.SERVER_ERR.getErrorCode(),"自定义异常");
    }
}
