package com.blog.entily.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginVo implements Serializable {

    // 主键ID
    private Long id;

    // 用户名
    private String username;

     // 昵称
    private String nickname;

    // 邮箱
    private String email;

    // jwt令牌
    private String token;
}
