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

