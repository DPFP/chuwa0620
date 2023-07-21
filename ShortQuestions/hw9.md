# HW9
### Name: Yuanzhen Lin

1. List all of the new annotations to your annotaitons.md and explain its role.\
See in the annotations.md


2. how do you do the debug?
- Set breakpoints
- Start the Debugging Session
- Inspect the Program State\
The Variables window shows the values of the variables at the current point of execution.
- Control Execution\
  Step Over (F8):\
  Step Into (F7):\
  Step Out (Shift+F8):\
  Run to Cursor (Alt+F9):   


3. What is DTO, VO, Payload, DO, model?
- DTO (Data Transfer Object): \
This is an object that carries data between processes. In the context of a Spring + JPA application, a DTO would often carry data between the service layer and the controller (API) layer. It's used to encapsulate the data being sent over the network - for example, the data sent as a response from your API.
- VO (Value Object): \
This is an object that represents a value, and doesn't have a conceptual identity. They are equal if their values are equal. Examples might be things like a date range (with a start and end date), a money object (with an amount and a currency), or a coordinate (with x and y values).
- Payload: \
This is the actual data that's being carried in a request or response body. In a RESTful service, this would be the JSON or XML data contained in the body of the HTTP request or response.
- DO (Domain Object): \
This is an object that is part of the domain model. It contains both data and behavior. For example, a User or Order entity in an e-commerce application could be considered domain objects.
- Model: \
In the context of Spring MVC, a Model is used to pass attributes (data) from controllers to view (like JSP or Thymeleaf). It represents the data of the application and the methods to manipulate it. In the context of JPA, a model usually refers to an Entity, which is a domain object that can be persisted to the database.


4. What is @JsonProperty("description_yyds")?\
The @JsonProperty annotation belongs to the Jackson library in Java, which is used for converting Java objects to JSON and vice versa (serialization and deserialization). This annotation is used to specify the property name in a JSON document.\
This can be useful when the JSON you are working with doesn't have the same field names as your Java model. It also applies when deserializing from JSON to Java, in order to map the JSON properties to the correct Java fields.
```aidl
public class Item {
    @JsonProperty("description_yyds")
    private String description;
}
```


5. do you know what is jackson?
```aidl
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.13.3</version>
  <scope>compile</scope>
</dependency>
```
Jackson is a very popular library in Java for handling JSON. It provides functionality for reading and writing JSON, either to and from basic POJOs (Plain Old Java Objects), or to and from a general-purpose JSON Tree Model (JsonNode), or to and from JSON-like data encoded as Strings.\
In a Spring Boot application, Jackson is the default JSON library and comes included with Spring Boot, so typically you wouldn't need to add this dependency yourself unless you need a specific version of Jackson that's different from the one Spring Boot provides.


6. What is spring-boot-stater?
 a. what dependecies in the below starter? do you know any starters?
```aidl
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
Spring Boot Starters are a set of convenient dependency descriptors that you can include in your application. The starters contain a lot of the dependencies that you need to get a project up and running quickly and with a consistent, supported set of managed transitive dependencies.

The spring-boot-starter-web is used for building web applications, including RESTful applications using Spring MVC. It uses Tomcat as the default embedded container.

Here's a list of what spring-boot-starter-web brings in:

- spring-boot-starter: This is the core starter, including auto-configuration support, logging, and YAML support.

- spring-boot-starter-json: This includes support for converting objects to and from JSON format, which is commonly used in web applications.

- spring-boot-starter-tomcat: This includes an embedded Tomcat server for running your web application.

- spring-webmvc: This is the core functionality of Spring MVC, including the DispatcherServlet for handling web requests.

- spring-web: This includes core web components used by Spring MVC, such as RestTemplate for client-side HTTP access.

- hibernate-validator: This provides support for Bean Validation, which is a standard validation technology for Java beans.

There are many other Spring Boot starters for different kinds of applications and technologies, including:
- spring-boot-starter-data-jpa: For Spring Data JPA with Hibernate
- spring-boot-starter-thymeleaf: For building MVC web applications using Thymeleaf views
- spring-boot-starter-security: For Spring Security
- spring-boot-starter-data-rest: For exposing Spring Data repositories over REST
- spring-boot-starter-amqp: For Spring AMQP (Advanced Message Queuing Protocol)
- spring-boot-starter-webflux: For building reactive web applications with Spring WebFlux

7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?\

@RequestMapping is a Spring annotation used to map web requests to Spring Controller methods. The value attribute defines the URL to which the annotated method responds, and the method attribute specifies the type of the HTTP request.

In terms of CRUD (Create, Read, Update, Delete) operations, they would typically map to the following HTTP methods:
- Create: POST
- Read: GET
- Update: PUT or PATCH
- Delete: DELETE

Here's how you might define controller methods for these operations in Spring:
```aidl
@Controller
@RequestMapping("/users")
public class UserController {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // implementation of user creation
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("userId") Long userId) {
        // implementation of getting a user
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User user) {
        // implementation of updating a user
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId) {
        // implementation of deleting a user
    }
}
```

Note: As of Spring 4.3, shortcut annotations for @RequestMapping with specific HTTP methods have been introduced. These are @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, and @PatchMapping. Using these can make your code more concise.


8. What is ResponseEntity? why do we need it?
```aidl
1 new ResponseEntity<>(postResponse, HttpStatus.OK); 
2 new ResponseEntity<>(postResponse, HttpStatus.CREATED);
3 ResponseEntity.ok(postService.getPostById(id));
```

ResponseEntity is a class in Spring Framework that represents an HTTP response, including the status code, headers, and body. Because it's a generic class, you can use it to fully configure the HTTP response.

You might use ResponseEntity in a controller method when you need to have more control over the response sent back to the client. With ResponseEntity, you can modify the HTTP status code, headers, and body content of the response.

1. new ResponseEntity<>(postResponse, HttpStatus.OK):\
This creates a new ResponseEntity with the postResponse object as the body and an HTTP status code of 200 (OK). This would typically be used for a successful request where data is being returned to the client.

2. new ResponseEntity<>(postResponse, HttpStatus.CREATED): \
This creates a new ResponseEntity with the postResponse object as the body and an HTTP status code of 201 (Created). This would typically be used for a successful POST request, where a new resource has been created.

3. ResponseEntity.ok(postService.getPostById(id)): \
This is a shortcut for creating a ResponseEntity with an HTTP status code of 200 (OK). The ok() method is a static method on ResponseEntity that creates a new ResponseEntity with the given body and a status code of 200.

Using ResponseEntity gives you more control over the HTTP response than simply returning an object from a controller method. It allows you to ensure that the client is receiving the right status codes and any necessary headers along with the response body.


9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

The ResultSet interface in JDBC (Java Database Connectivity) represents a result set of a database query. It maintains a cursor pointing to its current row of data. Initially, the cursor is positioned before the first row. The next() method of ResultSet moves the cursor to the next row, and because it returns false when there are no more rows in the ResultSet object, it is often used in a loop to iterate through the result set.

A typical JDBC flow to retrieve data would be as follows:
- Establish a connection: First, you establish a connection to the database using a Connection object.
```aidl
Connection connection = DriverManager.getConnection(url, username, password);
```

- Create a statement: After establishing a connection, you create a Statement object, which will be used to execute a SQL query.
```aidl
Statement statement = connection.createStatement();
```

- Execute the query: Then you execute the query, which returns a ResultSet object.
```aidl
ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
```

- Process the result set: Now you can iterate through the ResultSet object to retrieve the data returned from the query.
```aidl
while(resultSet.next()) {
    int id = resultSet.getInt("id");
    String name = resultSet.getString("name");
    // ... get other fields ...
    // process the data
}
```

- Close the resources: Finally, it's very important to close the resources when you're done with them to avoid potential memory leaks and other issues. This should ideally be done in a finally block or using a try-with-resources statement.
```aidl
resultSet.close();
statement.close();
connection.close();
```


10. What is the ORM framework?

ORM stands for Object-Relational Mapping. It's a programming technique that allows developers to interact with their database in an object-oriented manner.

An ORM framework solves this problem by mapping between tables in the database and the objects in the program. It provides APIs that allow you to perform CRUD (Create, Read, Update, Delete) operations without having to write SQL code, and it translates these operations into the appropriate SQL commands behind the scenes.

Examples of ORM frameworks in Java include Hibernate, EclipseLink, and the Java Persistence API (JPA), which is a standard interface that different ORM frameworks can implement. In the Spring Framework, Spring Data JPA makes it even easier to work with JPA-based ORMs.


11. Learn how to use ObjectMapper by this example.
```aidl
1 FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);
2 String s = objectMapper.writeValueAsString(foodOutlet);
3 objectMapper.readTree() // learn how to use it?
```

12. What is the serialization and desrialization?

Serialization is the process of converting a data object—a combination of code and data represented within a region of data storage—into a series of bytes that saves the state of the object in an easily transmittable form.

In this serialized form, the data can be delivered to another data store (such as an in-memory computing platform), application, or some other destination.

The reverse process—constructing a data structure or object from a series of bytes—is deserialization. The deserialization process recreates the object, thus making the data easier to read and modify as a native structure in a programming language.


13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```aidl
int[] array = new int[]{20, 3, 78, 9, 6, 53, 73, 99, 24, 32};

OptionalDouble average = Arrays.stream(array)
        .average();

if(average.isPresent()){
    System.out.println("Average is: " + average.getAsDouble());
} else {
    System.out.println("Array is empty");
}
```

14. 抄写，https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable

Located in Practice/redbook-03







