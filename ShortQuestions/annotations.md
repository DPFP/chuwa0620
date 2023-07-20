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