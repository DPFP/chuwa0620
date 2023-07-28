### Environment:

Java 17  
Spring Boot 3.1.1  
Database: H2

## How to Run

Use IntelliJ IDEA to open project_1.

Use http://localhost:8080/h2-console/ to check database

* url=jdbc:h2:file:./h2db/testdb
* username=sa
* password=

## Test Api

### Display all transactions of a customer

Get http://localhost:8080/api/v1/transactions/{customerId}

### Display a customer's reward points per month

Get http://localhost:8080/api/v1/transactions/reward-points/every-month/{customerId}

### Display a customer's total amount of reward points

Get http://localhost:8080/api/v1/transactions/reward-points/total-month/{customerId}

### Display a customer's total amount of reward points during previous {months} months

Get Get http://localhost:8080/api/v1/transactions/reward-points/previous-month/{customerId}/{months}