
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


- @GeneratedValue
  - Used to specify how primary key values are generated for an entity. 
```aidl
@Entity
public class MyEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    // other fields, getters, and setters
}
```

- @ManyToOne
  - Used to define a many-to-one relationship between two entities.
```aidl
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // getters and setters
}
```

- @JoinColumn
  - Used to specify a column for joining an entity association or element collection.
```aidl
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    // ... other fields, getters, and setters ...
}
```
- @JoinTable
  - Used to define the table that maps a many-to-many association
```aidl
@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    
    @ManyToMany
    @JoinTable(
        name = "book_author", 
        joinColumns = @JoinColumn(name = "book_id"), 
        inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    // ... other fields, getters, and setters ...
}

@Entity
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    // ... other fields, getters, and setters ...
}
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

- @Repository
  - Indicates that the decorated class is a repository. A Repository is a generalization of a data access object (DAO). It is an abstraction that provides CRUD (Create, Read, Update, Delete) operations on objects of a specific type against an underlying data store.
```aidl
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
```
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





