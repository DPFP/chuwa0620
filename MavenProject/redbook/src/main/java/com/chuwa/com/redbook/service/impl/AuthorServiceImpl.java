package com.chuwa.com.redbook.service.impl;

import com.chuwa.com.redbook.dao.AuthorRepository;
import com.chuwa.com.redbook.entity.Author;
import com.chuwa.com.redbook.entity.Post;
import com.chuwa.com.redbook.exception.ResourceNotFoundException;
import com.chuwa.com.redbook.payload.AuthorDto;
import com.chuwa.com.redbook.payload.PostDto;
import com.chuwa.com.redbook.service.AuthorService;
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
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = mapToEntity(authorDto);
        authorRepository.save(author);
        return mapToDTO(author);
    }

    @Override
    public List<AuthorDto> getAllAuthor() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(author -> mapToDTO(author)).collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ResourceName: Post", "FieldName: id", id));
        return mapToDTO(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author author = authorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ResourceName: Post", "FieldName: id", id));

        author.setName(authorDto.getName());
        author.setIntroduction(authorDto.getIntroduction());

        authorRepository.save(author);

        return mapToDTO(author);
    }

    @Override
    public void deleteAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ResourceName: Post", "FieldName: id", id));
        authorRepository.delete(author);
    }

    private AuthorDto mapToDTO(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setIntroduction(author.getIntroduction());

        return authorDto;
    }

    private Author mapToEntity(AuthorDto authorDto){
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setIntroduction(authorDto.getIntroduction());

        return author;
    }
}
