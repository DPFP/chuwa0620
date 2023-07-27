# rewardProgramApplication
A Spring Boot Web Restful Service for a reward program application

A Reward Point Service made with a Spring boot application
1.	Create two services to show the customer’s reward point and last three-month reward point report.
2.	Technologies used: Spring boot, JDK 11, Spring Data JPA, H2, Junit 5
3.	Create two tables: customer(name, id), 	transaction_data (amount, customer_id, purchase_date, id)
4.	To start, run mvn spring-boot:run
5.	Verify the server log to confirm with the following message:
2020-06-09 21:01:02.457  INFO 60100 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-06-09 21:01:02.477  INFO 60100 --- [           main] z.d.r.RewardprogramApplication           : Started RewardprogramApplication in 9.788 seconds (JVM running for 11.862)
2020-06-09 21:01:10.633  INFO 60100 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2020-06-09 21:01:10.634  INFO 60100 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2020-06-09 21:01:10.648  INFO 60100 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 12 ms

Application test
a.	Open a browser, enter: http://localhost:8080/api/v1/rewards/, then you should get the customer three month reward reports for two customers, each customer has it’s reward point calculated by month. 
b.	Open a browser, enter: http://localhost:8080/api/v1/rewards/customer/1, then you should get the customer  1’s reward point and group by the month. Here is an example data:

{
	"customer": {
		"id": 1,
		"name": "Mary"
	},
	"monthlyTrans": {
		"MAY": [{
			"amount": 120.00,
			"id": 4,
			"purchaseDate": "2020-05-07T21:01:10.859322",
			"rewardPoint": 90.00
		}, {
			"amount": 100.00,
			"id": 5,
			"purchaseDate": "2020-05-04T21:01:10.86232",
			"rewardPoint": 50.00
		}],
		"JUNE": [{
			"amount": 20.00,
			"id": 3,
			"purchaseDate": "2020-06-07T21:01:10.843319",
			"rewardPoint": 0
		}],
		"APRIL": [{
			"amount": 20.00,
			"id": 6,
			"purchaseDate": "2020-04-09T21:01:10.864322",
			"rewardPoint": 0
		}, {
			"amount": 60.00,
			"id": 7,
			"purchaseDate": "2020-04-05T21:01:10.867321",
			"rewardPoint": 10.00
		}, {
			"amount": 120.00,
			"id": 8,
			"purchaseDate": "2020-04-05T21:01:10.87032",
			"rewardPoint": 90.00
		}]
	},
	"monthlyTotalRewardPoint": {
		"MAY": 140.00,
		"JUNE": 0,
		"APRIL": 100.00
	}
}

