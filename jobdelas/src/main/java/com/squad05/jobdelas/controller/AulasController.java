package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Aulas;
import com.squad05.jobdelas.repository.AulasRepository;

@Controller
@RequestMapping("/aulas")
public class AulasController {

    @Autowired
    private AulasRepository aulasRepository;

    @GetMapping
    public ModelAndView aulas() {
        ModelAndView modelAndView = new ModelAndView("/aprendizado/aulas.html");

        modelAndView.addObject("cursos", aulasRepository.findAll());

        return modelAndView;
    }

    @PostMapping("/aulas.html")
    public ResponseEntity<Aulas> createAulas(@RequestBody Aulas aulas) {
        Aulas newAulas = aulasRepository.save(aulas);
        return new ResponseEntity<>(newAulas, HttpStatus.CREATED);
    }
}