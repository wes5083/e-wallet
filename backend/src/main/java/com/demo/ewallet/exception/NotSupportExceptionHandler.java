package com.demo.ewallet.exception;

import com.demo.ewallet.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class NotSupportExceptionHandler {

    @ExceptionHandler(com.demo.ewallet.exception.NotSupportException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVo handleNotSupportException(com.demo.ewallet.exception.NotSupportException ex) {
        return new ResponseVo(ex.getCode(), ex.getMessage(), null);
    }

}
