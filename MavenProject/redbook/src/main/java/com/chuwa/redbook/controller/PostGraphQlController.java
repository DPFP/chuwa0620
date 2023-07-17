package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PostGraphQlController {

    private final PostService postService;

    public PostGraphQlController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public PostDto postById(@Argument Long id) {
        return postService.getPostById(id);
    }

    @MutationMapping
    public PostDto createPost(@Argument String title, @Argument String description, @Argument String content) {
        PostDto pto = new PostDto();
        pto.setDescription(description);
        pto.setContent(content);
        pto.setTitle(title);
        return this.postService.createPost(pto);
    }
}
