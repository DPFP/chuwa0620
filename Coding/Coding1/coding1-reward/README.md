#Coding1 - Reward Project

### Author: Yuanzhen Lin

### Instruct on Running the App
1. Use intellJ IDE
2. Click Run 'Coding1RewardApplication' to start the app


### Project dependency
1. MySQL Driver
2. JPA Data 
3. Spring Web

### URL Intro
1. GET http://localhost:8080/api/v1/customers/{id}/reward/total
- This will return the total reward for customer with customer id: {id}
- Example Response:
  - {\
    "customerId": 1,\
    "rewardTotal": 500.0,\
    "monthToReward": {}\
    }

2. GET http://localhost:8080/api/v1/customers/{id}/reward/months?months-limit={months}&zero-record-show={show}
- This will return the total reward and reward at each month with customer id: {id}
- {months} is a long type represents what how many months from right now (this month) you want to look up
  - 1 means current month, 2 means current month + previous month, .....
- {show} is a boolean type represents whether you want to show the reward record of month with 0
  - true means you want the 0 reward record, false means you want to include the 0 reward record
- Example Response: 
  - {\
    "customerId": 1,\
    "rewardTotal": 450.0,\
    "monthToReward": {\
    "2023-06": 0.0,\
    "2023-07": 450.0\
    }\
    }