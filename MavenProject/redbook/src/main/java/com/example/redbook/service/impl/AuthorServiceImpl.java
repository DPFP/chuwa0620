package com.example.redbook.service.impl;

import com.example.redbook.dao.AuthorRepository;
import com.example.redbook.entity.Author;
import com.example.redbook.exception.ResourceNotFoundException;
import com.example.redbook.payload.AuthorDto;
import com.example.redbook.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author newAuthor = new Author();
        newAuthor.setName(authorDto.getName());

        Author savedAuthor = this.authorRepository.save(newAuthor);
        AuthorDto response = AuthorToDto(savedAuthor);
        return response;
    }

    private static AuthorDto AuthorToDto(Author savedAuthor){
        //Author(entity) -> AuthorDTO
        AuthorDto response = new AuthorDto();
        response.setId(savedAuthor.getId());
        response.setName(savedAuthor.getName());

        return response;
    }

    @Override
    public List<AuthorDto> getAllAuthor() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(author -> AuthorToDto(author)).collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        return AuthorToDto(authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author","id",id)));
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author","id",id));

        author.setName(authorDto.getName());

        Author updatedAuthor = authorRepository.save(author);
        return AuthorToDto(updatedAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        Author post = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author","id",id));
        authorRepository.deleteById(id);
    }
}
