package com.springboot.crudoperation.model;

import lombok.*;

import java.util.List;
import java.util.Date;

@Builder
@Getter
@Setter
public class SchoolDto {

      Long id;
      String name;
      String address;
      List<String> dressCodeColors;

      Date createdDate;

      String createdBy;
      Date updatedDate;

      String updatedBy;
}
