package com.db_clinic.db_clinic.controller;

import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db_clinic.db_clinic.Utils.JWTUtil;
import com.db_clinic.db_clinic.repository.UserRepo;
import com.db_clinic.db_clinic.service.auth.AuthService;
import com.db_clinic.db_clinic.service.jwt.UserService;
import com.db_clinic.dto.AuthenticationRequest;
import com.db_clinic.dto.AuthenticationResponse;
import com.db_clinic.dto.SignUpRequest;
import com.db_clinic.dto.UserDto;
import com.db_clinic.db_clinic.entity.User;



import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class Authcontrol {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JWTUtil jwtUtil;
    private final UserRepo userRepo;

    @PostMapping("/signup")
    public ResponseEntity<?> signupCustomer(@RequestBody SignUpRequest signupRequest){
        if(authService.hasCustomerWithEmail(signupRequest.getEmail())){
            return new ResponseEntity<>("A customer already exists with this email", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createdCustomerDto = authService.createcustomer(signupRequest);
        if (createdCustomerDto != null) {
            return new ResponseEntity<>(createdCustomerDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Customer not created, please try again later", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }

    @PostMapping("/login")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws
        BadCredentialsException, DisabledException, UsernameNotFoundException{
            try{
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), 
                authenticationRequest.getPassword()));
            }
            catch(BadCredentialsException e){
                throw new BadCredentialsException("Incorrect username or password");
            }
            final UserDetails userDetails=userService.userDetailsServie().loadUserByUsername(authenticationRequest.getEmail());
            Optional<User> optionalUser = userRepo.findFirstByEmail(userDetails.getUsername());
            final String jwt= jwtUtil.generateToken(userDetails);
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            if(optionalUser.isPresent()) {
                authenticationResponse.setJwt(jwt);
                authenticationResponse.setUserId(optionalUser.get().getId());
                authenticationResponse.setUserRole(optionalUser.get().getUserRole());
            }
            return authenticationResponse;
        }

}
