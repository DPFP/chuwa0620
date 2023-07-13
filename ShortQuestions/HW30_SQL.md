# HW30
## MySQL
**1. Create oms_company_address  table**
```
CREATE DATABASE testDB;
USE testDB;
CREATE TABLE oms_company_address (
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
```
**2. Insert some random data to  oms_company_address  table**
```
insert into oms_company_address (
	id, 
    address_name,
    send_status,
    receive_status,
    name,
    phone,
    province,
    city,
    region,
    detail_address)
values
(1, 'name1', 1, 1, 'abc', '1122334455', 'NY', 'NYC', 'Manhattan', '173 9th St'),
(2, 'name2', 0, 0, 'def', '5566778899', 'NJ', 'JC', 'Newport', '123 River DR'),
(3, 'name3', 1, 0, 'ghi', '7788990011', 'CA', 'LA', 'XXX', '456 North XX');
```

**3. Write a SQL query to fetch all data from  oms_company_address  `table**
```
SELECT * FROM testdb.oms_company_address;
```

**4. Write a SQL query to fetch top 3 records from  oms_company_address  table**
```
SELECT * FROM testdb.oms_company_address LIMIT 3;
```

**5. Update  oms_company_address  table to set all  phone to 666-6666-8888**
```
UPDATE oms_company_address SET phone = '666-6666-8888';
```

**6.  Delete one entry from  oms_company_address  table**
```
DELETE FROM testdb.oms_company_address WHERE id = 3;
```

## MongoDB
All commands were executed in Mongo Shell.
**1.  Create test DB**
```
use testDB
```
**2.  Create oms_company_address  collection  (method: createCollection() )**
```
db.createCollection("oms_company_address");
```

**3.  Insert few random entries to  oms_company_address  collection (method: insert() )**
```
db.oms_company_address.insertMany([
  {
    id: 1,
    address_name: "name1",
    send_status: 1,
    receive_status: 1,
    name: "abc",
    phone: "1122334455",
    province: "NY",
    city: "NYC",
    region: "Manhattan",
    detail_address: "173 9th St"
  },
  {
    id: 2,
    address_name: "name2",
    send_status: 0,
    receive_status: 0,
    name: "def",
    phone: "5566778899",
    province: "NJ",
    city: "JC",
    region: "Newport",
    detail_address: "123 River DR"
  }
]);
```

**4.  Read one entry from  oms_company_address  collection (method: find() )**
```
db.oms_company_address.find().limit(1);
```

**5.  Read all entries from  oms_company_address  collection (method: find() )**
```
db.oms_company_address.find();
```

**6.  Update one entry from  oms_company_address collection (method: update() or save() )**
```
db.oms_company_address.updateOne({'id':1},{$set:{'phone':"00000000"}});
```

**7.  Remove one entry from  oms_company_address collection (method: remove() )**
```
db.oms_company_address.deleteOne({'id':2});
```
