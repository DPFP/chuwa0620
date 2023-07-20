package com.chuwa.redbook.service.impl;

import com.chuwa.redbook.dao.AuthorRepo;
import com.chuwa.redbook.entity.Author;
import com.chuwa.redbook.exception.ResourceNotFoundException;
import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepo authorRepo;

    public AuthorServiceImpl (AuthorRepo aUthorRepo) {
        this.authorRepo = aUthorRepo;
    }

    private static Author getAuthorFromDto(AuthorDto authorDto) {
        Author newAuth = new Author();
        newAuth.setBirthday(authorDto.getBirthday());
        newAuth.setName(authorDto.getName());
        return newAuth;
    }

    private static AuthorDto getDtoFromAuthor(Author savedAuthor) {
        AuthorDto response = new AuthorDto();
        response.setBirthday(savedAuthor.getBirthday());
        response.setName(savedAuthor.getName());
        return response;
    }
    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = getAuthorFromDto(authorDto);
        Author a = authorRepo.save(author);
        AuthorDto response = getDtoFromAuthor(a);
        return response;
    }

    @Override
    public List<AuthorDto> getAllAuthor() {
        List<Author> authorList = authorRepo.findAll();
        return authorList.stream().map(author-> getDtoFromAuthor(author)).collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(long id) {
        Author author = authorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        return getDtoFromAuthor(author);
    }

    @Override
    public AuthorDto updateAuthorById(AuthorDto authorDto, long id) {
        Author theAuthor = authorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        theAuthor.setName(authorDto.getName());
        theAuthor.setBirthday(authorDto.getBirthday());
        return getDtoFromAuthor(theAuthor);
    }

    @Override
    public void deleteAuthorById(long id) {
        Author theAuthor = authorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));
        authorRepo.delete(theAuthor);
    }
}
