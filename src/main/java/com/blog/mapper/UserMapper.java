package com.blog.mapper;

import com.blog.entily.po.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User getUsername(String username);

    @Select("select * from user where email = #{email}")
    User selectByEmail(String email);


    @Insert("insert into user (username, password, nickname, email, avatar, context, create_time, update_time)"
            + "values " + "(#{username},#{password},#{nickname},#{email},#{avatar},#{context},#{createTime},#{updateTime})")
    void insert(User user);

    @Update("update user set password = #{password} where email = #{email}")
    void updatePassword(@Param("password") String password,@Param("email") String email);

    @Select("select * from user where id = #{id}")
    User selectById(Long id);
}
