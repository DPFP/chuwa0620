# HW 9
## Q1. List all of the new annotations to your annotaitons.md and explain its role.
```
See details in the updated file.
```

## Q2.  how do you do the debug?
```
Create breaking point and see how the vraible or other things changes
```

## Q3.  What is DTO, VO, Payload, DO, model?
```
Data Transfer Object: Used for transferring data between different layers of an application, contains only data, no business logic.
Value Object: often used to represent the data that is displayed to the user
Payloads: used to carry metadata information for processing and display to client
Domain Object: a logical container of purely domain information
Model:  a visual representation of software or systems' objects, attributes, actions, and relationships as an intermediary between data and the View.
```

## Q4.  What is @JsonProperty("description_yyds") (不会的话，课上问)?
```
The `@JsonProperty` annotation allows you to define a custom name for JSON properties that may differ from the 
Java object's field or method name. It provides more flexibility and control over the JSON serialization and deserialization process.
```

## Q5.  do you know what is jackson?
```
Jackson is widely used in various Java frameworks and applications to work with JSON data. It has become the de facto 
standard for JSON processing in the Java ecosystem due to its performance, ease of use, and extensive features.
```

## Q6.  What is spring-boot-stater?
a. what dependecies in the below starter? do you know any starters?
```
Spring-boot-starter is the dependencies and configurations that have been packaged by spring-boot for direct use. 
This is spring-boot-starter-web there are Spring WEB or more
```

## Q7 do you know  @RequestMapping(value = "/users", method =RequestMethod.POST) ? could you list CRUD by this style?
```
@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)  
```

## Q8.  What is ResponseEntity? why do we need it?
```
ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, it can give us
more flexibility in handling various scenarios in your Spring Boot applications
```

## Q9.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC
```
It is used to store the data which are returned from the database table after the execution of the SQL statements in 
the Java Program. The object of ResultSet maintains cursor point at the result data

Establish a connection with a data source
Send queries and update statements to the data source
Process the results
```

## Q10. What is the ORM framework?
```
Object-Relational Mapping. It is a programming technique that allows developers to interact with a relational database using an object-oriented programming language.  
```

## Q11. Learn how to use ObjectMapper by this example.
```
Done
```

## Q12. What is the serialization and desrialization?
```
Data serialization is the process of converting an object into a stream of bytes to more easily save or transmit it. And
Desirialization is the reverse process
```

## Q13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```
int[] array = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32}
Arrays.stream(array).average().getAsDouble();.
```

## Q14.抄写
```
in Redbook_coding file
```