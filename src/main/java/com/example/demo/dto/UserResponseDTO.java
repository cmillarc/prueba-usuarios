package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private String id;

    private Date created;

    private Date modified;

    private Date lastLogin;

    private String token;

    private boolean isActive;

}
