package com.chuwa.RewardsProgram.controller;


import com.chuwa.RewardsProgram.dao.UserRepository;
import com.chuwa.RewardsProgram.payload.UserDto;
import com.chuwa.RewardsProgram.service.UserService;
import com.sun.net.httpserver.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>("deleted id " + id, HttpStatus.OK);
    }

}
