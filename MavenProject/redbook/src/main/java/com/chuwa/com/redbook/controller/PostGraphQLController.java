package com.chuwa.com.redbook.controller;

import com.chuwa.com.redbook.payload.PostDto;
import com.chuwa.com.redbook.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class PostGraphQLController {

    private final PostService postService;

    public PostGraphQLController(PostService postService){
        this.postService = postService;
    }

    @QueryMapping
    public ResponseEntity<PostDto> postById(@Argument long id){
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @MutationMapping
    public PostDto createPost(@Argument String title, @Argument String description, @Argument String content){
        PostDto postDto = new PostDto();
        postDto.setContent(content);
        postDto.setDescription(description);
        postDto.setTitle(title);
        return postService.createPost(postDto);
    }
}
