package com.xcodev.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author xCode
 * @date 2025/1/26
 **/
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<XCodevResult> handleException(Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(XCodevResult.error(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
