package com.example.chuwaproject.controller;
import com.example.chuwaproject.dto.UserDTO;
import com.example.chuwaproject.exception.InvalidCredentialsException;
import com.example.chuwaproject.exception.NoSuchUserException;
import com.example.chuwaproject.exception.UserAlreadyExistException;
import com.example.chuwaproject.bean.User;
import com.example.chuwaproject.service.UserService;
import com.example.chuwaproject.utils.AllUtils;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    public UserController (UserService userService){this.userService=userService;}

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id){
        logger.info("Fetching user by ID: {}", id);
        User user = userService.getUser(id)
                .orElseThrow(() -> new NoSuchUserException("No Such User!"));
        logger.info("User found: {}", user);
        return ResponseEntity.ok(AllUtils.mapToUserDTO(user));
    }

    @GetMapping("/points/{id}")
    public ResponseEntity<Integer> getPointsById(@PathVariable long id){
        logger.info("Fetching points by ID: {}", id);
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()){
            logger.info("Points found: {}", user.get().getPoints());
            return ResponseEntity.ok(user.get().getPoints());
        }
        throw new NoSuchUserException("No Such User!");
    }

    @PostMapping()
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody User user){
        logger.info("Saving new user: {}", user);
        Optional<User> userOptional = userService.getUserByEmail(user.getEmail());
        if(userOptional.isPresent()) throw new UserAlreadyExistException("User Already Exist!!!");
        User savedUser = userService.saveUser(user);
        logger.info("User saved: {}", savedUser);
        return ResponseEntity.ok(AllUtils.mapToUserDTO(savedUser));
    }
    @PutMapping("/user")
    public ResponseEntity<UserDTO> updateUser(@RequestBody User user){
        logger.info("Updating user: {}", user);
        if(!userService.getUser(user.getId()).isPresent()) throw new NoSuchUserException("No Such User!");
        return ResponseEntity.ok(AllUtils.mapToUserDTO(userService.saveUser(user)));
    }
    @DeleteMapping("user/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id) {
        logger.info("Deleting user by ID: {}", id);
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody Map<String,String> credentials){
        logger.info("Login attempt for email: {}", credentials.get("email"));
        Optional<User> userOptional = userService.getUserByEmail(credentials.get("email"));
        if(userOptional.isPresent() && userOptional.get().getPassword().equals(credentials.get("password"))){
            logger.info("Login successful for email: {}", credentials.get("email"));
            return ResponseEntity.ok(AllUtils.mapToUserDTO(userOptional.get()));
        }
        throw new InvalidCredentialsException("Invalid Credentials!!!");
    }
}
