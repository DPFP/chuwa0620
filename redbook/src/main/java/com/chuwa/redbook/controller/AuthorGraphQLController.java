package com.chuwa.redbook.controller;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorGraphQLController {
    private AuthorService authorService;

    public AuthorGraphQLController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @QueryMapping
    public AuthorDto authorById(@Argument long id){
        return authorService.findAuthorById(id);
    }

    @MutationMapping
    public AuthorDto createAuthor(@Argument String name, @Argument int age){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName(name);
        authorDto.setAge(age);
        return authorService.createAuthor(authorDto);
    }
}
