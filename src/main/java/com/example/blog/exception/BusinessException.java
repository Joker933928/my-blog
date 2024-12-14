package com.example.blog.exception;

import com.example.blog.enums.ResponseCodeEnum;

public class BusinessException extends RuntimeException {

    private ResponseCodeEnum codeEnum;

    private Integer code;   // 响应码

    private String message; // 消息体

    public BusinessException(String message,Throwable e){
        super(message,e);
        this.message = message;
    }

    public BusinessException(String message){
        super(message);
        this.message = message;
    }

    public BusinessException(Throwable throwable){
        super(throwable);
    }

    public BusinessException(ResponseCodeEnum codeEnum){
        super(codeEnum.getMessage());
        this.codeEnum = codeEnum;
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public ResponseCodeEnum getCodeEnum() {
        return codeEnum;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    /**
     * 重写fillInStackTrace 业务异常不需要堆栈信息，提高效率
     */
    public Throwable fillInStackTrace(){
        return this;
    }

}
