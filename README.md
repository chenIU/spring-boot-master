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

+ @Autowired和@Resource的区别
  + Autowired注解属于Spring,Resource注解属于JavaEE;
  + Autowired默认根据byType注入,Resource在不指定name和type属性的情况下根据byName注入;
  + 当一个类型的bean有多个时Autowired注解可以结合Qualifier注解指定具体的bean名称,Resource可以通过指定name属性来区分不同的bean。
  
+ @Resource的装配顺序
  + 如果同时指定了name和type属性,则Spring在上下文中找到唯一匹配的bean进行装配,找不到则抛出异常;
  + 如果只指定了name属性,则在上下文中按照名称(id)查找bean进行装配,找不到则抛出异常;
  + 如果只指定了type属性,则在上下文中找到类型匹配的唯一bean,找不到或者找到多个,都会抛出异常;
  + 如果既没有指定name也没有指定type属性,则自动按照byName的方式装配;如果没有装配,则回退为一个原始类型进行匹配,如果匹配则自动装配.
  
**在注入属性的时候推荐使用@Resource注解,这个注解属于J2EE,减少了与Spring的耦合.**

`@Controller、@Service、@Component、@Repository：注入bean`
`@Autowired、@Resource：装配bean`

+ maven的scope类型:
  + compile,默认值是compile。compile表示被依赖的项目需要参与当前项目的编译,包括后续的测试和运行周期也参与其中,是一种比较强的依赖。打包的时候通常需要包含进去。
  + test 表示被依赖的项目仅仅参与参与测试相关的工作,包括测试代码的编译和执行,比较典型的是junit。
  + runtime 表示被依赖的项目无需参与项目的编译,不过后期的测试和运行需要其参与。与compile相比,跳过编译而已。
  + provided 以为着打包的时候不需要包含进去,别的终端设施(web container)会提供。事实上该依赖理论上可以参与编译、测试和运行。相当于compile,但是在打包阶段做了exclude的动作。
  + system 和provided相同,不过依赖不会从maven仓库中获取,而是在本地文件系统中拿,一定要配合systemPath使用。
  
+ HikariPool在配置单数据源时DataSource是:spring.datasource.url;多数据源时是:spring.datasource.jdbc-url

+ @Primary：当一个类型的bean在Spring容器中有多个实例时，使用此注解可以在装配的时候优先被选用

+ @Order
  + 该注解标记了组件的加载顺序，值越小拥有越高的优先级，可以为负数
  + @Order(-1)高于@Order(0)
  + @Order(1)高于@Order(2)
  
+ 启动项目时指定配置文件位置：java -jar xxx.jar --spring.config.location=classpath:/javaboy/
+ 启动项目时指定配置文件名称：java -jar xxx.jar --spring.config.name=app
+ 启动项目时指定端口：java -jar xxx.jar --server.port=8888

+ MyBatis中使用@Param注解的情况
  + 参数引入别名
  + XML中的SQL使用了$
  + 动态SQL
需要注意的是：多个参数的查询语句不需要强制添加@Param

+ static目录下静态资源默认是可以访问到的

+ java配置要优于配置文件配置

+ 条件注解
  + @ConditionalOnBean：当给定的bean存在时，实例化当前bean(名称)
  + @ConditionalOnMissingBean：当给定的bean不存在时，实例化当前bean(名称)
  + @ConditionalOnClass：当给定的类名在类路径上存在时，实例化当前bean(类型)
  + @ConditionalOnMissingClass：当给定的类名在类路径上不存在时，实例化当前bean(类型)
  
+ @Autowired
  + 该注解默认需要装配的bean实例一定存在，如果可能不存在，需要加上required = false
  
+ @ConfigurationProperties支持Spring宽松绑定
  + mail.host-name=localhost
  + mail.host_name=localhost
  + mail.HOST-NAME=localhost
  + mail.hostname=localhost
  + mail.hostName=localhost
  **以上几种都可以绑定到hostName属性上**
  
+ yaml文件和properties文件的对比
  + yaml文件的优势：配置有序
  + 不支持@PropertySource,只能从application.yml(properties)中读取
  
+ File类中mkdir和mkdirs方法的区别：mkdir需要父路径存在;mkdirs没有此限制,可以级联创建

+ @Configuration和@Component的区别是：前者的bean是singleton类型，后者是prototype类型。

+ 整型最高位0表示正数，1表示负数。

+ JDK1.7中HashMap冲突时，链表采用头插法；1.8采用尾插法。

+ String、StringBuilder、StringBuffer的区别和联系：
  + String 底层采用了一个不可变字符数组private final char value[],所以它的内容不可变;
  + StringBuilder 和 StringBuffer都继承自AbstractStringBuilder,底层是可变数组char[] value;
  + StringBuilder不是线程安全的，效率较高；StringBuffer是线程安全的，效率较低；
  + 执行速度StringBuilder > StringBuffer > String
  
+ 如何让HashMap实现线程同步：Map map = Collections.synchronizeMap(hashmap);

+ Executors创建线程池
  + newFixedThreadPool()：创建固定大小的线程池
  + newSingleThreadPool()：创建单个线程池
  + newCachedThreadPool()：创建无限大小的线程池，线程池中线程的数量不固定，可根据实际情况更改
  + newScheduledThreadPool()：创建固定大小的线程池，可以延迟或定时执行任务

+ 实现多线程的方法：
  + 继承Thread类
  + 实现Runnable接口
  + 实现Callable接口，利用task接受异步线程执行的结果
  
+ JDK1.8之后switch可以作用byte、short、int、char、boolean、string和enum上

+ ArrayList的默认大小是10；HashMap的默认大小是16。

+ Array可以存放基本类型和引用类型；ArrayList只能存放引用类型。

+ ArrayList扩容只会增加50%，而Vector扩容时增加1倍。

+ Queue的poll方法和remove方法的区别:
  + 两者都是返回一个元素，并在队列中删除返回的对象。
  + 如果没有元素poll()会返回null，而remove方法则会抛出NoSuchElementException异常。
  
+ http状态码301永久重定向，302暂时重定向。

+ sleep和wait的区别：
  + 来源不同：sleep来自Thread类,wait来自Object类;
  + 用法不同：sleep时间到时会自动恢复,wait需要notify或者notifyAll唤醒;
  + 持有锁的不同：sleep不释放锁,wait释放锁。
  + sleep可以作用在任何地方,wait方法只能作用于同步代码块中。
  
+ sleep和yield方法的区别：
  + sleep方法不会考虑线程的优先级，所以可能会给低优先级的线程运行机会；yield方法只会给相同优先级或更高优先级的线程运行机会
  + sleep方法调用之后，线程会进入阻塞状态；yield方法调用之后，线程会进入到就绪状态；
  + sleep方法声明时抛出了异常；yield方法则没有
  + sleep方法比yield方法具有更好的移植性。
  
+ 线程池中execute和submit方法的区别：
  + execute只能执行runnable类型的任务(提交不需要返回值的任务)
  + submit可以执行runnable和callable类型的任务(提交需要返回值的任务)

+ ThreadPoolExecutor 构造方法参数说明：
  + corePoolSize：核心线程数，定义了最小可以同时运行的线程数量
  + maximumPoolSize：最大线程数，当队列中存放的任务达到队列容量的时候，当前可以同时运行的线程数量变为最大线程数
  + keepAliveTime：存活时间，当线程池中线程数量大于corePoolSize的时候，如果这时候没有新的任务提交，核心线程数不回立即销毁，而是等待，直达等待时间超过了keepAliveTime才会被销毁
  + unit：时间单位，keepAliveTime参数的时间单位
  + workQueue：工作队列，当新任务来的时候会判断当前运行的线程数量是否达到核心线程数，如果达到的话，新任务会被存放到队列中
  + threadFactory：线程工厂，创建新线程的时候会用到
  + handler：拒绝策略
  
+ 线程池的拒绝策略
  + AbortPolicy：默认的拒绝策略，抛出 RejectedExecutionException 异常
  + CallerRunsPolicy：提交任务的线程自己去执行该任务
  + DiscardOldestPolicy：丢弃最老的任务，加入新的任务
  + DiscardPolicy：直接丢弃任务，不抛出异常
  
+ 引用数据类型
  + 类
  + 接口
  + 数组
  
+ 变量类型
  + 类变量（堆）
  + 成员变量（堆）
  + 局部变量（栈）
  
+ 可变参数是jdk1.5之后出现的新特点

+ POJO类中使用包装数据类型、RPC接口使用包装类型、局部变量使用基本数据类型

+ clone方法需要注意的点：
  + Object类的clone方法是本地方法,重载之后要把访问修饰符改为public
  + clone方法的返回值是一个Object对象
  
+ 修饰符问题：
  + public：所有地方都能访问
  + protected：同类、同包、子类能访问；不同包且无继承关系的类不能访问
  + default：同类、同包能访问；子类和不同包都不能访问
  + private：只有同类中能访问
  
+ 常见数据类型所处的包：
  + java.lang.String
  + java.lang.Integer
  + java.lang.Double
  + java.util.Date
  + java.util.HashMap
  + java.math.BigDecimal
  
+ Java中泛型T和?的区别：
  + "T"是定义类或者方法时声明的东西,"?"是调用时传入的东西,二者的概念不同;
  + Class<T>在实例化的时候,T要被替换成具体的类型,Class<?>代表通用泛型,?可以指代任何东西;
  + Class<? extend T>:有上限,表示T或者T的子类,Class<? super T>:有下限,表示T后者T的父类
  
+ 四种引用类型的区别：
  + 强引用(Strong Reference)：如果JVM垃圾回GC可达性分析为可达,即使JVM发生OOM改对象也不会被回收;
  + 软引用(Soft Reference)：在JVM内存充足的情况下,软引用对象不会被回收。当内存不足的时候,才会被垃圾回收器回收;
  + 弱引用(Weak Reference)：弱引用是一种比软引用更短的引用,不论当前内存是否充足,这些引用都只能活到下一次垃圾回收之前;
  + 虚引用(Phantom Reference)：最弱的一种引用类型,随时都有可能被GC回收
  
+ final关键字的功能概述
  + 用来修饰一个引用
    + 如果引用为基本数据类型,则该引用为常量,该值无法被修改;
    + 如果引用为引用数据类型,比如对象、数组,则该对象本身可以修改,但指向该对象或者数组地址的引用不可修改;
    + 如果引用是类的成员变量,则必须当场赋值,否则编译报错。
  + 用来修饰一个方法 当final修饰一个方法时,这个方法将成为最终方法,无法被子类重写。但是,该方法仍然可以被继承。
  + 用来修饰类 当final修饰一个类时,该类成为最终类,无法被继承。

+ JVM内存区域中栈、虚拟机栈、程序计数器是线程私有的,堆和方法区(类元信息、方法元信息、常量池)是线程之间共享的。

+ 方法内部建议使用StringBuilder,因为StringBuilder效率高,而且方法方法内部的局部变量不用考虑线程安全的问题。

+ volatile关键字的作用
  + 保证可见性
  + 不保证原子性
  + 禁止指令重排
  
+ Java中常见的Error
  + OutOfMemoryError
  + StackOverFlowError
  + NoSuchFieldError
  + NoSuchMethodError
  
+ = 赋值操作的含义
  + 对于基本数据类型来说,"="赋值操作是直接改变内存地址上的值;
  + 对于引用类型来说,"="赋值操作是改变引用变量所指向的内存地址;
  
+ 常见的类加载器(双亲委派)
  + Boostrap Classloader
  + Extension Classloader
  + Application Classloader
  
+ Runtime类中常用方法
  + availableProcessors：获取可用的处理器数量
  + getRuntime：获取一个运行时环境
  + exec：在单独的进程中执行指定的字符串命令
  + maxMemory：JVM虚拟机中最大的内存空间(字节)
  + totalMemory：JVM虚拟机初始总内存(字节)
  + freeMemory：可用内存
  
+ 线程安全的map
  + HashTable
  + ConcurrentHashMap
  + Collections.synchronizedHashMap(new HashMap<String,Object>())
  
+ jdk1.5新特性
  + 泛型
  + 自动装箱和拆箱
  + 枚举
  + 可变参数
  + 注解
  + 新的迭代语句
  + java.util.Formatter
  + juc并发包
  
+ jdk1.8新特性
  + Lambda表达式
  + Stream API
  + Date API
  + 函数式接口
  + 方法引用和构造器引用
  + 接口中静态方法和默认方法
  
+ @Configuration和@Component注解的主要区别是：前者会被ConfigurationClassPostProcessor后者拦截器拦截,被代理,相同的类会复用(singleton)。

+ PreparedStatement和Statement的主要区别：前者是预编译的，可以防止SQL注入，而后者不能。

+ Spring常见的注入方式：setter、constructor、注解

+ Spring的核心类：DispatcherServlet

+ HashMap链表树化的条件：1.链表的长度超过8；2.桶的个数超过64
  
+ InnoDB和MyISAM数据引擎的区别：
  + 前者支持事务；后者不支持
  + 前者支持行级锁；后者只支持表级锁
  + 前者支持外键；后者不支持
  + 前者不支持全文索引，后者支持
  
+ volatile和synchronized的区别：
  + volatile仅可改变变量的可见性；而synchronized可以保证变量的可见性和原子性
  + volatile只可作用于变量；而synchronized可以作用在变量、方法和类上
  + volatile不回造成线程阻塞；而synchronized会造成线程阻塞
  
+ mybatis的底层是基于jdk动态代理(**MappedStatement**对象)，利用RowBounds对象进行分页

+ Spring中自动装配的方式：
  + no：不进行自动装配，手动设置Bean的依赖关系
  + byName：根据Bean的名字进行装配
  + byType：根据Bean的类型进行装配
  + constructor：类似于byType，不过是应用于构造器的参数，如果正好有一个Bean与构造器的参数类型相同则可以自动装配，否则会导致错误。
  + autodetect：如果有默认的构造器，则通过constructor的方式进行自动装配，否则使用byType的方式进行自动装配。
  
+ 深拷贝与浅拷贝：
  + 浅拷贝：对基本数据类型进行值传递，对引用数据类型进行引用传递般的拷贝
  + 深拷贝：对基本数据类型进行值传递，对引用数据类型，创建一个新对象，并复制其内容
  
+ 构造器不能被重写，但是能被重载。

+ 线程的六种状态：
  + NEW：初始状态，线程被创建，但是还没有调用start方法
  + RUNNABLE：运行状态，Java线程将操作系统中的就绪和运行两种状态笼统的称为”运行中“
  + BLOCKED：阻塞状态，表示线程阻塞与锁
  + WAITING：等待状态，线程处于等待状态，进入该状态表示当前线程需要其他线程做出一些特定动作（通知或中断）
  + TIME_WAITING：超时等待，该状态不同与WAITING，可以在指定的时间之后自动恢复
  + TERMINATED：终止状态，表示该线程执行完毕
  
+ 浮点数之间的等值判断，基本数据类型不能用 == ，包装类型不能用equals。

+ a.compareTo(b)：返回-1表示a小于b；返回0表示a等于b；返回1表示a大于b。

+ JDK动态代理只能代理实现接口的类，而cglib动态代理则没有这个问题。

+ 链表的查询时间复杂度是O(N),红黑树的查询时间复杂度是O(lgN).

+ LinkedList的数据结构是双向链表（jdk1.6之前为双向循环链表，jdk1.7取消了循环）

+ 调用start()方法方可启动线程并让线程处于就绪状态，直接运行run()方法不回以多线程状态方式执行。

+ 构造方法本身即是线程安全的，不能使用synchronized修饰构造方法。

+ synchronized关键字的本质是对对象监视器monitor的获取

+ 锁的四种状态：无锁状态、偏向锁状态、轻量级锁状态、重量级锁状态

+ 数组的复杂度：
  + 访问：O(1),访问特定位置的元素
  + 插入：O(n),最坏的情况插入的元素位于首部，并需要移动所有的元素时
  + 删除：O(n),最坏的情况发生在删除数组的开头，并需要移动第一个元素后面所有的元素时
  
+ 链表：链表的插入和删除复杂度都是O(1)，查询复杂度是O(n)

+ MyBatis Mapper中的方法是不能重载的，因为采用的是全限名+方法名的保存和寻找策略

+ MyBatis动态SQL的执行原理是利用OGNL表达式从SQL参数中计算表达式的值，根据表达式的值动态拼接SQL

+ Java中 -1 0 1 不被认为时魔法值

+ BeanFactory是懒加载；ApplicationContext是预加载。

+ 创建对象Object obj = new Object()的过程：
  + 分配一块内存M
  + 在内存M上初始化该对象
  + 将内存M的地址赋值给引用变量obj