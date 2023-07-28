package com.chuwa.redbook.controller;


import com.chuwa.redbook.entity.Author;

import com.chuwa.redbook.service.AuthorService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorGraphqlController {
    private final AuthorService authorService;

    public AuthorGraphqlController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public Author postById(@Argument Long id) {
        return authorService.getAuthorById(id);
    }

    @MutationMapping
    public Author createPost(@Argument String name) {
        Author author = new Author();
        author.setName(name);
        return author;
    }
}