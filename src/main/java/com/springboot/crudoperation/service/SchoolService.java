package com.springboot.crudoperation.service;


import com.springboot.crudoperation.model.SchoolDto;

import java.util.List;

public interface SchoolService {

    SchoolDto saveSchool(SchoolDto schoolDto);

    SchoolDto updateSchool(SchoolDto schoolDto) throws Exception;

    SchoolDto findSchoolById(int schoolId);

    void deleteSchoolById(int schoolId);
    public List<Object> findSchoolBySearchText(String searchText);

}
