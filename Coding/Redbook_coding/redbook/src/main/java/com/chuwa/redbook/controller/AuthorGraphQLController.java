package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

public class AuthorGraphQLController {
    private final AuthorService authorService;

    public AuthorGraphQLController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public AuthorDto authorById(@Argument long id) {
        return  authorService.getAuthorById(id);
    }

    @MutationMapping
    public AuthorDto createAuthor(@Argument String name, @Argument String birthday) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName(name);
        authorDto.setBirthday(birthday);
        return authorService.createAuthor(authorDto);
    }
}
