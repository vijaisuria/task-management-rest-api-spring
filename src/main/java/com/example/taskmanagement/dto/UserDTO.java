package com.example.taskmanagement.dto;

public class UserDTO {
    private String username;
    private String password;

    public UserDTO() {
        this.username = "";
        this.password = "";
    }

    public UserDTO(String username, String password, Long id) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
