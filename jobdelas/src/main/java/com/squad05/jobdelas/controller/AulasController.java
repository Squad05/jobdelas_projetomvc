package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.repository.AulasRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/aulas")
public class AulasController {

    @Autowired
    private AulasRepository aulasRepository;

    @GetMapping
    public ModelAndView aulas() {
        ModelAndView modelAndView = new ModelAndView("/aulas.html");

        modelAndView.addObject("aulas", aulasRepository.findAll());

        return modelAndView;
    }

}