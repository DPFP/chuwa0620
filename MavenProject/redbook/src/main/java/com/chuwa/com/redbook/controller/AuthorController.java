package com.chuwa.com.redbook.controller;

import com.chuwa.com.redbook.payload.AuthorDto;
import com.chuwa.com.redbook.payload.PostDto;
import com.chuwa.com.redbook.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorDto> createPost(@RequestBody AuthorDto authorDto){
        AuthorDto response = this.authorService.createAuthor(authorDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<AuthorDto> getAllPosts(){
        return authorService.getAllAuthor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getPostById(@PathVariable(name="id") long id) {
        return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updatePostById(@PathVariable(name="id") long id, @RequestBody AuthorDto authorDto){
        AuthorDto authorResponse = authorService.updateAuthor(authorDto, id);
        return ResponseEntity.ok(authorResponse);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable(name="id") long id){
        authorService.deleteAuthorById(id);
        // return new ResponseEntity.ok(null);
    }

}
