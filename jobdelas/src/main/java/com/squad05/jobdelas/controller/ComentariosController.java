// package com.squad05.jobdelas.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.servlet.ModelAndView;

// import com.squad05.jobdelas.repository.ComentariosRepository;

// @Controller
// @RequestMapping("comentarios")
// public class ComentariosController {

// @Autowired
// private ComentariosRepository comentariosRepository;

// @GetMapping
// public ModelAndView comentarios() {
// ModelAndView modelAndView = new ModelAndView("/comentarios.html");

// modelAndView.addObject("comentarios", comentariosRepository.findAll());
// return modelAndView;
// }
// }
