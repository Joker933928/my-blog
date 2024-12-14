package com.example.blog.service;

import com.example.blog.entily.dto.LoginDTO;
import com.example.blog.entily.po.User;
import com.example.blog.entily.vo.LoginVo;

public interface UserService {

    /**
     * 登录
     * @param loginDTO
     * @return
     */
    User login(LoginDTO loginDTO);

}
