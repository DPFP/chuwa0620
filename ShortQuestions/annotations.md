# Annotations

### REST API

- `@RestController`: Marks a class as a REST controller.

- `@RequestMapping`: Maps requests to handling methods. It can be used at both class and method levels. You can specify HTTP methods, URL paths, request parameters, etc. to refine the mapping.

- `@GetMapping`: Maps a `GET` request to a handling method.

- `@PostMapping`: Maps a `POST` request to a handling method.

- `@PutMapping`: Maps a `PUT` request to a handling method.

- `@DeleteMapping`: Maps a `DELETE` request to a handling method.

- `@PatchMapping`: Maps a `PATCH` request to a handling method.

- `@RequestParam`: Retrieves specific values from request parameters and binds them to method parameters.

- `@PathVariable`: Retrieves specific values from the URL path and binds them to method parameters.

- `@RequestBody`: Binds JSON, XML, or other data from the request body to method parameters.

  ```java
  @RestController
  @RequestMapping("/api/v1/posts")
  public class PostController {
      @Autowired
      private PostService postService;

      @PostMapping
      public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
          PostDto response = this.postService.createPost(postDto);
          return new ResponseEntity<>(response, HttpStatus.CREATED);
      }

      @GetMapping
      public List<PostDto> getAllPosts(){
          return postService.getAllPosts();
      }
      @PutMapping("/{id}")
      public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name="id") long id){
          PostDto response = this.postService.updatePost(postDto, id);
          return new ResponseEntity<>(response, HttpStatus.OK);
      }

      @DeleteMapping("/{id}")
      public ResponseEntity<String> deletePost(@PathVariable(name="id") long id){
          postService.deletePostById(id);
          return new ResponseEntity<>("Deleted id: " + id, HttpStatus.OK);
      }
  }
  ```

### JPA Entity Classes

- `@Entity`: Used in JPA entity classes to indicate that the class maps to a table in the database.

- `@Table`: Declare a table in an `Entity` class.

- `@UniqueConstraint`: Specify which coloumn should be unique.

- `@Id`: Mark a column as `id`.

- `@GeneratedValue`: Marked value will be automatically generated.

- `@Column`: Declare a column in an `Entity` class.

- `@CreationTimestamp`: Create timestamp.

- `@UpdateTimestamp`: Update timestamp.

  ```java
  @Entity
  @Table(
          name = "posts",
          uniqueConstraints = {
                  @UniqueConstraint(columnNames = {"title"})
          }
  )
  public class Post {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @Column(name = "title", nullable = false)
      private String title;

      @Column(name = "description", nullable = false)
      private String description;
  }
  ```

### Java

- `@Override`: Mark a function which is overriden.

- `@Test`: Marks a method as a test method.

- `@FunctionalInterface`: Indicates that an interface is a functional interface, which contains only one abstract method.

  ```java
  @FunctionalInterface
  public interface intf{
      public void method();
  }

  public class impl implements intf{
      @Override
      public void method(){
          // do somthing
      }

      @Test
      public void testMethod(){
          // do something
      }
  }
  ```
