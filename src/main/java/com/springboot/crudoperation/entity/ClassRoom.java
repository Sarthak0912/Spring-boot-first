package com.springboot.crudoperation.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity(name = "classroom")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoom extends BaseEntity {

    String name;
    int grade;
    int floor;
    int strength;

}
