package com.example.springsocialnetworkapi.converter.user;

import com.example.springsocialnetworkapi.dto.user.SignUpDto;
import com.example.springsocialnetworkapi.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SignUpConverter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity toEntity(SignUpDto signUpDto) {
        UserEntity users = new UserEntity();
        users.setUsername(signUpDto.getUsername());
        users.setEncrytedPassword(passwordEncoder.encode(signUpDto.getPassword()));
        users.setFirstName(signUpDto.getFirstName());
        users.setLastName(signUpDto.getLastName());
        users.setEmail(signUpDto.getEmail());
        return users;
    }

    public SignUpDto toDto(UserEntity userEntity) {

        SignUpDto dto = new SignUpDto();

        if (userEntity.getId()!=null){
            dto.setId(userEntity.getId());
        }


        dto.setUsername(userEntity.getUsername());
        dto.setPassword(passwordEncoder.encode(userEntity.getEncrytedPassword()));
        dto.setFirstName(userEntity.getFirstName());
        dto.setLastName(userEntity.getLastName());
        dto.setEmail(userEntity.getEmail());
        return dto;
    }
}
