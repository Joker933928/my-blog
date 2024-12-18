package com.blog.entily.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmailCodeDto implements Serializable {

    // 邮箱
    private String email;

    // 密码
    private String password;

}
