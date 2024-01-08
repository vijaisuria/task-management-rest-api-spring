package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.LoginDTO;
import com.example.taskmanagement.dto.UserDTO;
import com.example.taskmanagement.model.User;
import com.example.taskmanagement.payload.LoginMessage;
import com.example.taskmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginMessage login(LoginDTO loginDTO) {
        User user = userRepository.findByUsername(loginDTO.getUsername());
        if (user == null) {
            return new LoginMessage("User not found", false);
        }
        String password = loginDTO.getPassword();
        String encodedPassword = user.getPassword();
        Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
        if (!isPwdRight) {
            return new LoginMessage("Wrong password", false);
        }
        return new LoginMessage("Login successful", true);
    }

    @Override
    public String register(UserDTO userDTO) {
        String username = userDTO.getUsername();
        if (userRepository.findByUsername(username) != null) {
            return "Username already exists";
        }
        String encodedPassword = this.passwordEncoder.encode(userDTO.getPassword());
        User user = new User(username, encodedPassword);
        userRepository.save(user);
        return userDTO.getUsername();
    }

    @Override
    public UserDTO getUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return new UserDTO();
        }
        return new UserDTO(user.getUsername(), user.getPassword(), user.getId());
    }

    @Override
    public UserDTO getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return new UserDTO();
        }
        return new UserDTO(user.getUsername(), user.getPassword(), user.getId());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
