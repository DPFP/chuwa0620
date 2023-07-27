# Rewards Program
This is a Spring Boot backend application for a rewards program. The application allows users to earn reward points based on their purchases over a three-month period. The rewards are calculated based on the purchase amount according to specific rules provided.

## Build Dependencies
- Java 17
- Spring boot 3.1.2
- Maven

## Getting Started
Go to the project directory, and build the project using Maven:
```
./mvnw clean install
```
Run the application:
```
./mvnw spring-boot:run
```
Then, the project can be accessible at http://localhost:8080.

## API 
### User
1. create users
URL: http://localhost:8080/api/v1/users  
Method: POST  
Description: create users, including their id and name

2. get all users
URL: http://localhost:8080/api/v1/users  
Method: GET  
Description: retrieve all the users' information

3. get user by id
URL: http://localhost:8080/api/v1/users/{userId}  
Method: GET  
Description: retrieve specific user by the id

4. delete user by id
URL: http://localhost:8080/api/v1/users/{userId}  
Method: DELETE  
Description: delete specific user by the id


### Transaction
1. create transactions
URL: http://localhost:8080/api/v1/users/{userId}/transactions  
Method: POST  
Description: create transactions for specific user, including id, title, amount and date

2. get all users
URL: http://localhost:8080/api/v1/users/{userId}/transactions  
Method: GET  
Description: retrieve all the transactions' information for a specific user

3. get transaction by id
URL: http://localhost:8080/api/v1/users/{userId}/transactions/{transactionsId}  
Method: GET  
Description: retrieve specific transaction for a specific user by the id

4. delete transaction by id
URL: http://localhost:8080/api/v1/users/{userId}/transactions/{transactionsId}  
Method: DELETE  
Description: delete specific transaction for a specific user by the id

### Rewards
1. get all transactions rewards
URL: http://localhost:8080/api/v1/rewards  
Method: GET  
Description: retrieve all transactions rewards for all users

2. get transactions rewards by user id
URL: http://localhost:8080/api/v1/rewards/{userId}  
Method: GET  
Description: retrieve all transactions rewards for a specific user

3. get transactions rewards by user id for latest 3 months
URL: http://localhost:8080/api/v1/rewards/{userId}  
Method: GET  
Description: retrieve latest 3-month transactions rewards for a specific user

4. get transactions rewards by user id whithin time range
URL: http://localhost:8080/api/v1/rewards/{userId}/{startMonth}/{endMonth}  
Method: GET  
Description: retrieve the transactions rewards from a specific time range for a specific user


## Database
This project uses an H2 in-memory database. The database is automatically created and initialized when the application starts.

## Error Handling
The application includes global exception handling to handle various types of exceptions and return appropriate error responses.

