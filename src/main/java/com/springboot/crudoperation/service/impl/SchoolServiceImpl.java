package com.springboot.crudoperation.service.impl;


import com.springboot.crudoperation.entity.School;
import com.springboot.crudoperation.model.SchoolDto;
import com.springboot.crudoperation.repository.SchoolRepository;
import com.springboot.crudoperation.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public SchoolDto saveSchool(SchoolDto schoolDto) {
        School school=new School();
        school.setName(schoolDto.getName());
        school.setAddress(schoolDto.getAddress());
        school.setDressCodeColors(schoolDto.getDressCodeColors());
        school.setCreatedDate(Date.valueOf(LocalDate.now()));
        school.setCreatedBy("Admin");
        schoolRepository.save(school);
        schoolDto.setId(school.getId());
        return schoolDto;
    }

    @Override
    public SchoolDto updateSchool(SchoolDto schoolDto) throws Exception {
        if (schoolDto.getId() == 0) {
            throw new Exception("ID doesnot exist");
        }

        return schoolDto;
    }

    @Override
    public SchoolDto findSchoolById(int schoolId) {
        SchoolDto schoolDto = new SchoolDto();
        schoolDto.setId(1L);
        schoolDto.setName("MIT");
        schoolDto.setAddress("Pune");
        String[] colours = {"Red", "Blue", "Green", "Yellow"};
        schoolDto.setDressCodeColors(Arrays.stream(colours).toList());
        return schoolDto;
    }

    @Override
    public Map deleteSchoolById(int schoolId) {
        Map<String,Object> map=new HashMap<>();
        map.put("Id",schoolId);
        map.put("Message","Deleted");
        return map;
    }

}
