package com.example.springsocialnetworkapi.service.user.impl;

import com.example.springsocialnetworkapi.custom.CustomUserDetails;
import com.example.springsocialnetworkapi.entity.UserEntity;
import com.example.springsocialnetworkapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity users = userRepository.findByUsername(username).get();
        if (users == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(users);
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return new CustomUserDetails(user);
    }

}
