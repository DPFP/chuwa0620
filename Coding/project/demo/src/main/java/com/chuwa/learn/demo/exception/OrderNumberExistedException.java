package com.chuwa.learn.demo.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
@Getter
@Setter
public class OrderNumberExistedException extends RuntimeException{
    String orderNumber;

    public OrderNumberExistedException(String orderNumber) {
        super("OrderNumber: " + orderNumber + " is existed, it cannot be duplicated!");
        this.orderNumber = orderNumber;
    }
}
