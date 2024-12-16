package com.example.blog.service.impl;

import com.example.blog.constant.MessageConstant;
import com.example.blog.entily.dto.LoginDTO;
import com.example.blog.entily.po.User;
import com.example.blog.entily.vo.LoginVo;
import com.example.blog.exception.BusinessException;
import com.example.blog.mapper.UserMapper;
import com.example.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param loginDTO
     * @return
     */
    @Override
    public User login(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        User user = userMapper.getUsername(username);

        // 判断用户不存在
        if(user == null){
            throw new BusinessException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        // 密码比对
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(password);
        if(!password.equals(user.getPassword())){
            System.out.println(password);
            throw new BusinessException(MessageConstant.PASSWORD_ERROR);
        }

        return user;
    }
}
