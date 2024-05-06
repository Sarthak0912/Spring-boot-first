package com.springboot.crudoperation.service;


import com.springboot.crudoperation.model.School;

import java.util.Map;

public interface SchoolService {

    School saveSchool(School school);

    School updateSchool(School school) throws Exception;

    School findSchoolById(int schoolId);

    Map deleteSchoolById(int schoolId);

}
