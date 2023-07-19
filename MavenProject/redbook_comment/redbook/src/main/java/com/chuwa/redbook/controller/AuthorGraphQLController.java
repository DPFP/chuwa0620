package com.chuwa.redbook.controller;


import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.AuthorService;
import com.chuwa.redbook.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


public class AuthorGraphQLController {
    private final AuthorService authorService;

    public AuthorGraphQLController(AuthorService authorService){
        this.authorService = authorService;
    }


    public Author postById(@Argument Long id){
        return authorService.getAuthorById(id);
    }


    public Author createPost(@Argument String name){
        Author author = new Author();
        author.setName(name);
        return author;
    }
}
