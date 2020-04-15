## Spring --- 文档学习笔记

### Spring简介

#### 组成

![](https://raw.githubusercontent.com/KongWiki/cloudImg/master/spring_framework.gif)

组成 Spring 框架的每个模块（或组件）都可以单独存在，或者与其他一个或多个模块联合实现。每个模块的功能如下:

- **Spring Core**：核心容器提供 Spring 框架的基本功能。核心容器的主要组件是 `BeanFactory`，它是工厂模式的实现。`BeanFactory` 使用*控制反转* （IOC） 模式将应用程序的配置和依赖性规范与实际的应用程序代码分开。
- **Spring Context**：Spring 上下文是一个配置文件，向 Spring 框架提供上下文信息。Spring 上下文包括企业服务，例如 JNDI、EJB、电子邮件、国际化、校验和调度功能。
- **Spring AOP**：通过配置管理特性，Spring AOP 模块直接将面向方面的编程功能集成到了 Spring 框架中。所以，可以很容易地使 Spring 框架管理的任何对象支持 AOP。Spring AOP 模块为基于 Spring 的应用程序中的对象提供了事务管理服务。通过使用 Spring AOP，不用依赖 EJB 组件，就可以将声明性事务管理集成到应用程序中。
- **Spring DAO**：JDBC DAO 抽象层提供了有意义的异常层次结构，可用该结构来管理异常处理和不同数据库供应商抛出的错误消息。异常层次结构简化了错误处理，并且极大地降低了需要编写的异常代码数量（例如打开和关闭连接）。Spring DAO 的面向 JDBC 的异常遵从通用的 DAO 异常层次结构。
- **Spring ORM**：Spring 框架插入了若干个 ORM 框架，从而提供了 ORM 的对象关系工具，其中包括 JDO、Hibernate 和 iBatis SQL Map。所有这些都遵从 Spring 的通用事务和 DAO 异常层次结构。
- **Spring Web**：Web 上下文模块建立在应用程序上下文模块之上，为基于 Web 的应用程序提供了上下文。所以，Spring 框架支持与 Jakarta Struts 的集成。Web 模块还简化了处理多部分请求以及将请求参数绑定到域对象的工作。
- **Spring MVC**：MVC 框架是一个全功能的构建 Web 应用程序的 MVC 实现。通过策略接口，MVC 框架变成为高度可配置的，MVC 容纳了大量视图技术，其中包括 JSP、Velocity、Tiles、iText 和 POI。

#### 拓展

![](https://raw.githubusercontent.com/KongWiki/cloudImg/master/sping-%E6%8B%93%E5%B1%95.png)



* Spring Boot
* Spring Cloud 

### IoC理论推导

IoC(控制反转)是一种设计思想， DI(依赖注入)是实现IOC的一种方式。

**控制反转的意思** 在控制反转之前， 对象的创建与依赖是通过程序进行硬编码实现的，对象的创建由程序控制，控制反转之后，是将对象的创建交由第三方， 也就是将**获得依赖对象的方式反转了** 从而很大程度的降低了程序的耦合性.

![](https://raw.githubusercontent.com/KongWiki/cloudImg/master/IOC.png)



![](/home/kongweikun/Downloads/container-magic-ioc.png)

Spring容器在初始化时先读取配置文件，根据配置文件或元数据创建与组织对象存入容器中，程序使用时再从Ioc容器中取出需要的对象。

**IoC是Spring框架的核心内容**，使用多种方式完美的实现了IoC，可以使用XML配置，也可以使用注解，新版本的Spring也可以零配置实现IoC。

控制反转是使用描述或注解并通过第三方生产或获取特定对象的方式。在Spring中实现控制反转的是IOC容器，其实现方法是依赖注入。

#### 学习IoC --- 搭建环境

![](/home/kongweikun/Pictures/Screenshot from 2020-02-06 11-36-41.png)

1. 使用set接口实现

   ```java
   private UserDao userDao;
   
   // 利用set进行动态实现值的注入
   public void setUserDao(UserDao userDao) {
           this.userDao = userDao;
   }
   ```

   使用set注入， 程序被动接受对象。

### IoC创建对象的方式

1. 使用无参构造创建对象

2. 若是无无参数构造方法， 按照文档， 有如下一些方式

   1. 下标的方式

      ```xml
      <bean id="user" class="com.wkk.pojo.Student">
          <constructor-arg index="0" value="维坤坤"/>
      </bean>
      ```

      

   2. 参数数据类型(多参数且类型相同麻烦)

      ```xml
      <bean id="user" class="com.wkk.pojo.Student">
          <constructor-arg type="java.lang.String" value="孔维坤"/>
      </bean>
      ```

      

   3. 参数

      ```xml
      <bean id="user" class="com.wkk.pojo.Student">
          <constructor-arg name="name" value="维坤坤"/>
      </bean>
      ```

### DI（依赖注入）

####  1. 构造器注入

```java
public class SimpleMovieLister {

    // the SimpleMovieLister has a dependency on a MovieFinder
    private MovieFinder movieFinder;

    // a constructor so that the Spring container can inject a MovieFinder
    public SimpleMovieLister(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    // business logic that actually uses the injected MovieFinder is omitted...
}
```



#### 2.  setter注入 （核心）

```java
public class SimpleMovieLister {

    // the SimpleMovieLister has a dependency on the MovieFinder
    private MovieFinder movieFinder;

    // a setter method so that the Spring container can inject a MovieFinder
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    // business logic that actually uses the injected MovieFinder is omitted...
}
```

其他各种花式类型的数据注入可参考[文档](https://docs.spring.io/spring/docs/5.2.3.RELEASE/spring-framework-reference/core.html#beans-factory-properties-detailed)

```xml
<bean id="student" class="com.wkk.Student">
        <!--简单数据类型-->
        <property name="name" value="维坤坤"/>
        <!--bean注入-->
        <property name="address" ref="address"/>
        <!--数组注入-->
        <property name="books" >
            <array>
                <value>飘</value>
                <value>三体</value>
                <value>安娜卡列尼娜</value>
            </array>
        </property>
        <!--List注入-->
        <property name="hobbys">
            <list>
                <value>吃饭</value>
                <value>听歌</value>
                <value>睡觉</value>
            </list>
        </property>
        <!--Map注入-->
        <property name="card">
            <map>
                <entry key="学号" value="1111"/>
                <entry key="金额" value="30000"/>
            </map>
        </property>
        <!--Set注入-->
        <property name="games">
            <set>
                <value>塞尔达</value>
                <value>马里奥</value>
                <value>暗影</value>
            </set>
        </property>
        <!--空值注入-->
        <property name="wife">
            <null>无</null>
        </property>
        <!--props注入-->
        <property name="info">
            <props>
                <prop key="admin">admin</prop>
                <prop key="suppor">support@exmaple.orz</prop>
            </props>
        </property>
    </bean>
```



#### 3. Bean的作用域

![](https://raw.githubusercontent.com/KongWiki/cloudImg/master/bean%E7%9A%84%E4%BD%9C%E7%94%A8%E5%9F%9F.png)

具体详见文档

**singleton**

![image](https://raw.githubusercontent.com/KongWiki/cloudImg/master/singleton.png)

```xml
<bean id="user" class="com.wkk.User" scope="singleton"/>
```



**prototype**

![image](https://raw.githubusercontent.com/KongWiki/cloudImg/master/prototype.png)

```xml
<bean id="user" class="com.wkk.User" scope="prototype"/>
```

### Spring 中三种装配 bean 的方式

Spring会从两个角度去自动化实现装配：

1. 组件扫描
2. 自动装配

这两者需要配合才能达到自动化装配的目的，组件扫描去发现包中的 bean，自动装配则是相当于常见的 new 操作。

#### 使用xml显示配置

该使用方式已经在DI中写了

步骤如下： 

1. 在xml中填写需要装配的bean
   1. 填写class
   2. 填写id
   3. 若有参数， 根据情况填写对应的内容

#### 在java中显示配置



#### 隐式的bean发现机制和自动装配

1. @component表示当前的类已经是一个Spring的一个bean了

   1. 可以在里面添加别名

2. 在Config文件中编写配置

   1. @ComponentScan: 开启组件扫描

      其类似于xml中的`<context:component-scan base-package="xxx">`

   2. @Configuration

3. @Autowired

   1. 在需要的地方进行注入
   2. 使用@Qualifier("iphone")进行指定实现类

   

### Spring-AOP

**使用AOP织人，需要导入的依赖**

```xml
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.4</version>
</dependency>
```

#### 1. 自定义类实现AOP

```xml
<!--注册bean-->    
<bean id="diy" class="com.wkk.pointcut.DiyPointcut"/>
<!--    自定义类实现AOP    -->
<aop:config>
            <aop:aspect ref="diy">
                <aop:pointcut id="diyPointcut" expression="execution(* com.wkk.service.impl.UserServiceImpl.*(..))"/>
                <aop:before pointcut-ref="diyPointcut" method="before"/>
                <aop:after pointcut-ref="diyPointcut" method="after"/>
            </aop:aspect>
</aop:config>
```

```java
public class DiyPointcut {
    public void before(){
        System.out.println("--------方法执行前------------");
    }

    public void after(){
        System.out.println("--------方法执行后-------------");
    }
}
```

```java
public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("增加了一个用户");
    }

    public void delete() {
        System.out.println("删除了一个用户");
    }

    public void update() {
        System.out.println("更新了一个用户");
    }

    public void query() {
        System.out.println("查询了一个用户");
    }
}
```

#### 2. 基于注解

```xml
<!--第三种方式:注解实现-->
<bean id="annotationPointcut" class="com.wkk.pointcut.AnnotationPointcut"/>
<aop:aspectj-autoproxy/>
```

```java
@Aspect
public class AnnotationPointcut {
    @Before("execution(* com.wkk.service.impl.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("------方法执行前---------");
    }
    @After("execution(* com.wkk.service.impl.UserServiceImpl.*(..)))")
    public  void after(){
        System.out.println("------方法执行后---------");
    }

    @Around("execution(* com.wkk.service.impl.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        System.out.println("签名:"+jp.getSignature());
        //执行目标方法proceed
        Object proceed = jp.proceed();
        System.out.println("环绕后");
        System.out.println(proceed);
    }
}
```



### Mybatis整合

#### 步骤

 1. 导入相关依赖

     	1. junit
     2. mybastis
     3. mysql-connector
     4. spring
     5. aop织入
     6. mybatis-spring
     7. spring-jdbc(c3p0等)

 2. 编写配置文件

    

 3. 测试

#### 使用MyBatis基本步骤

1. 编写实体(pojo)

   ```java
   @Data
   public class User {
       private int id;
       private String name;
       private String password;
   
   }
   ```

   

2. 编写核心配置文件(config.xml)

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE configuration
           PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-config.dtd">
   <!--configuration核心配置文件-->
   <configuration>
       <!--独立出连接MySQL的配置
       driver: 使用的驱动
       url: 连接的url
       username:
       password
       -->
       <properties resource="mybatis/jdbc.properties"/>
   
       <typeAliases>
           <package name="com.wkk.pojo"/>
       </typeAliases>
   
   
       <!--    事务管理和连接池的配置-->
       <environments default="development">
           <environment id="development">
               <transactionManager type="JDBC"/>
               <dataSource type="POOLED">
                   <property name="driver" value="${driver}"/>
                   <property name="url" value="${url}"/>
                   <property name="username" value="${username}"/>
                   <property name="password" value="${password}"/>
               </dataSource>
           </environment>
       </environments>
       <mappers>
           <mapper resource="mybatis/mapper.xml"/>
       </mappers>
   </configuration>
   
   ```

3. 编写接口(dao)

   ```java
   public interface UserDao {
       List<User> selectUser();
   }
   ```

4. 编写mapper.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper
           PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   <mapper namespace="com.wkk.dao.UsersDao">
       <select id="selectUser" resultType="user">
           select * from mybatis.user;
       </select>
   </mapper>
   
   ```

   >既然 MyBatis 的行为已经由上述元素配置完了，我们现在就要定义 SQL 映射语句了。 但是首先我们需要告诉 MyBatis 到哪里去找到这些语句。 Java 在自动查找这方面没有提供一个很好的方法，所以最佳的方式是告诉 MyBatis 到哪里去找映射文件。 你可以使用相对于类路径的资源引用， 或完全限定资源定位符（包括 `file:///` 的 URL），或类名和包名等        ---- Mybatis官方文档

   ​	

   ```xml
   <!-- 使用相对于类路径的资源引用 -->
   <mappers>
     <mapper resource="org/mybatis/builder/AuthorMapper.xml"/>
     <mapper resource="org/mybatis/builder/BlogMapper.xml"/>
     <mapper resource="org/mybatis/builder/PostMapper.xml"/>
   </mappers>
   ```

   ```xml
   <!-- 使用完全限定资源定位符（URL） -->
   <mappers>
     <mapper url="file:///var/mappers/AuthorMapper.xml"/>
     <mapper url="file:///var/mappers/BlogMapper.xml"/>
     <mapper url="file:///var/mappers/PostMapper.xml"/>
   </mappers>
   ```

   ```xml
   <!-- 使用映射器接口实现类的完全限定类名 -->
   <mappers>
     <mapper class="org.mybatis.builder.AuthorMapper"/>
     <mapper class="org.mybatis.builder.BlogMapper"/>
     <mapper class="org.mybatis.builder.PostMapper"/>
   </mappers>
   ```

   ```xml
   <!-- 将包内的映射器接口实现全部注册为映射器 -->
   <mappers>
     <package name="org.mybatis.builder"/>
   </mappers>
   <!--需要将映射和接口命名相同-->
   ```

5. 测试

   ```java
   // 对应的resource
   String resource = "mybatis/mybatis-config.xml";
   // 流读取
   InputStream inputStream = Resources.getResourceAsStream(resource);
   // sqlSessionFactory
   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
   SqlSession sqlSession = sqlSessionFactory.openSession(true);
   
   UserDao mapper = sqlSession.getMapper(UserDao.class);
   List<User> users = mapper.selectUser();
   for (User user : users) {
       System.out.println(user);
   }
   ```

   

#### MyBatis-Spring

MyBatis-Spring 会帮助你将 MyBatis 代码无缝地整合到 Spring 中。它将允许 MyBatis 参与到 Spring 的事务管理之中，创建映射器 mapper 和 `SqlSession` 并注入到 bean 中，以及将 Mybatis 的异常转换为 Spring 的 `DataAccessException`。最终，可以做到应用代码不依赖于 MyBatis，Spring 或 MyBatis-Spring。

```xml
<dependency>
  <groupId>org.mybatis</groupId>
  <artifactId>mybatis-spring</artifactId>
  <version>2.0.3</version>
</dependency>
```



#### 步骤

1. 编写数据源

2. 编写接口

3. 编写spring配置文件

   一下的步骤是按照Mybatis原生读取数据的方式来完成的

   ```java
   // 对应的resource
   String resource = "mybatis/mybatis-config.xml";
   // 流读取
   InputStream inputStream = Resources.getResourceAsStream(resource);
   // sqlSessionFactory
   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
   SqlSession sqlSession = sqlSessionFactory.openSession(true);
   UserDao mapper = sqlSession.getMapper(UserDao.class);        
   ```

   

   1. dataSource

      ```xml
      <!--dataSource: 使用Spring数据源替换Mybatis的配置 也可以使用其他 如 c3p0 dbcp
         此处使用的为Spring的jdbc: org.springframework.jdbc.datasource.DriverManagerDataSource-->
      <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
          <property name="driverClassName" value="${jdbc.driver}"/>
          <property name="url" value="${jdbc.url}"/>
          <property name="username" value="${jdbc.username}"/>
          <property name="password" value="${jdbc.password}"/>
      </bean>
      ```

   2. sqlsessionFactory

      ````xml
       <!--SqlSessionFactory-->
       <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
           <property name="dataSource" ref="dataSource"/>
           <!--    mybatis的基础配置指定    -->
           <property name="configLocation" value="classpath:mybatis/mybatis-config.xml"/>
           <!--映射的xml-->
           <property name="mapperLocations" value="classpath:mybatis/mapper.xml"/>
       </bean>
      ````

   3. sqlSession

      ```xml
      <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
          <constructor-arg index="0" ref="sqlSessionFactory"/>
      </bean>
      ```

4. 因为使用spring进行完成， 所以需要对接口有对应的实现，然后注入到spring中

5. 测试该类

### 声明式事物 

#### 事物的ACID原则

* 原子性(Atomicity)
* 一致性(Consistency)
* 隔离性(Isolation)
  * 多个业务可能操作同一个资源， 防止数据的损坏
* 持久性(Durability)

**编程式事物**: 代码中修改 

**声明式事物** : AOP 

## reference

* [Spring：概述、IOC理论](https://blog.kuangstudy.com/index.php/archives/511/)

* [mybatis文档](https://mybatis.org/mybatis-3/zh/index.html)

