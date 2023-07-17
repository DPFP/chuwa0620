# HW 6
MySQL:
```
1:Create  oms_company_address  table
create table oms_company_address(
	id bigint primary key,
    address_name varchar(200),
    send_status int(1),
    receive_status int(1),
    name varchar(64),
    phone varchar(64),
    province varchar(64),
    city varchar(64),
    region varchar(64),
    detail_address varchar(200) 
);

2.  Insert some random data to  oms_company_address  table
insert into oms_company_address
values
(1, 'loca', 1, 0, 'log', '654987321', 'guangdong', 'huizhou', 'huidong', '111 road, apt 103'),
(2, 'lion', 0, 0, 'pet', '1111111111', 'henan', 'zhenzhou', 'laocheng', '444 lu, apt 701'),
(3, 'loc', 1, 0, 'love', '333333333', 'moxige', 'cankun', 'adios', '999 street, apt 1002'),

3.  Write a SQL query to fetch all data from  oms_company_address  `table
select * from oms_company_address

4.  Write a SQL query to fetch top 3 records from  oms_company_address  table
select * from oms_company_address limit 3;

5.  Update  oms_company_address  table to set all  phone to 666-6666-8888
update oms_company_address set phone='666-6666-8888';

6.  Delete one entry from  oms_company_address  table
delete from oms_company_address where id = 1;
```

MongoDB:
```
1. Create test DB
use test


2. Create  oms_company_address  collection  (method: createCollection())
db.createCollection("oms_company_address")


3. Insert few random entries to oms_company_address collection (method: insert() )
db.oms_company_address.insertMany(
[
 {
    id: 1,
    address_name: "loca",
    send_status: 1,
    receive_status: 1,
    name: "Pullups",
    phone: "88991784",
    province: "love",
    city: "abc",
    region: "pll",
    detail_address: "332 84"
  },
  {
    id: 2,
    address_name: "sd",
    send_status: 0,
    receive_status: 1,
    name: "Joke Dike",
    phone: "800989965",
    province: "Pork",
    city: "city",
    region: "r",
    detail_address: "4756 aa AVE NE"
  }
]
);

4. Read one entry from oms_company_address collection (method: find() )
db.oms_company_address.find().limit(1)

5. Read all entries from  oms_company_address  collection (method: find() )
db.oms_company_address.find()

6. Update one entry from oms_company_address collection (method:update() or save())
db.oms_company_address.updateOne({id: 2},{$set:{name: "hainanjifan"}})


7. Remove one entry from oms_company_address collection (method:remove())
db.oms_company_address.deleteOne({id: 1})
```

API design
```
1. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc. -- 命名规范
- Twitter API
Tweets:
	GET statuses/lookup 
    GET statuses/show/:id	
    POST statuses/update
    POST statuses/destroy/:id	
    GET favorites/list

- YouTube API
  GET {base_URL}/channels?part=contentDetails &mine=true   Retrieve channel information
  GET {base_URL}/subscriptions?part=snippet&mySubscribers=true Retrieve Subscriptions


2. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE\
The blog would have Users, Posts, and Comments.
- Users
     GET /api/users/
     GET /api/users/{id}
     POST /api/users/
     PUT /api/users/{id}
     DELETE /api/users/{id}
- Posts
     GET /api/posts/
     GET /api/posts/{id}
     POST /api/posts/
     PUT /api/posts/{id}
     DELETE /api/posts/{id}
- Comments
     GET /api/comments/
     GET /api/comments/{id}
     POST /api/comments/
     PUT /api/comments/{id}
     DELETE /api/comments{id}

- Combined
    GET /api/users/{id}/posts
    GET /api/posts/{id}/comments


**Design APIs for the following features (思考:path variable 怎么用?有sub resources, 哪些地方该用复数)**
1. find the customer's payments,like credit card 1, credit card 2, paypal,ApplePay.
   GET /api/v1/customers/{customerId}/payments
2. Find the customer's history orders from 10/10/2022 to 10/24/2022
   GET /api/v1/customers/{customerId}/history_orders?startDate=2022-10-10&endDate=2022-10-24
3. find the customer's delievery addresses
   GET /api/v1/customers/{customerId}/delievery_address
4. If I also want to get customer's default payment and default delievery address,what kind of the API(URL)
   should be?
   GET /api/v1/customers/{customerId}/payment/default_payment
   GET /api/v1/cusomters/{customerId}/address/default_address
```
 