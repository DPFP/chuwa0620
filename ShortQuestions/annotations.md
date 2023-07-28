
### Java
- @FunctionalInterface
  - use for lambda, only one abstract method in interface
```
@FunctionalInterface
public interface Service {
    void sayHello(String name);
}
```

### JPA
- @Entity
    - This annotation is used at the class level to let it know that this class is an Entity (Table).
```aidl
@Entity
public class User {
   @Id
   private Long id;
   private String name;
   // getters and setters
}
```

- @Id
    - This annotation is used at the field level to denote the primary key of the entity.
```aidl
@Entity
public class User {
   @Id
   private Long id;
   // rest of the class
}
```

- @Table
    - This annotation is used to provide the details of the database table that will be used for mapping.
```aidl
@Entity
@Table(name="user_table")
public class User {
   // rest of the class
}
```

- @Column
  - define database column for entity conversion
```aidl
@Column(name="custom_column_name")
private String fieldName;
```


### Spring
- @AutoWire
  - annotation in Spring framework is used for automatic dependency injection.
```aidl
 @Autowired
 public MyClass(MyService myService) {
    this.myService = myService;
 }
```

- @Component
  - It tells Spring's component-scan feature to detect it automatically and add it into the application context as a managed bean.
```aidl
@Component
public class MyComponent {
    //...
}
```

- @ExceptionHandler
  - To define a method that handles exceptions thrown by request handling (@RequestMapping) methods.
```aidl
@Controller
public class MyController {

    //...
- @CompnonentScan
  - Spring is used to automatically discover beans and register them in the Spring application context.
```aidl
package com.example.myapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
    // ...
}
```
In the example above, Spring will scan all classes in the com.example.myapp package and its sub-packages for @Component, @Controller, @Service, @Repository, and @Configuration annotations, and automatically create beans for those classes.

```aidl
@Configuration
@ComponentScan(basePackages = "com.example.myapp.services")
public class AppConfig {
    // ...
}
```
In this case, Spring will only scan the com.example.myapp.services package and its sub-packages.

```aidl
@Configuration
@ComponentScan(basePackages = {"com.example.myapp.services", "com.example.myapp.repositories"})
public class AppConfig {
    // ...
}
```

In this case, Spring will scan both com.example.myapp.services and com.example.myapp.repositories packages and their sub-packages.

- @SpringbootApplication
  - A convenience annotation in Spring Boot that adds all of the following annotations:
1. @Configuration: This allows the class to be used as a source of bean definitions.

2. @EnableAutoConfiguration: This enables automatic configuration of the Spring application context, attempting to guess and configure beans that you are likely to need based on your classpath and other beans you have defined.

3. @ComponentScan: This enables auto-detection of beans from the same package as the class where this annotation is used or from its sub-packages.

Here's a basic example of a Spring Boot application that uses @SpringBootApplication:
```aidl
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

- @ControllerAdvice
  - Handle exceptions across the whole application, not just an individual controller. You can think of it as an interceptor of exceptions thrown by methods annotated with @RequestMapping.
```aidl
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> defaultErrorHandler(Exception e) {
        return new ResponseEntity<>("General error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException e) {
        return new ResponseEntity<>("Null pointer exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
```

