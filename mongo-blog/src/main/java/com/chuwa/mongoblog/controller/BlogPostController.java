package com.chuwa.mongoblog.controller;


import com.chuwa.mongoblog.entity.BlogPost;
import com.chuwa.mongoblog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/blog-post")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody BlogPost blogPost) {
        blogPostService.PostBlog(blogPost);

        return new ResponseEntity<>("succeed", HttpStatus.CREATED);
    }
}
