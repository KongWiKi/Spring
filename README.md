## Spring --- 文档学习

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




### IoC --- Spring



### IoC创建对象的方式

1. 使用无参构造创建对象

2. 若是无无参数构造方法， 按照文档， 有如下一些方式

   1. 下标的方式

      ```xml
      <bean id="user" class="com.wkk.pojo.User">
          <constructor-arg index="0" value="维坤坤"/>
      </bean>
      ```

      

   2. 参数数据类型(多参数且类型相同麻烦)

      ```xml
      <bean id="user" class="com.wkk.pojo.User">
          <constructor-arg type="java.lang.String" value="孔维坤"/>
      </bean>
      ```

      

   3. 参数

      ```xml
      <bean id="user" class="com.wkk.pojo.User">
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

### 使用Spring-AOP

**使用AOP织人，需要导入的依赖**

```xml
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.4</version>
</dependency>
```



 

## reference

* [Spring：概述、IOC理论](https://blog.kuangstudy.com/index.php/archives/511/)

  