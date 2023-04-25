package com.example.springsocialnetworkapi.converter.user;

import com.example.springsocialnetworkapi.dto.user.EditProfileDto;
import com.example.springsocialnetworkapi.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EditUserConverter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity toEntity(EditProfileDto editProfileDto, UserEntity userEntity) {
        userEntity.setUsername(editProfileDto.getUsername());
        userEntity.setEncrytedPassword(passwordEncoder.encode(editProfileDto.getPassword()));
        userEntity.setFirstName(editProfileDto.getFirstName());
        userEntity.setLastName(editProfileDto.getLastName());
        userEntity.setEmail(editProfileDto.getEmail());
        userEntity.setBio(editProfileDto.getBio());
        userEntity.setUserImage(editProfileDto.getImage());
        return userEntity;
    }

    public EditProfileDto toDto(UserEntity userEntity) {
        EditProfileDto editProfileDto = new EditProfileDto();

        if (userEntity.getId()!=null){
            editProfileDto.setId(userEntity.getId());
        }
        editProfileDto.setCreatedBy(userEntity.getCreatedBy());
        editProfileDto.setCreatedDate(userEntity.getCreatedDate());
        editProfileDto.setModifiedBy(userEntity.getModifiedBy());
        editProfileDto.setModifiedDate(userEntity.getModifiedDate());
        editProfileDto.setUsername(userEntity.getUsername());
        editProfileDto.setPassword(passwordEncoder.encode(userEntity.getEncrytedPassword()));
        editProfileDto.setFirstName(userEntity.getFirstName());
        editProfileDto.setLastName(userEntity.getLastName());
        editProfileDto.setEmail(userEntity.getEmail());
        editProfileDto.setBio(userEntity.getBio());
        editProfileDto.setImage(userEntity.getUserImage());
        return editProfileDto;
    }

}
