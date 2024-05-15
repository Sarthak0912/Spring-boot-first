package com.springboot.crudoperation.mapper;

import com.springboot.crudoperation.entity.School;
import com.springboot.crudoperation.model.SchoolDto;

import java.sql.Date;
import java.time.LocalDate;

public class SchoolMapper {

    public static SchoolDto mapToSchoolDto(School school){

        return SchoolDto.builder().name(school.getName()).id(school.getId()).address(school.getAddress()).dressCodeColors(school.getDressCodeColors()).createdBy(school.getCreatedBy()).updatedBy(school.getUpdatedBy()).createdDate(school.getCreatedDate()).updatedDate(school.getUpdatedDate()).build();
    }

    public  static School maptoSchool(SchoolDto schoolDto, String user){
        School school=new School();
        school.setName(schoolDto.getName());
        school.setAddress(schoolDto.getAddress());
        school.setDressCodeColors(schoolDto.getDressCodeColors());
        school.setCreatedDate(Date.valueOf(LocalDate.now()));
        school.setCreatedBy(user);
        return school;
    }
}
