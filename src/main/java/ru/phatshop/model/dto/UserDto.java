package ru.phatshop.model.dto;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private String confirmPassword;
    private String role;
}
