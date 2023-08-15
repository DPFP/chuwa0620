package com.example.chuwaproject.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class CustomErrorResponse {
    private final int statusCode;
    private final HttpStatus httpStatus;
    private final String message;
    private final ZonedDateTime timestamp;
}
