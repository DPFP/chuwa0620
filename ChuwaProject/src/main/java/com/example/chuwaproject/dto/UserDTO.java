package com.example.chuwaproject.dto;

import lombok.Data;

@Data
public class UserDTO {
    private long id;
    private String email;
    private String username;
    private int points;
}
