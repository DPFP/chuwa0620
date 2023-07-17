package com.chuwa.redbook.service;

import com.chuwa.redbook.payload.AuthorDto;

import java.util.List;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto ato);

    List<AuthorDto> getAllAuthors();

    AuthorDto getAuthorById(long id);

    void deteleById(long id);

    AuthorDto updateAuthor(long id, AuthorDto author);

}
