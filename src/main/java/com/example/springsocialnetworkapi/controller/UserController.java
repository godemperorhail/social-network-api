package com.example.springsocialnetworkapi.controller;

import com.example.springsocialnetworkapi.custom.CustomUserDetails;
import com.example.springsocialnetworkapi.dto.*;
import com.example.springsocialnetworkapi.dto.user.*;
import com.example.springsocialnetworkapi.jwt.JwtTokenProvider;
import com.example.springsocialnetworkapi.repository.UserRepository;
import com.example.springsocialnetworkapi.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private IUserService userService;
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpDto signUpDto) {
        // add check for username exists in a DB
        if (userRepository.existsByUsername(signUpDto.getUsername())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        // add check for email exists in DB
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        userService.saveUser(signUpDto);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @PostMapping("/login")
    public LoginResponse LoginUser(@Valid @RequestBody LoginDto loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

    // random yêu cầu phải xác thực mới có thể request
    @GetMapping("/random")
    public RandomStuff randomStuff() {
        return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
    }

    @PutMapping("/updateUser/{id}")
    public EditProfileDto editUser(@Valid @RequestBody EditProfileDto model, @PathVariable("id") long id) {
        model.setId(id);
        return userService.editUser(model);
    }
    @PutMapping("/resetPassword/{id}")
    public ForgotPasswordDto updatePassword(@Valid @RequestBody ForgotPasswordDto model, @PathVariable("id") long id) {
        model.setId(id);
        return userService.updatePassword(model);
    }

}
