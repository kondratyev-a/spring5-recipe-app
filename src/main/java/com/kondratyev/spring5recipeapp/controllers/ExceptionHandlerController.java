package com.kondratyev.spring5recipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormat(Exception exception){

        log.error("Handling number format exception");
        log.error(exception.getMessage());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("error");
        modelAndView.addObject("header", "400 Bad Request");
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }
}

