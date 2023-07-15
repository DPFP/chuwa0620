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
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto response = this.postService.createPost(postDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PostDto> getAllPost(){
        return  this.postService.getAllPost();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name="id") long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@PathVariable(name="id") String id, @RequestBody PostDto postDto){
        return ResponseEntity.ok(postService.updatePost(postDto, Long.parseLong(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostDto> deletePostById(@PathVariable(name="id")String id){
        PostDto postDto = postService.deletePostById(Long.parseLong(id));
        return ResponseEntity.ok(postDto);
    }
}
