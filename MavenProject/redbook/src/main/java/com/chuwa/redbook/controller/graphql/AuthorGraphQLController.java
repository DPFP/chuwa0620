package com.chuwa.redbook.controller.graphql;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.AuthorService;
import com.chuwa.redbook.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class AuthorGraphQLController {
    private final AuthorService authorService;

    @QueryMapping
    public AuthorDto authorById(@Argument Long id){
        return authorService.getAuthorById(id);
    }

    @MutationMapping
    public ResponseEntity createAuthor(
            @Argument AuthorDto authorDto) {
        AuthorDto response = this.authorService.createAuthor(authorDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
