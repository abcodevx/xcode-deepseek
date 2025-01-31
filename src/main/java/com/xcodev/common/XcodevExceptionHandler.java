package com.xcodev.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author xCode
 **/
@RestControllerAdvice
public class XcodevExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return new ResponseEntity<>(XcodevResult.error(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
