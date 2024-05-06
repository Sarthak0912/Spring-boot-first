package com.springboot.crudoperation.model;

import lombok.*;

import java.util.List;


@Getter
@Setter
public class School {

      int id;
     String name;
      String address;
      List<String> dressCodeColors;
}
