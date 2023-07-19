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