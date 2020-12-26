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
  + Autowired和注解属于Spring,Resource注解属于JavaEE;
  + Autowired和默认根据byType注入,Resource在不指定name和type属性的情况下根据byName注入;
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

+ @Configuration和@Component的区别是：前者的bean是单例的，后者是原型类型。

+ 整型最高位0表示整数，1表示负数。

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
  + 实现Runable接口
  + 实现Callable接口，利用task接受异步线程执行的结果
  
+ JDK1.8之后switch可以作用byte、short、int、char、boolean、string和enum上

+ ArrayList的默认大小是10；HashMap的默认大小是16。

+ Array可以存放基本类型和引用类型；ArrayList只能存放引用类型。

+ ArrayList扩容只会增加50%，而Vector扩容时增加1倍。

+ Queue的poll方法和remove方法的区别:
  + 两者都是返回一个元素，并在队列中删除返回的对象。
  + 如果没有元素poll()会返回null，而remove方法则会抛出NoSuchElementException异常。
  
+ http状态码301永久重定向，302暂时重定向。

+ sleep()和wait()的区别：
  + 来源不同：sleep()来自Thread类,wait()来自Object类;
  + 用法不同：sleep()时间到时会自动恢复,wait()需要notify或者notifyAll唤醒;
  + 持有锁的不同：sleep()不释放锁,wait()释放锁。
  
+ 线程池中execute()和submit()方法的区别：
  + execute()只能执行runable类型的任务
  + submit()可以执行runable和callable类型的任务
  
+ 线程池的拒绝策略
  + AbortPolicy：默认的拒绝策略，抛出 RejectedExecutionException 异常
  + CallerRunsPolicy：提交任何的线程自己去执行该任务
  + DiscardOldestPolicy：丢弃最老的任务，加入新的任何
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