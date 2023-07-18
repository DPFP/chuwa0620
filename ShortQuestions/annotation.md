Below are all the annotations that I have learned:

1. `@RestController`: <br>
    This annotation is used to define a RESTful web service controller. <br>
It combines the @Controller and @ResponseBody annotations, making it convenient to handle and return HTTP responses in JSON or XML format.
2. `@RequestMapping`: <br>
    It is used to map a specific URL pattern or HTTP method to a method in a controller class. <br>
    It defines the endpoint that will trigger the corresponding method for processing the request.
3. `@Autowired`: <br>
    This annotation is used for automatic dependency injection. <br>
    It injects an instance of a class into another class, resolving dependencies and allowing the components to work together.
4. `@Service`: <br>
    It is used to annotate a service class. <br>
    This annotation identifies the class as a service component in the business layer, typically containing the application's business logic.
5. `@Repository`: <br>
    This annotation is used to mark a class as a repository component. <br>
    It is typically applied to a class that performs database operations, providing data access and persistence functionality.
6. `@Component`: <br>
    a generic annotation in the Spring framework used to mark a class as a Spring-managed component. <br>
    The @Component annotation is typically used when the purpose of a class does not fall into one of the more specialized annotations (@Service, @Repository, etc.).
   It allows for generic bean definition and detection without specifying a particular role or specialization.
7. `@Bean`: <br>
    used to indicate that a method produces a bean to be managed by the Spring container. <br>
    It is often used in configuration classes to explicitly define and configure beans.
8. `@PathVariable`: <br>
    It is used to extract values from the URI path in a controller method. <br>
    This annotation binds a method parameter to a path variable in the request URL. 
9. `@RequestBody`: <br>
    It is used to bind the HTTP request body to a method parameter. <br>
    This annotation is commonly used to receive and parse the JSON or XML data sent in the request payload.
10. `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`: <br>
    These annotations are shortcuts for the commonly used HTTP methods GET, POST, PUT and DELETE, respectively. <br>
    They combine the @RequestMapping annotation with the respective HTTP method, making it easier to define endpoint mappings.
11. `@Entity`: <br>
    Used to mark a class as an entity representing a table in a relational database. <br>
    
12. `@Column`: <br>
    specify the mapping between a Java class field and a database column. 
