package com.example.backend.controllers;

import com.example.backend.Dto.SignUpDto;
import com.example.backend.Dto.UserDto;
import com.example.backend.Services.UserService;
import com.example.backend.config.UserAuthProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.backend.Dto.CredentialsDto;

import java.net.URI;

//jersey edit
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    private final UserService userService;
    UserAuthProvider userAuthProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto) {
        UserDto user = userService.login(credentialsDto);
        user.setToken(userAuthProvider.createToken(user));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        try {
            UserDto createdUser = userService.register(user);
            createdUser.setToken(userAuthProvider.createToken(createdUser));
            return ResponseEntity.created(URI.create("/users" + createdUser.getLogin())).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}