package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/listar/empresas")
    public ModelAndView listarEmpresas() {
        ModelAndView modelAndView = new ModelAndView("/jb_company/listarEmpresas.html");
        modelAndView.addObject("empresas", empresasService.listarEmpresas());

        return modelAndView;
    }

    @GetMapping("/buscar/empresas")
    public ModelAndView buscarEmpresas() {
        ModelAndView modelAndView = new ModelAndView("/jb_company/buscarEmpresas.html");

        return modelAndView;
    }

    @PostMapping("/empresas")
    public String cadastrarEmpresa(Empresas empresas) {
        empresasService.cadastrarEmpresa(empresas);

        return "redirect:/";
    }

    @PostMapping("/deletar/empresa")
    public String deletarEmpresa(@RequestParam Long id) {
        empresasService.deletarEmpresa(id);
        return "redirect:/listar/empresas";
    }

}
