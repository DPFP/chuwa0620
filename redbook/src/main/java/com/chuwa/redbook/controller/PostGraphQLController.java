package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * localhost:8080/graphiql?path=/graphql
 *
 * query postDetail {
 *     postById(id: "5") {
 *         title
 *         content
 *     }
 * }
 */
@Slf4j
@Controller
public class PostGraphQLController {

    private final PostService postService;

    public PostGraphQLController(PostService postService) {
        this.postService = postService;
    }

    @QueryMapping
    public PostDto findPostById(@Argument Long id) {
        log.info("id is", id);
        PostDto postDto = postService.getPostById(id);
        log.info("dto is", postDto);
        return postDto;
    }
}
