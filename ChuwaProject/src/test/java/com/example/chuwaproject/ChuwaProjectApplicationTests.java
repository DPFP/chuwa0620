package com.example.chuwaproject;

import com.example.chuwaproject.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ChuwaProjectApplicationTests {
    @Autowired
    UserController userController;
    @Test
    public void getUserByIdTest(){
        //code here
/*        long userId = 9; // Specify the ID of the user you want to retrieve

        ResponseEntity<User> response = userController.getUserById(userId);

        // Assert that the response has a successful status code (200 OK)
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Assert that the response body is not null
        assertNotNull(response.getBody());*/
    }
}
