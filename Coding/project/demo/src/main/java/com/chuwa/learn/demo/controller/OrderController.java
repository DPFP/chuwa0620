package com.chuwa.learn.demo.controller;

import com.chuwa.learn.demo.Service.Impl.OrderServiceImpl;
import com.chuwa.learn.demo.Service.OrderService;
import com.chuwa.learn.demo.entity.Order;
import com.chuwa.learn.demo.payload.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable long id) {
        OrderDTO orderDTO = orderService.getOrderById(id);
        if (orderDTO != null)
            return ResponseEntity.ok(orderDTO);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO savedOrderDTO = orderService.saveOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedOrderDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable long id, @RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.updateOrder(orderDTO, id));
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable long id) {
        orderService.deleteOrder(id);
        return "id : " + id +" has been deleted";
    }
}
