# Used by Entity

## @Entity

* Usage: This annotation is used to mark a class as an entity, which means it will be mapped to a database table.
* Understanding: When working with Object-Relational Mapping (ORM) frameworks like Hibernate in Java, this annotation
  allows you to specify that a Java class represents a persistent entity in the database.

```java

@Entity
public class User {
    @Id
    private Long id;
    private String username;
    private String email;
    // ...
}

```

## @Id

* Usage: The @Id annotation is used to specify the primary key of an entity class.
* Understanding: In JPA (Java Persistence API), this annotation indicates which field or property of the entity is to be
  treated as the unique identifier for that entity.

```java

@Entity
public class Product {
    @Id
    private Long productId;
    private String name;
    private double price;
    // ...
}

```

## @Component

* usage: Marks a class as a component eligible for Spring's automatic scanning and instantiation. Though it's not
  exclusively used for entities, it's often used to annotate classes representing entities in Spring Data projects.

```java

@Component
public class MyComponent {
    public void doSomething() {
        System.out.println("This is a Spring component.");
    }
}
```

# Used by Controller

## @RestController

* Usage: The @RestController annotation is used to mark a class as a controller in Spring Framework, specifically
  designed for RESTful web services.
* Understanding: This annotation combines the functionality of @Controller and @ResponseBody. It enables the class to
  handle HTTP requests and automatically serialize the response data to JSON or XML, making it ideal for building APIs.

```java

@RestController
@RequestMapping("/api")
public class ProductController {
    // Controller methods for handling product-related requests
    // ...
}

```

## @RequestMapping

* Usage: The @RequestMapping annotation is used to map HTTP requests to a specific handler method in a controller.
* Understanding: It allows you to define the URL pattern that will trigger the associated controller method. You can
  specify the HTTP method, path, and other attributes to handle different types of requests.

```java

@RestController
@RequestMapping("/api")
public class ProductController {

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        // Code to fetch and return all products
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        // Code to fetch a product by ID and return it in the response
    }

    // ...
}

```

## @RequestBody

* Usage: The @RequestBody annotation is used to indicate that a method parameter should be bound to the body of the HTTP
  request.
* Understanding: When using this annotation, the framework will automatically deserialize the request body into the
  specified parameter type. It is commonly used for POST and PUT requests where the data is sent in the request body.

```java

@RestController
@RequestMapping("/api")
public class ProductController {

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Product> createProduct(@RequestBody Product newProduct) {
        // Code to create a new product using the data from the request body
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
        // Code to update an existing product with the data from the request body
    }

    // ...
}
```

## @PathVariable

* Usage: The @PathVariable annotation is used to extract values from the URI path and use them as method parameters.
* Understanding: It allows you to capture dynamic values from the URL and pass them to the controller method as
  arguments.

```java

@RestController
@RequestMapping("/api")
public class ProductController {

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
        // Code to fetch a product by the given ID
    }

    // ...
}
```

# Used by Service

## @Service

* Usage: The @Service annotation is used to mark a class as a service component in Spring Framework.
* Understanding: This annotation is used to indicate that a class contains business logic and acts as a service layer.
  It is typically used to process and handle data retrieved from the database before sending it to the controller layer.

```java

@Service
public class ProductService {
    // Service methods for product-related operations
    // ...
}

```

## @Transactional

* Usage: The @Transactional annotation is used to define the transactional behavior for service methods.
* Understanding: By adding this annotation to a service method, the method will be executed within a transaction. If the
  method encounters an exception, the transaction will be rolled back, ensuring data consistency.

```java

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void updateProductStock(Long productId, int newStock) {
        Product product = productRepository.findById(productId);
        product.setStock(newStock);
        // Transaction will be automatically managed by Spring
    }

    // ...
}

```

## @Autowired

* Usage: The @Autowired annotation is used for automatic dependency injection in Spring.
* Understanding: By using this annotation, Spring will automatically resolve and inject the required dependency into the
  class without the need for manual configuration. It is commonly used for wiring service classes with repositories or
  other dependent components.

```java

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Service methods using the productRepository
    // ...
}

```

## @RequestMapping

*Usage: Maps HTTP requests to handler methods or controller classes. It can be used at the class level to define a base
URL or at the method level to specify individual endpoint mappings. @GetMapping: Maps HTTP GET requests to handler
methods or controller classes. It is a shortcut for @RequestMapping(method = RequestMethod.GET). @PostMapping:
Maps HTTP POST requests to handler methods or controller classes. It is a shortcut for @RequestMapping(method =
RequestMethod.POST).

## @PutMapping

*Usage: Maps HTTP PUT requests to handler methods or controller classes.

```java

@Controller
@RequestMapping("/books")
public class BookController {
    @PutMapping("/{id}")
    @ResponseBody
    public String updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        // Logic to update book details by ID with the data in updatedBook
        return "Book updated successfully";
    }
}
```

## @DeleteMapping:

*Usage: Maps HTTP DELETE requests to handler methods or controller classes. It is a shortcut for @RequestMapping(method
= RequestMethod.DELETE).

```java

@Controller
@RequestMapping("/books")
public class BookController {
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id) {
        // Logic to delete book by ID
        return "Book deleted successfully";
    }
}

```