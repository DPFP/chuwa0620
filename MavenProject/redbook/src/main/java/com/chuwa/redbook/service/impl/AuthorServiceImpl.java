package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/16/23$
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.getName());
        Author savedAuthor = this.authorRepository.save(author);
        return authorToDTO(savedAuthor);
    }

    public AuthorDto authorToDTO(Author author){
        AuthorDto response = new AuthorDto();
        response.setId(author.getId());
        response.setName(author.getName());
        return response;
    }

    @Override
    public List<AuthorDto> getAllAuthor() {
        List<Author> authorDtos = authorRepository.findAll();
        return authorDtos.stream().map(this::authorToDTO).collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ResourceName:Author", "FieldName:id", id));
        return authorToDTO(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ResourceName:Author", "FieldName:id", id));
        author.setName(authorDto.getName());
        Author updatedAuthor = authorRepository.save(author);
        return authorToDTO(updatedAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ResourceName:Author", "FieldName:id", id));
        authorRepository.delete(author);
    }
}
