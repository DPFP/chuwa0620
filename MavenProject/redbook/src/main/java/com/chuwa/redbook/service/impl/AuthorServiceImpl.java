package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.AuthorDto;

import com.chuwa.redbook.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto ato) {
        Author newAuthor = atoToAuthor(ato);
        Author savedAuthor = this.authorRepository.save(newAuthor);
        return authorToAto(savedAuthor);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return this.authorRepository.findAll()
                .stream()
                .map(author -> authorToAto(author))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        return authorToAto(author);
    }



    @Override
    public void deteleById(long id) {
        if (!authorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Author", "id", id);
        }
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto updateAuthor(long id, AuthorDto ato) {
        Author author = this.authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        author.setLastName(ato.getLastName());
        author.setFirstName(ato.getFirstName());
        author.setBirthDate(ato.getBirthDate());
        Author updatedAuthor = authorRepository.save(author);
        return authorToAto(updatedAuthor);
    }

    @Override
    public List<AuthorDto> getAuthorsBetweenID(long id1, long id2) {
        List<Author> authors = this.authorRepository.findAuthorByIdBetween(id1,id2);
        return authors.stream().map(author -> authorToAto(author)).collect(Collectors.toList());
    }

    private static Author atoToAuthor(AuthorDto ato) {
        Author newAuthor = new Author();
        newAuthor.setBirthDate(ato.getBirthDate());
        newAuthor.setFirstName(ato.getFirstName());
        newAuthor.setLastName(ato.getLastName());
        return newAuthor;
    }

    private static AuthorDto authorToAto(Author author) {
        AuthorDto response = new AuthorDto();
        response.setId(author.getId());
        response.setBirthDate(author.getBirthDate());
        response.setFirstName(author.getFirstName());
        response.setLastName(author.getLastName());
        return response;
    }

}
