### 2 how do you do the debug?
Right click on the triangle icon on main function and start the project in debug mode

### 3 What is DTO, VO, Payload, DO, model?
DTO stands for Data Transfer Object. It is an object that transports data between different processes in an application. A DTO is specifically designed to reduce the number of method calls between client and server by aggregating data.  
VO stands for Value Object, and it is similar to a DTO in that it is a simple object used to transfer data. However, VOs are often used to represent the data that is displayed to the user, rather than the data that is stored in the database or transferred between processes.  
Payloads are typically used to carry on metadata information consumed by a validation client. Use of payloads is not considered portable.  
A domain object is a developer-defined data type, an immutable Java class encapsulating a scalar value or a structure, with simple validation built into its constructor. The validation check occurs when an object of that domain type is created.  
Object Model refers to a visual representation of software or systems' objects, attributes, actions, and relationships.

### 4 What is @JsonProperty("description_yyds") 
The @JsonProperty annotation is used to specify the property name in a JSON object when serializing or deserializing a Java object using the Jackson library. It is often used when the JSON property name is different from the field name in the Java object, or when the JSON property name is not in camelCase.

### 5 do you know what is jackson?
Jackson is a very popular and efficient java based library to serialize or map java objects to JSON and vice versa.

### 6 What is spring-boot-stater? do you know any starters?
Spring Boot Starters are dependency descriptors that can be added under the <dependencies> section in pom. xml. There are around 50+ Spring Boot Starters for different Spring and related technologies. These starters give all the dependencies under a single name.  
There are other starters, like SpringMVC, Spring WEB.

### 7 do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?
RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.
- @RequestMapping(value = "/users", method = RequestMethod.GET)
- @RequestMapping(value = "/users/id", method = RequestMethod.PUT)
- @RequestMapping(value = "/users/id", method = RequestMethod.DELETE)

### 8 What is ResponseEntity? why do we need it?
ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response.

### 9 What is ResultSet in jdbc? and describe the flow how to get data using JDBC
A ResultSet object maintains a cursor that points to the current row in the result set. The term "result set" refers to the row and column data contained in a ResultSet object.  

1. establishing a connection
2. creating a prepared statement or query
3. execute the query
4. looping through the result set to get the objects 5. close the connection

### 10 What is the ORM framework?
Object Relational Mapping (ORM) is a technique used in creating a "bridge" between object-oriented programs and, in most cases, relational databases.

### 12 What is the serialization and desrialization?
Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory. 

### 13 use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```java
int[] arr = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
Double res = Arrays.stream(arr).average().getAsDouble();
```
