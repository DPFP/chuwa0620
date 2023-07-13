#### MySQL Exercise

Create oms_company_address table

```SQL
use chuwahw6;
create table oms_company_address (
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



insert some random data to oms_company_address table

```SQL
insert into oms_company_address (id, 
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
(1, 'company A', 0, 1, 'da', '123456', 'shanghai', 'shanghai', 'baoshan', 'xxxppp'),
(2, 'company B', 1, 0, 'pa', '61623456', 'jjiik', 'asdasd', 'saafdaoms_company_address', 'xxxppp');
```

![image-20230712131934567](https://raw.githubusercontent.com/xiaominglalala/pic/main/img/image-20230712131934567.png)

Write a SQL query to fetch all data from oms_company_address `table

```SQL
SELECT * FROM oms_company_address;
```



Write a SQL query to fetch top 3 records from oms_company_address table

```SQL
SELECT * FROM oms_company_address LIMIT 3;
```



Update oms_company_address table to set all phone to 666-6666-8888

```SQL
UPDATE oms_company_address SET phone = '666-6666-8888';
```



Delete one entry from oms_company_address table

```SQL
DELETE FROM oms_company_address WHERE id = 1;
```



(Optional) You can also try to create other tables that listed above







#### MongoDB Exercise

Create test DB

Create oms_company_address collection (method: createCollection() )

这两步直接使用MongoDB Compass的GUI就好了



Insert few random entries to oms_company_address collection (method: insert() )

直接GUI里面插入就好了

```sql
[
  {
    "companyName": "ABC Corp",
    "address": {
      "street": "1234 Main St",
      "city": "San Francisco",
      "state": "CA",
      "zip": "94101",
      "country": "USA"
    }
  },
  {
    "companyName": "XYZ Inc",
    "address": {
      "street": "5678 Market St",
      "city": "Los Angeles",
      "state": "CA",
      "zip": "90001",
      "country": "USA"
    }
  },
  {
    "companyName": "DEF Ltd",
    "address": {
      "street": "4321 Oak St",
      "city": "New York",
      "state": "NY",
      "zip": "10001",
      "country": "USA"
    }
  }
]
```



Read one entry from oms_company_address collection (method: find() )

Read all entries from oms_company_address collection (method: find() )

Update one entry from oms_company_address collection (method: update() or save() )

Remove one entry from oms_company_address collection (method: remove() )

1. **读取一个条目（使用find()方法）**：在MongoDB Compass中，你只需要在你的`oms_company_address` collection的搜索框中输入查询条件。例如，如果你想要找到公司名称为"ABC Corp"的条目，你可以输入以下查询：

   ```
   jsonCopy code
   {"companyName": "ABC Corp"}
   ```

2. **读取所有条目（使用find()方法）**：不输入任何查询条件，保持搜索框为空，然后直接点击“Find”按钮或者刷新页面，你就能看到`oms_company_address` collection中的所有条目。

3. **更新一个条目（使用update()或save()方法）**：在你的`oms_company_address` collection中，找到你想要更新的文档，然后点击右侧的“Edit Document”按钮。在打开的对话框中，你可以修改文档的内容。例如，你可以改变公司名称为"ABC Corp"的地址。完成修改后，点击“Update”按钮。

4. **删除一个条目（使用remove()方法）**：在你的`oms_company_address` collection中，找到你想要删除的文档，然后点击右侧的“Delete Document”按钮。在确认对话框中，点击“Delete”按钮。

如果想通过MongoDB的Shell或者使用某种编程语言（如Python，JavaScript等）的MongoDB驱动来操作：

1. **读取一个条目（使用find()方法）**：假设你要查找公司名称为"ABC Corp"的条目，你可以使用以下命令：

   ```
   javascriptCopy code
   db.oms_company_address.find({"companyName": "ABC Corp"}).limit(1);
   ```

2. **读取所有条目（使用find()方法）**：只需执行find()方法，不传入任何查询参数，即可获取集合中的所有条目：

   ```
   javascriptCopy code
   db.oms_company_address.find();
   ```

3. **更新一个条目（使用update()或save()方法）**：以下是一个例子，假设你要更新公司名称为"ABC Corp"的地址，你可以使用以下命令：

   ```
   javascriptCopy codedb.oms_company_address.update(
       {"companyName": "ABC Corp"},
       {$set: {"address.street": "New Street Name"}}
   );
   ```

   这个命令会将名称为"ABC Corp"的公司地址更新为"New Street Name"。

4. **删除一个条目（使用remove()方法）**：如果你要删除公司名称为"ABC Corp"的条目，你可以使用以下命令：

   ```
   javascriptCopy code
   db.oms_company_address.remove({"companyName": "ABC Corp"});
   ```