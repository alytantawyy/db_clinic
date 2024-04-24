package com.db_clinic.dto;

import com.db_clinic.db_clinic.enums.UserRole;

import lombok.Data;

@Data

public class UserDto {

    private Long id;

    private String name;

    private String email;

    private UserRole userrole;

}
