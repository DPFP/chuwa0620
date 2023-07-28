1. See Annotations.md

2. IDE like intellij have Debug mode which can help developer to debug with following aspects

   1. Break point which can let the program to stop at certain place
   2. Check variables
   3. Monitor change of variables.

   Besides breaking point, debug according to exception, implementation will also help speed up the debug process.

3.  

   1. DTO(Data transfer object) is object that carry data for inter layer communication, e.g. business layer, presentation layer.
   2. VO(Value object) Value object is quite similar, however it normally read-only(By providing only getter function)
   3. Payload is the data object that carrys the important content between Client side and server side.
   4. DO( Data object) is corresponding to database,  it was used by DAO layer.
   5. Model is used by DAO layer which helps the JPA to define the database schema.

4. @JsonProperty is used to auto parse the json object coming from the frontend, rename the object variable name to certain desinated name.

5. Jackson was used to serialized and deserialized between java data structure and json format.

6. Starters are **a set of convenient dependency descriptors that you can include in your application**. You get a one-stop-shop for all the Spring and related technologies that you need without having to hunt through sample code and copy-paste loads of dependency descriptors.

   1.  ![Image](http://www.springboottutorial.com/images/SpringBootStarterWeb-Dependencies.png)

2. Starter-comcat, starter-json

7.   @RequestMapping(value = "/users", method = RequestMethod.GET)

     @RequestMapping(value = "/users", method = RequestMethod.POST) 

     @RequestMapping(value = "/users", method = RequestMethod.DELETE) 

     @RequestMapping(value = "/users", method = RequestMethod.PUT) 

8.  ResponseEntity **represents the whole HTTP response: status code, headers, and body**. As a result, we can use it to fully configure the HTTP response. If we want to use it, we have to return it from the endpoint; Spring takes care of the rest.

9. JDBC ResultSet interface is **used to store the data from the database and use it in our Java Program**. We can also use ResultSet to update the data using updateXXX() methods. ResultSet object points the cursor at before the first row of the result data. Using the next() method, we can iterate through the ResultSet.

   1. Establish a connection with a data source
   2. Send queries and update statements to the data source
   3. Process the results

10. Object Relational Mapping (ORM) is a technique used in creating a "bridge" between object-oriented programs and, in most cases, [relational databases](https://www.freecodecamp.org/news/what-is-a-relational-database-rdbms-definition/).

11. Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory. 

12. ```java
    int[] arr = new int[]{0, 3, 78, 9, 6, 53, 73, 99, 24, 32};
    return Arrays.stream(arr).average().orElse(Integer.NaN);
    ```

13. Done