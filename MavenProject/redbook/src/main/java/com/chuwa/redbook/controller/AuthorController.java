package com.chuwa.redbook.controller;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.AuthorService;
import com.chuwa.redbook.util.AppConstants;
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
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto ato) {
        AuthorDto response = this.authorService.createAuthor(ato);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/ids")
    public List<AuthorDto> getUsersBetweenID(
            @RequestParam(value = "id1", defaultValue = "0", required = false) long id1,
            @RequestParam(value = "id2", defaultValue = "0", required = false) long id2
    ) {
        return this.authorService.getAuthorsBetweenID(id1,id2);
    }

    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getPostById(@PathVariable(name="id") long id) {
        AuthorDto response = this.authorService.getAuthorById(id);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name="id") long id) {
        this.authorService.deteleById(id);
        return new ResponseEntity<String>("Deleted Author id: " + id, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthorById(@PathVariable(name="id") long id, @RequestBody AuthorDto ato) {
        AuthorDto response = this.authorService.updateAuthor(id, ato);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

}
