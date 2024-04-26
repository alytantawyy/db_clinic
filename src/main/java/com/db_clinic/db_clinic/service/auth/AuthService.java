package com.db_clinic.db_clinic.service.auth;

import com.db_clinic.dto.SignUpRequest;
import com.db_clinic.dto.UserDto;

public interface AuthService {
    UserDto createcustomer(SignUpRequest signuprequest);


    boolean hasCustomerWithEmail(String email);
}
