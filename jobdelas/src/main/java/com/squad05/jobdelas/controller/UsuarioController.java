package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.UsuarioModel;
import com.squad05.jobdelas.repository.UsuarioRepository;

@Controller
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("/usuario/cadastro.html");

        modelAndView.addObject("usuario", new UsuarioModel());
        return modelAndView;
    }

    @PostMapping("cadastrar")
    public ModelAndView cadastrar(UsuarioModel usuario) {
        ModelAndView modelAndView = new ModelAndView("redirect:/login");

        usuarioRepository.save(usuario);

        return modelAndView;

    }
}
