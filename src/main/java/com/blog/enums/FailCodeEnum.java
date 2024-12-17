package com.blog.enums;

public enum FailCodeEnum {

    NICKNAME_EXIST(400,"昵称已存在"),
    USERNAME_EXIST(400,"用户已存在"),
    EMAIL_EXIST(400,"邮箱已存在"),
    EMAIL_FAIL(400,"邮箱不存在"),
    USERNAME_FAIL(400,"用户名错误"),
    PASSWORD_FAIL(400,"密码错误");


    private Integer code;

    private String message;


    FailCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}