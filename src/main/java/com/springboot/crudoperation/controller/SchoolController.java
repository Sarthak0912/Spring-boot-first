package com.springboot.crudoperation.controller;

import com.springboot.crudoperation.model.ResponseDto;
import com.springboot.crudoperation.model.School;
import com.springboot.crudoperation.service.SchoolService;
import com.springboot.crudoperation.service.impl.SchoolServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="School Controller", description = "This is used to perform crud operations on school data")
@RestController
public class SchoolController {

    @Autowired
   private SchoolService schoolService;

    @GetMapping(value = "/school")
   public School getValue(){

       return schoolService.findSchoolById(1);
    }

    @Operation(summary="Fetching school data using school Id")
    @GetMapping(value = "/school1")
    public ResponseEntity<?> getValueByResponseEntity(){

        return new ResponseEntity<>(schoolService.findSchoolById(2), HttpStatus.OK);
    }

//    @GetMapping(value = "/school/{schoolId}")
//    public ResponseEntity<?> getValueUsingPV(@PathVariable int schoolId){
//
//        return new ResponseEntity<>(schoolService.findSchoolById(schoolId), HttpStatus.OK);
//    }

    @GetMapping(value = "/school/{schoolId}")
    public ResponseEntity<?> getSchoolUsingRespDto(@PathVariable int schoolId) {

        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.OK.value()).message("s").data(schoolService.findSchoolById(schoolId)).build(),HttpStatus.OK);
    }

    @GetMapping(value = "/schooll")
    public ResponseEntity<?> getValueUsingRP(@RequestParam("SID") int schoolId){

        return new ResponseEntity<>(schoolService.findSchoolById(schoolId), HttpStatus.FOUND);
    }

    @PostMapping("/school")
    public ResponseEntity<?> postValue(@RequestBody School school){

        return new ResponseEntity<>(schoolService.saveSchool(school), HttpStatus.CREATED);
    }

    @PutMapping("/school")
    public ResponseEntity<?> putValue(@RequestBody School school) throws Exception {

        return new ResponseEntity<>(schoolService.updateSchool(school), HttpStatus.ACCEPTED);
    }
    @DeleteMapping (value = "/school/{schoolId}")
    public ResponseEntity<?> deleteValueUsingPV(@PathVariable int schoolId){

        return new ResponseEntity<>(schoolService.deleteSchoolById(schoolId), HttpStatus.OK);
    }

}
