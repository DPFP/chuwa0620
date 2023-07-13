package com.chuwa.redbook_mongoDB.controller;

import com.chuwa.redbook_mongoDB.payload.PostDto;
import com.chuwa.redbook_mongoDB.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

