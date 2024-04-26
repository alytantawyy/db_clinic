package com.db_clinic.dto;




import com.db_clinic.db_clinic.enums.UserRole;

import lombok.Data;

@Data
public class AuthenticationResponse {

    private String  jwt;
    private Long userId;
    private UserRole userRole;
    

}
