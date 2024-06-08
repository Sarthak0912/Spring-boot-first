package com.springboot.crudoperation.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserDto {
    Long id;
    Date createdDate;
    String createdBy;
    Date updatedDate;

    String updatedBy;
    int isDeleted;

    String userName;
    String password;
    String firstName;
    String LastName;
    String emailId;

}
