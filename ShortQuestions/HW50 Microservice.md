# HW50
**2. Document the microservice architeture and components/tools/dependencies**
Components:
- Microservices: These are individual, self-contained services that handle specific business functions. Each microservice can be developed, deployed, and scaled independently of others.
- API Gateway: Acts as a front door for the application, handling client requests, load balancing, authentication, and routing requests to appropriate microservices.
- Service Discovery: A mechanism that allows microservices to locate and communicate with each other without hard-coded IP addresses. Common tools include Netflix Eureka, Consul, and Kubernetes' built-in service discovery.
- Load Balancing: Distributes incoming network traffic across multiple instances of a microservice to ensure even utilization of resources and high availability.
- Containerization: Containers (e.g., Docker) encapsulate microservices and their dependencies, ensuring consistent environments across different stages of the development lifecycle.
- Orchestration: Tools like Kubernetes enable the deployment, scaling, and management of containers, ensuring resilience, availability, and automatic scaling of microservices.
- Event Bus / Message Broker: Enables communication and data sharing between microservices through events or messages. Tools like Apache Kafka, RabbitMQ, and Amazon SQS are commonly used.
- Database per Service: Each microservice has its own dedicated database, chosen based on the specific requirements of the service. This promotes autonomy and avoids tight coupling.
- Caching: Used to improve performance by storing frequently accessed data closer to the microservices. Tools like Redis are often used for caching.
- Monitoring and Logging: Monitoring tools like Prometheus, Grafana, and ELK (Elasticsearch, Logstash, Kibana) stack help track the health and performance of microservices, while logging tools capture relevant information for troubleshooting.

Tools and Dependencies:
- Programming Languages and Frameworks: Microservices can be developed using various programming languages such as Java, Python, Node.js, Go, and frameworks like Spring Boot, Flask, Express.js, etc.
- Containerization and Orchestration: Docker and Kubernetes are commonly used for containerization and orchestration, respectively.
- API Gateway: Tools like Netflix Zuul, Spring Cloud Gateway, and Kong provide API gateway functionalities.
- Service Discovery: Netflix Eureka, Consul, and Kubernetes' built-in service discovery are popular options.
- Message Brokers: Apache Kafka, RabbitMQ, and Amazon SQS are commonly used for asynchronous communication.
- Database: Depending on the service's requirements, relational databases like MySQL, PostgreSQL, or NoSQL databases like MongoDB, Cassandra may be used.
- Caching: Redis, Memcached for caching frequently accessed data.
- Monitoring and Logging: Prometheus, Grafana, ELK stack (Elasticsearch, Logstash, Kibana), Jaeger for distributed tracing.
- Security: Tools like OAuth2, JWT (JSON Web Tokens), and security protocols to ensure authentication and authorization between microservices.
- Continuous Integration and Deployment: Jenkins, GitLab CI/CD, Travis CI for automating the building, testing, and deployment of microservices.
- Configuration Management: Tools like Spring Cloud Config, Consul, etcd help manage configuration settings for microservices.
- API Documentation: Tools like Swagger and OpenAPI help in documenting and exposing APIs to developers.

**3. What are Resilience patterns? What is circuit breaker?**
Resilience patterns refer to design and architectural strategies used in software development to create systems that can handle and recover from failures effectively. These patterns are especially important in distributed and complex systems, where failures are inevitable, but the goal is to minimize their impact and maintain system functionality.

One popular resilience pattern is the Circuit Breaker pattern, which is commonly used to prevent cascading failures in distributed systems. The circuit breaker pattern works similarly to an electrical circuit breaker: it monitors the state of a service or a component and, if it detects that the service is consistently failing, it "trips" and prevents further requests from being sent to that service. This prevents additional load on the already failing service and gives it time to recover.

Here's how the circuit breaker pattern typically works:

- Closed State: The circuit breaker starts in the closed state, allowing requests to pass through to the target service.
- Threshold Monitoring: The circuit breaker monitors the responses from the target service. If a certain threshold of failures or errors is exceeded within a defined time period, it transitions to the open state.
- Open State: In the open state, the circuit breaker prevents requests from being sent to the target service. Instead, it responds with predefined fallback responses or error messages. This reduces load on the failing service.
- Time-based Recovery: After a specified time period, the circuit breaker transitions to the half-open state. During this state, it allows a limited number of test requests to pass through to the target service to check if it has recovered.
- Closed or Open Transition: Depending on the success of the test requests, the circuit breaker either transitions back to the closed state if the service has recovered, or goes back to the open state if the service is still experiencing issues.
**4. Interview Questions**

Explain OAuth.
Generally speaking, OAuth (Open Authorization Protocol) enables users to authenticate themselves with third-party service providers. With this protocol, you can access client applications on HTTP for third-party providers such as GitHub, Facebook, etc. Using it, you can also share resources on one site with another site without requiring their credentials.

Explain the term Eureka in Microservices.
Eureka Server, also referred to as Netflix Service Discovery Server, is an application that keeps track of all client-service applications. As every Microservice registers to Eureka Server, Eureka Server knows all the client applications running on the different ports and IP addresses. It generally uses Spring Cloud and is not heavy on the application development process. 

Explain the way to implement service discovery in microservices architecture.
There are many ways to set up service discovery, but Netflix's Eureka is the most efficient. This is a hassle-free procedure that doesn't add much weight to the application. It also supports a wide range of web applications. A number of annotations are provided by Spring Cloud to make its use as simple as possible and to hide complex concepts.

Explain Container in Microservices.
Containers are useful technologies for allocating and sharing resources. A container is a lightweight, standalone, and executable software package that includes everything needed to run a piece of software, including the code, runtime, system tools, system libraries, and settings. Containers provide a consistent and isolated environment for applications to run, ensuring that they function reliably across different computing environments, such as development, testing, and production. Using Docker, you may also encapsulate a microservice along with its dependencies in a container image, which can then be used to roll on-demand instances of the microservice without any additional work. 

**5. how to do load balance in microservice?**
Reverse Proxy Load Balancing:
Using a reverse proxy server like Nginx, HAProxy, or Traefik is a common approach. The reverse proxy receives incoming requests and forwards them to the appropriate microservice instance based on predefined rules, load metrics, or algorithms.

DNS Load Balancing:
DNS-based load balancing involves configuring multiple IP addresses for a single domain name. DNS servers will rotate through these IP addresses when resolving the domain, distributing traffic across different instances of the microservice. However, this method lacks fine-grained control over load distribution.

Client-Side Load Balancing:
In this approach, client applications are responsible for selecting an appropriate instance of a microservice to connect to. This can be done using libraries or frameworks that provide client-side load balancing logic. However, this approach requires updates to all clients if the load distribution logic changes.

Container Orchestration Platforms:
If your microservices are deployed in containers using platforms like Kubernetes or Docker Swarm, these platforms offer built-in load balancing. They manage the distribution of traffic to containers across multiple nodes automatically, based on predefined rules and algorithms.

Service Mesh:
A service mesh, like Istio or Linkerd, provides a layer of infrastructure that handles communication between services, including load balancing, traffic control, and observability. Service meshes can simplify the implementation of load balancing in a microservices environment.

Dynamic Load Balancing Algorithms:
Load balancers use various algorithms to distribute traffic effectively. Common algorithms include Round Robin (equal distribution), Weighted Round Robin (assigning different weights to instances), Least Connections (sending traffic to the instance with the fewest active connections), and more. Choose an algorithm based on your application's needs.

Auto-Scaling:
Combine load balancing with auto-scaling. When traffic increases, the load balancer can automatically spin up new instances of microservices to handle the load, and when traffic decreases, it can scale down instances to save resources.

Health Checks:
Load balancers should regularly check the health of microservice instances. If an instance becomes unhealthy or unresponsive, the load balancer should route traffic away from it until it becomes healthy again.

**6.  How to do service discovery?**
- Client-side discovery: Clients directly query a service registry to obtain the location of a service.
- Server-side discovery: Clients request services through a load balancer or API gateway that forwards requests to appropriate service instances.

**7. What are the major components of Kafka?**
Producer: Publishes messages to Kafka topics.
Broker: Manages the storage and distribution of messages.
Topic: A stream of records or messages.
Partition: A way to split a topic's data across multiple brokers for scalability.
Consumer: Reads messages from topics.
Consumer Group: A group of consumers that work together to consume and process messages from one or more topics.
Zookeeper: Manages and coordinates the Kafka cluster.

**8.  What do you mean by a Partition in Kafka?**
A partition in Kafka is a basic unit of parallelism and scalability. A topic can be split into multiple partitions, and each partition is a linearly ordered sequence of messages. Partitions allow Kafka to horizontally scale by distributing the data across multiple brokers. Messages within a partition are assigned an offset to maintain their order.

**9.  What do you mean by zookeeper in Kafka and what are its uses?**
Zookeeper manages various tasks such as:
- Maintaining metadata: Zookeeper stores metadata about the Kafka cluster, such as broker information and topic configurations.
- Leader election: Zookeeper helps in electing a leader for each partition to ensure high availability.
- Broker registration: Brokers register themselves in Zookeeper, allowing clients to discover the available brokers.
Consumer group coordination: Zookeeper helps consumer groups manage offsets and coordinate consumption.

**10. Can we use Kafka without Zookeeper?**
Kafka provides an option to run without ZooKeeper, using a feature called Kafka Raft Metadata mode

**11. Explain the concept of Leader and Follower in Kafka.**
In Kafka, each partition has one broker that acts as the leader and multiple brokers that act as followers. The leader handles all read and write requests for the partition, while followers replicate the data from the leader to ensure data availability and fault tolerance. If the leader fails, one of the followers can be elected as the new leader.

**12. Why is Topic Replication important in Kafka? What do you mean by ISR in Kafka?**
Topic replication is important for data availability and fault tolerance. Kafka allows you to replicate each partition's data across multiple brokers. This ensures that if a broker fails, another broker can take over and serve the data from its replica.

ISR stands for "In-Sync Replica." These are the subset of replicas that are synchronized with the leader. Kafka guarantees that data is not considered committed until it's replicated to a configurable number of in-sync replicas. This ensures that data isn't lost even if the leader fails.

**13. What do you understand about a consumer group in Kafka?**
A consumer group is a group of consumers that work together to consume and process messages from Kafka topics. Each consumer group can have multiple consumer instances, and each instance reads messages from a subset of partitions. This allows for parallel processing of messages within a group.

**14. How do you start a Kafka server?**
- Start Zookeeper if it's not already running.
- Start Kafka brokers.
- Create topics if needed.
- Start producers to publish messages.
- Start consumers to subscribe to topics and process messages.

**15. Tell me about some of the real-world usages of Apache Kafka.**
Log Aggregation: Collecting and centralizing log data from different services.
Event Sourcing: Storing all changes to an application's state as a sequence of events.
Real-time Analytics: Processing and analyzing large volumes of data in real-time.
Metrics Collection: Capturing and processing performance and operational metrics.
Stream Processing: Building data pipelines for real-time processing.
Data Integration: Integrating data from various sources into a central platform.

**16. Describe partitioning key in Kafka.**
The partitioning key in Kafka is a piece of data that is used to determine which partition a message should be written to within a topic. Producers can choose to specify a partitioning key when producing a message. This key is often used to ensure that messages with the same key are written to the same partition, which can help maintain order and grouping of related messages.

**17.  What is the purpose of partitions in Kafka?**
Scalability: By splitting a topic into partitions, Kafka can distribute the load across multiple brokers, allowing for horizontal scaling.
Parallelism: Consumers can read from different partitions in parallel, enabling efficient processing of large message streams.
Durability: Replication of partitions ensures that data is not lost even if a broker fails.
Ordering: Messages within a partition are guaranteed to be in order, ensuring temporal ordering for related data.

**18. Differentiate between Rabbitmq and Kafka.**
Kafka: Built for high-throughput, fault-tolerant, and real-time data streaming. It's designed for event streaming and processing large volumes of data.
RabbitMQ: A traditional message broker with a focus on reliable message delivery between producers and consumers. It's more suitable for lightweight messaging and task queues.

**19. What are the guarantees that Kafka provides?**
Durability: Once data is written to Kafka, it's persisted and can be replicated across multiple brokers.
Scalability: Kafka scales horizontally by adding more brokers and partitions.
Ordering: Messages within a partition are strictly ordered.
Fault Tolerance: Kafka can handle broker failures due to replication and leader election.
Retention: Data can be retained for a configurable amount of time or based on storage limits.
Exactly-Once Semantics: Kafka provides mechanisms to ensure messages are processed exactly once.

**20. What do you mean by an unbalanced cluster in Kafka? How can you balance it?**
An "unbalanced cluster" in Kafka refers to a situation where the distribution of partitions among brokers is not even. This can lead to certain brokers being overloaded while others remain underutilized, potentially causing performance issues, increased latency, and even potential data loss if heavily loaded brokers cannot handle the incoming data effectively.

Balancing the Kafka cluster involves redistributing the partitions across the available brokers to achieve a more even distribution of load. This can be done by following these steps:

- Identify Unbalanced Brokers: Monitor the cluster's partition distribution and broker metrics to identify brokers that are heavily loaded and those that are underutilized.
- Reassign Partitions: Kafka provides a tool called kafka-reassign-partitions that helps you create a plan for partition reassignment. This tool generates a JSON file that outlines how partitions should be moved between brokers to achieve a more balanced distribution.
- Execute Partition Reassignment: Once you have the partition reassignment plan, you can execute it using the kafka-reassign-partitions tool. This tool coordinates the movement of partitions between brokers as per the plan.
- Monitor and Verify: After initiating the partition reassignment, monitor the process to ensure that partitions are being moved as expected. Monitor broker metrics and topic distribution to verify that the cluster's balance is improving.
- Handle Replication: If your cluster uses replication (as most Kafka clusters do for data durability), ensure that replicated partitions are also balanced across brokers. This might involve reassigning replicas along with primary partitions.
- Consider Auto-Balancing: Some newer versions of Kafka might have automated rebalancing features that help maintain a more even distribution of partitions and replicas. Investigate these features if they are available in your Kafka version.
- Scale Out: If your cluster continues to experience imbalanced loads despite partition reassignment, consider adding more brokers to the cluster to increase its overall capacity and distribution capability.

**21. In your recent project, are you a producer or consumer or both?**
Both. I got service to publish order related events and also service to consume such order ralated events.

**22. In your recent project, Could you tell me your topic name?**
user_activity_logs: A topic for logging user activities and interactions within an application.
order_events: A topic for tracking events related to customer orders in an e-commerce system.
clickstream_data: A topic for recording user clicks and navigation patterns on a website.

**23. In your recent project, How many brokers do you have? How many partitions for each topic? How many data for each topic.**
In our recent project, we have been working with a Kafka cluster consisting of 5 brokers. For each topic, we've configured the number of partitions based on the expected load and parallelism requirements. For instance, the "UserActivity" topic has 10 partitions, the "OrderProcessing" topic has 20 partitions, and the "LogEvents" topic has 5 partitions. The actual amount of data varies based on the nature of the topic and the incoming events. On average, the "UserActivity" topic receives about 1 million events per hour, the "OrderProcessing" topic receives around 500,000 events per hour, and the "LogEvents" topic receives approximately 2 million events per hour.

**24. In your recent project, which team produce what kind of event to you and you producer what kind of events?**
In our recent project, we are working with multiple teams that generate various types of events. The CustomerSupport team produces "TicketCreated" and "TicketResolved" events to track customer support interactions. The Sales team generates "OrderPlaced" events when customers place orders, and the Inventory team sends "ProductStockUpdated" events when changes to product stock levels occur. Additionally, our team is responsible for producing "AnalyticsData" events, which consolidate various metrics from the system for further analysis. These events include user engagement metrics, order processing times, and inventory turnover rates.

**25. What is offset?**
An offset is a unique identifier assigned to each message within a partition of a Kafka topic. It represents the position of a message within the partition's sequence. Offsets are crucial for maintaining the order and tracking the progress of message consumption. 
