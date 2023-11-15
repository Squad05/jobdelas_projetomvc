package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Empresas;
import com.squad05.jobdelas.services.EmpresasService;

@Controller
@RequestMapping("/jbcompany")
public class EmpresasController {

    @Autowired
    private EmpresasService empresasService;

    @GetMapping("/empresas")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("/jb_company/empresaCadastro.html");
        modelAndView.addObject("empresas", new Empresas());

        return modelAndView;
    }

    @PostMapping("/empresas")
    public String cadastrarEmpresa(Empresas empresas) {
        System.out.println(empresas);
        empresasService.cadastrarEmpresa(empresas);

        return "redirect:/";
    }

}
