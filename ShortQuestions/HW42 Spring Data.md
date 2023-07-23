# HW42 Spring Data
**4. what is JPA? and what is Hibernate?**
JPA (Java Persistence API):
JPA is a specification provided by Java EE (Java Platform, Enterprise Edition) for defining a standard way to interact with relational databases using Java objects. It defines a set of interfaces and annotations that developers can use to define the mapping between Java classes and database tables.

Hibernate:
Hibernate is an implementation of the JPA specification and is one of the most popular ORM frameworks in the Java ecosystem. It simplifies the task of database interaction by abstracting away the low-level JDBC (Java Database Connectivity) code and allowing developers to work with Java objects directly. Hibernate takes care of translating Java objects to relational database structures and vice versa, making the data persistence process more manageable and efficient.

**5. What is Hiraki? what is the benefits of connection pool?**
Hiraki is a connection pooling which allows the application to maintain a pool of already established connections that can be reused when needed.

Connection pooling is a widely used technique in modern applications to optimize database interaction, improve performance, and enhance resource management. It is commonly implemented in various programming languages and frameworks, and many databases support it.

**6. What is the  @OneToMany, @ManyToOne, @ManyToMany? write some examples.**
@OneToMany, @ManyToOne, and @ManyToMany are annotations used in object-relational mapping (ORM) frameworks like Java Persistence API (JPA) and Hibernate to define relationships between entities in a relational database.

- @OneToMany:
The @OneToMany annotation is used to represent a one-to-many relationship between two entities. It implies that one instance of the source entity is associated with multiple instances of the target entity. In terms of the database, this is usually implemented using a foreign key in the target entity's table pointing back to the primary key of the source entity's table.
```
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy = "author")
    private List<Book> books;
    
}

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    
    private String title;
    
    @ManyToOne
    private Author author;
    
}
```

- @ManyToOne:
The @ManyToOne annotation is used to specify a many-to-one relationship between two entities. It means multiple instances of the source entity can be associated with a single instance of the target entity.

Example is same as above.

- @ManyToMany:
The @ManyToMany annotation is used to represent a many-to-many relationship between two entities. This implies that multiple instances of the source entity can be associated with multiple instances of the target entity. In the database, a separate join table is typically created to manage this relationship.
```
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    // Other user properties and relationships

    @ManyToMany
    @JoinTable(name = "user_group",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<Group> groups = new HashSet<>();

    // Constructors, getters, and setters
}

@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Other group properties and relationships

    @ManyToMany(mappedBy = "groups")
    private Set<User> members = new HashSet<>();

    // Constructors, getters, and setters
}

```

**7. What is the  cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?**
cascade = CascadeType.ALL:
When you define a relationship between two entities (e.g., parent and child entities), the cascade attribute specifies how the operations performed on the parent entity should be propagated to its related child entities. CascadeType.ALL means that all operations (including persist, remove, merge, detach, and refresh) on the parent entity will be cascaded to its child entities.

orphanRemoval = true:
The orphanRemoval attribute, when set to true, allows the ORM framework to automatically remove child entities that are no longer associated with any parent entity. This means that when you remove a child entity from the collection in the parent entity or set the relationship to null, the orphaned child entity will be deleted from the database.

Other CascadeType options in JPA are:
- CascadeType.PERSIST: Cascades the persist operation to the associated child entities. When you persist the parent entity, the child entities will also be persisted.

- CascadeType.MERGE: Cascades the merge operation to the associated child entities. When you merge the parent entity, the child entities will also be merged.

- CascadeType.REMOVE: Cascades the remove operation to the associated child entities. When you remove the parent entity, the child entities will also be removed.

- CascadeType.DETACH: Cascades the detach operation to the associated child entities. When you detach the parent entity, the child entities will also be detached.

- CascadeType.REFRESH: Cascades the refresh operation to the associated child entities. When you refresh the parent entity, the child entities will also be refreshed.

**8. What is the  fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the 
difference? In which situation you choose which one?**
They are annotations used in Java Persistence API (JPA) to define the fetching strategy for related entities in a JPA entity relationship.

- fetch = FetchType.LAZY:
related entities are loaded from the database only when they are explicitly accessed or referenced in the code. In other words, the related entities are fetched lazily, meaning they are not loaded immediately along with the parent entity. Instead, the related entities are fetched from the database on-demand, when the application code tries to access them. This can help improve performance by avoiding unnecessary database queries for related entities that might not be used.

- fetch = FetchType.EAGER
With this option, related entities are loaded immediately along with the parent entity. When the parent entity is retrieved from the database, the related entities are also fetched in a single query. This can be convenient because you have all the necessary data available in memory, but it may cause performance issues if you have a large number of related entities or if the related entities themselves have more associations, leading to a "n+1" query problem.

Lazy fetching (fetch = FetchType.LAZY) is generally preferred when you have relationships that might not be used frequently or when loading the related entities could be expensive in terms of performance. This helps avoid unnecessary data retrieval and can lead to more efficient database queries.

Eager fetching (fetch = FetchType.EAGER) is useful when you know that you will consistently need the related entities every time you retrieve the parent entity, and you want to avoid additional queries to fetch related data during runtime.

In many scenarios, it's a good practice to use lazy fetching by default, and only switch to eager fetching for specific relationships where you know that eager loading is more appropriate. It's important to profile and analyze the application's behavior to determine the best fetching strategy based on the actual usage patterns and performance requirements.

**9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?**
The method naming convention plays a crucial role in defining queries based on method names without having to write explicit JPQL (Java Persistence Query Language) or SQL queries. This convention allows you to create dynamic queries by simply defining method names in specific formats. 
The rule for the method naming convention is as follows:
- Method Prefix: The method name should start with a prefix that indicates the type of operation you want to perform. Some common prefixes include:
- findBy: Used to retrieve entities based on specific attributes.
- countBy: Used to count entities based on specific attributes.
- deleteBy: Used to delete entities based on specific attributes.
- Property Expression: After the prefix, you should add the name of the entity's property (field) you want to use for filtering or sorting.

Query Keyword: If you want to filter the results using a specific condition, you can add a query keyword to the method name. Some common query keywords include:
- Is, Equals: Used for exact match.
- Like: Used for partial string matching.
- Not: Used for negation.
- In: Used to match any of the specified values.
- GreaterThan, LessThan: Used for numeric comparisons.
- After, Before: Used for date comparisons.
- Optional Logical Operators: You can chain multiple properties using logical operators like And and Or.

Optional Ordering: To specify the order in which you want the results to be sorted, you can append OrderBy followed by the property name for sorting.

Here are some examples to illustrate the JPA method naming convention:
```
// Example 1: Find all employees with a given name
List<Employee> findByFirstName(String firstName);

// Example 2: Find all employees whose age is greater than a given value
List<Employee> findByAgeGreaterThan(int age);

// Example 3: Count the number of employees with a specific job title
long countByJobTitle(String jobTitle);

// Example 4: Delete employees with a certain salary
void deleteBySalary(double salary);

// Example 5: Find all employees whose name contains a specific substring and age is less than a given value
List<Employee> findByFirstNameContainingAndAgeLessThan(String substring, int age);

// Example 6: Find all employees whose department is either 'HR' or 'Finance', ordered by their salary in descending order
List<Employee> findByDepartmentInOrderBySalaryDesc(List<String> departments);
```

**14. What is JPQL?**
JPQL provides a way to perform database queries using object-oriented concepts, similar to SQL, but operates on entity objects and their attributes rather than on database tables and columns. It allows developers to express queries in terms of the entity model rather than database-specific structures.

**15. What is @NamedQuery and @NamedQueries?**
@NamedQuery is used to define a single named query for an entity class. A named query is a static, pre-defined SQL-like query that can be referred to by its unique name in the application code. Named queries are useful when you want to encapsulate complex or frequently used queries, which can then be easily executed by their names.

@NamedQueries is used to define multiple named queries for an entity class. This annotation allows you to group multiple @NamedQuery annotations together within the same entity class.

**16. What is @Query? In which Interface we write the sql or JPQL?**
@Query is an annotation used to specify custom queries for database operations in JPA repositories. JPA is a specification for mapping Java objects to relational database tables and is commonly used in Java-based applications to interact with databases.

SQL is written in the JDBC interface for direct database access without an ORM.
JPQL is used in JPA implementations for ORM-based database interactions.

**17.  What is HQL and Criteria Queries?**
HQL is a powerful and expressive query language provided by Hibernate. It operates on persistent objects and their properties instead of database tables and columns. With HQL, you can perform database operations in a more object-oriented way, abstracting away the underlying database-specific details.

Criteria Queries provide an alternative way to build dynamic queries in Hibernate using a programmatic approach. It allows you to create query criteria as objects and avoid writing raw HQL or SQL queries. Criteria Queries are type-safe, which means you get compile-time checks and better refactoring support.

**18. What is EnityManager?**
EntityManager is a core interface that serves as the primary interface for interacting with the underlying database using object-relational mapping (ORM) techniques. It is part of the Java Persistence API and is used to perform various CRUD (Create, Read, Update, Delete) operations on database entities.

**19. What is SessionFactory and Session?**
SessionFactory is an important component in Hibernate that represents a factory for creating Session objects. It is responsible for bootstrapping Hibernate and initializing various settings related to database connections and mapping configurations. The SessionFactory is typically created once during the application startup and shared across the entire application. It is a thread-safe object and provides a cache of compiled mappings for better performance.

Session represents a single unit of work with the database and acts as an interface between the Java application and the database. It is used to perform CRUD (Create, Read, Update, Delete) operations on persistent objects, as well as to execute queries against the database. Each Session should be used for a specific and well-defined task and then closed after completion.

**20.What is Transaction? how to manage your transaction?**
A transaction is a logical unit of work that consists of one or more database operations. These operations are treated as a single, indivisible unit, which means they will either all succeed or all fail. Transactions are crucial for maintaining data integrity and consistency in a database system.

How to manage transactions using JPA:
- Enable Transaction Management:
In your Spring Boot application's main class or configuration class, enable transaction management by adding the @EnableTransactionManagement annotation:

- Define Transactional Methods:
Annotate the methods that need to be executed within a transactional context with the @Transactional annotation. This annotation can be applied at the class or method level, depending on your requirements.

- Handle Exception and Rollback

**21. What is hibernate Caching?**
- First-level cache (Session cache):
Also known as the session cache, it is the default and most basic level of caching provided by Hibernate.
When an entity is retrieved or loaded using a Session, Hibernate stores the object in the first-level cache. If the same entity is requested again during the same session, Hibernate returns the cached object rather than querying the database again.

- Second-level cache (SessionFactory cache):
The second-level cache is shared among all Session instances within a Hibernate SessionFactory.
It allows caching data across multiple sessions and even across different parts of the application, providing a broader scope for caching.
When data is retrieved from the database, it is stored in the second-level cache. Subsequent requests for the same data from any session can be satisfied from this cache, avoiding the need to go to the database.

**22. What is the difference between first-level cache and second-level cache?**
First-level cache is specific to a Hibernate Session, providing entity caching within a single session's boundaries.
Second-level cache is shared across multiple Session instances, enabling caching at the application level and serving as a global cache for frequently accessed data.

**23. How do you understand @Transactional?**
@Transactional is an annotation used to define the transactional behavior of methods or classes. Transactions are used to ensure data consistency and integrity in a database by grouping a set of database operations into a single unit of work. If any part of the transaction fails, the whole transaction is rolled back, and the database returns to its original state before the transaction started.

**24. Write a simple factory design pattern**
```
public interface Shape {
    void draw();
}

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a triangle");
    }
}

public class ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase("triangle")) {
            return new Triangle();
        }

        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.createShape("circle");
        circle.draw(); // Output: Drawing a circle

        Shape square = shapeFactory.createShape("square");
        square.draw(); // Output: Drawing a square

        Shape triangle = shapeFactory.createShape("triangle");
        triangle.draw(); // Output: Drawing a triangle
    }
}

```