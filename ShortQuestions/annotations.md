## Entity
1. `@Entity`, `@Table`
    ```java
    @Entity
    @Table(
            name = "posts",
            uniqueConstraints =  {
                    @UniqueConstraint(columnNames = {"title"})
            }
    )
    ```
2. `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)`, `@Column(name = "description", nullable = false)`, `@CreationTimestamp`
    ```java
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @CreationTimestamp
    private LocalDateTime createDateTime;
    ```
3. `@OneToMany`: Current class object may contains multiple objects of another class
 ```java
 @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL, orphanRemoval = true)
 private Set<Comment> comments = new HashSet<>();
 ```
4. `@ManyToOne`: Current class objects may be included into on objects of another class
 ```java
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "post_id", nullable = false)
 private Post post;
 ```
5. `@ManyToMany`: Current class object may contains multiple objects of another class, and vice versa
 ```java
     @ManyToMany(fetch = FetchType.LAZY)
     @JoinTable(name = "sku_inventory",
             joinColumns = @JoinColumn(name = "sku_id"),
             inverseJoinColumns = @JoinColumn(name = "inventory_id"))
     private Set<PmsInventory> pmsInventories = new HashSet<>();
 ```
## Controller
1. `@RestController`, `@RequestMapping("/api/v1/posts")`, `@Autowired`, `@PostMapping`
    ```java
    @RestController
    @RequestMapping("/api/v1/posts")
    public class PostController {
    
        @Autowired
        private PostService postService;
    
        @PostMapping
        public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO postDTO) {
            PostDTO postResponse = postService.createPost(postDTO);
    
            return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
        }
    }
    ```
2. `@GetMapping`: GET endpoint
   ```java
   @GetMapping
   public List<PostDTO> getPost() {
   return postService.getPosts();
   ```
3. `@PutMapping`: PUT endpoint
   ```java
   @PutMapping("/{id}")
   public ResponseEntity<PostDTO> updatePostById(@RequestBody PostDTO postDTO, @PathVariable(name = "id") Long id) {
           PostDTO postResponse = postService.updatePost(postDTO, id);
           return new ResponseEntity<>(postResponse, HttpStatus.OK);
           }
   ```
4. `@DeleteMapping`: DELETE endpoint
   ```java
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deletePost(@PathVariable(name = "id") Long id) {
           postService.deletePostById(id);
           return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
           }
   ```
## Repository
1. `@Repository`
    ```java
    @Repository
    public interface PostRepository extends JpaRepository<Post, Long> {
        // no need to write anything here (yet)
    }
    ```
   
### Service
1. `Service`
   ```java
   @Service
   public class PostServiceImpl implements PostService {
   ...
   }
   ```
