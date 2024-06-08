package com.springboot.crudoperation.mapper;

import com.springboot.crudoperation.entity.User;
import com.springboot.crudoperation.model.UserDto;

public class UserMapper {

    public static UserDto mapToUserDto(User user){

        return UserDto.builder().id(user.getId()).userName(user.getUsername()).password(user.getPassword()).firstName(user.getFirstName()).LastName(user.getLastName()).emailId(user.getEmailId()).build();
    }

    public  static User mapToUser(UserDto userDto){

        return User.builder().userName(userDto.getUserName()).firstName(userDto.getFirstName()).password(userDto.getPassword()).LastName(userDto.getLastName()).emailId(userDto.getEmailId()).build();
    }
}
