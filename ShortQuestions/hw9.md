# 1. List all of the new annotations to your annotaitons.md and explain its role

Done

# 2. how do you do the debug?

1. check logs
2. Set breakpoints
3. Run in debug mode

# 3. What is DTO, VO, Payload, DO, model?

DTO (Data Transfer Object): A simple object used to transfer data between different parts of an application or between
applications.

VO (Value Object): An object that represents a value and is compared based on its attributes, often used for immutable
and identity-independent concepts.

Payload: The actual data carried within a message or container, such as the data sent or received in an HTTP request or
response.

DO (Domain Object): Represents real-world concepts in the application's domain and contains business logic related to
the core domain.

Model: In the context of MVC, it represents the data and business logic of the application. In broader terms, it can
refer to the objects and data structures used to represent and manipulate the application's data.

# 4. What is @JsonProperty("description_yyds")

@JsonProperty("description_yyds") is a Jackson annotation used in Java to specify the mapping between a Java object's
property and a JSON field. It is primarily used when serializing (converting Java object to JSON) or deserializing (
converting JSON to Java object) data using the Jackson library.

# 5. Do you know what is jackson?

Jackson is a popular and widely used open-source Java library for working with JSON data. It provides a set of powerful
tools to serialize (convert Java objects to JSON) and deserialize (convert JSON to Java objects) data, making it easy to
work with JSON data in Java applications.

Jackson is extensively used in web development, especially in projects that involve RESTful APIs and web services, as
JSON is a common data interchange format for these types of applications.

# 6. What is spring-boot-stater?

In Spring Boot, a "starter" is a special type of dependency that simplifies the process of setting up and configuring
various features and functionalities in your Spring Boot application. Spring Boot starters are designed to provide a
convenient way to include common dependencies and configuration for specific use cases or technologies.

Some common Spring Boot starters include:

spring-boot-starter-web: For building web applications using Spring MVC. spring-boot-starter-data-jpa: For using Spring
Data JPA to work with databases. spring-boot-starter-security: For adding Spring Security to secure your application.
spring-boot-starter-test: For including testing dependencies, such as JUnit and Mockito. spring-boot-starter-thymeleaf:
For using the Thymeleaf templating engine in web applications.

# 7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

it can be used to implement CRUD (Create, Read, Update, Delete) operations in a Spring Boot application. However, since
Spring 4.3, it is recommended to use more specific annotations like @PostMapping, @GetMapping, @PutMapping, and
@DeleteMapping for handling HTTP methods, as they provide better clarity and make the code more readable.

Nonetheless, for the sake of completeness, I'll provide an example of how to implement CRUD operations using
@RequestMapping

```java
    // Create - POST
@RequestMapping(method = RequestMethod.POST)
// Create - POST
@PostMapping

// Read - GET
@RequestMapping(value = "/{id}", method = RequestMethod.GET)
// Read - GET
@GetMapping("/{id}")
// Update - PUT
@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
// Update - PUT
@PutMapping("/{id}")
// Delete - DELETE
@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
// Delete - DELETE
@DeleteMapping("/{id}")
```

# 8. What is ResponseEntity? why do we need it?

ResponseEntity gives us greater control over the HTTP response and allows us to create well-structured and informative
responses for our web applications.

# 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

Sure, here's a brief explanation of getting data using JDBC:

Load JDBC Driver: Load the appropriate JDBC driver for the database.

Establish Connection: Establish a connection to the database using DriverManager.getConnection().

Create Statement or PreparedStatement: Create a Statement or PreparedStatement for executing SQL queries.

Execute Query: Execute the SQL query using executeQuery() method to get a ResultSet.

Process ResultSet: Use the ResultSet to retrieve data from the database.

Close Resources: Close the ResultSet, Statement, PreparedStatement, and Connection to release resources.

# 10. What is the ORM framework?

ORM frameworks handle the mapping between the relational database and the object-oriented code. They automatically
translate data between the database tables and the corresponding objects in the application. This means developers can
work with database data using familiar object-oriented principles and do not need to write explicit SQL queries for
basic CRUD operations.

Key features and benefits of using an ORM framework include:

Simplified Data Access: Developers can work with database data using object-oriented programming concepts, reducing the
need for writing complex SQL queries.

Database Independence: ORM frameworks abstract the database-specific details, allowing applications to be more easily
switched between different database systems.

Increased Productivity: ORM reduces boilerplate code for database interaction, leading to faster development and
improved maintainability.

Type Safety: By using objects and classes, ORM frameworks provide compile-time type checking, reducing the likelihood of
runtime errors.

Relationship Management: ORM frameworks handle relationships between objects, such as one-to-one, one-to-many, and
many-to-many, simplifying complex data structures.

# 11. Learn how to use ObjectMapper by this example

Done

# 12. What is the serialization and desrialization?

Serialization is the process of converting an object's state (data) into a format that can be easily stored,
transmitted, or reconstructed later. The serialized data can be in the form of a byte stream, XML, JSON, or other
formats suitable for storage or communication. Serialization is commonly used when saving objects to files, sending data
over a network, or persisting data in databases.

Deserialization, on the other hand, is the process of reconstructing an object from its serialized form back into its
original state, allowing the data to be used and manipulated within a program. Deserialization is commonly used when
reading data from files, receiving data over a network, or retrieving data from databases.

# 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]

```
double average = Arrays.stream(array)
                .average()
                .orElse(0); // Provide a default value if the array is empty
```

# 14. . 抄写，https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable

Done