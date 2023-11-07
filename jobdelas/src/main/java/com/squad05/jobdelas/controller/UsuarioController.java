package com.squad05.jobdelas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UsuarioController {

    @GetMapping("cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("/usuario/cadastro.html");

        return modelAndView;
    }

}
