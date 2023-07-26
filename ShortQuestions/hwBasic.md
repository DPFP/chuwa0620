1. See Annotation.md

2. Spring is an open-source lightweight framework that allows Java EE 7 developers to build simple, reliable, and scalable enterprise applications. This framework mainly focuses on providing various ways to help you manage your business objects. It made the development of Web applications much easier than compared to classic Java frameworks and Application Programming Interfaces (APIs), such as Java database connectivity (JDBC), JavaServer Pages(JSP), and Java Servlet. This framework uses various new techniques such as Aspect-Oriented Programming (AOP), Plain Old Java Object (POJO), and dependency injection (DI), to develop enterprise applications. The **Spring framework** can be considered as a collection of sub-frameworks, also called layers, such as Spring AOP. Spring Object-Relational Mapping (Spring ORM). Spring Web Flow, and Spring Web MVC. You can use any of these modules separately while constructing a Web application. The modules may also be grouped together to provide better functionalities in a Web application. *Spring Boot* is built on top of the conventional spring framework. So, it provides all the features of spring and is yet easier to use than spring. Spring Boot is a microservice-based framework and making a production-ready application in very less time. In Spring Boot everything is auto-configured. We just need to use proper configuration for utilizing a particular functionality. Spring Boot is very useful if we want to develop REST API. 

3. **Spring IoC (Inversion of Control) Container is the core of Spring Framework**. It creates the objects, configures and assembles their dependencies, manages their entire life cycle. The Container uses Dependency Injection(DI) to manage the components that make up the application

4. One of the most important annotations in spring is @ComponentScan which is **used along with the @Configuration annotation to specify the packages that we want to be scanned**. @ComponentScan without arguments tells Spring to scan the current package and all of its sub-packages.

5. we can use filter in xml file and @ComponentScan annotation in Java

6. Spring Boot @SpringBootApplication annotation is **used to mark a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning**. It's same as declaring a class with @Configuration, @EnableAutoConfiguration and @ComponentScan annotations.

7. There are **three** different ways in which you can define a Spring bean: annotating your class with the stereotype @Component annotation (or its derivatives) writing a bean factory method annotated with the @Bean annotation in a custom Java configuration class. declaring a bean definition in an XML configuration file

8. Let's start with the default naming strategy for an annotation used at the class level. To name a bean, **Spring uses the class name and converts the first letter to lowercase**.

   Spring provides annotations like [*@Bean*](https://www.baeldung.com/spring-bean-annotations) and [*@Qualifier*](https://www.baeldung.com/spring-qualifier-annotation) to be used on methods for bean creation.

9. **@Component is a generic stereotype for any Spring-managed component or bean.** **@Repository is a stereotype for the persistence layer.** **@Service is a stereotype for the service layer**.

10. @Autowired, @Resources, @Inject

11. Constructor based, Setter based, Field Based

12. Use @configuration, @Component, BeanFactory

13. BeanFactory will read the config and manage the loading and initialization of bean. Application context is more comprehensive which also includes bean process registration

14. Bean scope represent the  how the bean should be hold in certain area. Normally, it will be set to singleton, which means a container will only have bean,  prototype means every thread will create one bean.

15. ```xml
    <bean id="jdbc"
    	class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
    	<property name="locations" value="/WEB-INF/jdbc.properties" />
    </bean>
    <bean id="dataSource" class="org.apache.tomcat.jdbc.pool.DataSource"
    	destroy-method="close">
    	<property name="driverClassName" value="${jdbc.driverClassName}" />
    	<property name="url" value="${jdbc.url}" />
    </bean>
    
    # using constructor for injection
    <bean id="obj3" class="com.likeyichu.sample.Sample3">
    	<constructor-arg value="123"/>
    	<constructor-arg ref="obj1"/>
    	<constructor-arg ref="obj2"/>
    </bean>
    ```

    