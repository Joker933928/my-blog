package com.blog.service.impl;

import com.blog.enums.FailCodeEnum;
import com.blog.service.UserService;
import com.blog.constant.MessageConstant;
import com.blog.entily.dto.LoginDTO;
import com.blog.entily.dto.UserDto;
import com.blog.entily.po.User;
import com.blog.exception.BusinessException;
import com.blog.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;


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
            throw new BusinessException(FailCodeEnum.USERNAME_FAIL);
        }

        // 密码比对
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println("加密密码后:"+password);
        if(!password.equals(user.getPassword())){
            throw new BusinessException(FailCodeEnum.PASSWORD_FAIL);
        }

        return user;
    }


    /**
     * 注册
     *
     * @param userDto
     * @return
     */
    @Override
    public void register(UserDto userDto) {
        // 根据邮箱搜索用户
        User user = userMapper.selectByEmail(userDto.getEmail());

        if(user != null){
            throw new BusinessException(FailCodeEnum.EMAIL_EXIST);
        }

        User username = userMapper.getUsername(userDto.getUsername());
        if(username != null){
            throw new BusinessException(FailCodeEnum.USERNAME_EXIST);
        }

        // 初始化User类
        user = new User();

        byte[] password = userDto.getPassword().getBytes();
        user.setUsername(userDto.getUsername());
        user.setPassword(DigestUtils.md5DigestAsHex(password));
        user.setNickname(userDto.getNickname());
        user.setEmail(userDto.getEmail());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
    }


    /**
     * 修改密码
     *
     * @param userDto
     */
    @Override
    public void restPWD(UserDto userDto) {
        // 根据邮箱搜索用户
        String email = userDto.getEmail();
        String newPassword = userDto.getPassword();
        if(newPassword == null || newPassword.length() == 0){
            throw new BusinessException(FailCodeEnum.PASSWORD_FAIL);
        }

        User user = userMapper.selectByEmail(email);
        if(user == null){
            throw new BusinessException(FailCodeEnum.EMAIL_FAIL);
        }

        byte[] password = newPassword.getBytes();
        String pwd = DigestUtils.md5DigestAsHex(password);

        userMapper.updatePassword(pwd,email);
    }
}
