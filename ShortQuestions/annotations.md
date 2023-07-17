## 1
@FunctionalInterface: used for lambda
```
@FunctionalInterface
public interface Calculator {
    int calculate(int a, int b);
}
```

@Column: Used to convert entities to database entries.
```
    @Column(name = "custom_column_name")
    private String fieldName;
```

@Autowired: The @Autowired annotation is used in Spring Framework to automatically wire dependencies between components. When you annotate a field, setter method, or constructor with @Autowired, Spring will automatically resolve and inject the appropriate dependency into that component at runtime.
```
    @Autowired
    private PostService postService;
```

@RestController
@RequestMapping
@PostMapping

These type of annotations are used to REST apis.

@Id is used to set as primary key.
@ GeneratedValue is typically used in conjunction with the @Id annotation to specify the primary key of an entity.
``` 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
```

@Service
By marking a class with @Service, you are indicating that it serves the role of a service or business logic component. This helps in semantic clarity and provides a standardized way of defining and autodetecting service classes within the application context.



## 2
The table will have two columns.
One is called name and its varchar(255) type and have a default value of John Snow.

The other is called STUDENT_NAME, it cannot be nullale and can have duplicates.

## 3
first_name
operating_system

## 4
Presentation Layer: JSON translation, handle http requests.

Business Layer: Validation, any business logic.

Persistence Layer: The data access layer handles the storage and retrieval of data.

Database Layer: The actual database that store data.

## 5
Presentation Layer:
Postman sends an HTTP request to a specific endpoint (URL) in the application.
The request is received by the appropriate controller in the presentation layer.
The controller is responsible for handling the request and interacting with other layers.

Business Layer:
The controller delegates the request to the corresponding service class in the service layer.
The service class contains the business logic related to the requested operation.
The service class may interact with one or more repositories in the data access layer to retrieve or manipulate data.

Persistence Layer:
he service class interacts with the repository to perform database operations.
The repository handles the communication with the underlying database, executing queries, and returning data to the service class.

Database:
Perform actual operations on the database.

## 6
They are configuration files commonly used in Spring Boot applications to configure various settings and properties.

`application.properties` is a file in key-value pair format, where each line represents a configuration property. It is based on the standard Java Properties format and is widely used in Spring Boot applications. You can define properties such as database connection details, server port, logging configurations, and other application-specific settings.

`application.yml` is an alternative configuration file format supported by Spring Boot. It uses YAML (YAML Ain't Markup Language) syntax, which provides a more human-readable and structured way to define configuration properties. YAML supports hierarchical structures and indentation for representing complex data.

## 7
See under MavenProject.