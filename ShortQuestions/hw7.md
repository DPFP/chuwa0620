# Chuwa 0620 Assignment 7

### Zhizhou Xu

1. **explain how the below annotaitons specify the table in database?**

- `@Column(columnDefinition = "varchar(255) default 'John Snow'")`:  
   This annotation is used to define the column properties for the `name` field.  
   `columnDefinition` attribute specifies the SQL definition of the column.  
   In this case, it defines the column as `varchar(255)` data type with a default value of 'John Snow'.

- `@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)`:  
  This annotation is used to define the column properties for the `studentName` field.  
  `name` attribute specifies the name of the column in the database, which is "STUDENT_NAME".  
  `length` attribute specifies the maximum length of the column value, which is 50 characters.  
  `nullable` attribute specifies whether the column can contain null values. In this case, it is set to `false`, indicating that null values are not allowed.  
  `unique` attribute specifies whether the column values must be unique. In this case, it is set to `false`, allowing duplicate values.

2. **What is the default column names of the table in database for `@Column`?**  
   `first_name`  
   `operating_system`

3. **What are the layers in springboot application? what is the role of each layer?**

- Presentation Layer (Controller/REST Controller):  
   Role: Handles incoming requests, validates input, and returns responses to the client.
- Service Layer:
  Role: Implements business logic and coordinates operations between different components.
- Data Access Layer (Repository/DAO):  
   Role: Handles data persistence and retrieval from the database or external sources.
- Domain/Model Layer:
  Role: Represents the application's data entities and contains business logic related to them.
- Integration Layer:
  Role: Handles integration with external systems or services.
- Configuration Layer:
  Role: Manages application configuration and setup.

4. **Describe the flow in all of the layers if an API is called by Postman.**

   1. Presentation Layer (Controller/REST Controller):

   - Receives the HTTP request from Postman.
   - Extracts path variables, query parameters, and request body data.
   - Invokes the corresponding method in the Service Layer.

   2. Service Layer:

   - Receives the request from the Controller.
   - Performs business logic, data manipulation, and orchestration.
   - May interact with the Data Access Layer to fetch or persist data.

   3. Data Access Layer (Repository/DAO):

   - Handles database operations if required by the Service Layer.
   - Performs queries or ORM operations to interact with the database.
   - Returns data to the Service Layer.

   4. Domain/Model Layer:

   - Represents the application's data entities.
   - May be accessed by the Service Layer for entity-related operations.

   5. Integration Layer:

   - Handles interactions with external systems or services if needed.
   - Makes API calls, performs data transformation, or manages integrations.

   6. Presentation Layer (Controller/REST Controller):

   - Receives the response from the Service Layer.
   - Prepares the HTTP response, including headers, status codes, and the response body.
   - Sends the response back to Postman.

5. **What is the application.properties? do you know application.yml?**  
   Both files serve the purpose of configuring Spring Boot applications, and you can choose either format based on your preference or specific requirements. Spring Boot automatically loads the configuration from these files during application startup.
