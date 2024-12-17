package com.blog.service;

import com.blog.entily.dto.LoginDTO;
import com.blog.entily.dto.UserDto;
import com.blog.entily.po.User;

public interface UserService {

    /**
     * 登录
     * @param loginDTO
     * @return
     */
    User login(LoginDTO loginDTO);

    /**
     * 注册
     * @param userDto
     * @return
     */
    void register(UserDto userDto);

    /**
     * 修改密码
     * @param userDto
     */
    void restPWD(UserDto userDto);
}
