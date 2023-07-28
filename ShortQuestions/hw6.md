# HW6 DATABASE MySQL
1. 
```
	CREATE TABLE oms_company_address(
		Id			bigint    		Primary Key
		address_name 	varchar(200)		
		send_status		int(1)
		receive_status		int(1)
		name			varchar(64)
		phone			varchar(64)
		province		varchar(64)
	city			varchar(64)
	region			varchar(64) 
	detail_address		varchar(200)   			
	);
```



2. 
```
Insert into oms_company_address value(1, "Apple park", 1, 1, "Tim Cook", "000-111-2222", "CA", "Cupertino", "95014", "10600 North Tantau Avenue Cupertino, CA 95014" )
```

3. 
```
SELECT *
FROM oms_company_address
```

4. 
```
SELECT  Max(*)
FROM oms_company_address
LIMIT 3
```

5. 
```
UPDATE oms_company_address
SET phone = “666-6666-8888”
```

6. 
```
DELETE FROM oms_company_address
LIMIT 1
```


# MongoDB

1. 
```
	use test
```

2. 
```
	db.createCollection("oms_company_address")
```

3. 
```
	db.oms_company_address.insert([
		{
			id: 1,
			address_name: "Apple park",
			send_status: 1,
			receive_status: 0
			name: "Tim Cook",
			phone: "000-111-2222",
			province: "CA",
			city: "Cupertino",
			region: "95014",
			detail_address: "10600 North Tantau Avenue Cupertino, CA 95014"
		},
		{
			id: 2,
			address_name: "Apple park",
			send_status: 1,
			receive_status: 0
			name: "Sam Book",
			phone: "000-111-3333",
			province: "CA",
			city: "Cupertino",
			region: "95013",
			detail_address: "10600 North Tantau Avenue Cupertino, CA 95014"

		}
	])
```

4. 
```
	db.oms_company_address.find().limit(1)
```

5. 
```
	db.oms_company_address.find()
```

6. 
```
	db.oms_company_address.updateOne({id: 2}, {$set:{region: "95015"}})
```

7. 
```
	db.oms_company_address.deleteOne({id: 2})
```


# Postman API

### REST API Postman
take below examples,
- 5 GET APIs with different response type
- 5 POST APIs with json request body, please also paste the response here
- 3 PUT APIs with json request body, please also paste the response here
- 2 DELETE API
- Each example with 404, 401, 500 and any http status codes you know


### GET
- 200 OK: GET https://reqres.in/api/users/1
- 200 OK: GET https://reqres.in/api/unknown
- 200 OK: GET https://reqres.in/api/users?page=2
- 404 Not Found: GET https://reqres.in/api/users/23
- 400 Bad Request

### POST
- 201 Created: POST https://reqres.in/api/users
```
//request body
{
    "name": "morpheus",
    "job": "leader"
}

//response
{
  "name": "morpheus",
  "job": "leader",
  "id": "503",
  "createdAt": "2023-07-15T23:24:00.893Z"
}
```

- 200 OK: POST https://reqres.in/api/register

```
//request body
{
  "email": "eve.holt@reqres.in",
  "password": "pistol"
}

//response
{
    "id": 4,
    "token": "QpwL5tke4Pnpja7X4"
}
```

- 400 Bad Request: POST https://reqres.in/api/register

```
//request body
{
    "email": "sydney@fife"
}

//response
{
    "error": "Missing password"
}

```

- 200 OK: POST https://reqres.in/api/login

```
//request body
{
  "email": "eve.holt@reqres.in",
  "password": "cityslicka"
}

//response
{
    "token": "QpwL5tke4Pnpja7X4"
}
```

- 400 Bad Request: POST https://reqres.in/api/login

```
//request body
{
    "email": "peter@klaven"
}

//response
{
    "error": "Missing password"
}

```

### PUT

- 200 OK : PUT https://reqres.in/api/users/2

```
//request body
{
    "name": "morpheus",
    "job": "zion resident"
}

//response
{
    "name": "morpheus",
    "job": "zion resident",
    "updatedAt": "2022-08-21T23:27:44.324Z"
}

```

- 400 Bad Request: PUT https://reqres.in/api/users/2

```
//request body
{
  "name": "morpheus",
  "job": "zion resident"
  "email": "a@a.a"
}

//response
{
  <!DOCTYPE html>
  <html lang="en">
  <head>
  <meta charset="utf-8">
  <title>Error</title>
  </head>
  <body>
  <pre>Bad Request</pre>
  </body>
  </html>
}

```


- 404 Not Found: PUT https://api.getpostman.com/scim/v2/Users

```
//request body
null

//response
{
    "error": {
        "name": "NotFound",
        "message": "We can't seem to find what you are looking for."
    },
    "status": "error"
}

```

### DELETE

- 204 No Content: DELETE https://reqres.in/api/users/2

```
//response
null
```

- 204 No Content: DELETE https://reqres.in/api/users

```
//response
null
```

# API Examples

1. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc.
	- Twitter:
		- GET User lookup https://api.twitter.com/2/users/:id
		- POST Create a Tweet https://api.twitter.com/2/tweets
		- DELETE Delete a Tweet https://api.twitter.com/2/tweets/:id
		- PUT Hide a reply https://api.twitter.com/2/tweets/:id/hidden
	- Youtube:
		- GET https://www.googleapis.com/youtube/v3/comments?{part}&{id}
		- POST https://www.googleapis.com/youtube/v3/comments?{part}
		- DELETE https://www.googleapis.com/youtube/v3/comments?{id}
		- PUT https://www.googleapis.com/youtube/v3/comments{part}


2. Design a collection of APIs for a Blog Website,please specify GET POST PUT DELETE
	- **Retrieving posts from a blog**: `GET https://www.xyz.com/api/v3/content`
	- **Retrieving a specific post**: `GET https://www.xyz.com/api/v3/id/contentId`
	- **Adding a post**: `POST https://www.xyz.com/api/v3/id`
	- **Deleting a post**: `DELETE https://www.xyz.com/api/v3/id/contentId`
	- **Updating a post**: `PUT https://www.xyz.com/api/v3/id/contentId`


# Design APIs for the following features
### 1 find the customer's payments, like credit card1, credit card2,paypal,ApplePay.
GET URL/v1/users/{userid}/payments/{typeOfPayment}

### 2 Find the customer's history orders from 10/10/2022to10/24/2022
GET URL/v1/users/{userid}/orders?fromDate=10-10-2022&endDate=10-24-2022

### 3 find the customer's delivery addresses
GET URL/v1/users/{userid}/addresses/default

### 4 If I also want to get customer's default payment and default delivery address,what kind of the API(URL) should be?
GET URL/v1/users/{userid}/payments/default  
GET URL/v1/users/{userid}/addresses/default

