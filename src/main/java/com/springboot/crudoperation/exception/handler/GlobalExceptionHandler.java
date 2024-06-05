package com.springboot.crudoperation.exception.handler;

import com.springboot.crudoperation.exception.DataNotFoundException;
import com.springboot.crudoperation.exception.UserExistsException;
import com.springboot.crudoperation.exception.UserNotFoundException;
import com.springboot.crudoperation.model.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleSchoolNotFoundException(DataNotFoundException exception){

        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.NOT_FOUND.value()).message(exception.getMessage()).build(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException exception){

        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.UNAUTHORIZED.value()).message(exception.getMessage()).build(),HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<?> handleUserExistsException(UserExistsException exception){

        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.NOT_ACCEPTABLE.value()).message(exception.getMessage()).build(),HttpStatus.NOT_ACCEPTABLE);
    }
}
