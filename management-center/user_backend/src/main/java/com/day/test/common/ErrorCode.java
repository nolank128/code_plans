package com.day.test.common;

/**
 * 错误码
 *
 */
public enum ErrorCode {

    SUCCESS(0,"ok",""),
    PARAMS_ERROR(40000,"请求错误",""),
    NULL_ERROR(40001,"请求参数为空",""),
    NOT_LOGIN(40100,"未登录",""),
    NO_AUTH(40101,"无权限",""),
    SYSTEM_ERROR(50000,"系统内部错误","");


    private final int code;
    /*
    * 状态码信息*/
    private final String message;
    /*
    * 错误码信息
    * */
    private  final String description;

    ErrorCode(int code,String message,String description) {
        this.code=code;
        this.message = message;
        this.description=description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
