package com.chuwa.com.redbook.controller;

import com.chuwa.com.redbook.entity.Post;
import com.chuwa.com.redbook.payload.PostDto;
import com.chuwa.com.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
@RestController
@RequestMapping("api/v1/posts")
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
        return postService.getAllPost();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name="id") long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@PathVariable(name="id") long id, @RequestBody PostDto postDto){
        PostDto postResponse = postService.updatePost(postDto, id);
        return ResponseEntity.ok(postResponse);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable(name="id") long id){
        postService.deletePostById(id);
        // return new ResponseEntity.ok(null);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<PostDto>> getPostByTitle(@PathVariable(name="title") String title) {
        return new ResponseEntity<>(postService.getPostByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/title/contains/{title}")
    public ResponseEntity<List<PostDto>> getPostByTitleContains(@PathVariable(name="title") String title) {
        return new ResponseEntity<>(postService.getPostsByTitleContains(title), HttpStatus.OK);
    }

}








