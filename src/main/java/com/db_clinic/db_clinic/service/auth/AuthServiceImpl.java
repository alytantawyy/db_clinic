package com.db_clinic.db_clinic.service.auth;

import org.springframework.stereotype.Service;

import com.db_clinic.db_clinic.entity.User;
import com.db_clinic.db_clinic.enums.UserRole;
import com.db_clinic.db_clinic.repository.UserRepo;
import com.db_clinic.dto.SignUpRequest;
import com.db_clinic.dto.UserDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AuthServiceImpl implements AuthService {
    private final UserRepo userrepo;

    @Override
    public UserDto createcustomer(SignUpRequest signuprequest) {
        // TODO Auto-generated method stub
        User user=new User();
        user.setName(signuprequest.getName());
        user.setEmail(signuprequest.getEmail());
        user.setPassword(signuprequest.getPassword());
        user.setUserrole(UserRole.RECEPTIONIST);
        User creatUser = userrepo.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(creatUser.getId());
        return null;
        
    }

}
