# HW6
### Name: Yuanzhen Lin

## Database
### MySQL
1. Create oms_company_address table\
```aidl
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
2. Insert some random data to oms_company_address table
```aidl
   INSERT INTO oms_company_address
   VALUES
   (1, "Lakers", 1, 0, "Jonny Dang", 4003453345, 'CA', 'JA', 'Cloouse', '333 usd st'),
   (2, "Suns", 0, 0, "Tim Lee", 4435543345, 'NY', 'YM', 'Lothe', '434 tt st'),
   (3, "Warrior", 1, 1, "July Wong", 6455535654, 'PH', 'RT', 'Nithe', '434 js st');
```

3. Write a SQL query to fetch all data from oms_company_address table
```aidl
   SELECT * FROM oms_company_address;
```
4. Write a SQL query to fetch top 3 records from oms_company_address table
```aidl
   SELECT * FROM oms_company_address limit 3
```
5. Update oms_company_address table to set all phone to 666-6666-8888
```aidl
   UPDATE oms_company_address SET phone = '666-6666-8888';
```
6. Delete one entry from oms_company_address table
```aidl
   DELETE FROM oms_company_address WHERE id = 3;
```

### MongoDB
1. Create test DB
```
use test
```

2. Create  oms_company_address  collection  (method: createCollection())
```aidl
db.createCollection("oms_company_address")
```

3. Insert few random entries to oms_company_address collection (method: insert() )
```aidl
db.oms_company_address.insertMany(
[
 {
    id: 1,
    address_name: "Enenrgy 1",
    send_status: 1,
    receive_status: 0,
    name: "Mars Jose",
    phone: "666-6666-8888",
    province: "Tim",
    city: "Los",
    region: "Fala",
    detail_address: "33 DD St"
  },
  {
    id: 2,
    address_name: "Lasting 2",
    send_status: 0,
    receive_status: 1,
    name: "Jane Luck",
    phone: "666-6666-8888",
    province: "York",
    city: "Dental",
    region: "Risk",
    detail_address: "8997 Mask St"
  }
]
);
```
4. Read one entry from oms_company_address collection (method: find() )
```aidl
db.oms_company_address.find().limit(1)
```
5. Read all entries from  oms_company_address  collection (method: find() )
```aidl
db.oms_company_address.find()
```

6. Update one entry from oms_company_address collection (method:update() or save())
```aidl
db.oms_company_address.updateOne(
    {id: 1},
    {
        $set:{
            phone: "22334"
        }
    }
)
```

7. Remove one entry from oms_company_address collection (method:remove())
```aidl
db.oms_company_address.deleteOne({ id: 1 })
```


## REST API
### POSTMAN
#### GET APIS
1. This API provides information about Star Wars universe.
    - Request: `GET https://swapi.dev/api/people/1`
    - Response Status: `200 OK`
    - Body: `{
      "name": "Luke Skywalker",
      "height": "172",
      "mass": "77",
      "hair_color": "blond",
      "skin_color": "fair",
      "eye_color": "blue",
      "birth_year": "19BBY",
      "gender": "male",
      "homeworld": "https://swapi.dev/api/planets/1/",
      "films": [
      "https://swapi.dev/api/films/1/",
      "https://swapi.dev/api/films/2/",
      "https://swapi.dev/api/films/3/",
      "https://swapi.dev/api/films/6/"
      ],
      "species": [],
      "vehicles": [
      "https://swapi.dev/api/vehicles/14/",
      "https://swapi.dev/api/vehicles/30/"
      ],
      "starships": [
      "https://swapi.dev/api/starships/12/",
      "https://swapi.dev/api/starships/22/"
      ],
      "created": "2014-12-09T13:50:51.644000Z",
      "edited": "2014-12-20T21:17:56.891000Z",
      "url": "https://swapi.dev/api/people/1/"
      }
    
2. This API provides information about cryptocurrencies.
    - Request: `GET https://api.coingecko.com/api/v3/coins/list`
    - Response Status: `404 Not Found`
    - Body: {
      "error": "coin not found"
      }

3. This API provides programming jokes.
    - Request: `GET https://v2.jokeapi.dev/joke/Programming?blacklistFlags=nsfw,religious,political,racist,sexist,explicit&type=single`
    - Response Status: `400 Bad Request`
    - Body: {}
4. This service provides fake API for testing and prototyping.
    - Request: `GET https://jsonplaceholder.typicode.com/posts`
    - Response Status: `200 OK`
      - Body: [
        {
        "userId": 1,
        "id": 1,
        "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
        },
        {
        "userId": 1,
        "id": 2,
        "title": "qui est esse",
        "body": "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"
        },
      ]

5. This API provides data about the Pokémon main series games.
    - Request: `GET https://pokeapi.co/api/v2/pokemon/ditto`
    - Response Status: `200 OK`
    - Body:{
      "abilities": [
      {
      "ability": {
      "name": "limber",
      "url": "https://pokeapi.co/api/v2/ability/7/"
      },
      "is_hidden": false,
      "slot": 1
      },
      {
      "ability": {
      "name": "imposter",
      "url": "https://pokeapi.co/api/v2/ability/150/"
      },
      "is_hidden": true,
      "slot": 3
      }
      ],
      "base_experience": 101,
      "forms": [
      {
      "name": "ditto",
      "url": "https://pokeapi.co/api/v2/pokemon-form/132/"
      }
      ],
   }

#### POST APIS
1. JSONPlaceholder API - Create a Post
    - Request: `POST https://jsonplaceholder.typicode.com/posts`
    - Request Body: {
      "title": "foo",
      "body": "bar",
      "userId": 1
      }
    - Response Status: `201 Created`
    - Response Body: {
      "title": "foo",
      "body": "bar",
      "userId": 1,
      "id": 101
      }

2. Req|Res API - Create a User
    - Request: `POST https://reqres.in/api/users`
    - Request Body: {
      "name": "morpheus",
      "job": "leader"
      }
    - Response Status: `201 Created`
    - Response Body: {
      "name": "morpheus",
      "job": "leader",
      "id": "815",
      "createdAt": "2023-07-13T20:53:40.158Z"
      }

3. HTTPBin API - Post Test
    - Request: `POST https://httpbin.org/post`
    - Request Body: {
      "name": "morpheus",
      "job": "leader"
      }
    - Response Status: `401 Unauthorized`
    - Response Body: {}

4. Restful-Booker API - Create a Booking
   - Request: `POST https://restful-booker.herokuapp.com/booking`
   - Request Body: {
     "firstname": "Jim",
     "lastname": "Brown",
     "totalprice": 111,
     "depositpaid": true,
     "bookingdates": {
     "checkin": "2018-01-01",
     "checkout": "2019-01-01"
     },
     "additionalneeds": "Breakfast"
     }
   - Response Status: `500 Internal Server Error`
   - Response Body: {}

5. Fake JSON Server - Create an Author
    - Request: `POST https://my-json-server.typicode.com/typicode/demo/authors`
    - Request Body: {
      "name": "John Smith",
      "books": 10
      }
    - Response Status: `404 Not Found`
    - Response Body: {}

#### PUT APIS
1. JSONPlaceholder
   - Request: `PUT https://jsonplaceholder.typicode.com/posts/1`
   - Request Body: {
     "id": 1,
     "title": "foo",
     "body": "bar",
     "userId": 1
     }
   - Response Status: `200 OK`
   - Response Body: {
     "id": 1,
     "title": "foo",
     "body": "bar",
     "userId": 1
     }

2. Reqres
    - Request: `PUT https://reqres.in/api/users/2`
    - Request Body: {
      "name": "morpheus",
      "job": "zion resident"
      }
    - Response Status: `200 OK`
    - Response Body: {
      "name": "morpheus",
      "job": "zion resident",
      "updatedAt": "2023-07-13T21:05:34.040Z"
      }

3. Restful Booker
    - Request: `PUT https://restful-booker.herokuapp.com/booking/1`
    - Request Body: {
      "firstname" : "Jim",
      "lastname" : "Brown",
      "totalprice" : 111,
      "depositpaid" : true,
      "bookingdates" : {
      "checkin" : "2018-01-01",
      "checkout" : "2019-01-01"
      }
      }
    - Response Status: `403 Forbidden`
    - Response Body: Forbidden


#### DELETE APIS
1. JSONPlaceholder API - Delete a Post
    - Request: `DELETE https://jsonplaceholder.typicode.com/posts/1`
    - Request Body: 
    - Response Status: `200 OK`
    - Response Body: 

2. FakeStore API - Delete a Product
    - Request: `DELETE https://fakestoreapi.com/products/1`
    - Request Body:
    - Response Status: `200 OK`
    - Response Body:


## API Design
1. Find 2 collection of APIs example. ie. Twitter, Paypal, Youtube etc. -- 命名规范
- Twitter API\
  GET https://api.twitter.com/2/tweets: Returns a variety of information about a single Tweet specified by the requested ID.\
  POST https://api.twitter.com/2/tweets: Creates a new tweet.\
  DELETE https://api.twitter.com/2/tweets/{id}: Deletes a specified tweet.\
  GET https://api.twitter.com/2/users/{id}: Returns a variety of information about the user specified by the requested user ID.\
  GET https://api.twitter.com/2/users/{id}/tweets: Returns the Tweets composed by the user specified by the requested user ID.
- YouTube Data API
GET https://www.googleapis.com/youtube/v3/videos: Returns a list of YouTube videos that match the API request parameters.\
GET https://www.googleapis.com/youtube/v3/channels: Returns a list of YouTube channels that match the API request parameters.\
GET https://www.googleapis.com/youtube/v3/playlists: Returns a collection of playlists that match the API request parameters.\
GET https://www.googleapis.com/youtube/v3/comments: Returns a list of comments that match the API request parameters.


2. Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE\
We assume the blog would have Users, Posts, and Comments. 
- Users
  - List all users.\
    `GET /api/users/`
  - Get the details of a specific user by ID.\
    `GET /api/users/{id}`
  - Create a new user.\
    `POST /api/users/`
  - Update the details of a specific user by ID.\
    `PUT /api/users/{id}`
  - Delete a specific user by ID.\
    `DELETE /api/users/{id}`
- Posts
  - List all posts.\
    `GET /api/posts/`
  - Get the details of a specific post by ID.\
    `GET /api/posts/{id}`
  - Create a new post.\
    `POST /api/posts/`
  - Update the details of a specific post by ID.\
    `PUT /api/posts/{id}`
  - Delete a specific post by ID.\
    `DELETE /api/posts/{id}`
- Comments
  - List all comments.\
    `GET /api/comments/`
  - Get the details of a specific comment by ID.\
    `GET /api/comments/{id}`
  - Create a new comment.\
    `POST /api/comments/`
  - Update the details of a specific comment by ID.\
    `PUT /api/comments/{id}`
  - Delete a specific comment by ID.\
    `DELETE /api/comments/{id}`
  
- Users & Posts
    - Get all posts created by a specific user.\
        `GET /api/users/{id}/posts`
- Posts & Comments 
  - Get all comments on a specific post.\
        `GET /api/posts/{id}/comments`


**Design APIs for the following features (思考:path variable 怎么用?有sub resources, 哪些地方该用复数)**
1. find the customer's payments,like credit card 1, credit card 2, paypal,ApplePay.
`GET /api/v1/customers/{customerId}/payments`
2. Find the customer's history orders from 10/10/2022 to 10/24/2022
`GET /api/v1/customers/{customerId}/orders?startDate=2022-10-10&endDate=2022-10-24`
3. find the customer's delievery addresses
`GET /api/v1/customers/{customerId}/address`
4. If I also want to get customer's default payment and default delievery address,what kind of the API(URL)
    should be?
`GET /api/v1/customers/{customerId}/payment/default`
`GET /api/v1/cusomters/{customerId}/address/default`





