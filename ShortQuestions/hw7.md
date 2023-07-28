## 2. explain how the below annotaitons specify the table in database?

```java
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;


@Column(name = "STUDENT_NAME", length = 50, nullable = false, unique = false)
private String studentName;
```

@Column annotations specify how the fields in the Java class are mapped to the corresponding columns in the database
table. These annotations allow us to define various attributes related to the database column, such as column name, data
type, length, default value, and constraints.

* The first column's name is "NAME", type is varchar(255), default value is 'John Snow'.
* The second column's name is "STUDENT_NAME", length is 50, cannot be null, not required to be unique.

## 3. What is the default column names of the table in database for @Column ?

```java
@Column
private String firstName;
@Column
private String operatingSystem;
```

firstName operatingSystem

## 4. What are the layers in springboot application? what is the role of each layer?

### Controller:

* Role: The presentation layer is responsible for handling user interactions and HTTP requests. It acts as the entry
  point of the application and processes incoming requests.
* Function: Controllers receive requests from clients, invoke appropriate service methods, and return the response,
  often in the form of JSON or HTML.

### Service Layer:

* Role: The service layer contains business logic and acts as an intermediary between the presentation and data access
  layers.
* Function: Services handle complex operations, process data, enforce business rules, and perform any necessary
  validation.

### Data Access Layer (Repository/DAO):

* Role: The data access layer is responsible for interacting with the database or external data sources.
* Function: Repositories or Data Access Objects (DAOs) provide methods to perform CRUD (Create, Read, Update, Delete)
  operations on the database.

### Domain/Entity Layer:

* Role: The domain or entity layer represents the core business entities of the application.
* Function: These classes model the entities that are stored in the database and define their properties and
  relationships.

## 5. Describe the flow in all of the layers if an API is called by Postman.

1. Postman sends an HTTP request to the API's endpoint.
2. The request is handled by a specific controller method in the Presentation Layer.
3. The controller delegates the request to the Service Layer for business logic processing.
4. The Service Layer interacts with the Data Access Layer (Repositories) to fetch or update data.
5. Data is returned as Domain Objects (Entities) from the Data Access Layer to the Service Layer.
6. The Service Layer performs additional business logic and transformations.
7. The completed response is sent back to the Presentation Layer (Controller).
8. The Presentation Layer constructs the HTTP response and sends it back to Postman.
9. Postman displays the response data and status code to the user.

## 6. What is the application.properties? do you know application.yml?

* application.properties is a file that allows you to configure properties for your Spring Boot application in a
  key-value format. It uses the .properties file extension and is typically placed in the src/main/resources directory
  of your Spring Boot project.

* application.yml is an alternative configuration file format in YAML (YAML Ain't Markup Language) for Spring Boot
  applications. It uses the .yml file extension and also resides in the src/main/resources directory.