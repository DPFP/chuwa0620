# RewardCalculator
Built by Maven

Run the Spring Boot Application first and then send api call from Postman.

GET http://localhost:8080/api/users/{user_id}/reward   :to get the user's total rewards points

GET http://localhost:8080/api/users/{user_id}/reward/{month}   :to get the user's rewards points within recent {month} months

POST http://localhost:8080/api/transactions    :with body {"id":xx, "amount":xx, "date":"YYYY-MM-DD"} to post a transaction