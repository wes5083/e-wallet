package com.demo.ewallet.vo;

import lombok.Data;

@Data
public class ResponseVo<T> {

    public final static int SUCCESS = 1;
    public final static int FAIL = 0;
    public final static int NOT_SUPPORT = 2;

    private int statusCode;

    private String message;

    private T data;

    public ResponseVo(int statusCode, String message, T data) {
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }

    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo<T>(SUCCESS, "success", data);
    }

    public static <T> ResponseVo<T> fail(String message, T data) {
        return new ResponseVo<T>(FAIL, message, data);
    }

}