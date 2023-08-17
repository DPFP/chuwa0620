package com.chuwa.redbook.controller.rest;

import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.payload.PostDto;
import com.chuwa.redbook.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorDto> createPost(@RequestBody AuthorDto authorDto){
        AuthorDto response = this.authorService.createAuthor(authorDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public List<AuthorDto> getAllPosts(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name="id") long id){
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updatePostById(@RequestBody AuthorDto authorDto, @PathVariable(name="id") long id){
        AuthorDto response = this.authorService.updateAuthor(authorDto, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name="id") long id){
        authorService.deleteAuthorById(id);
        return new ResponseEntity<>("Deleted id: " + id, HttpStatus.OK);
    }




}
