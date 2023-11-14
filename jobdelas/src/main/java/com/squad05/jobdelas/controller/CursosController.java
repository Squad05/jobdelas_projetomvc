package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.repository.CursosRepository;

@Controller
@RequestMapping("/cursos")
public class CursosController {

    @Autowired
    private CursosRepository cursosRepository;

    @GetMapping
    public ModelAndView cursos() {
        ModelAndView modelAndView = new ModelAndView("/aprendizado/cursos.html");

        modelAndView.addObject("cursos", cursosRepository.findAll());

        return modelAndView;
    }

}