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
    public ResponseEntity<PostDto> creatPost(@RequestBody PostDto postDto) {
        PostDto response = this.postService.createPost(postDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<PostDto>> getAllPost() {
        return new  ResponseEntity<>(this.postService.getAllPost(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long Id) {
        return ResponseEntity.ok(this.postService.getPostById(Id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(this.postService.updatePostById(postDto, id));
    }

    @DeleteMapping("/{id}")
    public void  deletePostById(@PathVariable(name = "id") long id) {
        this.postService.deletePostById(id);
    }
}
