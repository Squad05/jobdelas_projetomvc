package com.squad05.jobdelas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Usuarios;

@Controller
@RequestMapping("/jbcompany")
public class EmpresasController {

    @GetMapping("/empresas")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("/jb_company/empresaCadastro.html");
        return modelAndView;
    }

}
