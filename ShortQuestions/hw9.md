# Chuwa0620 HW9  
### Zhizhou Xu

1. See in annotation.md  
2. How do you do the dubug?  
First, create break point where the bug might have located. Then run the project in debug mode. It will stop at the break point, and then we can run it by step and see what program has generated to figure out if there is a bug.  
3. What is DTO, VO, Payload, DO, model?  
    - DTO (Data Transfer Object): Used for transferring data between different layers of an application, contains only data, no business logic.
    - VO (Value Object): Represents immutable data objects, compared based on their content, used to encapsulate multiple attributes.
    - Payload: Data transmitted in an HTTP request or response, carries relevant data for processing or display.
    - DO (Domain Object): Represents objects in the business domain, contains business logic and behavior.
    - Model: Represents the application's data and business logic in the MVC architecture, acts as an intermediary between data and the View.
4. What is `@JsonProperty`?  
   The `@JsonProperty` annotation can be used on fields or methods, and it allows you to define a custom name for JSON properties that may differ from the Java object's field or method name. It provides more flexibility and control over the JSON serialization and deserialization process.
5. Do you know what is jackson?  
   Jackson is widely used in various Java frameworks and applications to work with JSON data. It has become the de facto standard for JSON processing in the Java ecosystem due to its performance, ease of use, and extensive features.
6. What is spring-boot-starter?
Spring-boot-starter is the dependencies and configurations that have been packaged by spring-boot for direct use.  
7. Do you know `@RequestMapping(value = "/users", method = RequestMethod.POST)`? Could you list CRUD by this style?
It means the request URL is `/users`, the request method is `POST`. Itself is a `Creat` method. `Read`, `Update`, `Delete` are as follow.  
   - `Read`  
     `@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)`  
   - `Update`  
     `@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)`  
   - `Delete`  
     `@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)`  
8. What is ResponseEntity? why do we need it?  
   `ResponseEntity` provides control over the entire HTTP response, including status codes, headers, and response bodies, giving you more flexibility in handling various scenarios in your Spring Boot applications.  
9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC?  
   A `ResultSet` is an interface provided by Java that represents the result of a database query. It is used to retrieve and manipulate the data returned by the SELECT query executed on a database using JDBC.  
   1. Load JDBC Driver: First, you need to load the appropriate JDBC driver for your database. This is done using the Class.forName() method, where you specify the JDBC driver's class name.  
   2. Establish Database Connection: Use DriverManager.getConnection() to establish a connection to the database. You need to provide the database URL, username, and password for authentication. 
   3. Create SQL Query: Create an SQL SELECT query string to retrieve the data you want from the database. 
   4. Execute Query: Create a Statement or PreparedStatement object from the database connection and execute the SQL query using the executeQuery() method. 
   5. Retrieve Data from ResultSet: The executeQuery() method returns a ResultSet object. Use various methods of the ResultSet interface (e.g., next(), getInt(), getString(), etc.) to traverse the result set and access the data. 
   6. Process Data: Process the retrieved data as needed. You can loop through the ResultSet to extract values from each row and perform any required business logic or data manipulation. 
   7. Close Resources: After processing the data, make sure to close the ResultSet, Statement, and the database connection to release resources and avoid potential resource leaks.  
10. What is the ORM framework?  
    ORM stands for Object-Relational Mapping. It is a programming technique that allows developers to interact with a relational database using an object-oriented programming language.  
11. Done  
12. What is the serialization and desrialization?  
    Serialization is the process of converting objects or data structures into a format that can be stored or transmitted. Deserialization is the reverse process of reconstructing the original object or data structure from its serialized form. These processes are commonly used for network communication, data persistence, caching, and remote procedure calls in distributed systems. Common formats for serialization include JSON, XML, and Protocol Buffers.  
13. Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].  
   ```java
   import java.util.Arrays;
   
   public class Main {
       public static void main(String[] args) {
           int[] array = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
   
           // Using Java Stream API to get the average
           double average = Arrays.stream(array)
                                 .average()
                                 .orElse(0.0); // In case the array is empty
   
           System.out.println("Average: " + average);
       }
   }
   ```  
14. Done  
15. Done