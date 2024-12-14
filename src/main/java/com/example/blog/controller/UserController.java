package com.example.blog.controller;


import com.example.blog.constant.JwtClaimsConstant;
import com.example.blog.entily.dto.LoginDTO;
import com.example.blog.entily.po.User;
import com.example.blog.entily.vo.LoginVo;
import com.example.blog.entily.vo.ResponseVO;
import com.example.blog.properties.JwtProperties;
import com.example.blog.service.UserService;
import com.example.blog.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    public ResponseVO<LoginVo> login(@RequestBody LoginDTO loginDTO) {
        User user = userService.login(loginDTO);

        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims
        );

        LoginVo loginVo = LoginVo.builder()
                .id(user.getId())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .token(token)
                .build();

        return ResponseVO.success(loginVo);

    }


}
