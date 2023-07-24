## @Override
```
public class Foo {

    @Override
    public boolean equals(Foo foo) {
        return true;
}
}
```

## @FunctionalInterface
```
@FunctionalInterface
public interface Foo {
public int doSomething();
}

@FunctionalInterface
public interface Bar {

    public int doSomething();

    public default int doSomethingElse() {
        return 1;
    }
}
```


## @Repository
```
@Repository
public interface PostRepository  extends JpaRepository<Post, Long> {
    //Currently no code needed
}

```

## @Entity
```
@Entity
@Table(
        name = "posts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        }
)
```

## @Service
```
@Service
public class PostServiceImpl implements PostService {
    xxx
}
```

## @Controller and @Mapping
```
@Controller
public class PostGraphQLController {
    private final PostService postService;
    public PostGraphQLController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public PostDto postById(@Argument Long id) {
        return postService.getPostById(id);
    }
}
```


## @OneToMany
```
Current class object could contain multiple objects
@OneToMany(mappedBy = "posts", cascade = CascadeType.ALL, orphanRemoval = true)
private Set<Comment> comments = new HashSet<>();
```

## @ManyToOne
```
Current class object could be contained in multiple other objects
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "post_id", nullable = false)
private Post post;
```


## @ManyToMany
```
Current class object could contain multiple objects AND it could be contained in multiple other objects
@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(name = "sku_inventory",
      joinColumns = @JoinColumn(name = "sku_id"),
      inverseJoinColumns = @JoinColumn(name = "inventory_id"))
private Set<PmsInventory> pmsInventories = new HashSet<>();
 ```



## @RestController: Marks a class as a REST controller.

## @RequestMapping: Maps requests to  methods. It can be used at both class and method levels.

## @GetMapping: Maps a `GET` request to a method

## @PostMapping: Maps a `POST` request to a  method.

## @PutMapping: Maps a `PUT` request to a handling method.

## @DeleteMapping: Maps a `DELETE` request to a handling method.

## @PatchMapping: Maps a `PATCH` request to a handling method.

## @RequestParam: Get values from request parameters and use them as method parameters.

## @PathVariable: Get values from the URL path and use them as method parameters.

## @RequestBody: Make data from the request body to method parameters.


## @Configuration: Make a class configuration by itself and will have methods to instantiate and configure the dependencies.

## @Bean: When Spring finds an @Bean annotation, it executes that method and registers the return value as a bean within the ApplicationContext.