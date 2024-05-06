package com.springboot.crudoperation.service.impl;


import com.springboot.crudoperation.model.School;
import com.springboot.crudoperation.service.SchoolService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class SchoolServiceImpl implements SchoolService {


    @Override
    public School saveSchool(School school) {
        School schoolPut = school;
        schoolPut.setId(123);
        return schoolPut;
    }

    @Override
    public School updateSchool(School school) throws Exception {
        if (school.getId() == 0) {
            throw new Exception("ID doesnot exist");
        }

        return school;
    }

    @Override
    public School findSchoolById(int schoolId) {
        School school = new School();
        school.setId(schoolId);
        school.setName("MIT");
        school.setAddress("Pune");
        String[] colours = {"Red", "Blue", "Green", "Yellow"};
        school.setDressCodeColors(Arrays.stream(colours).toList());

        return school;
    }

    @Override
    public Map deleteSchoolById(int schoolId) {
        Map<String,Object> map=new HashMap<>();
        map.put("Id",schoolId);
        map.put("Message","Deleted");
        return map;
    }

}
