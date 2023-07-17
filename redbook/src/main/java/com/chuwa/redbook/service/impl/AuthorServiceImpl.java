package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = convertToAuthor(authorDto);
        Author newAuthor = authorRepository.save(author);
        return convertToAuthorDto(newAuthor);
    }

    @Override
    public List<AuthorDto> getAllAuthor() {
        List<Author> authors = authorRepository.findAll();

        return authors.stream().map(this::convertToAuthorDto).collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("author not found", "author with", id));
        return convertToAuthorDto(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("author not found", "author with", id));

        if (author.getName() != null) {
            author.setName(authorDto.getName());
        }
        if (authorDto.getGender() != null) {
            author.setGender(authorDto.getGender());
        }
        if (authorDto.getAge() != null) {
            author.setAge(authorDto.getAge());
        }

        Author updateAuthor = authorRepository.save(author);

        return convertToAuthorDto(updateAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        Author author = authorRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("author not found", "author with", id));
        authorRepository.delete(author);
    }

    private Author convertToAuthor(AuthorDto authorDto) {
        Author author = new Author();
        BeanUtils.copyProperties(authorDto, author);
        return author;
    }

    private AuthorDto convertToAuthorDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        BeanUtils.copyProperties(author, authorDto);
        return authorDto;
    }
}
