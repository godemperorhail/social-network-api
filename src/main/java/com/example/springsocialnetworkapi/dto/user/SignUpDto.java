package com.example.springsocialnetworkapi.dto.user;

import com.example.springsocialnetworkapi.dto.BaseDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpDto extends BaseDto {
    @NotBlank(message = "First name can't be empty ")
    private String firstName;
    @NotBlank(message = "Last name can't be empty ")
    private String lastName;
    @NotBlank(message = "Username can't be empty ")
    private String username;
    @NotBlank(message = "Email can't be empty ")
    @Email
    private String email;
    @NotBlank(message = "Password can't be empty ")
    @Size(min = 8,max = 36,message ="Password must be more than 8 and less than 36 characters" )
    private String password;
    @NotBlank(message = "Role can't be empty ")
    private String roleCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
