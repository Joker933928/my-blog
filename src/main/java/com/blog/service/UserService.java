package com.blog.service;

import com.blog.entily.dto.EmailCodeDto;
import com.blog.entily.dto.LoginDto;
import com.blog.entily.dto.UserDto;
import com.blog.entily.po.User;
import com.blog.entily.vo.UserVo;

public interface UserService {

    /**
     * 登录
     * @param loginDTO
     * @return
     */
    User login(LoginDto loginDTO);

    /**
     * 注册
     * @param userDto
     * @return
     */
    void register(UserDto userDto);

    /**
     * 修改密码
     * @param emailCodeDto
     */
    void restPWD(EmailCodeDto emailCodeDto);

    /**
     *
     * @param userId
     */
    UserVo getUser(Long userId);
}
