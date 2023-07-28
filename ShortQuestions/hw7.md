# HW 7
## Q1. Create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controlle
```
See details in the file.
```

## Q2. Explain how the below annotaitons specify the table in database?
```
The @Column annotation is used to specify that a class be mapped to a column in the database
In the first case the column is defined as varchar(255) default 'John Snow', which means a column type is varchar(255) 
and have default value of "John Snow"
In the second case, (name="STUDENT_NAME", length=50, nullable=false, unique=false), which means that a column name is 
"STUDENT_NAME"; the length of the column is 50, the values cannot be null; and values could be duplicates
```

## Q3 What is the default column names of the table in database for  @Column
```
"first_name"
"operating_system"
```

## Q4.  What are the layers in springboot application? what is the role of each layer?
```
Presentation Layer – Authentication & Json Translation. 
Business Layer – Business Logic, Validation & Authorization. 
Persistence Layer – Storage Logic
```

## Q5.  Describe the flow in all of the layers if an API is called by Postman
```
Client: send request

Controller: receives request and calls services

Services: do the bussiness logic

DAO/repository: fetch or change data through this layer

Return to service layer to perform tasks

Back to Controller and then to client
```

## Q6. What is the application.properties? do you know application.yml?
```
Both are configuration files for Spring boot
```

## Q7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database toMongoDB
```
In coding files
```