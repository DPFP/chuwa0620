package com.chuwa.redbook.controller;

import com.chuwa.redbook.entity.Author;
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
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        Author response = this.authorService.createAuthor(author);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthor(){
        return new ResponseEntity<>(this.authorService.getAllAuthor(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable(name="id") long id){
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthorById(@PathVariable(name="id") String id, @RequestBody Author author){
        return ResponseEntity.ok(authorService.updateAuthor(author, Long.parseLong(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable(name="id")String id) {
        String author = authorService.deleteAuthorById(Long.parseLong(id));
        return ResponseEntity.ok(author);
    }
}
