package com.example.springboot_springsecurity.entity;

import lombok.Data;

/**
 * @date 2020/10/24 - 13:44
 */
@Data
public class UserInfo {
    private int id;
    private String username;
    private String password;
    private String role;
}