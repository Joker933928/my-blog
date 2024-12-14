package com.example.blog.enums;

public enum ResponseCodeEnum {

    CODE_200(200,"操作成功"),
    CODE_400(400,"请求参数错误"),
    CODE_401(401,"身份认证过去，请重新登录"),
    CODE_404(404,"页面不存在"),
    CODE_405(405,"请求方法错误"),
    CODE_500(500,"服务器返回错误，请联系管理员"),
    CODE_501(501,"服务器未响应"),
    CODE_502(502,"网关错误");

    private Integer code;
    private String message;


    ResponseCodeEnum(Integer code, String message) {
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
