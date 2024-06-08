package com.springboot.crudoperation.service.impl;

import com.springboot.crudoperation.entity.User;
import com.springboot.crudoperation.exception.UserExistsException;
import com.springboot.crudoperation.exception.UserNotFoundException;
import com.springboot.crudoperation.mapper.UserMapper;
import com.springboot.crudoperation.model.UserDto;
import com.springboot.crudoperation.repository.UserRepository;
import com.springboot.crudoperation.service.UserService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto findByUserName(String userName) throws UserNotFoundException {
        User user=userRepository.findByUserName(userName);
        if(user!=null) {
            return UserMapper.mapToUserDto(user);
        }

       else{
           throw new UserNotFoundException("User not found!");
        }
    }

    @Override
    public UserDto signUp(UserDto userDto) throws UserNotFoundException {
        User user = userRepository.findByUserName(userDto.getUserName());
        if (user != null) {
            throw new UserExistsException("User already exists!");
        }
        else{
            User user1=userRepository.save(UserMapper.mapToUser(userDto));
            return UserMapper.mapToUserDto(user1);        }
    }

    @Override
    public User logIn(UserDto userDto) throws UserNotFoundException {
        User user = userRepository.findByUserName(userDto.getUserName());
        if (user != null) {
           return user;
        }
        else{
            throw new UserExistsException("User doesn't exist!");
        }
    }

    @Override
    public UserDto logOut(UserDto userDto) throws UserNotFoundException {
        return null;
    }
}
