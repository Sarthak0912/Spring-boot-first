package com.springboot.crudoperation.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Builder
@Getter
@Setter
public class ResponseDto<T>  {

    Integer statusCode;
    String message;
    T data;
    List<T> listData;



}
