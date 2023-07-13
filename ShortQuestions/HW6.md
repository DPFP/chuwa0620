### Postman

**GET APIs**

1. 获取所有书籍（返回JSON数组）：
   - Request: `GET /api/books`
   - Response: `200 OK`
   - Body: `[{ "id": 1, "title": "Book 1", "authorId": 1 }, { "id": 2, "title": "Book 2", "authorId": 2 }]`
   - Error Response: `500 Internal Server Error`, `401 Unauthorized`, `404 Not Found`
2. 获取指定书籍的信息（返回JSON对象）：
   - Request: `GET /api/books/{bookId}`
   - Response: `200 OK`
   - Body: `{ "id": 1, "title": "Book 1", "authorId": 1 }`
   - Error Response: `500 Internal Server Error`, `401 Unauthorized`, `404 Not Found (Book not found)`
3. 获取所有作者（返回JSON数组）：
   - Request: `GET /api/authors`
   - Response: `200 OK`
   - Body: `[{ "id": 1, "name": "Author 1" }, { "id": 2, "name": "Author 2" }]`
   - Error Response: `500 Internal Server Error`, `401 Unauthorized`, `404 Not Found`
4. 获取指定作者的信息（返回JSON对象）：
   - Request: `GET /api/authors/{authorId}`
   - Response: `200 OK`
   - Body: `{ "id": 1, "name": "Author 1" }`
   - Error Response: `500 Internal Server Error`, `401 Unauthorized`, `404 Not Found (Author not found)`
5. 获取所有订单（返回JSON数组）：
   - Request: `GET /api/orders`
   - Response: `200 OK`
   - Body: `[{ "id": 1, "bookId": 1, "customerId": 1 }, { "id": 2, "bookId": 2, "customerId": 1 }]`
   - Error Response: `500 Internal Server Error`, `401 Unauthorized`, `404 Not Found`

**POST APIs**

1. 创建新书籍：
   - Request: `POST /api/books`
   - Body: `{ "title": "New Book", "authorId": 1 }`
   - Response: `201 Created`
   - Response Body: `{ "id": 3, "title": "New Book", "authorId": 1 }`
   - Error Response: `500 Internal Server Error`, `401 Unauthorized`, `400 Bad Request`
2. 创建新作者：
   - Request: `POST /api/authors`
   - Body: `{ "name": "New Author" }`
   - Response: `201 Created`
   - Response Body: `{ "id": 3, "name": "New Author" }`
   - Error Response: `500 Internal Server Error`, `401 Unauthorized`, `400 Bad Request`
3. 创建新订单：
   - Request: `POST /api/orders`
   - Body: `{ "bookId": 1, "customerId": 1 }`
   - Response: `201 Created`
   - Response Body: `{ "id": 3, "bookId": 1, "customerId": 1 }`
   - Error Response: `500 Internal Server Error`, `401 Unauthorized`, `400 Bad Request`

**PUT APIs**

1. 更新指定书籍的信息：
   - Request: `PUT /api/books/{bookId}`
   - Body: `{ "title": "Updated Book", "authorId": 1 }`
   - Response: `200 OK`
   - Response Body: `{ "id": 1, "title": "Updated Book", "authorId": 1 }`
   - Error Response: `500 Internal Server Error`, `401 Unauthorized`, `400 Bad Request`, `404 Not Found (Book not found)`
2. 更新指定作者的信息：
   - Request: `PUT /api/authors/{authorId}`
   - Body: `{ "name": "Updated Author" }`
   - Response: `200 OK`
   - Response Body: `{ "id": 1, "name": "Updated Author" }`
   - Error Response: `500 Internal Server Error`, `401 Unauthorized`, `400 Bad Request`, `404 Not Found (Author not found)`
3. 更新指定订单的信息：
   - Request: `PUT /api/orders/{orderId}`
   - Body: `{ "bookId": 2, "customerId": 1 }`
   - Response: `200 OK`
   - Response Body: `{ "id": 1, "bookId": 2, "customerId": 1 }`
   - Error Response: `500 Internal Server Error`, `401 Unauthorized`, `400 Bad Request`, `404 Not Found (Order not found)`

**DELETE APIs**

1. 删除指定书籍：
   - Request: `DELETE /api/books/{bookId}`
   - Response: `204 No Content`
   - Error Response: `500 Internal Server Error`, `401 Unauthorized`, `404 Not Found (Book not found)`
2. 删除指定作者：
   - Request: `DELETE /api/authors/{authorId}`
   - Response: `204 No Content`
   - Error Response: `500 Internal Server Error`, `401 Unauthorized`, `404 Not Found (Author not found)`

### API Design

#### Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc. -- 命名规范

**Twitter APIs**

| 动作     | 路径                             | 描述                           |
| -------- | -------------------------------- | ------------------------------ |
| **推文** |                                  |                                |
| GET      | /1.1/statuses/user_timeline.json | 检索特定用户的推文历史         |
| GET      | /1.1/statuses/show.json          | 根据推文ID检索特定推文         |
| POST     | /1.1/statuses/update.json        | 发布新的推文，请求体中包含数据 |
| POST     | /1.1/statuses/destroy/{id}.json  | 删除具有特定ID的推文           |
| **用户** |                                  |                                |
| GET      | /1.1/users/show.json             | 根据用户ID或用户名检索特定用户 |
| GET      | /1.1/followers/list.json         | 检索用户的关注者列表           |
| GET      | /1.1/friends/list.json           | 检索用户的关注列表             |
| POST     | /1.1/account/settings.json       | 更新用户设置，请求体中包含数据 |

**PayPal APIs**

| 动作     | 路径                               | 描述                                              |
| -------- | ---------------------------------- | ------------------------------------------------- |
| **付款** |                                    |                                                   |
| GET      | /v1/payments/payment               | 检索所有支付信息                                  |
| POST     | /v1/payments/payment               | 创建新的支付，请求体中包含数据                    |
| **发票** |                                    |                                                   |
| GET      | /v1/invoicing/invoices             | 检索所有发票信息                                  |
| POST     | /v1/invoicing/invoices             | 创建新的发票，请求体中包含数据                    |
| PUT      | /v1/invoicing/invoices/{invoiceId} | 更新具有特定invoiceId的现有发票，请求体中包含数据 |
| DELETE   | /v1/invoicing/invoices/{invoiceId} | 取消具有特定invoiceId的发票                       |

#### Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

| 动作     | 路径                         | 描述                                               |
| -------- | ---------------------------- | -------------------------------------------------- |
| **用户** |                              |                                                    |
| GET      | /api/users                   | 检索所有用户列表                                   |
| GET      | /api/users/{userId}          | 根据用户ID检索指定用户                             |
| POST     | /api/users                   | 创建新用户，请求体中包含数据                       |
| PUT      | /api/users/{userId}          | 更新具有特定userId的现有用户，请求体中包含数据     |
| DELETE   | /api/users/{userId}          | 删除具有特定userId的用户                           |
| **帖子** |                              |                                                    |
| GET      | /api/posts                   | 检索所有帖子列表                                   |
| GET      | /api/posts/{postId}          | 根据帖子ID检索指定帖子                             |
| POST     | /api/posts                   | 创建新帖子，请求体中包含数据                       |
| PUT      | /api/posts/{postId}          | 更新具有特定postId的现有帖子，请求体中包含数据     |
| DELETE   | /api/posts/{postId}          | 删除具有特定postId的帖子                           |
| **评论** |                              |                                                    |
| GET      | /api/posts/{postId}/comments | 检索特定帖子的所有评论                             |
| GET      | /api/comments/{commentId}    | 根据评论ID检索指定评论                             |
| POST     | /api/posts/{postId}/comments | 在特定帖子中添加新评论，请求体中包含数据           |
| PUT      | /api/comments/{commentId}    | 更新具有特定commentId的现有评论，请求体中包含数据  |
| DELETE   | /api/comments/{commentId}    | 删除具有特定commentId的评论                        |
| **类别** |                              |                                                    |
| GET      | /api/categories              | 检索所有类别列表                                   |
| GET      | /api/categories/{categoryId} | 根据类别ID检索指定类别                             |
| POST     | /api/categories              | 创建新类别，请求体中包含数据                       |
| PUT      | /api/categories/{categoryId} | 更新具有特定categoryId的现有类别，请求体中包含数据 |
| DELETE   | /api/categories/{categoryId} | 删除具有特定categoryId的类别                       |

#### Design APIs for the following features (思考：path variable 怎么⽤？有sub resources, 哪些地⽅该⽤复数)

#### find the customer's payments, like credit card 1, credit card 2, paypal, Apple Pay.

**GET** `/api/customers/{customerId}/payments`

#### Find the customer's history orders from 10/10/2022 to 10/24/2022

**GET** `/api/customers/{customerId}/orders?startDate=2022-10-10&endDate=2022-10-24`



#### find the customer's delievery addresses

**GET** `/api/customers/{customerId}/addresses`

#### If I also want to get customer's default payment and default delievery address, what kind of the API (URL) should be?

**GET** `/api/customers/{customerId}/payments/default`

**GET** `/api/customers/{customerId}/addresses/default`