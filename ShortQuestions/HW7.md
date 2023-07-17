## 1.create a file to list all of the annotaitons you learned and known, and explain the usage and how do youunderstand it. 

you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.

- File name: annotations.md
- you'd better also list a code example under the annotations.

### Annotations Used by Entity

1. `@Entity` (JPA): This annotation specifies that the class is an entity. This annotation is applied to the entity class.

   ```Java
   @Entity
   public class Book {
       ...
   }
   ```

2. `@Table` (JPA): This annotation is used to specify the details of the table that will be used to persist the entity in the database.

   ```java
   @Entity
   @Table(name = "books")
   public class Book {
       ...
   }
   ```

3. `@Id` (JPA): This annotation is used to specify the primary key of the entity.

   ```java
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   ```

4. `@Column` (JPA): This annotation is used to specify the details of the column for the property that will be persisted in the database.

   ```java
   @Column(name = "book_title", nullable = false)
   private String title;
   ```

### Annotations Used by Controller

1. `@Controller` (Spring MVC): This annotation indicates that a particular class serves the role of a controller. The `@Controller` annotation acts as a stereotype for the annotated class, indicating its role.

   ```java
   @Controller
   public class BookController {
       ...
   }
   ```

2. `@RestController` (Spring MVC): This annotation is a specialized version of the controller. It includes the `@Controller` and `@ResponseBody` annotations and as a result, simplifies the controller implementation.

   ```java
   @RestController
   public class BookController {
       ...
   }
   ```

3. `@RequestMapping` (Spring MVC): This annotation is used to map web requests onto specific handler classes and/or handler methods.

   ```java
   @RestController
   @RequestMapping("/books")
   public class BookController {
       ...
   }
   ```

4. `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping` (Spring MVC): These annotations are specialized versions of `@RequestMapping` annotation that act as shortcuts for `@RequestMapping(method = RequestMethod.GET)` and others.

   ```java
   @GetMapping("/{id}")
   public ResponseEntity<Book> getBook(@PathVariable("id") long id) {
       ...
   }
   ```

### Annotations Used by Service Layer

1. `@Service` (Spring): This annotation is used with classes that provide some business functionalities. Spring context will autodetect these classes when annotation-based configuration and classpath scanning is used.

   ```java
   @Service
   public class BookService {
       ...
   }
   ```

2. `@Transactional` (Spring): This annotation is used with methods that require a database transaction.

   ```java
   @Service
   public class BookService {
   
       @Transactional
       public void updateBook(...) {
           ...
       }
   }
   ```

### Annotations Used for Security

1. `@PreAuthorize` (Spring Security): This annotation decides whether a method can actually be invoked or not based on user's role.

   ```java
   @PreAuthorize("hasRole('ADMIN')")
   public void updateBook(...) {
       ...
   }
   ```

2. `@Secured` (Spring Security): It's used to decide access at the method level. This is an older annotation, less flexible than `@PreAuthorize`.

   ```java
   @Secured("ROLE_ADMIN")
   public void updateBook(...) {
       ...
   }
   ```

### Annotations Used for Testing

1. `@Test` (JUnit): This annotation is used with methods to indicate that they are test methods.

   ```java
   public class BookTest {
   
       @Test
       public void testUpdateBook() {
           ...
       }
   }
   ```

2. `@Before` (JUnit): This annotation is used on methods that need to be executed before each test method.

   ```java
   public class BookTest {
   
       @Before
       public void setup() {
           ...
       }
   
       @Test
       public void testUpdateBook() {
           ...
       }
   }
   ```

3. `@After` (JUnit): This annotation is used on methods that need to be executed after each test method.

   ```java
   public class BookTest {
   
       @After
       public void cleanup() {
           ...
       }
   
       @Test
       public void testUpdateBook() {
           ...
       }
   }
   ```

4. `@MockBean` (Spring Boot): This annotation is used to add mocks to a Spring `ApplicationContext`. Can be used as a class level annotation or on fields in either `@SpringBootTest` or `@WebMvcTest` classes.

   ```java
   @WebMvcTest(BookController.class)
   public class BookControllerTest {
   
       @MockBean
       private BookService bookService;
   
       ...
   ```





## 2. explain how the below annotaitons specify the table in database?

```Java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```

`@Column(columnDefinition = "varchar(255) default 'John Snow'")` creates a `name` column, type `varchar(255)`, defaulting to 'John Snow' if no value is provided.

`@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)` maps `studentName` to `STUDENT_NAME` column in the database, maximum length 50 characters, cannot be null, and values don't need to be unique.

## 3. What is the default column names of the table in database for @Column ?

```Java
@Column
private String firstName;
@Column
private String operatingSystem;
```

对于Java中的`@Column`注解，如果未显式指定列名，则默认使用属性名作为数据库表中的列名。

数据库表中的默认列名将分别为`firstName`和`operatingSystem`。

However, it is always a good practice to explicitly specify the column name

```Java
@Column(name = "first_name")
private String firstName;

@Column(name = "operating_system")
private String operatingSystem;
```



## 4. What are the layers in springboot application? what is the role of each layer?

1. **Controller Layer**: This layer **handles the incoming HTTP requests and sends back HTTP responses.** Controllers interpret the user input and transform it into a model which is represented to the user by the view. Controllers are typically annotated with `@Controller` or `@RestController` in Spring Boot.
2. **Service Layer**: The service layer contains the **business logic of the application** and is used to **communicate between the controller and repository layers**. This layer is where all the business rules for the application are defined. It's typically marked by the `@Service` annotation in Spring Boot.
3. **Repository/DAO Layer**: This layer is responsible for **interacting with the database**. It performs all the **CRUD** operations: Create, Read, Update, and Delete. In Spring Boot, this layer is typically an interface extending one of the Spring Data JPA repository interfaces (like `JpaRepository`, `CrudRepository`). Classes/interfaces in this layer are typically marked with `@Repository` annotation.
4. **Model/Entity Layer**: This layer **represents the data structure of the application**. These are typically the classes that map to the database tables. Entities are used to persist data to the database and fetch data from it. They are typically annotated with `@Entity`.

## 5. Describe the flow in all of the layers if an API is called by Postman.

Let's take an example of a `GET` request being made to an API endpoint `/api/books/{id}` which returns the details of a specific book:

1. **Controller Layer**: The request from Postman is received at this layer. The `BookController`, which is responsible for handling requests related to books, matches the requested URI `/api/books/{id}` and calls the appropriate method, for example `getBookById(id)`.
2. **Service Layer**: The `getBookById(id)` method in the `BookController` will then call a corresponding method in the `BookService`. This service contains the business logic to handle the request. In this case, it would be responsible for validating the `id` and handling any business exceptions.
3. **Repository/DAO Layer**: After validating the `id`, the `BookService` calls a method in `BookRepository` to fetch the book from the database. The `BookRepository` does the actual querying of the database and returns the result back to the `BookService`.
4. **Model/Entity Layer**: The `BookRepository` interacts with the `Book` entity to map the database table to a Java object.
5. Once the `Book` object is returned to the `BookService` from the `BookRepository`, the service layer may then perform additional operations like further processing or filtering of the data.
6. The `BookService` then returns the processed data back to the `BookController`.
7. Finally, the `BookController` sends this data as an HTTP response back to the client (Postman in this case).

## 6. What is the application.properties? do you know application.yml?

The `application.properties` file uses a traditional, properties-style format for defining properties:

```
propertiesCopy codeserver.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=secret
```

On the other hand, `application.yml` uses YAML (Yet Another Markup Language), a human-readable data serialization standard:

```
yamlCopy codeserver:
  port: 8080
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: secret
```

## 7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;

https://www.mongodb.com/compatibility/spring-boot

Done