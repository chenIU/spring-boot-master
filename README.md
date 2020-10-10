### spring boot demo

+ 多态的必要条件
    + 继承
    + 重写
    + 父类引用指向子类对象
    
+ 静态属性、静态方法都可以被继承和隐藏，但是不能被重写，因此不能实现多态。

+ 自定义异常注意实现
    + 必须继承自Exception或Exception的子类，常用RuntimeException
    + 必须提供无参构造方法
    + 必须实现String message的一参构造方法，super(message)
    
+ 泛型
    + <数据类型> 只能是引用类型
    + <? extends T> 传入的只能是T或T的子类
    + <? super T>   传入的只能是T或T的父类
    + 泛型上限和下限的原则：PECS(Producer Extends Consumer Super)
    
+ Integer和int的区别
    + Integer缓存了[-128,127]之间的数据;
    + Integer默认是null，可以区分未赋值和值为0的情况;
    + 加减乘除和比较用的比较多时，使用int;
    + 容器里建议使用Integer;
    + 对于PO实体类，如果数据库里字段允许为null，应使用Integer。如果不允许使用null，则可以考虑使用int;
    + Integer提供了一系列方法，不过一般使用的较少;
    + 建议使用int，这样一方面省去了装箱和拆箱的过程，另一方面也避免了数据比较可能带来的bug。
    
+ 工厂模式：属于创建型模式，常用于创建对象。

+ join 如果某个线程在另一个线程t上调用了t.join();那么此线程将被挂起，直到目标线程t结束才恢复。

+ isEmpty()认为空字符串(" ")不是空，isBlank()认为空字符串是空。