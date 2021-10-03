package com.lovezhan.controller.advice;

import com.lovezhan.controller.UserController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * 如果不手动的处理异常， ErrorController将会兜底处理
 */
@Slf4j
//@ControllerAdvice("com.lovezhan.controller")
public class UserControllerAdvice extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    public String handleControllerException(HttpServletRequest request,Throwable ex) {
        log.info("异常advice");
        HttpStatus status = getStatus(request);
        return status.toString();
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer code = (Integer)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        HttpStatus status = null;
        if(code != null){
            status = HttpStatus.resolve(code);
        }
        return (status != null) ? status : HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
