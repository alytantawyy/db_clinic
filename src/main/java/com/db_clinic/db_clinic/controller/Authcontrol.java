package com.db_clinic.db_clinic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db_clinic.db_clinic.service.auth.AuthService;
import com.db_clinic.dto.SignUpRequest;
import com.db_clinic.dto.UserDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class Authcontrol {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignUpRequest signupRequest){
    UserDto createdCustomerDto = authService.createcustomer(signupRequest);
    if (createdCustomerDto != null) {
        return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);
    } else {
        return new ResponseEntity<>("Customer not created, please try again later", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

}
