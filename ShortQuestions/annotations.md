# Annotations

## -----------------------------------Controller-----------------------------------

@RestController: Mark this class as a REST controller
```java
@RestController
public class ExampleController{
    return null;
}
```

@RequestMapping: map HTTP requests to specific handler methods in the controller class.
```java
@RestController
@RequestMapping("api/v1/posts")
public class ExampleController{
    //
}
```

@GetMapping: map get request to handling method
```java
@RestController
public class ExampleController{
    @GetMapping("/example")
    public String handleGetRequest() {
        return "This is a GET request";
    }
}
```

@PostMapping: map post request to handling method
```java
@RestController
public class ExampleController{
    @PostMapping("/example")
    public String handlePostRequest() {
        return "This is a Post request";
    }
}
```

@PutMapping: map put(update) request to handling method
```java
@RestController
public class ExampleController{
    @PutMapping("/example")
    public String handlePutRequest() {
        return "This is a Post request";
    }
}
```

@DeleteMapping: map delete request to handling method
```java
@RestController
public class ExampleController{
    @DeleteMapping("/example")
    public String handleDeleteRequest() {
        return "This is a Delete request";
    }
}
```

@PathVariable: extract path variable from request URL and bind them to method parameters
```java
@RestController
public class ExampleController{
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(postService.getPostById(id),HttpStatus.OK);
    }
}
```

@RequestBody: bind the request body to a method parameter
```java
@RestController
public class ExampleController{
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto response = this.postService.createPost(postDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

@QueryMapping: graphql controller annotation that act as a shortcut for @SchemaMapping with typename of "Query", which is used to express the mapping of a handler method to a Graphql type and field pair
```java
@QueryMapping
public PostDto postById(@Argument Long id){
    return postService.getPostById(id);
}
```

@MutationMapping: 
graphql controller annotation that act as a shortcut for @SchemaMapping with typename of "Mutation", which is used to express the mapping of a handler method to a Graphql type and field pair
```java
@MutationMapping
public PostDto createPost(@Argument String title, @Argument String description, @Argument String content){
    PostDto postDto = new PostDto();
    postDto.setContent(content);
    postDto.setTitle(title);
    postDto.setDescription(description);
    return postService.createPost(postDto);
}
```


## -----------------------------------Entity-----------------------------------


```
@Entity: Define a class to be the entity in the database
```java
@Entity
public class Post{
    //define the entity
}
```

@UniqueConstraint: specify that one or more columns in a table should have unique values. It helps enforce data integrity rules by ensuring that duplicate values are not allowed in the specified columns.
```java
@Entity
@Table(name = "users",
       uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
public class User {
    // ...
}
```

@Table: define the table
```java
@Entity
@Table(name = "users",
       uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
public class User {
    // ...
}
```

@ID: define the variable to be the primary key
```java
@Entity
@Table(name = "users",
       uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
}
```

@GeneratedValue: provides different strategies to automatically generate primary key values.
```java
@Entity
@Table(name = "users",
       uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
}
```

@Column: define a column in the database with name and proporities
```java
@Entity
@Table(name = "users",
       uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    

    @Column(name = "title", nullable = false)
    private String title;
}
```

@CreationTimeStamp: automatically populate a timestamp or date field with the current date and time when an entity is created and persisted in the database.
```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    // Other entity attributes and methods
}
```

@UpdateTimestamp: automatically update a timestamp or date field with the current date and time whenever an entity is updated and persisted in the database.
```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Other entity attributes and methods
}
```

@Bean: it is the annotation that used to define a method that produces a bean managed by the Spring container.
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Car carBean() {
        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Camry");
        return car;
    }
}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private Car car;

    @Autowired
    public CarService(Car car) {
        this.car = car;
    }

    public void printCarDetails() {
        System.out.println("Car make: " + car.getMake());
        System.out.println("Car model: " + car.getModel());
    }
}
```

@JsonProperty
JsonProperty is an annotation provided by the Jackson library, which is used for mapping Java class properties (fields or methods) to JSON object properties during serialization and deserialization. 
```java
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    @JsonProperty("fullName")
    private String name;

    // Other fields, constructors, and methods (getters/setters) omitted for brevity
}

Person person = new Person();
person.setName("John Doe");

ObjectMapper objectMapper = new ObjectMapper();
String jsonString = objectMapper.writeValueAsString(person);
// The jsonString will be: {"fullName":"John Doe"}


String json = "{\"fullName\":\"Jane Smith\"}";

ObjectMapper objectMapper = new ObjectMapper();
Person person = objectMapper.readValue(json, Person.class);
// The 'person' object will have the name set as "Jane Smith"

```

@ComponentScan
@ComponentScan is an annotation provided by the Spring Framework that is used to enable component scanning in a Spring application. Component scanning is a process where Spring automatically detects and registers Spring-managed beans (components) in the application context without the need for explicit bean definitions.
```java
package com.example.myapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.myapp.components")
public class MyAppConfig {
    // Configuration class content
}
```

@Configuration:
In Spring Framework, @Configuration is an annotation used to indicate that a Java class is a configuration class. Configuration classes are an important part of the Spring configuration model and are used to define Spring beans and their dependencies.
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

    // Other bean definitions using @Bean
}

```

@SpringbootApplication
@SpringBootApplication is a meta-annotation provided by Spring Boot, and it is used to annotate the main class of a Spring Boot application. It combines three commonly used annotations: @SpringBootConfiguration, @EnableAutoConfiguration, and @ComponentScan.
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```


@SpringBootConfiguration
The @SpringBootConfiguration annotation in the Spring Framework is a specialization of @Configuration that indicates the class is a source of bean definitions. It's usually applied on the main application class to indicate that this class serves as a configuration class for the Spring Boot application.
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringBootConfiguration;

@SpringBootConfiguration
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```


@EnableAutoConfiguration
The @EnableAutoConfiguration annotation in Spring Boot is used to enable the auto-configuration of the Spring application context, which attempts to automatically configure your Spring application based on the dependencies that you have added.
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.mycompany.myapp"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```

@Primary
@Primary is to give higher preference to a particular bean. When Spring finds more than one bean of the same type and needs to inject one, it will inject the @Primary bean.
```java
@Bean
@Primary
public MyBean primaryBean() {
    return new MyBean();
}

@Bean
public MyBean secondaryBean() {
    return new MyBean();
}



@Autowired
private MyBean myBean; // this will be primaryBean
```

@Qualifier
@Qualifier is an annotation in Spring that you can use to help disambiguate bean references when you have multiple beans of the same type.
```java
@Bean
public Foo foo1() {
    return new Foo("foo1");
}

@Bean
public Foo foo2() {
    return new Foo("foo2");
}


@Service
public class Bar {
    private final Foo foo;

    @Autowired
    public Bar(@Qualifier("foo1") Foo foo) {
        this.foo = foo;
    }
}
```