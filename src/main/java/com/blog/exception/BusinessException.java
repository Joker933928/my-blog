package com.blog.exception;

import com.blog.enums.FailCodeEnum;

public class BusinessException extends RuntimeException {

    private final Integer code;   // 响应码

    private final String message; // 消息体

    public BusinessException(FailCodeEnum codeEnum){
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
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
