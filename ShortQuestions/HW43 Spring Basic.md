# HW43
**2.  What is Spring and Springboot? What is the benfits of using Srpingboot?**
Spring is a popular open-source framework for building Java applications. It provides a comprehensive ecosystem that simplifies the development of enterprise-level applications by offering features like dependency injection, aspect-oriented programming, data access, security, and more.

Spring Boot is a sub-project of the Spring Framework that aims to simplify the process of building stand-alone, production-ready Spring applications. It provides an opinionated configuration approach, meaning that it offers sensible defaults and auto-configuration options, reducing the need for manual setup and boilerplate code.

Benefits of using Spring Boot:

- Rapid Application Development: Spring Boot's opinionated approach and auto-configuration significantly reduce the development time, allowing developers to quickly build applications.
- Simplified Configuration: Spring Boot's convention-over-configuration approach reduces the need for explicit configuration files, making it easier to manage and understand application settings.
- Embedded Servers: Spring Boot provides embedded servlet containers, eliminating the need to deploy applications to external servers during development and testing.
- Production-Ready Defaults: Spring Boot sets sensible defaults for production settings, which helps create applications that are ready for deployment without extensive manual configuration.
- Microservices Support: Spring Boot is well-suited for building microservices-based architectures due to its lightweight nature and easy integration with cloud platforms.

**3.  What is IOC and What is DI?**
Inversion of Control is a design principle in software engineering, where the control of object creation and lifecycle management is shifted from the application code to an external container or framework.
In traditional programming, objects are created and managed by the application code itself. However, in IoC, the responsibility for creating, managing, and injecting dependencies is delegated to a container or framework.
The main aim of IoC is to achieve loose coupling between components, making the code more modular, flexible, and easier to maintain.

Dependency Injection is a specific implementation of Inversion of Control. It refers to the process of providing the dependencies of a class from the outside rather than creating them within the class.
In DI, the dependencies are "injected" into a class during its creation, typically through constructor injection, setter injection, or method injection.
By using DI, a class becomes more reusable, as its dependencies can be easily swapped or mocked during testing, and it becomes easier to change the behavior of the class without modifying its code.

**4.  What is  @CompnonentScan?**
@ComponentScan is a Spring Framework annotation used to enable component scanning within a specified package and its sub-packages. Component scanning is the process by which Spring automatically discovers and registers Spring beans from the classes annotated with stereotype annotations like @Component, @Service, @Repository, etc.

When you annotate a configuration class with @ComponentScan, Spring will scan the specified package and its sub-packages for Spring components and register them in the Spring application context, making them available for dependency injection and other Spring features.

**5.  How to define which package spring need to scan in xml and annotaiton?**
In XML Configuration:
To define which package Spring should scan for component scanning in XML configuration, you can use the <context:component-scan> element. 
```
<context:component-scan base-package="com.example.myapp" />
```

**6.  What is  @SpringbootApplication?**
@SpringBootApplication is a convenience annotation provided by Spring Boot. It is a combination of three annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan.

@Configuration: Indicates that the class contains Spring configuration and bean definitions.
@EnableAutoConfiguration: Enables Spring Boot's auto-configuration feature, which automatically configures various dependencies and settings based on the classpath and the dependencies present.
@ComponentScan: Enables component scanning to automatically detect and register Spring beans.
Using @SpringBootApplication on the main application class simplifies the configuration process by automatically configuring Spring Boot and scanning components in the same package as the main class and its sub-packages.

**7. How many ways wo can define a bean?**
Component Scanning: By annotating classes with stereotype annotations like @Component, @Service, @Repository, or @Controller, Spring automatically registers these classes as beans when component scanning is enabled.

Java Configuration: You can define beans using Java-based configuration by creating a configuration class annotated with @Configuration and defining bean methods annotated with @Bean. The return value of these methods represents the bean, and its name is derived from the method name (unless specified explicitly).

XML Configuration: Beans can also be defined in XML configuration files using <bean> elements.
```
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myService" class="com.example.MyService"/>
</beans>
```

**8.  What is default bean name for  @Component and  @Bean?**
For @Component, the default bean name is the uncapitalized and unqualified class name. For example, if a class is named MyService, the default bean name will be myService.

For @Bean, the default bean name is the same as the name of the method annotated with @Bean.

**9.  What is the difference between  @component and  @service,@repository?**
In Spring Framework, both @Component, @Service, and @Repository are used to declare beans, but they are typically used to represent different types of components in the application.

@Component: It is a generic stereotype annotation used to indicate that a class is a Spring component. It serves as a general-purpose stereotype and can be used to mark any Spring-managed component, including services, repositories, controllers, etc. It does not provide any additional behavior-specific functionality.

@Service: This is a specialization of @Component. It is used to annotate service classes in the business layer. Service classes typically hold the business logic and are responsible for processing data and applying business rules.

@Repository: This is also a specialization of @Component. It is used to annotate DAO (Data Access Object) classes that are responsible for interacting with the database or any external data source. It provides additional exception translation capabilities, converting lower-level data access exceptions into Spring's unified DataAccessException.

In summary, while @Component, @Service, and @Repository can be used interchangeably to declare beans, it's a good practice to use them based on their intended roles to make the code more expressive and provide additional functionality where required 

**10. How many annotaitons we can use to inject the bean?**
We can use four annotations to inject beans into a class:
@Autowired: This annotation can be used to auto-wire a bean into a class member, constructor, or method. It allows Spring to automatically detect the appropriate bean and inject it where needed.

@Inject: This is another annotation used for dependency injection, similar to @Autowired. It is part of the Java Dependency Injection (JSR-330) standard and is also supported by Spring.

@Resource: This annotation can be used for dependency injection by name. It allows you to specify the name of the bean to be injected explicitly.

@Qualifier: This annotation is used in conjunction with @Autowired or @Inject when there are multiple beans of the same type, and you need to specify which bean should be injected by providing the bean name as a qualifier.

**11. Tell me the three types to do dependency injection(How can we inject the beans in Spring)? Which way is better and why?**
Constructor Injection: In this type, dependencies are provided through the constructor of the class. It ensures that the object is fully initialized before it's used and promotes immutability. Constructor injection is often considered a better choice due to its benefits in terms of testability and explicit dependencies.

Setter Injection: In this type, dependencies are provided through setter methods. It allows for optional dependencies and can make the code more readable when there are many dependencies. However, it may lead to objects being in an invalid state until all setters are called.

Field Injection: In this type, dependencies are directly injected into class fields. While it's the most concise form of injection, it's often considered less preferable than constructor or setter injection because it can make testing more difficult, and it couples the class directly to the dependency.

The constructor injection is generally considered better due to its explicit nature, immutability, and better testability. It also avoids circular dependency.

**12. If we have multiple beans for one type, how to set one is primary? and how to let the spring to pick one bean to inject if no primay.**
Setting a Primary Bean: When you have multiple beans of the same type, you can set one of them as the primary bean using the @Primary annotation. The primary bean will be given preference when autowiring by type, and Spring will use it by default when no qualifier is specified.
```
@Component
@Primary
public class PrimaryBean implements SomeInterface {
    // Class implementation
}
```

Handling No Primary Bean: If there is no primary bean set, and multiple beans of the same type are available, Spring will throw a NoUniqueBeanDefinitionException during the autowiring process. To resolve this, you can either set one of the beans as primary, as mentioned above, or use the @Qualifier annotation along with @Autowired to specify the bean's name to be injected explicitly.
```
@Component
public class MyClass {
    private final SomeInterface someBean;

    @Autowired
    public MyClass(@Qualifier("primaryBean") SomeInterface someBean) {
        this.someBean = someBean;
    }
}
```

**13. What is the difference between BeanFactory and ApplicationContext in Spring?**
BeanFactory: BeanFactory is the root interface for accessing the Spring IoC container. It provides the basic functionality for managing beans, such as instantiation, configuration, and assembling dependencies. It supports lazy initialization of beans, which means that beans are only created when requested.

ApplicationContext: ApplicationContext is a sub-interface of BeanFactory and provides additional features and functionalities. It includes all the functionalities of BeanFactory and adds context-specific features, such as internationalization, event handling, resource loading, AOP (Aspect-Oriented Programming), and support for various application contexts like web application context, enterprise application context, etc.

In summary, ApplicationContext is a more advanced container than BeanFactory and is generally preferred for most Spring applications due to its extended capabilities.

**14. What is the Scope of a Bean?  and list the examples for each scope.**
The scope of a bean in Spring defines the lifecycle and visibility of the bean instance. Spring provides several bean scopes, each serving different purposes. The most common bean scopes are:

Singleton (default): Spring creates only one instance of the bean and shares it throughout the application context. It is the default scope. One bean per application context.

Prototype: Spring creates a new instance of the bean every time it is requested.