package com.example.springsocialnetworkapi.service.user.impl;

import com.example.springsocialnetworkapi.converter.user.EditUserConverter;
import com.example.springsocialnetworkapi.converter.user.ForgotPasswordConverter;
import com.example.springsocialnetworkapi.converter.user.SignUpConverter;
import com.example.springsocialnetworkapi.dto.user.EditProfileDto;
import com.example.springsocialnetworkapi.dto.user.ForgotPasswordDto;
import com.example.springsocialnetworkapi.dto.user.SignUpDto;
import com.example.springsocialnetworkapi.entity.RoleEntity;
import com.example.springsocialnetworkapi.entity.UserEntity;
import com.example.springsocialnetworkapi.service.user.IUserService;
import com.example.springsocialnetworkapi.repository.RoleRepository;
import com.example.springsocialnetworkapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private SignUpConverter signUpConverter;

    @Autowired
    private EditUserConverter editUserConverter;
    @Autowired
    private ForgotPasswordConverter forgotPasswordConverter;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public SignUpDto saveUser(SignUpDto signUpDto) {
        UserEntity users = new UserEntity();
        users = signUpConverter.toEntity(signUpDto);
        RoleEntity roles = roleRepository.findOneByRoleCode(signUpDto.getRoleCode()).get();
        users.setRoles(Collections.singletonList(roles));
        users = userRepository.save(users);
        return signUpConverter.toDto(users);
    }

    @Override
    public EditProfileDto editUser(EditProfileDto editProfileDto) {
        UserEntity users = new UserEntity();
        if (editProfileDto.getId() != null) {
            UserEntity oldUser = userRepository.findById(editProfileDto.getId()).get();
            users = editUserConverter.toEntity(editProfileDto, oldUser);
        }
        users = userRepository.save(users);
        return editUserConverter.toDto(users);
    }

    @Override
    public ForgotPasswordDto updatePassword(ForgotPasswordDto forgotPasswordDto) {
        UserEntity users=new UserEntity();
        if (forgotPasswordDto.getEmail()!=null){
            UserEntity insertUser=userRepository.findByUsername(forgotPasswordDto.getUsername()).get();
            users= forgotPasswordConverter.toEntity(forgotPasswordDto,insertUser);
        }
        users=userRepository.save(users);

        return forgotPasswordConverter.toDto(users);
    }

}
