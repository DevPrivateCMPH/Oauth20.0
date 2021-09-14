package com.cmph.api.main.service;


import com.cmph.api.main.dto.UserDto;
import com.cmph.api.main.model.AuthUser;
import com.cmph.api.main.repository.UserRepository;
import com.cmph.api.main.repository.UserRoleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AuthUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	public AuthUser register(UserDto userDto) {
        AuthUser authUser = new ObjectMapper().convertValue(userDto, AuthUser.class);
        authUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        authUser.setRoles(Collections.singletonList(userRoleRepository.findByRoleNameContaining("USER")));
        Optional<AuthUser> optUser = userRepository.findByUserNameOrEmail(userDto.getUserName(), userDto.getEmail());
        if (!optUser.isPresent()) {
            return userRepository.save(authUser);
        }
        throw new RuntimeException("User already exist");
    }
}
