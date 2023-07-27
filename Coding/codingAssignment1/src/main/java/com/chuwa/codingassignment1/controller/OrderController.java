package com.chuwa.codingassignment1.controller;

import com.chuwa.codingassignment1.payload.OrderDto;
import com.chuwa.codingassignment1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @param
 * @return Author: zhanghm$
 * Date: 7/26/23$
 */
@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping()
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto) {
        double value = orderDto.getValue();
        double points = 2 * (value - 100) + value - 50;
        orderDto.setPoints(points);
        OrderDto orderResponse = orderService.createOrder(orderDto);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}/{months}")
    public ResponseEntity<Double> getTotalScoreWithinCustomMonths(@PathVariable(value = "id") Long id,
                                                                  @PathVariable(value = "months") Integer months){
        double points = orderService.getTotalPointsWithinCustomMonths(id, months);
        return new ResponseEntity<>(points, HttpStatus.ACCEPTED);
    }
}
