package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Vagas;
import com.squad05.jobdelas.services.EmpresasService;
import com.squad05.jobdelas.services.VagasService;

@Controller
public class VagasController {

    @Autowired
    private VagasService vagasService;

    @Autowired
    private EmpresasService empresasService;

    @GetMapping("vagas")
    public ModelAndView vagas() {
        ModelAndView modelAndView = new ModelAndView("/jobdelas/vagas/vagas.html");

        modelAndView.addObject("vagas", vagasService.listarVagas());

        return modelAndView;
    }

    @GetMapping("jbcompany/cadastrar/vagas")
    // Exemplo de verificação de erro de sintaxe
    public ModelAndView cadastroView() {
        ModelAndView modelAndView = new ModelAndView("/jb_company/criar-vagas.html");

        modelAndView.addObject("vagas", new Vagas());
        modelAndView.addObject("empresas", empresasService.listarEmpresas());

        return modelAndView;
    }

    @PostMapping("jbcompany/cadastrar/vagas")
    public String cadastrarVaga(Vagas vagas) {
        vagasService.cadastrarVagas(vagas);

        return "redirect:/vagas";
    }

    @GetMapping("jbcompany/deletar/vagas/{id}")
    public String deletarVaga(@PathVariable Long id) {
        vagasService.deletarVagas(id);

        return "redirect:/vagas";
    }
}
