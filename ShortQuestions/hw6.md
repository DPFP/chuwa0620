# SQL Exercise
## 1. Create  oms_company_address  table
```
CREATE TABLE oms_company_address (
  id bigint PRIMARY KEY,
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

## 2. Insert some random data to  oms_company_address  table
```
INSERT INTO oms_company_address (id, address_name, send_status, receive_status, name, phone, province, city, region, detail_address)
VALUES 
  (1, 'Address 1', 1, 0, 'John Doe', '1234567890', 'California', 'Los Angeles', 'Downtown', '123 Main St'),
  (2, 'Address 2', 0, 1, 'Jane Smith', '9876543210', 'New York', 'New York City', 'Midtown', '456 Elm St'),
  (3, 'Address 3', 1, 1, 'Mike Johnson', '5555555555', 'Texas', 'Houston', 'West Side', '789 Oak Ave');
```

## 3. Write a SQL query to fetch all data from  oms_company_address  `table
```
SELECT * FROM oms_company_address
```

## 4. Write a SQL query to fetch top 3 records from  oms_company_address  table
```
SELECT * FROM OMS_COMPANY_ADDRESS LIMIT 3
```

## 5.  Update  oms_company_address  table to set all  phone to 666-6666-8888
```
UPDATE oms_company_address SET phone = '666-6666-8888';
```

## 6. Delete one entry from  oms_company_address  table
```
DELETE FROM OMS_COMPANY_ADDRESS WHERE ID = (SELECT ID FROM OMS_COMPANY_ADDRESS LIMIT 1)
```

# MongoDB Exercise
## 1.  Create  test DB 
```
use test
```
## 2.  Create  oms_company_address  collection  (method: createCollection() )
```
db.createCollection("oms_company_address")
```

## 3.  Insert few random entries to  oms_company_address  collection (method: insert() )
```
db.oms_company_address.insertMany([
  {
    id: 1,
    address_name: "Address 1",
    send_status: 1,
    receive_status: 0,
    name: "John Doe",
    phone: "666-6666-8888",
    province: "California",
    city: "Los Angeles",
    region: "Downtown",
    detail_address: "123 Main St"
  },
  {
    id: 2,
    address_name: "Address 2",
    send_status: 0,
    receive_status: 1,
    name: "Jane Smith",
    phone: "666-6666-8888",
    province: "New York",
    city: "New York City",
    region: "Midtown",
    detail_address: "456 Elm St"
  },
  {
    id: 3,
    address_name: "Address 3",
    send_status: 1,
    receive_status: 1,
    name: "Mike Johnson",
    phone: "666-6666-8888",
    province: "Texas",
    city: "Houston",
    region: "West Side",
    detail_address: "789 Oak Ave"
  }
]);
```

## 4.  Read one entry from  oms_company_address  collection (method: find() )
```
db.oms_company_address.find().limit(1)
```

## 5.  Read all entries from  oms_company_address  collection (method: find() )
```
db.oms_company_address.find()
```
## 6.  Update one entry from  oms_company_address collection (method: update() or save() )
```
db.oms_company_address.updateOne(
  { id: 1 },
  {
    $set: {
      phone: "777-7777-9999" 
    }
  }
)

```
## 7.  Remove one entry from  oms_company_address collection (method: remove() )
```
db.oms_company_address.deleteOne({ id: 1 })
```


# API Design
1. Find the customer's payments:

GET /customers/{customerId}/payments



2. Find the customer's history orders from a specific date range:

GET /customers/{customerId}/orders?start_date=2022-10-10&end_date=2022-10-24


3. Find the customer's delivery addresses:

GET /customers/{customerId}/delivery-addresses

4. Get the customer's default payment and delivery address:

GET /customers/{customerId}/default-details
Retrieves the customer's default payment and delivery address.