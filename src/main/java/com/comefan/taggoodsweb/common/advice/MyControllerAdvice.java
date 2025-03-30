package com.comefan.taggoodsweb.common.advice;

import com.comefan.taggoodsweb.controller.vo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class MyControllerAdvice {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseResponse handleException(Exception e){
        log.info("MyControllerAdvice handleException msg={}",e.getMessage(),e);
        return BaseResponse.getFailResponse(BaseResponse.class,e.getMessage());
    }

}
