# API Design
## 1.Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.  -- 命名规范
users，orders

## 2.Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE
GET - 获取博客文章信息：

GET /api/posts：获取所有博客文章的列表。
GET /api/posts/{id}：根据博客文章的ID获取特定的博客文章信息。
POST - 创建新的博客文章：

POST /api/posts：创建一篇新的博客文章。
PUT - 更新博客文章信息：

PUT /api/posts/{id}：根据博客文章的ID更新特定的博客文章信息。
DELETE - 删除博客文章：

DELETE /api/posts/{id}：根据博客文章的ID删除特定的博客文章。

## Design APIs for the following features (思考：path variable 怎么用？有sub resources, 哪些地方该用复数)

查找客户的支付方式，如信用卡1、信用卡2、PayPal和Apple Pay。

GET /api/customers/{customerId}/payments：查找特定客户的所有支付方式。
GET /api/customers/{customerId}/payments/{paymentId}：查找特定客户的特定支付方式。
查找客户从2023年7月10日到2023年7月13日期间的历史订单。

GET /api/customers/{customerId}/orders?startDate=2023-7-10&endDate=2023-7-13：查找特定客户在指定日期范围内的历史订单。
查找客户的送货地址。

GET /api/customers/{customerId}/addresses：查找特定客户的所有送货地址。
GET /api/customers/{customerId}/addresses/{addressId}：查找特定客户的特定送货地址。
如果您还想获取客户的默认支付方式和默认送货地址，可以设计以下API：

GET /api/customers/{customerId}/default-payment：获取特定客户的默认支付方式。
GET /api/customers/{customerId}/default-address：获取特定客户的默认送货地址。