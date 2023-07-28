package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRespository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRespository authorRespository;

    public AuthorServiceImpl(AuthorRespository authorRespository) {
        this.authorRespository = authorRespository;
    }


    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author newAuthor = mapToEntity(authorDto);
        Author savedAuthor = this.authorRespository.save(newAuthor);

        AuthorDto response = mapToDTO(savedAuthor);
        return response;
    }

    private Author mapToEntity(AuthorDto authorDto) {
        Author newAuthor = new Author();
        newAuthor.setUsername(authorDto.getUsername());
        newAuthor.setAge(authorDto.getAge());
        return newAuthor;
    }

    private AuthorDto mapToDTO(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setUsername(author.getUsername());
        authorDto.setAge(author.getAge());
        return authorDto;
    }

    @Override
    public List<AuthorDto> getAllAuthor() {
        List<Author> authors = authorRespository.findAll();
        List<AuthorDto> authorDtos = authors
                .stream()
                .map(author -> mapToDTO(author))
                .collect(Collectors.toList());
        return authorDtos;
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = authorRespository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        return mapToDTO(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author author = authorRespository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        author.setAge(authorDto.getAge());
        author.setUsername(authorDto.getUsername());
        author.setId(authorDto.getId());

        Author updateAuthor = authorRespository.save(author);
        return mapToDTO(updateAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        Author author = authorRespository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        authorRespository.delete(author);

    }
}
