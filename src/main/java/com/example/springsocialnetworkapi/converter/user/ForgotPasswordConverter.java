package com.example.springsocialnetworkapi.converter.user;

import com.example.springsocialnetworkapi.dto.user.ForgotPasswordDto;
import com.example.springsocialnetworkapi.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ForgotPasswordConverter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity toEntity(ForgotPasswordDto forgotPasswordDto, UserEntity userEntity) {
        userEntity.setEncrytedPassword(passwordEncoder.encode(forgotPasswordDto.getPassword()));
        return userEntity;
    }

    public ForgotPasswordDto toDto(UserEntity userEntity) {
        ForgotPasswordDto forgotPasswordDto = new ForgotPasswordDto();
        forgotPasswordDto.setUsername(userEntity.getUsername());
        forgotPasswordDto.setPassword(passwordEncoder.encode(userEntity.getEncrytedPassword()));
        return forgotPasswordDto;
    }
}
