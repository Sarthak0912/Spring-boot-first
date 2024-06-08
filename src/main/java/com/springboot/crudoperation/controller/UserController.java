package com.springboot.crudoperation.controller;

import com.springboot.crudoperation.entity.User;
import com.springboot.crudoperation.exception.UserNotFoundException;
import com.springboot.crudoperation.mapper.UserMapper;
import com.springboot.crudoperation.model.LoginResponse;
import com.springboot.crudoperation.model.ResponseDto;
import com.springboot.crudoperation.model.SchoolDto;
import com.springboot.crudoperation.model.UserDto;
import com.springboot.crudoperation.service.UserService;
import com.springboot.crudoperation.service.impl.JwtService;
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
    @Autowired
    JwtService jwtService;

    @PostMapping(value = "/signup")
    public ResponseEntity<?> SignUp(@RequestBody UserDto userDto) throws UserNotFoundException {

        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.CREATED.value()).message("Signup Successful!!").data(userService.signUp(userDto)).build(), HttpStatus.CREATED);
    }
    @PostMapping(value = "/logIn")
    public ResponseEntity<?> logIn(@RequestBody UserDto userDto) throws UserNotFoundException {
        User user=userService.logIn(userDto);
        LoginResponse response=LoginResponse.builder().token(jwtService.generateToken(user)).expiryTime(jwtService.getExpiryTime()).build();
        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.ACCEPTED.value()).message("Login Successful!!").data(response).build(), HttpStatus.ACCEPTED);
    }
    @PostMapping(value = "/logOut")
    public ResponseEntity<?> logOut(@RequestBody UserDto userDto) throws UserNotFoundException {

        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.OK.value()).message("Logout Successful!!").data(userService.logOut(userDto)), HttpStatus.OK);
    }
}
