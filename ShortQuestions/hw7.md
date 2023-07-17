# 2.  explain how the below annotaitons specify the table in database?
```
@Column(columnDefinition = "varchar(255) default 'John Snow'")
private String name;
  
@Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
private String studentName;
```
The two annotations defines a table with two columns. The first column is "NAME", and its type is varchar(255), and it's default value is 'John Snow'.

The second column is "STUDENT_NAME". It's length is 50. Its value can be null and must be unique.

# 3. What is the default column names of the table in database for  @Column 
first_name and operating_system

# 4. What are the layers in springboot application? what is the role of each layer?
- Presentation Layer
    * This layer is responsible for handling user interaction and presenting data to the user.
    * It typically consists of controllers, views, and view models.
- Business Layer
    * This layer contains the business logic of the application.
    * It typically consists of services, repositories, and domain objects.
- Persistence Layer
    * This layer is responsible for storing and retrieving data from the database.
    * It typically consists of repositories, DAOs, and data access objects.
- Database Layer
    * This layer is the actual database where the data is stored.

# 5. Describe the flow in all of the layers if an API is called by Postman
Presentation layer first receives the call of api. The business layer then executes the business logic for the request. The persistence layer interacts with the database to store or retrieve data. The database layer stores or retrieve the data. Business layer receives the data and foward it to the presentation layer to apply changes or data return.

# 6. What is the application.properties? do you know application.yml?
application.properties is a plain text file that uses the Java Properties format. Each property in the file is defined on a separate line, and the key and value are separated by an equal sign (=). 

application.yml is a YAML file that uses the YAML format. YAML is a human-readable data serialization language that is often used for configuration files. Each property in the YAML file is defined on a separate line, and the key and value are separated by a colon (:).