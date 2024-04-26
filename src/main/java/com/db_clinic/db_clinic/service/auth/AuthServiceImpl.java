package com.db_clinic.db_clinic.service.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.db_clinic.db_clinic.dto.SignUpRequest;
import com.db_clinic.db_clinic.dto.UserDto;
import com.db_clinic.db_clinic.entity.User;
import com.db_clinic.db_clinic.enums.UserRole;
import com.db_clinic.db_clinic.repository.UserRepo;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AuthServiceImpl implements AuthService {
    private final UserRepo userrepo;

    @PostConstruct
    public void createAdminAccount(){
        User adminAccount = userrepo.findByUserRole(UserRole.ADMIN);
        if(adminAccount==null){
            User newAdminAccount = new User();
            newAdminAccount.setName("Admin");
            newAdminAccount.setEmail("admin@test.com");
            newAdminAccount.setPassword(new BCryptPasswordEncoder().encode("admin"));
            newAdminAccount.setUserRole(UserRole.ADMIN);
            userrepo.save(newAdminAccount);
            System.out.println("Admin account created successfully");

        }
    }
    @Override
    public UserDto createcustomer(SignUpRequest signuprequest) {
        // TODO Auto-generated method stub
        User user=new User();
        user.setName(signuprequest.getName());
        user.setEmail(signuprequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signuprequest.getPassword()));
        user.setUserRole(UserRole.RECEPTIONIST);
        User creatUser = userrepo.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(creatUser.getId());
        return userDto;
        
    }

    @Override
    public boolean hasCustomerWithEmail(String email) {
        // TODO Auto-generated method stub
       return userrepo.findFirstByEmail(email).isPresent();
    }

    

}
