### spring boot demo

+ 多态的必要条件
    + 继承
    + 重写
    + 父类引用指向子类对象
+ 静态属性、静态方法都可以被继承和隐藏，但是不能被重写，因此不能实现多态。
+ 自定义异常注意实现
    + 必须继承自Exception或Exception的子类，常用RuntimeException
    + 必须提供无参构造方法
    + 必须实现String messsage的一参构造方法，super(message)