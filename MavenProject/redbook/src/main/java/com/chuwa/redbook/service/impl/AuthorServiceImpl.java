package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        Author author1 = new Author();
        author1.setName(author.getName());
        author1.setId(author.getId());
        this.authorRepository.save(author1);
        return author1;
    }

    @Override
    public List<Author> getAllAuthor() {
        List<Author> authors = authorRepository.findAll();
        return authors;
    }

    @Override
    public Author getAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        return author;
    }

    @Override
    public Author updateAuthor(Author author, long id) {
        Author target = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        target.setName(author.getName());
        Author response = authorRepository.save(author);
        return response;
    }

    @Override
    public String deleteAuthorById(long id) {
        Author target = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        authorRepository.deleteById(id);
        return "Author with id: " + id + " deleted.";
    }
}