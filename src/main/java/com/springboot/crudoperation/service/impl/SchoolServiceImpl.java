package com.springboot.crudoperation.service.impl;


import com.springboot.crudoperation.entity.School;
import com.springboot.crudoperation.exception.DataNotFoundException;
import com.springboot.crudoperation.mapper.SchoolMapper;
import com.springboot.crudoperation.model.SchoolDto;
import com.springboot.crudoperation.repository.SchoolRepository;
import com.springboot.crudoperation.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public SchoolDto saveSchool(SchoolDto schoolDto) {
       School school = SchoolMapper.maptoSchool(schoolDto,"Admin");
        schoolRepository.save(school);
        schoolDto.setId(school.getId());
        return schoolDto;
    }

    @Override
    public SchoolDto updateSchool(SchoolDto schoolDto)  {
        Optional<School> optionalData= schoolRepository.findByIdAndIsDeleted(schoolDto.getId(),0);
        if(optionalData.isPresent()){
            School school=optionalData.get();
            if(!schoolDto.getName().isEmpty()) {
                school.setName(schoolDto.getName());
            }
            school.setUpdatedBy("Admin");
            school.setUpdatedDate(Date.valueOf(LocalDate.now()));
            schoolRepository.save(school);
            return SchoolMapper.mapToSchoolDto(school);
        }
        else {
            throw new DataNotFoundException("Record not found");
        }
    }

    @Override
    public SchoolDto findSchoolById(int schoolId) {
        Optional<School> optionalData = schoolRepository.findByIdAndIsDeleted(schoolId, 0);

        if (optionalData.isPresent()) {
            School school = optionalData.get();
            return SchoolMapper.mapToSchoolDto(school);

        }
        else{
            throw new DataNotFoundException("Record not found");
        }

    }

    @Override
    public void deleteSchoolById(int schoolId) {
        Optional<School> optionalData=schoolRepository.findByIdAndIsDeleted((long)schoolId,0);
        if(optionalData.isPresent()){
            School school = optionalData.get();
            school.setIsDeleted(1);
            schoolRepository.save(school);
        }
        else{
            throw new DataNotFoundException("Record not found!");
        }


    }

}
