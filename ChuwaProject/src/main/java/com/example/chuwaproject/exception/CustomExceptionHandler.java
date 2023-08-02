package com.example.chuwaproject.exception;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(NoSuchUserException.class)
    public ResponseEntity<Object> handleNoSuchUserException(NoSuchUserException ex) {
        //LOGGER.error("NoSuchUserException: {}", ex.getMessage());
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND, ex.getMessage(), ZonedDateTime.now());
        return new ResponseEntity<>(customErrorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException ex) {
        LOGGER.error("UserAlreadyExistException: {}", ex.getMessage());
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.CONFLICT.value(),HttpStatus.CONFLICT, ex.getMessage(), ZonedDateTime.now());
        return new ResponseEntity<>(customErrorResponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Object> handleInvalidCredentialsException(InvalidCredentialsException ex) {
        LOGGER.error("InvalidCredentialsException: {}", ex.getMessage());
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.UNAUTHORIZED.value(),HttpStatus.UNAUTHORIZED, ex.getMessage(), ZonedDateTime.now());
        return new ResponseEntity<>(customErrorResponse,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleInvalidCredentialsException(ConstraintViolationException ex) {
        LOGGER.error("ConstrainViolationExceptionException: {}", ex.getMessage());
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST, ex.getMessage(), ZonedDateTime.now());
        return new ResponseEntity<>(customErrorResponse,HttpStatus.BAD_REQUEST);
    }
}
