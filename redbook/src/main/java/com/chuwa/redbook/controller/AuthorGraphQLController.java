package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorGraphQLController {
    private final AuthorService authorService;

    public AuthorGraphQLController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public AuthorDto authorById(@Argument Long id){
        return authorService.getAuthorById(id);
    }

    @MutationMapping
    public AuthorDto createAuthor(@Argument String username, @Argument Integer age){
        AuthorDto authorDto = new AuthorDto();

        authorDto.setUsername(username);
        authorDto.setAge(age);

        return authorService.createAuthor(authorDto);
    }
}
