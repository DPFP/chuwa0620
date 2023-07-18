package com.chuwa.redbook.controller;


import com.chuwa.redbook.payload.AuthorDto;
import com.chuwa.redbook.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        AuthorDto response = this.authorService.createAuthor(authorDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping
    public List<AuthorDto> getAllAuthors(){
        return authorService.getAllAuthor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@RequestBody AuthorDto authorDto,
                                                   @PathVariable(name = "id") long id){
        AuthorDto authorResponse = authorService.updateAuthor(authorDto, id);
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable(name = "id") long id){
        authorService.deleteAuthorById(id);
        return new ResponseEntity<>("Author Entity deleted successfully.", HttpStatus.OK);
    }
}
