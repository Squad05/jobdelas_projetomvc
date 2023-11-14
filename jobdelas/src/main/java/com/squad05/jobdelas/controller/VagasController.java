package com.squad05.jobdelas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("vagas")
public class VagasController {

    @GetMapping()
    public ModelAndView vagas() {
        ModelAndView modelAndView = new ModelAndView("/vagas/vagas.html");

        return modelAndView;
    }
}
