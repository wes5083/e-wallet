package com.demo.ewallet.exception;


import com.demo.ewallet.vo.ResponseVo;
import lombok.Data;

@Data
public class NotSupportException extends RuntimeException {

    private Integer code;

    private String message;

    public NotSupportException(String message) {
        super(message);
        this.message = message;
        this.code = ResponseVo.NOT_SUPPORT;
    }

}
