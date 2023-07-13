## MySql
### 1 Create oms_company_address table
```sql
CREATE TABLE oms_company_address
(
    id             bigint,
    address_name   varchar(20),
    send_status    int(1),
    receive_status int(1),
    name           varchar(64),
    phone          varchar(64),
    province       varchar(64),
    city           varchar(64),
    region         varchar(64),
    detail_address varchar(200),
    PRIMARY KEY (id)
);
```

### 2 Insert some random data to oms_company_address table
```sql
 INSERT INTO oms_company_address
 VALUES (0, '1111 Street', 1, 0, 'Mike', '123-123-1234', 'Zhejiang', 'Ningbo', 'Yinzhou', 'xxx'),
     (1, '2222 Street', 1, 1, 'Jack', '123-123-1234', 'Jiangsu', 'Nanjing', 'yyy', 'xxx'),
     (2, '3333 Street', 0, 0, 'Tom', '123-123-1234', 'Shanghai', 'Shanghai', 'yyy', 'xxx');
```

### 3 Write a SQL query to fetch all data from oms_company_address table
```sql
SELECT * FROM oms_company_address;
```

### 4 Write a SQL query to fetch top 3 records from oms_company_address table
```sql
SELECT *
FROM oms_company_address
LIMIT 3;
```

### 5 Update oms_company_address table to set all phone to 666-6666-8888
```sql
UPDATE oms_company_address
SET phone = '666-6666-8888';
```

### 6 Delete one entry from oms_company_address table
```sql
DELETE FROM oms_company_address WHERE id = 0;
```

## MongoDB
### 1 Create test DB
```
use test
```

### 2 Create oms_company_address collection (method: createCollection() )
```
db.createCollection("oms_company_address");
```

### 3 Insert few random entries to oms_company_address collection (method: insert() )
```
 db.products.insertMany( [
 { id: 0, address_name:'1111 Street', send_status:1, receive_status:0, name:'Mike', phone:'123-123-1234', province:'Zhejiang', city:'Ningbo', region:'Yinzhou', detail_address:'xxx' },
 { id: 1, address_name:'3333 Street', send_status:0, receive_status:0, name:'Tom', phone:'123-123-1234', province:'Shanghai', city:'Shanghai', region:'yyy', detail_address:'xxx'},
 { id: 2, address_name:'4444 Street', send_status:1, receive_status:0, name:'Steve', phone:'123-123-1234', province:'Sichuan', city:'Chengdu', region:'yyy', detail_address:'xxx'}
 ] );
```

### 4 Read one entry from oms_company_address collection (method: find() )
```
db.oms_company_address.find().limit(1);
```

### 5 Read all entries from oms_company_address collection (method: find() )
```
db.oms_company_address.find();
```

### 6 Update one entry from oms_company_address collection(method:update() or save())
```
db.oms_company_address.update({id:1},{$set:{phone:'666-666-6666'}});
```

### 7 Remove one entry from oms_company_address collection(method:remove())
```
db.oms_company_address.remove({name:"Mike"});
```


## API design
### 1 Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.
1. Youtube
- PUT https://www.googleapis.com/youtube/v3/channels
- POST https://www.googleapis.com/youtube/v3/comments
- GET https://www.googleapis.com/youtube/v3/comments
- POST https://www.googleapis.com/youtube/v3/comments/markAsSpam
- GET https://www.googleapis.com/youtube/v3/subscriptions
- POST https://www.googleapis.com/youtube/v3/subscriptions

2. Twitter
GET https://api.twitter.com/2/tweets
POST https://api.twitter.com/2/tweets
DELETE https://api.twitter.com/2/tweets/{id}
GET https://api.twitter.com/2/users/{id}
GET https://api.twitter.com/2/users/{id}/tweets

### 2 Design a collection of APIs for a Blog Website,please specify GET POST PUT DELETE
- Get user page summary: GET baseURL/v1/users/{userid}/summary
- Get user settings: GET baseURL/v1/users/{userid}/settings/address
- Update user settings: PUT baseURL/v1/users/{userid}/settings/address
- Delete user payment card: DELETE baseURL/v1/users/{userid}/payments/card/{card_id}

## Design APIs for the following features
### 1 find the customer's payments, like credit card1, credit card2,paypal,ApplePay.
GET baseUrl/v1/users/{userid}/payments/card/{card_id}

### 2 Find the customer's history orders from 10/10/2022to10/24/2022
GET baseUrl/v1/users/{userid}/orders/?start_date=10-10-2022 & end_date=10-24-2022

### 3 find the customer's delivery addresses
GET baseUrl/v1/users/{userid}/addresses/default

### 4 If I also want to get customer's default payment and default delivery address,what kind of the API(URL) should be?
GET baseUrl/v1/users/{userid}/payments/default  
GET baseUrl/v1/users/{userid}/addresses/default
