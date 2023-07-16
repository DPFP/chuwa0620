package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.AuthorService;
import com.chuwa.redbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        AuthorDto response = authorService.createAuthor(authorDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<AuthorDto> getAuthor() {
        return authorService.getAllAuthor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name="id") long id) {
        return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthorById(@PathVariable(name = "id") long id, @RequestBody AuthorDto authorDto) {
        return ResponseEntity.ok(authorService.updateAuthor(authorDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteAuthor(@PathVariable(name="id") Long id) {
        authorService.deleteAuthorById(id);
        return ResponseEntity.ok(id);
    }
}
