package com.chuwa.redbook.controller;

import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorGraphQlController {

    private final AuthorService authorService;

    public AuthorGraphQlController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // untested
    @QueryMapping
    public AuthorDto authorById(@Argument Long id) {
        return authorService.getAuthorById(id);
    }

    @MutationMapping
    public AuthorDto createAuthor(@Argument String firstName, @Argument String lastName, @Argument String birthDate) {
        AuthorDto ato = new AuthorDto();
        ato.setLastName(lastName);
        ato.setFirstName(firstName);
        ato.setBirthDate(birthDate);
        return this.authorService.createAuthor(ato);
    }

    @MutationMapping
    public AuthorDto deleteAuthor(@Argument Long id) {
        AuthorDto authorBeforeDelete = this.authorService.getAuthorById(id);
        this.authorService.deteleById(id);
        return authorBeforeDelete;
    }

    @MutationMapping
    public AuthorDto updateAuthor(@Argument Long id, @Argument String firstName, @Argument String lastName, @Argument String birthDate) {
        AuthorDto ato = new AuthorDto();
        ato.setLastName(lastName);
        ato.setFirstName(firstName);
        ato.setBirthDate(birthDate);
        return this.authorService.updateAuthor(id, ato);
    }
}
