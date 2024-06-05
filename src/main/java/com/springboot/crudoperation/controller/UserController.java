package com.springboot.crudoperation.controller;

import com.springboot.crudoperation.entity.User;
import com.springboot.crudoperation.exception.UserNotFoundException;
import com.springboot.crudoperation.mapper.UserMapper;
import com.springboot.crudoperation.model.ResponseDto;
import com.springboot.crudoperation.model.SchoolDto;
import com.springboot.crudoperation.model.UserDto;
import com.springboot.crudoperation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/auth")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/signup")
    public ResponseEntity<?> SignUp(@RequestBody UserDto userDto) throws UserNotFoundException {

        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.CREATED.value()).message("Signup Successful!!").data(userService.signUp(userDto)), HttpStatus.CREATED);
    }
    @PostMapping(value = "/logIn")
    public ResponseEntity<?> logIn(@RequestBody UserDto userDto) throws UserNotFoundException {

        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.ACCEPTED.value()).message("Login Successful!!").data(userService.logIn(userDto)), HttpStatus.ACCEPTED);
    }
    @PostMapping(value = "/logOut")
    public ResponseEntity<?> logOut(@RequestBody UserDto userDto) throws UserNotFoundException {

        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.OK.value()).message("Logout Successful!!").data(userService.logOut(userDto)), HttpStatus.OK);
    }
}
