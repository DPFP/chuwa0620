package chuwa.learning.mongoblog.controller;

import chuwa.learning.mongoblog.dao.PostRepository;
import chuwa.learning.mongoblog.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") long id) {
        return postRepository.findById(String.valueOf(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        post.setPostTime(LocalDateTime.now());
        post.setUpdateTime(LocalDateTime.now());
        Post savePost = postRepository.save(post);
        return ResponseEntity.ok(savePost);
    }
}