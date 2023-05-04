package com.example.springsocialnetworkapi.controller;

import com.example.springsocialnetworkapi.dto.*;
import com.example.springsocialnetworkapi.dto.user.*;
import com.example.springsocialnetworkapi.jwt.JwtTokenUtil;
import com.example.springsocialnetworkapi.repository.UserRepository;
import com.example.springsocialnetworkapi.service.user.IUserService;
import com.example.springsocialnetworkapi.service.user.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private IUserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

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
    public ResponseEntity<?> LoginUser(@Valid @RequestBody LoginDto loginRequest) throws Exception {
        authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        final UserDetails userDetails = userDetailsServiceImpl
                .loadUserByUsername(loginRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));

    }

    // random yêu cầu phải xác thực mới có thể request
    @GetMapping("/random")
    public RandomStuff randomStuff() {
        return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
    }

    @PutMapping("/update/{id}")
    public EditProfileDto editUser(@Valid @RequestBody EditProfileDto model, @PathVariable("id") long id) {
        model.setId(id);
        return userService.editUser(model);
    }

    @PutMapping("/reset/{id}")
    public ForgotPasswordDto updatePassword(@Valid @RequestBody ForgotPasswordDto model, @PathVariable("id") long id) {
        model.setId(id);
        return userService.updatePassword(model);
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
