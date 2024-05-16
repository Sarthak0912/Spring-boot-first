package com.springboot.crudoperation.controller;

import com.springboot.crudoperation.model.ResponseDto;
import com.springboot.crudoperation.model.SchoolDto;
import com.springboot.crudoperation.service.SchoolService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="School Controller", description = "This is used to perform crud operations on school data")
@RequestMapping(value = "/school")
@RestController
public class SchoolController {

    @Autowired
   private SchoolService schoolService;

//    @GetMapping
//   public School getSchool(){
//
//       return schoolService.findSchoolById(1);
//    }

//    @Operation(summary="Fetching school data using school Id")
//    @GetMapping(value = "/school1")
//    public ResponseEntity<?> getValueByResponseEntity(){
//
//        return new ResponseEntity<>(schoolService.findSchoolById(2), HttpStatus.OK);
//    }

//    @GetMapping(value = "/school/{schoolId}")
//    public ResponseEntity<?> getValueUsingPV(@PathVariable int schoolId){
//
//        return new ResponseEntity<>(schoolService.findSchoolById(schoolId), HttpStatus.OK);
//    }

    @GetMapping(value = "{schoolId}")
    public ResponseEntity<?> getSchoolUsingRespDto(@PathVariable int schoolId) {

        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.OK.value()).message("successfully fetched!").data(schoolService.findSchoolById(schoolId)).build(),HttpStatus.OK);
    }

//    @GetMapping(value = "/school")

//    public ResponseEntity<?> getValueUsingRP(@RequestParam("SID") int schoolId){
//
//        return new ResponseEntity<>(schoolService.findSchoolById(schoolId), HttpStatus.FOUND);
//    }

    @PostMapping
    public ResponseEntity<?> postValue(@RequestBody SchoolDto schoolDto){

        return new ResponseEntity<>(schoolService.saveSchool(schoolDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> putValue(@RequestBody SchoolDto schoolDto) throws Exception {

        return new ResponseEntity<>(schoolService.updateSchool(schoolDto), HttpStatus.ACCEPTED);
    }
    @DeleteMapping (value = "{schoolId}")
    public ResponseEntity<?> deleteValueUsingPV(@PathVariable int schoolId){

        schoolService.deleteSchoolById(schoolId);
        return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.OK.value()).message("Record Deleted!").build(),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getValueUsingRP(@RequestParam("SearchText") String searchText){

       return new ResponseEntity<>(ResponseDto.builder().statusCode(HttpStatus.FOUND.value()).message("Records fetched").listData(schoolService.findSchoolBySearchText(searchText)).build(),HttpStatus.FOUND);
   }
}

