package com.example.blog.entily.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginDTO implements Serializable {

    // 用户名
    private String username;

    // 密码
    private String password;
}
