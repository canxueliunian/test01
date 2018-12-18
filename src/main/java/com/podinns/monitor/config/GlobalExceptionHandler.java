package com.podinns.monitor.config;

/**
 * Created by lishuntao on 2018/11/27.
 * 群居错误处理controller
 */

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView businessExceptionHandler(HttpServletRequest req, Exception e) throws Exception {

        ModelAndView mav = new ModelAndView();
        mav.addObject("message", e.getMessage());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }


}

