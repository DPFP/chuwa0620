package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.payload.PostDto;
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
    @PostMapping
    public ResponseEntity<AuthorDto> creatAuthor(@RequestBody AuthorDto authorDto) {
        AuthorDto response = this.authorService.createAuthor(authorDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<AuthorDto>> getAllAuthor() {
        return new  ResponseEntity<>(this.authorService.getAllAuthor(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name = "id") long Id) {
        return ResponseEntity.ok(this.authorService.getAuthorById(Id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthorById(@RequestBody AuthorDto authorDto, @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(this.authorService.updateAuthorById(authorDto, id));
    }

    @DeleteMapping("/{id}")
    public void  deleteAuthorById(@PathVariable(name = "id") long id) {
        this.authorService.deleteAuthorById(id);
    }
}
