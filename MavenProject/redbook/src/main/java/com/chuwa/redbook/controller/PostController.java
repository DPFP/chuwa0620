package com.chuwa.redbook.controller;


import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto pto) {
        PostDto response = this.postService.createPost(pto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name="id") long id) {
        PostDto response = this.postService.getPostById(id);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name="id") long id) {
        this.postService.deteleById(id);
        return new ResponseEntity<String>("Deleted Post id: " + id, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@PathVariable(name="id") long id, @RequestBody PostDto pto) {
        PostDto response = this.postService.updatePost(id, pto);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

}
