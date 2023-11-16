package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.repository.VagasRepository;
import com.squad05.jobdelas.services.VagasService;

@Controller
@RequestMapping("vagas")
public class VagasController {

    @Autowired
    private VagasService vagasService;

    @GetMapping
    public ModelAndView vagas() {
        ModelAndView modelAndView = new ModelAndView("/jobdelas/vagas/vagas.html");

        modelAndView.addObject("vagas", vagasService.listarVagas());

        return modelAndView;
    }
}
