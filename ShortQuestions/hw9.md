# 1.  List all of the new annotations to your annotaitons.md and explain its role
Done

# 2. how do you do the debug?
1. Set breakpoints
2. Run in debug mode
3. Interact with the application and check

# 3. What is DTO, VO, Payload, DO, model?
**DTO**: Data Transfer Object is a design pattern used to transfer data between different layers or components of an application. It typically carries data but does not contain business logic.

**VO**: Value Object is a design pattern that represents an immutable object whose equality is based on the value of its attributes rather than on its identity. Value objects are often used to encapsulate a group of related attributes that form a cohesive unit.

**Payload**: Payload refers to the data or information that is transmitted or carried by a message in a communication system. In the context of APIs or message-based systems, the payload represents the actual data being transferred, excluding any metadata or protocol-related information.

**DO**: Domain Object represents an object that models concepts from the problem domain or the business logic of an application.

**Model**: "model" refers to a representation of something in the software system. It can be used to represent the data structure, behavior, or the overall structure of the application.

# 4. What is @JsonProperty("description_yyds")
To assign a name to an parameter, affecting in JSON parsing.

# 5. Do you know what is jackson?
Jackson provides a powerful set of APIs for converting Java objects to JSON format (serialization) and converting JSON back to Java objects (deserialization).

# 6. What is spring-boot-stater?
spring-boot-starter is a Maven or Gradle dependency that provides a convenient way to include a set of dependencies in a Spring Boot project.

Some dependencies in the starter are:
- SpringMVC
- Jackson JSON
- Spring WEB
- Logging

# 7. do you know  @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?
It's to handle urls that are "/users" and http method is POST.

Read: @RequestMapping(value = "/users", method = RequestMethod.GET)

Update: @RequestMapping(value = "/users/id", method = RequestMethod.PUT)

Delete: @RequestMapping(value = "/users/id", method = RequestMethod.DELETE)

# 8. What is ResponseEntity? why do we need it?
Wrapper class to response info sent back to client. It provides a standard and clear way to manage header, content and status code sending.

# 9.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC
Query results will be stored in jdbc after query.

1. Build connection between jdbc and database.
2. Create statement
3. Create resultset and execute sql
4. Close all resources, reversely.

# 10. What is the ORM framework?
ORM is a programming technique and framework that enables developers to map objects from java to data stored in relational databases.

# 11. Learn how to use ObjectMapper by this example
Done

# 12. What is the serialization and desrialization?
Serialization: Object to JSON

Desrialization: JSON to Object

# 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]
```
int [] nums = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
double ave = Arrays.stream(nums).average().orElse(0.0);
```

# 14. . 抄写，https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable
Done