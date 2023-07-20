## 1. Create  oms_company_address  table

```sql
CREATE TABLE oms_company_address
(
    id             bigint PRIMARY KEY,
    address_name   varchar(200),
    send_status    int(1),
    receive_status int(1),
    name           varchar(64),
    phone          varchar(64),
    province       varchar(64),
    city           varchar(64),
    region         varchar(64),
    detail_address varchar(200)
);
```

## 2. Insert some random data to  oms_company_address  table

```sql
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region,
                                 detail_address)
VALUES (1, 'Address A B C', 0, 0, 'Amy', '1234567890', 'Sichuan', 'Chengdu', 'Wuhou', '123 W 45th Pl'),
       (2, 'Address D E F', 0, 1, 'Jack', '9876543210', 'Liaoning', 'Dalian', 'Kaifa', '456 E 37th St'),
       (3, 'Address X Y Z', 1, 1, 'IAN', '1237103889', 'Guangdong', 'Shenzhen', 'Longgang', '789 W 23th St');
```

## 3. Write a SQL query to fetch all data from  oms_company_address  `table

```sql
SELECT *
FROM oms_company_address
```

## 4. Write a SQL query to fetch top 3 records from  oms_company_address  table

```sql
SELECT *
FROM OMS_COMPANY_ADDRESS LIMIT 3
```

## 5. Update  oms_company_address  table to set all  phone to 666-6666-8888

```sql
UPDATE oms_company_address
SET phone = '666-6666-8888';
```

## 6. Delete one entry from  oms_company_address  table

```sql
DELETE
FROM oms_company_address
WHERE id = 1
```

## 1. Create test DB

```
use test
```

## 2. Create oms_company_address collection  (method: createCollection() )

```
db.createCollection("oms_company_address")
```

## 3. Insert few random entries to oms_company_address collection (method: insert() )

```
db.oms_company_address.insertMany([
  {
    id: 2,
    address_name: "Address 2",
    send_status: 1,
    receive_status: 1,
    name: "Jane Smith",
    phone: "555-5555-9999",
    province: "New York",
    city: "New York City",
    region: "Midtown",
    detail_address: "456 Broadway"
  },
  {
    id: 3,
    address_name: "Address 3",
    send_status: 0,
    receive_status: 1,
    name: "Bob Johnson",
    phone: "777-7777-2222",
    province: "Texas",
    city: "Houston",
    region: "Downtown",
    detail_address: "789 Oak St"
  },
  {
    id: 4,
    address_name: "Address 4",
    send_status: 1,
    receive_status: 1,
    name: "Alice Lee",
    phone: "111-1111-3333",
    province: "Florida",
    city: "Miami",
    region: "Beachside",
    detail_address: "10 Ocean Ave"
  }
])


```

## 4. Read one entry from oms_company_address collection (method: find() )

```
db.oms_company_address.find().limit(1)

```

## 5. Read all entries from oms_company_address collection (method: find() )

```
db.oms_company_address.find()

```

## 6. Update one entry from oms_company_address collection (method: update() or save() )

```
db.oms_company_address.updateOne(
  { id: 1 },
  { $set: { send_status: 2 } }
)
```

## 7. Remove one entry from oms_company_address collection (method: remove() )

```
db.oms_company_address.deleteOne({ id: 1 })
```

## 1. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc. -- 命名规范

Twitter API Collection:

* Service: Twitter
* Collection Name: twitter-api-collection
* Description: This collection contains various APIs provided by Twitter, allowing developers to interact with Twitter's
  platform, retrieve tweets, post tweets, access user information, and perform other actions related to the Twitter
  service.

PayPal API Collection:

* Service: PayPal
* Collection Name: paypal-api-collection
* Description: This collection includes a set of APIs provided by PayPal, enabling developers to integrate PayPal's
  payment services into their applications, process transactions, handle payment notifications, and manage user accounts
  related to PayPal.

## 2. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE

GET API - Retrieve Blog Posts:

* Endpoint: /api/posts
* Description: This API will retrieve all blog posts available on the website.
* Response: A JSON array containing all the blog posts in the database.

POST API - Create a New Blog Entity:

* Endpoint: /api/posts
* Description: This API will allow users to create a new blog post.
* Request Body: A JSON object containing the details of the new blog post, including the title, content, author, and any
  other relevant information.
* Response: A JSON object representing the newly created blog post with a unique identifier (e.g., post ID) assigned by
  the server.

GET API - Retrieve a Single Blog Entity:

* Endpoint: /api/posts/{postId}
* Description: This API will retrieve a specific blog post by its unique identifier (postId).
* Response: A JSON object containing the details of the requested blog post.

PUT API - Update an Existing Blog Entity:

* Endpoint: /api/posts/{postId}
* Description: This API will allow users to update an existing blog post by its unique identifier (postId).
* Request Body: A JSON object containing the updated details of the blog post, such as the title, content, or any other
  fields that need to be modified.
* Response: A JSON object representing the updated blog post with its new details.

DELETE API - Delete a Blog Entity:

* Endpoint: /api/posts/{postId}
* Description: This API will allow users to delete a specific blog post by its unique identifier (postId).
* Response: A success message indicating that the blog post has been successfully deleted.
* Please note that in the above design, the {postId} is a placeholder for the unique identifier of the blog post.
  Depending on your implementation, this could be an automatically generated ID or any other unique identifier assigned
  to each blog post. Additionally, you may want to consider implementing authentication and authorization mechanisms to
  ensure that only authorized users can create, update, or delete blog posts.

# Design APIs for the following features (思考：path variable 怎么用？有sub resources, 哪些地方该用复数)

## 1. find the customer's payments, like credit card 1, credit card 2, paypal, Apple Pay.

```
GET /api/customers/{customerId}/payments
```

## 2. Find the customer's history orders from 10/10/2022 to 10/24/2022

```
GET /api/customers/{customerId}/orders?startDate=2022-10-10&endDate=2022-10-24
```

## 3. find the customer's delievery  addresses

```
GET /api/customers/{customerId}/addresses
```

## 4. If I also want to get customer's default payment and default delievery address, what kind of the API (URL) should be?

```
/api/customers/{customerId}/addresses?includeDefaults=true
```

```
/api/customers/{customerId}/payments?includeDefaults=true
```