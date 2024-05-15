package com.springboot.crudoperation.repository;

import com.springboot.crudoperation.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Long> {


}
