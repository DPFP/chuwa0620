### Environment:
Java 17  
Spring Boot 2.7.14  
Database: H2  

## How to run
Open 'demo' with IDEA, reload the Maven and run.  
Test using Postman, the API would be listed then.  

In the 'src/main/java/com/chuwa/learn/demo/utils', the class 'DataInitializer' would automatically populate some sample data into the database. The populate sql file is in the 'resource/data.sql'.

Also I provide the CRUD interface of Customer and Order for insert data into the database based on Customer one to many Order relationship. The API would also be listed then.

## API 

### Points Calculate

#### get total points of the customer with id {id}
GET http://127.0.0.1:8080/api/points/total/{id}

#### get total points of the customer with id {id} during the past three month
GET http://127.0.0.1:8080/api/points/threemonth/{id}

#### get every month points of the customer with id {id}
GET http://127.0.0.1:8080/api/points/everymonth/{id}


### CRUD 

#### get all customers
GET http://127.0.0.1:8080/api/customers

#### get customer by id
GET http://127.0.0.1:8080/api/customers/{id}

#### create customer
POST http://127.0.0.1:8080/api/customers

request body:
```JSON
{
    "firstName": "YOURFIRSTNAME",
    "lastName":"YOURLASTNAME"
}
```

#### update customer
PUT http://127.0.0.1:8080/api/customers/{id}

request body:
```JSON
{
    "firstName": "YOURFIRSTNAME",
    "lastName":"YOURLASTNAME"
}
```


#### delete customer by id
DELETE http://127.0.0.1:8080/api/customers/{id}

#### get all orders
GET http://127.0.0.1:8080/api/orders

#### get order by id
GET http://127.0.0.1:8080/api/orders/{id}

#### create order
POST http://127.0.0.1:8080/api/orders  

request body:
```JSON
{
    "orderNumber": "ORDER025",
    "orderCost": 102.5,
    "customerId": 1
}
```
##### tips:
orderNumber should be unique, custoemrId should be an existing customer id. Else, it would send back error message

#### update order
PUT http://127.0.0.1:8080/api/orders/{id}
```JSON
{
    "orderNumber": "ORDER001",
    "orderCost": 999,
    "customerId": 1
}
```

#### delete order by id
DELETE http://127.0.0.1:8080/api/customers
