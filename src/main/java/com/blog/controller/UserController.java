package com.blog.controller;


import com.blog.entily.dto.UserDto;
import com.blog.entily.vo.ResponseVO;
import com.blog.enums.ResponseCodeEnum;
import com.blog.service.UserService;
import com.blog.constant.JwtClaimsConstant;
import com.blog.entily.dto.LoginDTO;
import com.blog.entily.po.User;
import com.blog.entily.vo.LoginVo;
import com.blog.utils.JwtUtil;
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

    @PostMapping("/login")
    public ResponseVO<LoginVo> login(@RequestBody LoginDTO loginDTO) {
        User user = userService.login(loginDTO);

        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());

        String token = JwtUtil.createJWT(loginDTO.getUsername(),0L,claims);
        System.out.println(token);;

        LoginVo loginVo = LoginVo.builder()
                .id(user.getId())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .token(token)
                .build();

        return ResponseVO.success(ResponseCodeEnum.LOGIN_SUCCESS,loginVo);
    }

    @PostMapping("/register")
    public ResponseVO<LoginVo> register(@RequestBody UserDto userDto){
        userService.register(userDto);
        return ResponseVO.success(ResponseCodeEnum.REGISTER_SUCCESS);
    }


    @PostMapping("/logout")
    public ResponseVO logout(){
        return ResponseVO.success(ResponseCodeEnum.LOGOUT_SUCCESS);
    }

    @PostMapping("/restPassword")
    public ResponseVO<LoginVo> restPassword(@RequestBody UserDto userDto){
        userService.restPWD(userDto);
        return ResponseVO.success(ResponseCodeEnum.CODE_200);
    }


}
