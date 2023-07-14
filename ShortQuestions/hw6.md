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

 