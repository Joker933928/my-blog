package com.example.blog.entily.vo;

import com.example.blog.enums.ResponseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO<T> {

    private ResponseCodeEnum codeEnum;
    private T data;// 数据


    public static <T> ResponseVO<T> success(){
        return new ResponseVO<>(ResponseCodeEnum.CODE_200,null);
    }

    public static <T> ResponseVO<T> success(T data){
        return new ResponseVO<>(ResponseCodeEnum.CODE_200,data);
    }

    public static <T> ResponseVO<T> error(){
        return new ResponseVO<>(ResponseCodeEnum.CODE_404,null);
    }

    public static <T> ResponseVO<T> error(T data){
        return new ResponseVO<>(ResponseCodeEnum.CODE_400,data);
    }

}
