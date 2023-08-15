package com.chuwa.learning.rewardcalculatorv2.Controller;

import com.chuwa.learning.rewardcalculatorv2.Dto.OrderDTO;
import com.chuwa.learning.rewardcalculatorv2.Dto.UserDTO;
import com.chuwa.learning.rewardcalculatorv2.Exception.UserNotFoundException;
import com.chuwa.learning.rewardcalculatorv2.Service.OrderService;
import com.chuwa.learning.rewardcalculatorv2.Service.UserService;
import com.opencsv.CSVWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api")
@Log4j2
public class Controllers {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    // API endpoint to add a new user
    @PostMapping("/users")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.addUser(userDTO));
    }

    // API endpoint to delete a user by ID
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try{
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        }
        catch (UserNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    // API endpoint to get all users
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // API endpoint to add a new order
    @PostMapping("/orders")
    public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.addOrder(orderDTO));
    }

    // API endpoint to get all orders
    @GetMapping("/orders")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // API endpoint to get the total reward points for a user
    @GetMapping("/users/{id}/reward")
    public ResponseEntity<String> getTotalRewardPoints(HttpServletResponse response, @PathVariable Long id) {
        response.setHeader("Project", "chuwa.learning.RewardPointsCalculator");
        Double rewardPoints = userService.calculateRewardPoints(id);
        String base64Encoded = Base64.getEncoder().encodeToString(rewardPoints.toString().getBytes(StandardCharsets.UTF_8));

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8");
        headers.set("Content-Encoding", "base64");

        return ResponseEntity.ok().headers(headers).body(base64Encoded);
    }

    @GetMapping("/users/{userId}/orders/csv")
    public ResponseEntity<byte[]> getOrdersAndPointsInCSV(@PathVariable Long userId) {
        try {
            byte [] baos = userService.getOrdersAndPointsInCSV(userId);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("text/csv"));
            headers.setContentDispositionFormData("attachment", "orders.csv");

            return new ResponseEntity<>(baos, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}


