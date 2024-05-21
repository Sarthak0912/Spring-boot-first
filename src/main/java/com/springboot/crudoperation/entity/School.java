package com.springboot.crudoperation.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "school")
@Getter
@Setter
public class School extends BaseEntity {

    String name;
    String address;
    List<String> dressCodeColors;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
            @JoinColumn(name = "school_Id")
    List<ClassRoom> classRoomList;

}
