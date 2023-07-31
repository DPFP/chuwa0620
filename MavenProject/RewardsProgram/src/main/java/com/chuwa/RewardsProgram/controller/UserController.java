package com.chuwa.RewardsProgram.controller;


import com.chuwa.RewardsProgram.dao.UserRepository;
import com.chuwa.RewardsProgram.payload.UserDto;
import com.chuwa.RewardsProgram.service.EncryptService;
import com.chuwa.RewardsProgram.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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

    @Autowired
    private EncryptService encryptService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<String> login (@RequestParam Long userId, HttpServletResponse response) {
        UserDto userDto = userService.getUserById(userId);
        Cookie cookie = new Cookie("user_id", String.valueOf(userDto.getId()));
        cookie.setMaxAge(3600); // Set the cookie expiration time (in seconds)
        cookie.setHttpOnly(true);
        cookie.setPath("/"); // Set the cookie to be accessible across the whole application
        response.addCookie(cookie);
        return ResponseEntity.ok("Login successful.");

    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    @GetMapping("/{id}/encrypt")
    public ResponseEntity<String> encryptUser(@PathVariable(name = "id") long id) throws JsonProcessingException {
        UserDto userDto = userService.getUserById(id);
        ObjectMapper mapper = new ObjectMapper();
        String data = encryptService.generateHash(mapper.writeValueAsString(userDto));
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>("deleted id " + id, HttpStatus.OK);
    }

}
