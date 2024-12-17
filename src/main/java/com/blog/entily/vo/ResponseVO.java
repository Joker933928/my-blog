package com.blog.entily.vo;

import com.blog.enums.ResponseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO<T> {

    private Integer code;
    private String msg;
    private T data;// 数据


    public static <T> ResponseVO<T> success(ResponseCodeEnum codeEnum){
        return new ResponseVO<>(codeEnum.getCode(),codeEnum.getMessage(),null);
    }

    public static <T> ResponseVO<T> success(ResponseCodeEnum codeEnum,T data){
        return new ResponseVO<>(codeEnum.getCode(),codeEnum.getMessage(),data);
    }

    public static <T> ResponseVO<T> error(ResponseCodeEnum codeEnum){
        return new ResponseVO<>(codeEnum.getCode(),codeEnum.getMessage(),null);
    }

    public static <T> ResponseVO<T> error(ResponseCodeEnum codeEnum,T data){
        return new ResponseVO<>(codeEnum.getCode(),codeEnum.getMessage(),data);
    }

}
