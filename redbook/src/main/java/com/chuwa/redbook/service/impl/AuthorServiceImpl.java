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

    private AuthorDto mapAuthorToAuthorDto(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setAge(author.getAge());
        authorDto.setName(author.getName());
        return authorDto;
    }
    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setAge(authorDto.getAge());
        Author savedAuthor = authorRepository.save(author);
        return mapAuthorToAuthorDto(savedAuthor);
    }

    @Override
    public List<AuthorDto> findAllAuthor() {
        List<Author> authors = authorRepository.findAll();
        return(authors.stream().map(this::mapAuthorToAuthorDto).collect(Collectors.toList()));
    }

    @Override
    public AuthorDto findAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        return mapAuthorToAuthorDto(author);
    }

    @Override
    public AuthorDto updateAuthorById(AuthorDto authorDto, long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        author.setAge(authorDto.getAge());
        author.setName(authorDto.getName());
        Author updatedAuthor = authorRepository.save(author);
        return mapAuthorToAuthorDto(updatedAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        authorRepository.delete(author);
    }
}
