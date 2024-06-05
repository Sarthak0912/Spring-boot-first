package com.springboot.crudoperation.service;

import com.springboot.crudoperation.entity.User;
import com.springboot.crudoperation.exception.UserNotFoundException;
import com.springboot.crudoperation.model.UserDto;

public interface UserService {

    UserDto findByUserName(String userName) throws UserNotFoundException;

    public UserDto signUp(UserDto userDto) throws UserNotFoundException;

    public UserDto logIn(UserDto userDto) throws UserNotFoundException;

    public UserDto logOut(UserDto userDto) throws UserNotFoundException;
}
