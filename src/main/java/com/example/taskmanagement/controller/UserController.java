package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.LoginDTO;
import com.example.taskmanagement.dto.UserDTO;
import com.example.taskmanagement.model.User;
import com.example.taskmanagement.payload.LoginMessage;
import com.example.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Qualifier("userService")
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginMessage login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }

    @PostMapping("/register")
    public String register(@RequestBody UserDTO userDTO) {
        return userService.register(userDTO);
    }

}
