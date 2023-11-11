package com.squad05.jobdelas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CursosController {

    @GetMapping("cursos")
    public ModelAndView cursos() {
        ModelAndView modelAndView = new ModelAndView("/aprendizado/cursos.html");

        return modelAndView;
    }

    @GetMapping("curso")
    public ModelAndView curso() {
        ModelAndView modelAndView = new ModelAndView("/aprendizado/curso.html");

        return modelAndView;
    }
}