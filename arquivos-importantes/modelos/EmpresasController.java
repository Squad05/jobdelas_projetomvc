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

import com.squad05.jobdelas.model.Empresas;
import com.squad05.jobdelas.repository.EmpresaRepository;


@Controller
@RequestMapping("/empresas")
public class EmpresasController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping
    public ModelAndView aulas() {
        ModelAndView modelAndView = new ModelAndView("/empresas.html");

        modelAndView.addObject("empresas", empresaRepository.findAll());

        return modelAndView;
    }
@PostMapping("/empresa")
    public ResponseEntity<Empresas> createAulas(@RequestBody Empresas Empresas) {
        Empresas newEmpresas = empresaRepository.save(Empresas);
        return new ResponseEntity<>(newEmpresas, HttpStatus.CREATED);
    }
}