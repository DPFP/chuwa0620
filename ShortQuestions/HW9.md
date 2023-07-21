#### 1. List all of the new annotations to your annotaitons.md and explain its role.

#### 2. How do you do the debug?

打断点，单步调试并且查看变量的变化

#### 3. What is DTO, VO, Payload, DO, model?



#### 4. What is @JsonProperty("description_yyds") (不会的话，课上问)?

#### 5. Do you know what is jackson?

```Java
<dependency>
<groupId>com.fasterxml.jackson.core</groupId>
<artifactId>jackson-databind</artifactId>
<version>2.13.3</version>
<scope>compile</scope>
</dependency>
```

Jackson is an open-source library for Java that allows you to convert Java objects to JSON objects and vice vers

#### 6. What is spring-boot-stater?

a. what dependecies in the below starter? do you know any starters?



#### 7. Do you know @RequestMapping(value = "/users", method =RequestMethod.POST) ? could you list CRUD by this style?

- Create (POST)

  - ```Java
    @RequestMapping(value = "/users", method =RequestMethod.POST)
    public User createUser(@RequestBody User user){
        
    }
    ```

- Read (GET)

  - ```Java
    @RequestMapping(value = "/users/{id}", method =RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        
    }
    ```

- Update (PUT)

  - ```Java
    @RequestMapping(value = "/users/{id}", method =RequestMethod.PUT)
    public User updateUser((@PathVariable Long id){
        
    }
    ```

- Delete (DELETE)

  - ```Java
    @RequestMapping(value = "/users/{id}", method =RequestMethod.DELETE)
    public void deleteUser((@PathVariable Long id){
        
    }
    ```

#### 8. What is `ResponseEntity`? why do we need it?

`ResponseEntity` **represents the whole HTTP response: status code, headers, and body**. As a result, we can use it to fully configure the HTTP response.



```Java
@GetMapping("/users/{id}")
public ResponseEntity<User> getUser(@PathVariable Long id) {
    User user = userService.findUser(id);
    if (user == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

```



#### 9. What is `ResultSet` in jdbc? and describe the flow how to get data using JDBC

`ResultSet` 是JDBC（Java Database Connectivity）API中的一个对象，它表示SQL查询的结果。你可以通过遍历 `ResultSet` 来获取查询返回的数据。

使用JDBC获取数据的流程如下：

1. **加载JDBC驱动**：使用 `Class.forName()` 方法加载驱动，建立Java程序和数据库之间的连接。
2. **创建连接**：加载驱动后，使用 `DriverManager.getConnection()` 方法建立数据库连接。
3. **创建语句**：从连接中创建一个 `Statement` 对象，用于执行SQL查询。
4. **执行查询**：使用 `Statement` 对象执行SQL查询，这将返回一个 `ResultSet`。
5. **处理ResultSet**：遍历 `ResultSet` 来获取查询返回的数据。
6. **关闭连接**：当你完成数据处理后，应关闭连接以释放数据库资源

```Java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/databaseName";
        String username = "username";
        String password = "password";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 创建连接
            connection = DriverManager.getConnection(url, username, password);

            // 创建语句
            statement = connection.createStatement();

            // 执行查询并获取结果
            resultSet = statement.executeQuery("SELECT * FROM tableName");

            // 处理结果
            while (resultSet.next()) {
                System.out.println(resultSet.getString("columnName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

```



#### 10. What is the ORM framework?

ORM (Object-Relational Mapping)allows developers to interact with their database in an object-oriented manner. In Java, ORM frameworks like 

- Hibernate,
- JPA (Java Persistence API), 
- or Spring Data JPA are used. 

They map Java objects to database tables (and vice versa), so developers can perform create, read, update, and delete (CRUD) operations on objects rather than writing SQL queries. This can greatly simplify the development process and improve code maintainability.

ORM（对象关系映射）许开发人员以面向对象的方式与数据库进行交互。在 Java 中，使用 Hibernate、JPA（Java Persistence API）或 Spring Data JPA 等 ORM 框架。

它们将 Java 对象映射到数据库表（反之亦然），因此开发人员可以对对象执行创建、读取、更新和删除 (CRUD) 操作，而不用编写 SQL 查询。这样可以大大简化开发流程，提高代码的可维护性。

#### 11. Learn how to use ObjectMapper by this example.

https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-cor
e/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java

```Java
FoodOutlet foodOutlet =
objectMapper.readValue(resBody, FoodOutlet.class);
String s =
objectMapper.writeValueAsString(foodOutlet);
objectMapper.readTree() // learn how to use it?
```



#### 12. What is the serialization and desrialization?

a. https://hazelcast.com/glossary/serialization/

#### 13. Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

```Java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
        double average = Arrays
            .stream(array)
            .average()
            .orElse(0);
        System.out.println("Average: " + average);
    }
}

```



#### 14. 抄写，https://github.com/TAIsRich/springbootredbook/tree/03_post_pageable，你也可以像我⼀样分branch添加新代码。

#### 15. (Optional) 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comment你也可以像我⼀样分branch添加新代码

#### 16. (Optional)Try to write the CRUD api for a new application Cassandra-Blog

a. spring 提供了相关dependency,(https://start.spring.io/)

i. Spring Data for Apache Cassandra
b. Cassandra⼗分流⾏，且⾯试问的多。