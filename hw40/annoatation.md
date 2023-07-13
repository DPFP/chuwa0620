# Annotations Used by Entities

## @Entity
- Usage: Specifies that the class is an entity and is mapped to a database table.
- Explanation: This annotation is used to mark a class as an entity, allowing it to be persisted to a database table.

## @Table
- Usage: Specifies the details of the database table to which an entity is mapped.
- Explanation: This annotation allows you to customize the name and other properties of the table associated with an entity.

## @Column
- Usage: Specifies the mapping between an entity attribute and a database column.
- Explanation: This annotation is used to define the mapping of a specific attribute to a database column, including the column name, data type, and constraints.

## @Id
- Usage: Specifies the primary key attribute of an entity.
- Explanation: This annotation designates the attribute as the primary key of the entity.

## @GeneratedValue
- Usage: Specifies the generation strategy for the primary key values.
- Explanation: This annotation defines the strategy for generating primary key values, such as using auto-increment, sequences, or UUIDs.

## @OneToMany
- Usage: Establishes a one-to-many association between two entities.
- Explanation: This annotation is used to define a one-to-many relationship between two entities, where one entity has a collection of related entities.

## @ManyToOne
- Usage: Establishes a many-to-one association between two entities.
- Explanation: This annotation is used to define a many-to-one relationship between two entities, where multiple entities are associated with a single entity.

# Annotations Used by Controllers

## @RestController
- Usage: Marks a class as a RESTful controller.
- Explanation: This annotation is used to indicate that a class serves as a RESTful controller, allowing it to handle HTTP requests and produce JSON/XML responses.

## @RequestMapping
- Usage: Maps HTTP requests to controller methods.
- Explanation: This annotation is used to map specific HTTP requests to methods in a controller, specifying the URL path, HTTP method, and other details.

## @PathVariable
- Usage: Extracts a variable from the URL path.
- Explanation: This annotation is used to bind a method parameter to a variable extracted from the URL path, allowing access to dynamic values in the request URL.

## @RequestParam
- Usage: Retrieves request parameters from the URL query string or form data.
- Explanation: This annotation is used to bind a method parameter to a request parameter, extracting its value from the query string or form data.

## @RequestBody
- Usage: Binds the request body to a method parameter.
- Explanation: This annotation is used to bind the request body to a method parameter, allowing access to the data sent in the request body, typically in JSON or XML format.

## @PostMapping
- Usage: Handles HTTP POST requests.
- Explanation: This annotation is used to map a method to handle HTTP POST requests, specifying the URL path and other details.

## @GetMapping
- Usage: Handles HTTP GET requests.
- Explanation: This annotation is used to map a method to handle HTTP GET requests, specifying the URL path and other details.

