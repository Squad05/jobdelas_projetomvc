// package com.squad05.jobdelas.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.servlet.ModelAndView;

// import com.squad05.jobdelas.repository.VagasRepository;

// @Controller
// @RequestMapping("vagas")
// public class VagasController {

// @Autowired
// private VagasRepository vagasRepository;

// @GetMapping
// public ModelAndView vagas() {
// ModelAndView modelAndView = new ModelAndView("/vagas/vagas.html");

// modelAndView.addObject("vagas", vagasRepository.findAll());
// return modelAndView;
// }
// }
