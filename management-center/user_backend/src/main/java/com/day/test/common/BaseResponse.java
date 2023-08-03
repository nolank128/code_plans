package com.day.test.common;


import lombok.Data;

import java.io.Serializable;


/**
 * 通用返回类
 * @param <T>
 */

@Data
public class BaseResponse<T> implements Serializable {
    private int code;

    private T data;

    private String message;

    private String desciption;

    public BaseResponse(int code,T data,String message,String desciption) {
        this.code = code;
        this.data=data;
        this.message=message;
        this.desciption=desciption;
    }

    public BaseResponse(int code,T data,String message){

        this(code,data,message,"");
    }

    public BaseResponse(int code,T data){

        this(code,data,"","");
    }

    public BaseResponse(ErrorCode errorCode){
        this(errorCode.getCode(),null,errorCode.getMessage(),errorCode.getDescription());
    }
}
