package com.springboot.curdoperation.service;

import com.springboot.curdoperation.model.School;


public interface SchoolService {

    void saveSchool();

    School findSchoolById(int schoolId);

}
