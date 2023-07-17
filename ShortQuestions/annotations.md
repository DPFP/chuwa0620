# Annotations

## REST Api

@RestController: Mark this class as a REST controller
```java
@RestController
public class ExampleController{
    return null;
}
```

@RequestMapping: map HTTP requests to specific handler methods in the controller class.
```java
@RestController
@RequestMapping("api/v1/posts")
public class ExampleController{
    //
}
```

@GetMapping: map get request to handling method
```java
@RestController
public class ExampleController{
    @GetMapping("/example")
    public String handleGetRequest() {
        return "This is a GET request";
    }
}
```

@PostMapping: map post request to handling method
```java
@RestController
public class ExampleController{
    @PostMapping("/example")
    public String handlePostRequest() {
        return "This is a Post request";
    }
}
```

@PutMapping: map put(update) request to handling method
```java
@RestController
public class ExampleController{
    @PutMapping("/example")
    public String handlePutRequest() {
        return "This is a Post request";
    }
}
```

@DeleteMapping: map delete request to handling method
```java
@RestController
public class ExampleController{
    @DeleteMapping("/example")
    public String handleDeleteRequest() {
        return "This is a Delete request";
    }
}
```

@PathVariable: extract path variable from request URL and bind them to method parameters
```java
@RestController
public class ExampleController{
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(postService.getPostById(id),HttpStatus.OK);
    }
}
```

@RequestBody: bind the request body to a method parameter
```java
@RestController
public class ExampleController{
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto response = this.postService.createPost(postDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
```

