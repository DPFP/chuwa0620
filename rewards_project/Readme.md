# Rewards Program

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
A customer receives 2 points for every dollar spent over 

`$100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction`
`(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).`
Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.

## 开发环境

- Java 17
- Spring Boot 3
- MySQL 8
- Junit 5
- Lombok
- modelmapper



## Project Setup

### Installing Dependencies

The project uses Maven as a build tool. To install all the necessary project dependencies, navigate to the project's root directory in your terminal/command line interface and run the following command:

```
bashCopy code
mvn install
```

This command will download and install all the dependencies required for the project as specified in the project's `pom.xml` file.

### Running the Project

To run the project, you should still be in the project's root directory. Initiate the application using the following Maven command:

```
bashCopy code
mvn spring-boot:run
```

This command will start the Spring Boot application on your local system. The application's port and other configurations are set in the `application.properties` or `application.yml` file in the `src/main/resources` directory.

After running this command, you should see output in the console indicating that the application has started successfully. By default, the application will be available at `http://localhost:8080`, unless you've configured a different port.

### Running the Project using an IDE

Alternatively, you can also run the project using an Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse. Here's how to do it:

1. Import the project into your preferred IDE.
2. Ensure that the IDE has Maven support enabled and it has properly loaded the project's Maven configuration.
3. Find the main class of the project, which is usually annotated with `@SpringBootApplication`, and run this class directly. Your IDE should handle the rest.

Note: The specific instructions might vary depending on the IDE you're using. Please refer to the IDE's official documentation for precise instructions.

## Introduction

Three entities:  `Customer`, `Reward`, and `Transaction`.

1. **Customer Entity**: This entity represents a customer in the application.
   - `id`: A unique identifier for the customer.
   - `name`: The name of the customer.
   - `email`: The email of the customer.
   - `createDateTime`: The timestamp that indicates when the customer entry was created. This is automatically generated when the customer is created.
   - `updateDateTime`: The timestamp that indicates when the customer entry was last updated. This is automatically updated whenever the customer entry is modified.
2. **Reward Entity**: This entity represents the rewards or points earned by a customer.
   - `id`: A unique identifier for the reward.
   - `customer`: The `Customer` entity associated with the reward. This uses a Many-To-One relationship since one customer can have many rewards.
   - `points`: The number of reward points.
   - `createDateTime`: The timestamp that indicates when the reward entry was created. This is automatically generated when the reward is created.
   - `updateDateTime`: The timestamp that indicates when the reward entry was last updated. This is automatically updated whenever the reward entry is modified.
3. **Transaction Entity**: This entity represents a transaction made by a customer.
   - `id`: A unique identifier for the transaction.
   - `customer`: The `Customer` entity associated with the transaction. This also uses a Many-To-One relationship since one customer can make many transactions.
   - `amount`: The amount involved in the transaction.
   - `createDateTime`: The timestamp that indicates when the transaction entry was created. This is automatically generated when the transaction is created.
   - `updateDateTime`: The timestamp that indicates when the transaction entry was last updated. This is automatically updated whenever the transaction entry is modified.

These entities interact with each other to provide a complete picture of a customer's interactions with the system. By linking rewards and transactions with a particular customer, the application is able to track and update a customer's reward points based on their transaction history.



This project mainly consists of three services: `CustomerService`, `TransactionService`, and `RewardService`. These services interact with each other to create a reward system based on the customer's transactions. Here's a detailed breakdown of each service and the methods they offer:

1. **CustomerService**: Manages customer data and interactions.
   - `createCustomer(CustomerDto customerDto)`: Creates a new customer entry with the provided details.
   - `getCustomerById(Long id)`: Retrieves a single customer's details using their unique ID.
   - `getAllCustomers()`: Retrieves all customer data.
   - `updateCustomer(Long id, CustomerDto customerDto)`: Updates a specific customer's details using their ID and the new information.
   - `deleteCustomer(Long id)`: Removes a specific customer entry using their ID.
2. **RewardService**: Handles computation and management of reward points.
   - `calculateRewardPointsForTransaction(double amount)`: Calculates the reward points for a given transaction amount.
   - `getRewardByCustomerIdAndTimeRange(Long customerId, LocalDateTime startDateTime, LocalDateTime endDateTime)`: Retrieves a customer's reward points within a specific time frame.
   - `getRewardsForPastThreeMonths(Long customerId)`: Retrieves a customer's reward points for the past three months.
   - `getAllRewardsByCustomerId(Long customerId)`: Retrieves all reward points for a specific customer.
3. **TransactionService**: Manages customer transactions and associated operations.
   - `createTransaction(Long customerId, TransactionDto transactionDto)`: Creates a new transaction for a specific customer.
   - `updateTransaction(Long id, TransactionDto transactionDto)`: Updates a specific transaction's details using its ID and the new information.
   - `deleteTransaction(Long id)`: Removes a specific transaction entry using its ID.
   - `getTransactionById(Long id, Long customerId)`: Retrieves a single transaction's details using its unique ID and the customer's ID.
   - `getAllTransactionsByCustomerId(Long customerId)`: Retrieves all transactions for a specific customer.
   - `getCustomerTransactionsInLastThreeMonths(Long customerId)`: Retrieves all transactions for a specific customer in the past three months.
   - `getAllTransactionsByCustomerIdAndTimeRange(Long customerId, LocalDateTime startTime, LocalDateTime endTime)`: Retrieves all transactions for a specific customer within a given time range.

## API

### Customer API

#### Create Customer

##### URL

```http
POST http://your-domain.com/api/v1/customers
```

##### Description

Creates a new customer.

##### Example

<img src="https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230727175220321.png" alt="image-20230727175220321" style="zoom:67%;" />

#### Get Customer By ID

##### URL

```http
GET http://your-domain.com/api/v1/customers/{id}
```

##### Description

Retrieves a specific customer by ID.

##### Parameters

| Name | Type        | Description             |
| ---- | ----------- | ----------------------- |
| `id` | Long (Path) | The ID of the customer. |

##### Example

<img src="https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230727175304959.png" alt="image-20230727175304959" style="zoom:67%;" />

#### Get All Customers

##### URL

```http
GET http://your-domain.com/api/v1/customers
```

##### Description

Retrieves all customers.

##### Example

<img src="https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230727175350944.png" alt="image-20230727175350944" style="zoom:67%;" />

#### Update Customer

##### URL

```http
PUT http://your-domain.com/api/v1/customers/{id}
```

##### Description

Updates an existing customer.

##### Parameters

| Name | Type        | Description             |
| ---- | ----------- | ----------------------- |
| `id` | Long (Path) | The ID of the customer. |

##### Example

<img src="https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230727180603182.png" alt="image-20230727180603182" style="zoom:67%;" />

##### URL

```http
DELETE http://your-domain.com/api/v1/customers/{id}
```

##### Description

Deletes a customer.

##### Parameters

| Name | Type        | Description             |
| ---- | ----------- | ----------------------- |
| `id` | Long (Path) | The ID of the customer. |

##### Example

<img src="https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230727180702869.png" alt="image-20230727180702869" style="zoom:67%;" />

### Transaction API

The Rewards Program Transaction API allows users to manage transactions for customers.

#### Create a Transaction

```http
POST /api/v1/transactions/{customerId}
```

##### Description

Creates a new transaction for a specific customer.

##### Parameters

| Name             | Type                | Description                                                  |
| ---------------- | ------------------- | ------------------------------------------------------------ |
| `customerId`     | Long (Path)         | The ID of the customer for whom the transaction is being created. |
| `transactionDto` | JSON (Request Body) | The transaction details to be created.                       |

##### Example

<img src="https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230727161916603.png" alt="image-20230727161916603" style="zoom:67%;" />





#### Update a Transaction

##### URL

```http
PUT http://your-domain.com/api/v1/transactions/{id}
```

##### Description

Updates an existing transaction for a specific customer.

##### Parameters

| Name             | Type                | Description                              |
| ---------------- | ------------------- | ---------------------------------------- |
| `id`             | Long (Path)         | The ID of the transaction to be updated. |
| `transactionDto` | JSON (Request Body) | The updated transaction details.         |

##### Example

![image-20230727163934567](https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230727163934567.png)

#### Delete a Transaction

##### URL

```http
DELETE http://your-domain.com/api/v1/transactions/{id}/{customerId}
```

##### Description

Deletes an existing transaction for a specific customer.

##### Parameters

| Name | Type        | Description                              |
| ---- | ----------- | ---------------------------------------- |
| `id` | Long (Path) | The ID of the transaction to be deleted. |



##### Example

![image-20230727171841490](https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230727171841490.png)

#### Get Transaction by ID

##### URL

```http
GET http://your-domain.com/api/v1/transactions/{id}/{customerId}
```

##### Description

Retrieves a specific transaction by its ID and the customer ID who owns the transaction.

##### Parameters

| Name         | Type        | Description                                      |
| ------------ | ----------- | ------------------------------------------------ |
| `id`         | Long (Path) | The ID of the transaction to be retrieved.       |
| `customerId` | Long (Path) | The ID of the customer who owns the transaction. |

##### Example

![image-20230727172047622](https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230727172047622.png)

#### Get All Transactions by Customer ID

##### URL

```http
GET http://your-domain.com/api/v1/transactions/{customerId}
```

##### Description

Retrieves all transactions associated with a specific customer.

##### Parameters

| Name         | Type        | Description                                               |
| ------------ | ----------- | --------------------------------------------------------- |
| `customerId` | Long (Path) | The ID of the customer for whom to retrieve transactions. |

##### Example

![image-20230727172203554](https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230727172203554.png)



#### Get Customer Transactions in Last Three Months

##### URL

```http
GET http://your-domain.com/api/v1/transactions/{customerId}/lastThreeMonths
```

##### Description

Retrieves all transactions associated with a specific customer within the last three months.

##### Parameters

| Name         | Type        | Description                                               |
| ------------ | ----------- | --------------------------------------------------------- |
| `customerId` | Long (Path) | The ID of the customer for whom to retrieve transactions. |

##### Example

<img src="https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230727173013402.png" alt="image-20230727173013402" style="zoom:67%;" />

#### Get All Transactions by Customer ID and Time Range

##### URL

```http
GET http://your-domain.com/api/v1/transactions/{customerId}/timeRange
```

##### Description

Retrieves all transactions associated with a specific customer within a specific time range.

##### Parameters

| Name         | Type                  | Description                                                  |
| ------------ | --------------------- | ------------------------------------------------------------ |
| `customerId` | Long (Path)           | The ID of the customer for whom to retrieve transactions.    |
| `startTime`  | LocalDateTime (Query) | The start time of the time range to filter transactions. Format: `yyyy-MM-ddTHH:mm:ss`. |
| `endTime`    | LocalDateTime (Query) | The end time of the time range to filter transactions. Format: `yyyy-MM-ddTHH:mm:ss` |

##### Example

<img src="https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230727172937720.png" alt="image-20230727172937720" style="zoom:67%;" />

### Reward API

#### Get All Rewards By Customer ID

##### URL

```http
GET http://your-domain.com/api/v1/customers/{customerId}/rewards
```

##### Description

Retrieves all rewards associated with a specific customer.

##### Parameters

| Name         | Type        | Description                                     |
| ------------ | ----------- | ----------------------------------------------- |
| `customerId` | Long (Path) | The ID of the customer to retrieve rewards for. |

##### Example

<img src="https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230727173613633.png" alt="image-20230727173613633" style="zoom:67%;" />

#### Get Rewards For Past Three Months

##### URL

```http
GET http://your-domain.com/api/v1/customers/{customerId}/rewards/pastThreeMonths
```

##### Description

Retrieves the rewards earned by a specific customer within the past three months.

##### Parameters

| Name         | Type        | Description                                     |
| ------------ | ----------- | ----------------------------------------------- |
| `customerId` | Long (Path) | The ID of the customer to retrieve rewards for. |

##### Example

<img src="https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230727173524772.png" alt="image-20230727173524772" style="zoom:67%;" />

## 其他

不想写了，没耐心了，如果这是一个真实的任务，会努力去写，但我现在不想做太多的文字功夫，感觉有太多可做的了，写一点点也没意思。

比如怎么设计的，有哪些log，有什么test，有什么exception。目前实际代码里log，test，exception也只是简单设计。还有负载均衡，断路器之类也没加。还有密码存储问题等。

