@Component - Marks a class as a component eligible for Spring's automatic scanning and instantiation.

@Autowired - Automatically injects dependencies by type.

@Controller - Marks a class as a controller component in Spring MVC.

@RestController - Marks a class as a controller for RESTful services, used to return data instead of views.

@Service - Marks a class as a service component in the business logic layer.

@Repository - Marks a class as a persistence component in the data access layer.

@RequestMapping - Maps HTTP requests to handler methods or controller classes.

@GetMapping - Maps HTTP GET requests to handler methods or controller classes.

@PostMapping - Maps HTTP POST requests to handler methods or controller classes.

@PutMapping - Maps HTTP PUT requests to handler methods or controller classes.

@DeleteMapping - Maps HTTP DELETE requests to handler methods or controller classes.

@PathVariable - Retrieves variable values from the URL path and injects them into handler method parameters.

@RequestParam - Retrieves the value of a request parameter from the HTTP request and injects it into handler method parameters.

@RequestBody - Deserializes the content of an HTTP request into a Java object.

@ResponseBody - Serializes the object returned by a method into the content of an HTTP response.

@ExceptionHandler - Defines global exception handling methods.

@Configuration - Indicates that a class declares one or more bean definitions and is eligible to be processed by the Spring container as a source of bean definitions.

@Bean - Indicates that a method produces a bean to be managed by the Spring container.

@Value - Injects values from external sources into fields, constructors, or methods.

@Entity - It is a enity, will be used to map with database

@Table - will be used to locate the database table name

@GeneratedValue - self-generated value

@Column - specify the informaiton for this column, like name in database, can be null or not in database

@Repository - a class is a data repository or a DAO (Data Access Object) that encapsulates data access logic for a particular domain model.

@JoinColumn - the mapping of a foreign key column between two associated entities in a relational database when using ORM