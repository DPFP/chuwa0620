package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepository;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.entity.Post;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author newAuthor = new Author();
        newAuthor.setFirstName(authorDto.getFirstName());
        newAuthor.setLastName(authorDto.getLastName());

        Author saveAuthor = this.authorRepository.save(newAuthor);

        // author entity ---> authorDto
        AuthorDto response = authorToDto(saveAuthor);
        return response;
    }

    private static AuthorDto authorToDto(Author saveAuthor) {
        AuthorDto response = new AuthorDto();
        response.setId(saveAuthor.getId());
        response.setFirstName(saveAuthor.getFirstName());
        response.setLastName(saveAuthor.getLastName());
        return response;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(author -> authorToDto(author)).collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        return authorToDto(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto, long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));

        author.setLastName(authorDto.getLastName());
        author.setFirstName(authorDto.getFirstName());

        Author saveAuthor = this.authorRepository.save(author);

        AuthorDto response = authorToDto(saveAuthor);

        return response;
    }

    @Override
    public void deleteAuthorById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        authorRepository.delete(author);
    }
}
