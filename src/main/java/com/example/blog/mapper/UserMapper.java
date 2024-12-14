package com.example.blog.mapper;

import com.example.blog.entily.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User getUsername(String username);
}
