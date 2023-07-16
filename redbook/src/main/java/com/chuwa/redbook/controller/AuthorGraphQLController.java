package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.AuthorService;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * localhost:8080/graphiql?path=/graphql
 *
 * query authorDetail {
 *     authorById(id: "1") {
 *         gender
 *     }
 * }
 */
@Controller
public class AuthorGraphQLController {

    @Autowired
    private AuthorService authorService;

    @QueryMapping
    public AuthorDto findAuthorById(@Argument Long id) {
        return authorService.getAuthorById(id);
    }
}
