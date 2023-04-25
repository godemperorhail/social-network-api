package com.example.springsocialnetworkapi.service.user;

import com.example.springsocialnetworkapi.dto.user.EditProfileDto;

import com.example.springsocialnetworkapi.dto.user.ForgotPasswordDto;
import com.example.springsocialnetworkapi.dto.user.SignUpDto;

public interface IUserService {
    SignUpDto saveUser(SignUpDto signUpDto);
    EditProfileDto editUser(EditProfileDto editProfileDto);

    ForgotPasswordDto updatePassword(ForgotPasswordDto forgotPasswordDto);

}
