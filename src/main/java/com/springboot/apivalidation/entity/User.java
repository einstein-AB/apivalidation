package com.springboot.apivalidation.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "USER_TBL")
@Data
@AllArgsConstructor /*(staticName = "build", access = AccessLevel.PUBLIC)*/
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private int userId;
    private String name;
    private String gender;
    private int age;
    private String email;
    private String nationality;
}
