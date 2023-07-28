package com.chuwa.redbook.service.Impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private static AuthorDto getAuthorDto(Author author){
        AuthorDto response = new AuthorDto();

        response.setId(author.getId());
        response.setAge(author.getAge());
        response.setFirstName(author.getFirstName());
        response.setLastName(author.getLastName());
        return response;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author newAuthor = new Author();
        newAuthor.setAge(authorDto.getAge());
        newAuthor.setId(authorDto.getId());
        newAuthor.setFirstName(authorDto.getFirstName());
        newAuthor.setLastName(authorDto.getLastName());

        Author savedAuthor = this.authorRepository.save(newAuthor);
        AuthorDto response = getAuthorDto(newAuthor);
        return response;
    }

    @Override
    public List<AuthorDto> getAllAuthor() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(author -> getAuthorDto(author))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        return getAuthorDto(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        author.setLastName(authorDto.getLastName());
        author.setAge(authorDto.getAge());
        author.setFirstName(authorDto.getFirstName());

        Author updateAuthor = authorRepository.save(author);

        return getAuthorDto(updateAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        authorRepository.delete(author);
    }
}
