package com.day.test.exception;

import com.day.test.common.BaseResponse;
import com.day.test.common.ErrorCode;
import com.day.test.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHander {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse businessException(BusinessException e){
        log.error("businessExceptionHander: "+ e.getMessage(),e);
        return ResultUtils.error(e.getCode(),e.getMessage(),e.getDescription());

    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse runtimeException(RuntimeException e){
        log.error("runtimeException",e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR,e.getMessage(),"");

    }
}
