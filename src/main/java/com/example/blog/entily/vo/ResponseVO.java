package com.example.blog.entily.vo;

import com.example.blog.enums.ResponseCodeEnum;
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


    public static <T> ResponseVO<T> success(){
        return new ResponseVO<>(200,"操作成功",null);
    }

    public static <T> ResponseVO<T> success(T data){
        return new ResponseVO<>(200,"操作成功",data);
    }

    public static <T> ResponseVO<T> error(){
        return new ResponseVO<>(404,"页面不存在",null);
    }

    public static <T> ResponseVO<T> error(T data){
        return new ResponseVO<>(400,"请求参数错误",data);
    }

}
