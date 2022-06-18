package com.springboot.apivalidation.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor /*(staticName = "build", access = AccessLevel.PUBLIC)*/
@NoArgsConstructor
public class UserRequest {

    @NotBlank (message = "name cannot be empty") //NotNull + NotEmpty
    private String name;

    @NotNull (message = "Gender cannot be null")
    private String gender;

    @Min(value = 18, message = "Age cannot be less than 18")
    @Max(value = 60, message = "Age cannot be more than 60")
    private int age;

    @Email (message = "Invalid email")
    private String email;

    @NotBlank (message = "name cannot be empty") //NotNull + NotEmpty
    private String nationality;
}
