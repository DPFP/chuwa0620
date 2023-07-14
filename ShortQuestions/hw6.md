# HW 6
MySQL:
1. Create  oms_company_address  table
2.  Insert some random data to  oms_company_address  table
3.  Write a SQL query to fetch all data from  oms_company_address  `table
4.  Write a SQL query to fetch top 3 records from  oms_company_address  table
5.  Update  oms_company_address  table to set all  phone to 666-6666-8888
6.  Delete one entry from  oms_company_address  table

```
1:
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
```
 