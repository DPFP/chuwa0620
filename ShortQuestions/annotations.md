1. Annotation

   ```java
   // for bean
   @Component
   public class ConversationImpl implements Conversation{
     
   }
   
   @Service
   @RequiredArgsConstructor
   public class BlogServiceImpl implements BlogService{
     private BlogRepository blogRepo;
     
   }
   
   @Repository
   public class BlogRepository extends JpaRepository<Blog,Long>{
     Blog findByBlogId(Long id);
   }
   
   @Controller
   @CrossOrigin(origins = "*", maxAge = 3600)
   @RestController
   @RequiredArgsConstructor
   @RequestMapping("/api/v1/auth")
   public class BlogController{
     // mapping rest api
   }
   
   // for injectsion
   @Autowired
   @Inject
   @Resource
   
   //Config
   @Configuration // xml
   @Bean // on method
   
   
   // AOP
   @Aspect
   @After
   @Before
   @Around
   @Pointcut
   
   //Value
   @Value()
   
   
   //Data
   @Entity
   @Table
   @Version
   @Id
   @GeneratedValue
   @Column
   @OneToMany
   @ManyToOne
   @OneToOne
   ```

2. @Column(columnDefinition = "varchar(255) default 'John Snow'") means the while creating the table in database, column name will have type of varchar with max length 255 and default value as "john snow"

   @@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false) means student_name column in database will have length of 50, cannot be null and does't need to be unique.

3. firstName = first_name, operationSystem = operation_system.

4. Presentation layer, Business Layer, Persistance Layer, Database Layer

5. 1. The Client makes an **HTTP** request(GET, PUT, POST, etc.)
   2. The HTTP request is forwarded to the **Controller**. The controller maps the request. It processes the handles and calls the server logic.
   3. The business logic is performed in the **Service layer**. The spring boot performs all the logic over the data of the database which is mapped to the spring boot model class through [Java Persistence Library](https://www.geeksforgeeks.org/spring-boot-spring-data-jpa/)(**JPA**).
   4. The [JSP](https://www.geeksforgeeks.org/introduction-to-jsp/) page is returned as Response from the controller.

6. Application properties are **configurable application parameters to change an application's behavior**. In the typical case, only system administrators and/or application administrators can read and write application properties.

7. @Service By marking a class with @Service, you are indicating that it serves the role of a service or business logic component. This helps in semantic clarity and provides a standardized way of defining and autodetecting service classes within the application context.

   @Configuration Declares a class as the source for bean definitions.

   @ComponentScan Directs Spring to search for components in the path specified.

   @Qualifier, @Primary When there are mulitple beans, decide which bean to use

   @Resource, @Inject Other way of bean injection

   @Controller @RestController = @Controller + @ResponseBody

   @ResponseBody need to be before the returned object.

   @ExceptionHandler method level, used to handle the specific exceptions and sending the custom responses to the client.

   @ControllerAdvice class level, it can make this class a bean, define global exception handlers to all controller.

   @NotEmpty @Size @Valid Used for validation, ie: column length cannot be greater than 10.

   @Aspect Annotation used to denote class that defines all aop self methods.

   @PointCut Define a collection with a given name, function body is null.

   @Before, @After, @AfterThrowing, @AfterReturning, @Around Time to trigger aop method.

   @Mock Mock an object or certain behavior.

   @InjectMocks We can use @InjectMocks to automatically inject the mock object into the some thing that uses the mocked object.

   @Test From Junit, indicate this method is a test

   @Spy If the behavior is given, use the given behavior, if not, use the original behavior of this object.

   @BeforeAll, @AfterAll Run some common setting or methods before all tests. Also can only added to static method as it is in class level.

   ## 