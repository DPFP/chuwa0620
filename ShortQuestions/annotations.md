# annotations
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