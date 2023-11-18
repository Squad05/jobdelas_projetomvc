package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.squad05.jobdelas.model.Empresas;
import com.squad05.jobdelas.services.EmpresasService;

@Controller
@RequestMapping("/jbcompany")
public class EmpresasController {

    @Autowired
    private EmpresasService empresasService;

    @GetMapping("/cadastrar/empresas")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("/jb_company/empresa-cadastro.html");
        modelAndView.addObject("empresas", new Empresas());

        return modelAndView;
    }

    @GetMapping("/listar/empresas")
    public ModelAndView listarEmpresas() {
        ModelAndView modelAndView = new ModelAndView("/jb_company/listar-empresas.html");
        modelAndView.addObject("empresas", empresasService.listarEmpresas());

        return modelAndView;
    }

    @GetMapping("/buscar/empresas")
    public ModelAndView buscarEmpresas() {
        ModelAndView modelAndView = new ModelAndView("/jb_company/buscar-empresas.html");

        return modelAndView;
    }

    @PostMapping("/empresas")
    public String cadastrarEmpresa(Empresas empresas) {
        empresasService.cadastrarEmpresa(empresas);

        return "redirect:/jbcompany/listar/empresas";
    }

    @PostMapping("/deletar/empresa/{id}")
    public String deletarEmpresa(@PathVariable Long id, RedirectAttributes attributes) {
        try {
            empresasService.deletarEmpresa(id);
            return "redirect:/jbcompany/listar/empresas";

        } catch (DataIntegrityViolationException e) {
            attributes.addAttribute("erro", "Não é possível excluir a empresa, pois existem vagas associadas.");
            return "redirect:/jbcompany/listar/empresas";
        }
    }

}
