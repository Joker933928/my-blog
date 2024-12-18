package com.blog.entily.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginDto implements Serializable {

    // 用户名
    private String username;

    // 密码
    private String password;
}
