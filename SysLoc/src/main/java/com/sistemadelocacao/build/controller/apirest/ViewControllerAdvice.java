package com.sistemadelocacao.build.controller.apirest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = Controller.class)
public class ViewControllerAdvice {
    
    @ExceptionHandler(Exception.class)
    public String errorException(Exception e, Model model){
        model.addAttribute("mensagemDeErro", e.getMessage());
        return "error";
    }
}