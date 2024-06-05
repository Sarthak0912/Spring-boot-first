package com.springboot.crudoperation.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;
import java.util.List;

@Entity(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User extends BaseEntity{

    String firstName;
    String LastName;
    String emailId;
    String userName;
    String password;



}
