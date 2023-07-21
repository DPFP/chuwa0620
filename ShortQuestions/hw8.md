1. See Annotation.md

2. Done

3. Done

4. JPA is concerned with *persistence*, which loosely means any mechanism by which Java objects outlive the application process that created them. Not all Java objects need to be persisted, but most applications persist key business objects. The JPA specification lets you define *which* objects should be persisted, and *how* they are persisted in your Java applications. 

   Hibernate is an open source object relational mapping ([ORM](https://theserverside.techtarget.com/definition/object-relational-mapping)) tool that provides a framework to map object-oriented domain models to relational databases for web applications.

   Object relational mapping is based on the containerization of objects and the abstraction that provides that capacity. Abstraction makes it possible to address, access and manipulate objects without having to consider how they are related to their data sources.

5. Hikari is a JDBC *DataSource* implementation that provides a connection pooling mechanism.Connection pools **promote the reuse of connection objects and reduce the number of times that connection objects are created**. Connection pools significantly improve performance for database-intensive applications because creating connection objects is costly both in terms of time and resources.

6. ​       

   1. ```java
      //@OneToMany was used to define one to many mapping relationship between tables
      public class Cart {
      
          //...     
       
          @OneToMany(mappedBy="cart")
          private Set<Item> items;
      	
          //...
      }
      @Entity
      @Table(name="ITEMS")
      public class Item {
          
          //ManytoOne was used to define Many to one mapping relationship between tables
          @ManyToOne
          @JoinColumn(name="cart_id", nullable=false)
          private Cart cart;
      
          public Item() {}
          
          // getters and setters
      }
      ```

   2. ```java
      @Entity
      class Student {
      
          @Id
          Long id;
      
          @ManyToMany
          Set<Course> likedCourses;
      
          // additional properties
          // standard constructors, getters, and setters
      }
      
      @Entity
      class Course {
      
          @Id
          Long id;
      
          @ManyToMany
          Set<Student> likes;
      
          // additional properties
          // standard constructors, getters, and setters
      }
      ```

7. It means that all operation in parent table will be applied to child table as well, and entity in child table that is not refered by a entity in parent table will be auto removed. Cascade contains following Type: 

   1. *ALL* : All operation
   2. *PERSIST*: Create operation
   3. *MERGE* Merge operation
   4. *REMOVE* delete operation
   5. *REFRESH* When fetch parent entity, will also fetch child entity
   6. *DETACH* if parent entity got removed from context, child entity will also be removed.

8. LAZY: It fetches the child entities lazily i.e at the time of fetching parent entity it just fetches proxy(created by cglib or any other utility) of the child entities and when you access any property of child entity then it is actually fetched by hibernate. EAGER: it fetches the child entities along with parent.

9. JPA defines inherent rules about implicit logical name determination. If JPA provider portability is a major concern, or if you really just like the JPA-defined implicit naming rules, be sure to stick with ImplicitNamingStrategyJpaCompliantImpl (the default).
   Also, JPA defines no separation between logical and physical name. Following the JPA specification, the logical name is the physical name. If JPA provider portability is important, applications should prefer not to specify a PhysicalNamingStrategy. Only if we need something that is not covered by default naming covention, we can implemented by ourself. 

   Normally, we concat column name with server predefined word in jpa to complete naming.

10. Done

11. Optional

12. Optional

13. Done

14. JPQL is Java Persistence Query Language defined in JPA specification. 

15. If you want to use named query in hibernate, you need to have knowledge of @NamedQueries and @NamedQuery annotations.

    **@NameQueries** annotation is used to define the multiple named queries.

    **@NameQuery** annotation is used to define the single named query.

16. @Query annotation can be used to sepecifiy JPQL or native SQL for certain method, we will write SQL or JPQL in repo interface.

17. HQL is hibernate Query Language which can seperate query from database schema instead using Class variable mapping.One of the methods is Criteria API, which **allows you to build up a criteria query object programmatically where you can apply filtration rules and logical conditions**.

18. EntityManager is **an interface provided by Java Persistence API (JPA) specification**. We use EntityManager as a general-purpose DAO interface for managing lifecycle of entity instances, such as: Create & Remove persistent entity instances. Find entities by their primary key.

19. **The SessionFactory is a thread safe object and used by all the threads of an application.** **A Session is used to get a physical connection with a database**. The Session object is lightweight and designed to be instantiated each time an interaction is needed with the database.

20. Transactions are a set of operations used to perform a logical set of work. It is the bundle of all the instructions of a logical operation. A transaction usually means that the data in the database has changed. One of the major uses of DBMS is to protect the user’s data from system failures. It is done by ensuring that all the data is restored to a consistent state when the computer is restarted after a crash. The transaction is any one execution of the user program in a DBMS. One of the important properties of the transaction is that it contains a finite number of steps. Executing the same program multiple times will generate multiple transactions. 

21. Hibernate will cache data in memory to prevent performance lowering caused by frequent disk access.

22. The first-level cache is the Session cache and is a mandatory cache through which all requests must pass. The Session object keeps an object under its own power before committing it to the database.

    If you issue multiple updates to an object, Hibernate tries to delay doing the update as long as possible to reduce the number of update SQL statements issued. If you close the session, all the objects being cached are lost and either persisted or updated in the database.Second level cache is an optional cache and first-level cache will always be consulted before any attempt is made to locate an object in the second-level cache. The second level cache can be configured on a per-class and per-collection basis and mainly responsible for caching objects across sessions.Any third-party cache can be used with Hibernate. An **org.hibernate.cache.CacheProvider** interface is provided, which must be implemented to provide Hibernate with a handle to the cache implementation.

23. @Transactional can be used to wrap an entire function that should be considered as a transaction.

24. ```java
    public interface Notification {
        void notifyUser();
    }
    public class SMSNotification implements Notification {
    
    	@Override
    	public void notifyUser()
    	{
    		// TODO Auto-generated method stub
    		System.out.println("Sending an SMS notification");
    	}
    }
    public class PushNotification implements Notification {
    
    	@Override
    	public void notifyUser()
    	{
    		// TODO Auto-generated method stub
    		System.out.println("Sending a push notification");
    	}
    }
    public class EmailNotification implements Notification {
    
    	@Override
    	public void notifyUser()
    	{
    		// TODO Auto-generated method stub
    		System.out.println("Sending an e-mail notification");
    	}
    }
    
    public class NotificationFactory {
    	public Notification createNotification(String channel)
    	{
    		if (channel == null || channel.isEmpty())
    			return null;
    		switch (channel) {
    		case "SMS":
    			return new SMSNotification();
    		case "EMAIL":
    			return new EmailNotification();
    		case "PUSH":
    			return new PushNotification();
    		default:
    			throw new IllegalArgumentException("Unknown channel "+channel);
    		}
    	}
    }
    
    ```