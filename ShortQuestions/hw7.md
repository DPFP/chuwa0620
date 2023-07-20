### 2 explain how the below annotaitons specify the table in database?
Define the two colunms in the table.  
column1: name, type: varchar(255), default value: 'John Snow'
column2: student_name, length: 50, cannot be empty, not unique

### 3 What is the default column names of the table in database for @Column?
first_name and operating_system

### 4 What are the layers in springboot application? what is the role of each layer?
1. Presentation Layer
The presentation layer is the top layer of the spring boot architecture. It consists of Views. i.e., the front-end part of the application. It handles the HTTP requests and performs authentication. It is responsible for converting the JSON field’s parameter to Java Objects and vice-versa. Once it performs the authentication of the request it passes it to the next layer. i.e., the business layer.

2. Business Layer
The business layer contains all the business logic. It consists of services classes. It is responsible for validation and authorization.

3. Persistence Layer
The persistence layer contains all the database storage logic. It is responsible for converting business objects to the database row and vice-versa.

4. Database Layer
The database layer contains all the databases such as MySql, MongoDB, etc. This layer can contain multiple databases. It is responsible for performing the CRUD operations.

### 5 Describe the flow in all of the layers if an API is called by Postman.
Postman API call -> Controller (API layer) -> Service (business layer) -> DAO (persistence layer) -> DB (database)

### 6 What is the application.properties? do you know application.yml?
Application properties are configurable application parameters to change an application's behavior. In the typical case, only system administrators and/or application administrators can read and write application properties.  

YAML is a superset of JSON, and as such is a very convenient format for specifying hierarchical configuration data. YAML is more readable and it is good for the developers to read/write configuration files.
