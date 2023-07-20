package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = DtoToAuthor(authorDto);
        Author newAuthor = authorRepository.save(author);

        AuthorDto authorResponse = authorToDto(newAuthor);
        return authorResponse;
    }


    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> authorDto = new ArrayList<>();
//        for(Author author : authors){
//            AuthorDto response = authorToDto(author);
//
//            authorDtos.add(response);
//
//        }
//        return authorDtos;
        return authors.stream().map(author -> authorToDto(author)).collect(Collectors.toList());    }

    @Override
    public AuthorDto getAuthorById(long id) {

        //        Author author = authorRepository.findById(id).get();
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        return authorToDto(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        author.setName(authorDto.getName());

        Author updatedAuthor = authorRepository.save(author);
        return authorToDto(updatedAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        authorRepository.delete(author);
    }


    private static AuthorDto authorToDto(Author author) {
        AuthorDto response = new AuthorDto();
        response.setId(author.getId());
        response.setName(author.getName());
        return response;
    }

    private static Author DtoToAuthor(AuthorDto authorDto){
        Author author = new Author();
        author.setName(authorDto.getName());

        return author;
    }
}
