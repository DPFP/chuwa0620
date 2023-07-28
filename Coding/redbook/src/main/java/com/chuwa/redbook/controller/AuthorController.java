package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
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
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        AuthorDto response = this.authorService.createAuthor(authorDto);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthor() {
        return new ResponseEntity<>(authorService.getAllAuthor(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthorById(@PathVariable(name="id") long id, @RequestBody AuthorDto authorDto) {
        return ResponseEntity.ok(authorService.updateAuthor(authorDto, id));
    }

    @DeleteMapping("/{id}")
    public String deleteAuthorById(@PathVariable(name = "id") long id) {
        authorService.deleteAuthorById(id);
        return ""+id+" post has been delete";
    }
}
