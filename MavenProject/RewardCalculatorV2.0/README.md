# RewardCalculator
Built by Maven

Run the Spring Boot Application first and then send api call from Postman.

GET http://localhost:8080/api/users/{user_id}/reward   :to get the user's total rewards points, encrypted by base64

POST http://localhost:8080/api/users    :with body {"id":xx, "name":xx, "password":xx} to post a new user

POST http://localhost:8080/api/orders    :with body {"id":xx, "userId":xx, "amount":xx} to post a new order

DELETE http://localhost:8080/api/users/{ID}    :delete a user

GET http://localhost:8080/api/users/{userId}/orders/csv   :to get the user's rewards points breakdown, in csv format

**Default data include:**

users.add(new User(1l,"qq","12345",null));

users.add(new User(2l,"pp","11111",null));

orders.add(new Order(1l, 1l, LocalDateTime.now(), 120.0));

orders.add(new Order(2l, 1l,LocalDateTime.now(), 60.0));

orders.add(new Order(3l, 2l,LocalDateTime.now(), 70.0));

