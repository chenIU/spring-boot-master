package com.ruida.springbootdemo.reflect;


import com.ruida.springbootdemo.model.Cat;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-30 11:49
 */
@Slf4j
public class ReflectionTest {

    private static final String TAG = "Reflection";

    @Test
    public void test(){
        Class<?> clazz = HashMap.class;
        log.info("Class:{}",clazz.getCanonicalName());
        log.info("Modifier:{}",Modifier.toString(clazz.getModifiers()));

        TypeVariable<? extends Class<?>>[] typeParameters = clazz.getTypeParameters();
        if(typeParameters.length != 0){
            StringBuilder stringBuilder = new StringBuilder("Parameter:");
            for(TypeVariable tv:typeParameters){
                stringBuilder.append(tv.getName());
                stringBuilder.append(" ");
            }
            log.info(stringBuilder.toString());
        }else {
            log.info(" -- No Type Parameters -- ");
        }

        //获取类实现的所有接口
        Class<?>[] interfaces = clazz.getInterfaces();
        if(interfaces.length != 0){
            StringBuilder stringBuilder = new StringBuilder("Implemented Interfaces:");
            for(Type type:interfaces){
                stringBuilder.append(type.getTypeName());
                stringBuilder.append(" ");
            }
            log.info(stringBuilder.toString());
        }else {
            log.info("  -- No Implemented Interfaces --");
        }

        //获取类继承的所有父类
        List<Class> classList = new ArrayList<>();
        getAncestor(clazz,classList);
        if(classList.size() != 0){
            StringBuilder stringBuilder = new StringBuilder();
            for(Class<?> c:classList){
                stringBuilder.append(c.getCanonicalName());
                stringBuilder.append(" ");
            }
            log.info(stringBuilder.toString());
        }else {
            log.info(" -- No SuperClass --");
        }

        //获取类的所有注解(只能获取到Runtime类型的注解)
        Annotation[] annotations = clazz.getAnnotations();
        if(annotations.length != 0){
            StringBuilder stringBuilder = new StringBuilder();
            for(Annotation annotation:annotations){
                stringBuilder.append(annotation.toString());
                stringBuilder.append(" ");
            }
            log.info(stringBuilder.toString());
        }else {
            log.info(" -- No Annotations --");
        }
    }

    private void getAncestor(Class<?> clazz,List<Class> classList){
        Class<?> superclass = clazz.getSuperclass();
        if(superclass != null){
            classList.add(superclass);
            getAncestor(superclass,classList);
        }
    }

    //Member
    //java.lang.Field
    //java.lang.Method
    //java.lang.Constructor

    /**
     * Field
     * getDeclaredField(String name) 获取指定类型的变量(只要声明就能获取，包括private修饰的变量)
     * getField 获取指定类型的变量(只能获取到被public修饰的变量)
     * getDeclaredFields 获取所有类型的变量,包括private
     * getField 获取所有public类型的变量
     */
    @Test
    public void testField(){
        Class<?> clazz = Cat.class;
        Field[] fields = clazz.getDeclaredFields();
        for(Field f : fields){
            StringBuilder sb = new StringBuilder();
            sb.append("field name = ");
            sb.append(f.getName());

            sb.append(" type = ");
            sb.append(f.getType());

            sb.append(" modifier = ");
            sb.append(Modifier.toString(f.getModifiers()));

            Annotation[] annotations = f.getAnnotations();
            if(annotations.length != 0){
                sb.append(" annotations = ");
                for(Annotation annotation : annotations){
                    sb.append(annotation.toString());
                    sb.append(" ");
                }
            }else {
                sb.append(" -- No Annotations --");
            }
            log.info(sb.toString());
        }
    }

    /**
     * Method
     *
     * 获取方法(Class依然提供了四种方法获取Method)
     * getDeclaredMethod(String name,Class<?>... parameterTypes) 根据方法名称和参数类型获取所有类型的方法
     * getMethod(String name,Class<?>... parameterTypes) 根据方法名称和参数类型获取所有public类型的方法
     * getDeclaredMethods() 获取所有方法
     * getMethods() 获取所有public方法
     *
     * 获取方法返回类型
     * getReturnType()：获取目标方法返回类型对应的Class对象
     * getGenericReturnType()：获取目标方法返回类型对应的Type对象
     * 1.方法返回值为普通简单对象,如Object,int,String等.两者一样
     * 例如：public String function()
     * getReturnType：class java.lang.String
     * getGenericReturnType()：class java.lang.String
     * 2.方法返回值为泛型
     * 例如：public T function()
     * getReturnType()：class java.lang.Object
     * getGenericType()：T
     * 3.返回值为参数化类型
     * 例如：public Class<String> function()
     * getReturnType：class java.lang.Class
     * getGenericType：java.lang.Class<java.lang.String>
     *
     * 获取方法参数类型
     * getParameterTypes()：获取目标方法各参数类型对应的Class对象
     * getGenericParameterTypes()：获取目标方法各参数类型对应的Type对象
     *
     * 获取方法声明抛出的异常类型
     * getExceptionTypes()：获取目标方法各参数类型对应的Class对象
     * getGenericExceptionTypes()：获取目标方法各参数类型对应的Type对象
     *
     * 其他常用方法：
     * method.getModifiers()：获取方法修饰符
     * method.isVarArgs()：判断方法参数是否为可变参数
     */
    @Test
    public void testMethod() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Cat.class;
        Constructor constructor = c.getConstructor(String.class,Integer.class);
        Object cat = constructor.newInstance("Tom", 20);
        log.info(cat.toString());

        //调用无参方法
        Method sleep = c.getDeclaredMethod("sleep");
        sleep.invoke(cat);

        //调用定项参数方法
        Method eat = c.getDeclaredMethod("eat", String.class);
        eat.invoke(cat,"fish");

        //调用不定项参数方法
        //不定项参数可以当作数组处理
        Class[] argType = new Class[]{String[].class};
        Method varArgsEat = c.getDeclaredMethod("eat", argType);
        String[] args = new String[]{"fish","meat"};
        varArgsEat.invoke(cat,(Object) args);
    }
    //反射不支持自动装箱,因为装箱发生在编译时期,而反射发生在运行时期

    /**
     * Constructor
     * getDeclaredConstructor(Class<?>... parameterType)：获取指定的构造函数
     * getConstructor(Class<?>... parameterType)：获取指定的public类型构造函数
     * getDeclaredConstructors：获取所有声明的构造方法
     * getConstructors：获取所有public类型的构造方法
     *
     * 1.Class.newInstance()仅可以调用无参构造方法;Constructor.newInstance()可以调用任意构造方法
     * 2.Class.newInstance()会将构造方法中的异常原封不动的抛出;Constructor.newInstance()会将构造方法中的异常包装成InvocationTargetException抛出
     * 3.Class.newInstance()需要拥有构造方法的访问权限;Constructor.newInstance()可以通过Constructor.setAccessible(true)绕过权限检查
     */
    @Test
    public void testConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> c = Cat.class;
        Constructor<?> constructor = c.getConstructor(String.class, Integer.class);
        Object cat = constructor.newInstance("Tom", 20);
        log.info(cat.toString());
    }

    /**
     * 数组(数组的本质是一个对象，所以它也有自己的类型)
     * 例如对于int[],数组类型是class[I,其中类型中[代表数组的维度,[代表一维数组,[[代表二维数组.[后面的字母代表数组中的元素类型,I代表int,一般为类型首字母大写(long除外，为J)
     * class[B byte类型的一维数组
     * class[S short类型的一维数组
     * class[I int类型的一维数组
     * class[C char类型的一维数组
     * class[J long类型的一维数组，J代表long类型，因为L被引用类型占用了
     * class[F float类型的一维数组
     * class[D double类型的一维数组
     * class[Ljava.lang.String 引用类型的一维数组
     * class[[Ljava.lang.String 引用类型的二维数组
     */
    @Test
    public void testArray(){
        //用反射创建数组
        Object array = Array.newInstance(int.class, 2);
        Array.setInt(array,0,1);
        Array.setInt(array,1,2);
        System.out.println(Arrays.toString((int[]) array));
//        System.out.println(Arrays.deepToString((Object[]) array));
    }

    /**
     * 其他方法
     * 注解中常用方法
     * 1.Annotation[] annotations = (Annotation[]) class.getAnnotations();//获取class对象的所有注解
     * 2.Annotation annotation = (Annotation) class.getAnnotation(Deprecated.class);//获取class对象指定注解
     * 3.Type genericSuperclass = class1.getGenericSuperclass();//获取class对象的直接超类的
     * 4.Type Type[] interfaceTypes = class1.getGenericInterfaces();//获取class对象的所有接口的type集合
     *
     * 获取Class对象的其他方法
     * clazz.isPrimitive();//判断是否是基础类型
     * clazz.isArray();//判断是否为数组类型
     * clazz.isAnnotation();//判断是否为注解类
     * class.isInterface();//判断是否为接口
     * clazz.isEnum();//判断是否为枚举
     * clazz.isAnonymousClass();//判断是否为匿名内部类
     * clazz.isAnnotationPresent(Deprecated.class);//判断是否被某个注解类修饰
     * clazz.getName();//获取class名字,包含包路径
     * clazz.getPackage();//获取class的包信息
     * clazz.getSimpleName();//获取class类名
     * clazz.getModifier();//获取class访问权限
     * clazz.getDeclaredClasses();//获取内部类
     * clazz.getDeclaringClass();//外部类
     * clazz.getClassLoader();//返回类加载器
     * clazz.getSuperclass();//获取所有的父类
     * class.getInterfaces();//获取所有实现的接口
     */

    /**
     * 枚举
     * Class.isEnum();//判断一个类是否是枚举类
     */

    /**
     * 反射的缺点
     * 1.性能问题：因为反射是在运行时而不是在编译时，所有不会利用到编译优化，同时因为是动态生成，因此，反射操作的效率要比那些非反射操作低得多。
     * 2.安全问题：使用反射技术要求程序必须在一个没有安全限制的环境中运行。如果一个程序必须在有安全限制的环境中运行，如Applet，那么这就是个问题了。
     * 3.代码问题：由于反射允许代码执行一些在正常情况下不被允许的操作（比如访问私有的属性和方法），所以使用反射可能会导致意料之外的副作用－－代码有功能上的错误，
     * 降低可移植性。反射代码破坏了抽象性，因此当平台发生改变的时候，代码的行为就有可能也随着变化。
     */

}
