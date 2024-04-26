package com.db_clinic.db_clinic.service.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.db_clinic.db_clinic.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public UserDetailsService userDetailsServie() {
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String username)  {
               return userRepo.findFirstByEmail(username)
               .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
            
        };

        
        
    }

}
