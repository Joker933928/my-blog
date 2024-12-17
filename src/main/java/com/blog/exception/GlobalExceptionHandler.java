package com.blog.exception;

import com.blog.entily.vo.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ResponseVO<String>> handleBusinessException(BusinessException ex){
        ResponseVO<String> responseVO = new ResponseVO<>(ex.getCode(),ex.getMessage(),null);
        return new ResponseEntity<>(responseVO, HttpStatus.BAD_REQUEST);
    }

}
