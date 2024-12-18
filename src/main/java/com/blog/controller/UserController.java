package com.blog.controller;


import com.blog.entily.dto.EmailCodeDto;
import com.blog.entily.dto.UserDto;
import com.blog.entily.vo.ResponseVO;
import com.blog.entily.vo.UserVo;
import com.blog.enums.ResponseCodeEnum;
import com.blog.service.UserService;
import com.blog.constant.JwtClaimsConstant;
import com.blog.entily.dto.LoginDto;
import com.blog.entily.po.User;
import com.blog.entily.vo.LoginVo;
import com.blog.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param loginDto
     * @return
     */
    @PostMapping("/login")
    public ResponseVO<LoginVo> login(@RequestBody LoginDto loginDto) {
        User user = userService.login(loginDto);

        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());

        String token = JwtUtil.createJWT(loginDto.getUsername(),0L,claims);
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

    /**
     * 注册
     * @param userDto
     * @return
     */
    @PostMapping("/register")
    public ResponseVO<LoginVo> register(@RequestBody UserDto userDto){
        userService.register(userDto);
        return ResponseVO.success(ResponseCodeEnum.REGISTER_SUCCESS);
    }


    /**
     * 退出
     * @return
     */
    @PostMapping("/logout")
    public ResponseVO logout(){
        return ResponseVO.success(ResponseCodeEnum.LOGOUT_SUCCESS);
    }

    /**
     * 修改密码
     * @param emailCodeDto
     * @return
     */
    @PostMapping("/restPassword")
    public ResponseVO<LoginVo> restPassword(@RequestBody EmailCodeDto emailCodeDto){
        userService.restPWD(emailCodeDto);
        return ResponseVO.success(ResponseCodeEnum.CODE_200);
    }

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    @GetMapping("/getUser")
    public ResponseVO getUser(@RequestParam("userId") Long userId){
        UserVo user = userService.getUser(userId);
        return ResponseVO.success(ResponseCodeEnum.CODE_200,user);
    }

}
