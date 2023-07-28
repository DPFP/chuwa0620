package com.yuming.rewardsprogram.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@EqualsAndHashCode(callSuper = true)
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SystemAPIException extends RuntimeException{
    private HttpStatus httpStatus;
    private String message;

    public SystemAPIException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }


    public SystemAPIException(String message, HttpStatus httpStatus, String message1) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message1;
    }
}
