@RestController: Mark this class as a REST controller
@RequestMapping: map HTTP requests to specific handler methods in the controller class.
@GetMapping: map get request to handling method
@PostMapping: map post request to handling method
@PutMapping: map put(update) request to handling method
@DeleteMapping: map delete request to handling method
@PathVariable: extract path variable from request URL and bind them to method parameters
@RequestBody: bind the request body to a method parameter
@UniqueConstraint: specify that one or more columns in a table should have unique values. It helps enforce data integrity rules by ensuring that duplicate values are not allowed in the specified columns
@Table: define the table
@GeneratedValue: provides different strategies to automatically generate primary key values.
@Column: define a column in the database with name and proporities
@CreationTimeStamp: automatically populate a timestamp or date field with the current date and time when an entity is created and persisted in the database.
@UpdateTimestamp: automatically update a timestamp or date field with the current date and time whenever an entity is updated and persisted in the database.