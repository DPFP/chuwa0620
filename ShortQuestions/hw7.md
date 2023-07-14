# HW7
### Name: Yuanzhen Lin

2. explain how the below annotations specify the table in database?\
The @Column annotation is used in conjunction with @Entity annotation to specify that a specific class member variable will be mapped to a specific column in the database table.\
- @Column(columnDefinition = "varchar(255) default 'John Snow')\
This annotation is mapping the member variable name to a column in the database table. The columnDefinition attribute allows you to define the SQL to be used to create the column. In this case, it creates a column of type varchar(255) and sets the default value to 'John Snow'. If a value for name is not provided, 'John Snow' will be used.\
- @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)\
This annotation is mapping the member variable studentName to a column in the database table with the name STUDENT_NAME. The length attribute specifies that the column has a maximum length of 50 characters. The nullable=false attribute indicates that this column cannot contain null values, meaning a value must be provided for studentName when creating or updating records. The unique=false attribute indicates that the column does not enforce unique values, meaning multiple records can have the same value for studentName.

3. What is the default column names of the table in database fo r@Column?
If you annotate a field with @Column but do not provide a name attribute, the column name in the database table will default to the name of the field in the Java class.\
- @Column private String firstName;\
This will map to a column named firstName in the database table.
- @Column private String operatingSystem;\
This will map to a column named operatingSystem in the database table.\
Please note that the exact name of the column can be influenced by your JPA provider and its settings. For example, Hibernate has a setting called hibernate.ejb.naming_strategy that can change the default naming strategy. Also, some database types are case-sensitive with column names, so it's always a good idea to check the specific rules of your JPA provider and database.


4. What are the layers in springboot application? what is the role of each layer?
   A typical Spring Boot application is divided into three main layers:

- Presentation Layer: \
This is also known as the web layer, where all the controller classes reside. This layer interacts with the user. The @Controller and @RestController annotations are used to define controller classes that handle incoming HTTP requests and send responses.

- Service Layer: \
This layer contains the business logic of the application. It acts as a bridge between the Presentation Layer and the Data Access Layer. The @Service annotation is used to annotate classes at the service layer. These classes should contain methods that perform operations like calculations, validations, transformations, and invoke methods from the data access layer.

- Data Access Layer: \
Also known as the Repository or DAO (Data Access Object) Layer, it interacts with the database and performs all the CRUD operations. The @Repository annotation is used to annotate classes at the data access layer. In Spring Boot, we can use Spring Data JPA's CrudRepository or JpaRepository to easily perform CRUD operations without needing to write a lot of boilerplate code.

5. Describe the flow in all of the layers if an API is called by Postman.
- Client Request: \
The client sends a HTTP GET request to the Spring Boot application, specifying the appropriate URL, like http://localhost:8080/users/1
- Dispatcher Servlet: \
The request first hits the Dispatcher Servlet, which is the front controller in Spring MVC that routes the request to the appropriate handler method.
- Controller Layer: \
The handler method in the Controller (Presentation Layer) that matches the request path and HTTP method is invoked. The @PathVariable annotation is used to extract the user ID from the URL.
- Service Layer: \
The controller method then calls the corresponding service method, passing the user ID as an argument. The service method encapsulates the business logic of the application. In this case, it's a simple fetch operation, but it could be more complex in a real-world application.
- Repository Layer: \
The service method interacts with the repository (Data Access Layer) to retrieve the user data from the database. Spring Data JPA provides the findById method (and many others) out of the box.
- Return Response: \
The retrieved User object is returned back through the layers: first to the Service Layer, then to the Controller Layer, and finally back to the Dispatcher Servlet. The User object is automatically converted to JSON (or another appropriate format) using an HTTP message converter.


7. What is the application.properties? do you know application.yml?\
In Spring Boot, application.properties and application.yml are both configuration files where you can define custom properties and modify default settings provided by the Spring framework. These files should be placed in the src/main/resources directory.
- application.properties: \
This file uses the traditional .properties format, which is simple and easy to read, but can become a bit verbose when dealing with hierarchical configuration data. Here's an example:
```aidl
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root
```

- application.yml: \
This file uses the YAML (YAML Ain't Markup Language) format, which is more human-readable and compact, especially for hierarchical data. Here's the equivalent configuration in YAML:
```aidl
server:
  port: 8081

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: root
```

8. Create a Project, name it with mongo-blog, write a POST API for mongo-blog,change database to MongoDB;

