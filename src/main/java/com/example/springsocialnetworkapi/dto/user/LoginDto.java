package com.example.springsocialnetworkapi.dto.user;

import javax.validation.constraints.NotBlank;

public class LoginDto {
    @NotBlank(message = "Username can't be empty ")
    private String username;
    @NotBlank(message = "Password can't be empty ")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
