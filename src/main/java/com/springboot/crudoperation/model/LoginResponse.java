package com.springboot.crudoperation.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {

    String token;
    Long expiryTime;
}
