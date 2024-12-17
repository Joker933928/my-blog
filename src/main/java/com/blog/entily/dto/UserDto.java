package com.blog.entily.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class UserDto implements Serializable {

    // 用户名
    private String username;

    // 密码
    private String password;

    // 昵称
    private String nickname;

    // 邮箱
    private String email;


}
