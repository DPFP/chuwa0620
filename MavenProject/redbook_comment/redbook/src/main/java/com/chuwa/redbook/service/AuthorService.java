package com.chuwa.redbook.service;

import com.chuwa.redbook.entity.Author;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author author);

    List<Author> getAllAuthor();

    Author getAuthorById(long id);

    Author updateAuthor(Author author, long id);

    String deleteAuthorById(long id);
}
