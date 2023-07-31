# annotations
@Value annotation: For getting value from application.properties
```
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyConfig {

    @Value("${your.property.key}") // Replace "your.property.key" with the actual key in application.properties
    private String yourPropertyValue;

    // Getter method to access the property value from other parts of the application
    public String getYourPropertyValue() {
        return yourPropertyValue;
    }
}
```

We can use four annotations to inject beans into a class:
@Autowired: This annotation can be used to auto-wire a bean into a class member, constructor, or method. It allows Spring to automatically detect the appropriate bean and inject it where needed.
@Inject: This is another annotation used for dependency injection, similar to @Autowired. It is part of the Java Dependency Injection (JSR-330) standard and is also supported by Spring.
@Resource: This annotation can be used for dependency injection by name. It allows you to specify the name of the bean to be injected explicitly.
@Qualifier: This annotation is used in conjunction with @Autowired or @Inject when there are multiple beans of the same type, and you need to specify which bean should be injected by providing the bean name as a qualifier.

@SpringBootApplication is a convenience annotation provided by Spring Boot. It is a combination of three annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan.
@Configuration: Indicates that the class contains Spring configuration and bean definitions.
@EnableAutoConfiguration: Enables Spring Boot’s auto-configuration feature, which automatically configures various dependencies and settings based on the classpath and the dependencies present.
@ComponentScan: Enables component scanning to automatically detect and register Spring beans.
Using @SpringBootApplication on the main application class simplifies the configuration process by automatically configuring Spring Boot and scanning components in the same package as the main class and its sub-packages.

Mapping Java Object with Database Table:
@Entity - it is a enity, will be used to map with database
@Table - will be used to locate the database table name
@Id - this column is a primary key
@GeneratedValue(strategy = GenerationType.IDENTITY) - 主键⾃增的策略
@Column(name = "description", nullable = false) - specify the informaiton for this column, like name in database, can be null or not in database.

@Repository:
When you annotate a class with @Repository, Spring Boot will automatically detect and register it as a Spring bean during component scanning. This allows you to take advantage of Spring's features, such as dependency injection and transaction management, for your data access operations.

@OneToMany: The @OneToMany annotation is used to represent a one-to-many relationship between two entities. It implies that one instance of the source entity is associated with multiple instances of the target entity. In terms of the database, this is usually implemented using a foreign key in the target entity's table pointing back to the primary key of the source entity's table.

@ManyToOne: The @ManyToOne annotation is used to specify a many-to-one relationship between two entities. It means multiple instances of the source entity can be associated with a single instance of the target entity.
```
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy = "author")
    private List<Book> books;
    
}

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    
    private String title;
    
    @ManyToOne
    private Author author;
    
}
```

@ManyToMany: The @ManyToMany annotation is used to represent a many-to-many relationship between two entities. This implies that multiple instances of the source entity can be associated with multiple instances of the target entity. In the database, a separate join table is typically created to manage this relationship.
```
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    // Other user properties and relationships

    @ManyToMany
    @JoinTable(name = "user_group",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<Group> groups = new HashSet<>();

    // Constructors, getters, and setters
}

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Other group properties and relationships

    @ManyToMany(mappedBy = "groups")
    private Set<User> members = new HashSet<>();

    // Constructors, getters, and setters
}

```

@Transactional annotation provides a way to manage database transactions, ensuring that a group of database operations either all succeed (commit) or all fail (rollback) as a single atomic unit. This helps maintain data integrity and consistency within the database.

@ControllerAdvice: The @ControllerAdvice annotation allows you to create a global exception handling component that can be shared across multiple controllers. It can contain multiple @ExceptionHandler methods for different exception types.
@ExceptionHandler: Spring allows you to define exception handling methods in your controller classes using the @ExceptionHandler annotation. When an exception is thrown within the controller's method or any method invoked from it, Spring will look for the corresponding @ExceptionHandler method to handle that exception. You can then perform the necessary error handling or return a custom response to the client.

@SpringBootApplication: This annotation is used to mark the main class of a Spring Boot application.
```
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

@RestController: This annotation is used to create RESTful web services by combining @Controller and @ResponseBody annotations.
```
@RestController
public class UserController {
    @GetMapping("/users")
    public List<User> getUsers() {
        // Retrieve and return list of users
    }
}
```

@Autowired: This annotation is used to automatically wire dependencies between Spring components.
```
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
```

@RequestMapping: This annotation is used to map HTTP requests to specific controller methods.
```
@RestController
public class UserController {
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id) {
        // Retrieve and return user with specified ID
    }
}
```

@PathVariable: This annotation is used to bind a method parameter to a path variable in the request URL.
```
@RestController
public class UserController {
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Long id) {
        // Retrieve and return user with specified ID
    }
}
```

@RequestBody: This annotation is used to bind the request body to a method parameter.
```
@RestController
public class UserController {
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        // Create and return the user
    }
}
```

@Transactional: This annotation is used to define transactional boundaries around methods for database operations.
```
@Service
public class UserService {
    @Transactional
    public User updateUser(User user) {
        // Update user in the database
    }
}
```

@Valid: This annotation is used to perform validation on method parameters or request bodies using Bean Validation annotations.
```
@PostMapping("/users")
public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
    // Create and return the user
}
```

@EnableCaching: This annotation is used to enable Spring's caching support in the application.
```
@SpringBootApplication
@EnableCaching
public class MyApplication {
    // ...
}
```

@Scheduled: This annotation is used to schedule the execution of methods at fixed intervals or specific times.
```
@Service
public class MyScheduler {
    @Scheduled(fixedDelay = 5000)
    public void performTask() {
        // Perform a task every 5 seconds
    }
}
```