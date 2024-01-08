package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.LoginDTO;
import com.example.taskmanagement.dto.UserDTO;
import com.example.taskmanagement.model.User;
import com.example.taskmanagement.payload.LoginMessage;

public interface UserService {
    public LoginMessage login(LoginDTO loginDTO);
    public String register(UserDTO userDTO);
    public UserDTO getUser(String username);
    public UserDTO getUser(Long id);
    public void deleteUser(Long id);
}
