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

7. Done