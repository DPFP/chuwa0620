
###@SpringBootApplication: 
This is the main annotation used to mark the main class of a Spring Boot application. It combines the functionality of @Configuration, @EnableAutoConfiguration, and @ComponentScan annotations.

###@RestController: 
This annotation is used to mark a class as a RESTful controller. It combines @Controller and @ResponseBody annotations, allowing you to handle HTTP requests and return response bodies.

###@RequestMapping:
This annotation is used to map HTTP requests to specific methods in a controller class. It can be applied at the class or method level and allows you to specify the URL path and HTTP method for handling the request.

###@Autowired: 
This annotation is used to inject dependencies automatically. It can be applied to fields, constructors, or setter methods, allowing Spring to resolve and provide the necessary dependencies.

###@Service: 
This annotation is used to mark a class as a service component. It is typically applied to classes that contain business logic and are responsible for processing data or performing operations.

###@Repository: 
This annotation is used to mark a class as a repository component. It is typically applied to classes that handle data access and interact with the database, providing methods for querying, saving, and retrieving data.

###@Component: 
This annotation is used to mark a class as a generic Spring component. It is a generic stereotype annotation that can be used when more specific annotations like @Service or @Repository are not applicable.

###@Configuration: 
This annotation is used to mark a class as a configuration class. It is typically used in conjunction with @Bean annotations to define beans and configure various aspects of the application.

###@EnableAutoConfiguration: 
This annotation is used to enable Spring Boot's auto-configuration mechanism. It allows Spring Boot to automatically configure beans and components based on the dependencies present in the classpath.

###@Value: 
This annotation is used to inject values from properties files or environment variables into Spring components. It can be applied to fields, constructors, or setter methods, allowing you to easily externalize configuration values.

### @Bean
mark as a bean to be scanned

### @Query
### @Table
### @Document
### @OneToMany
### @OneToOne
### @ManyToOne
### @ManyToMany