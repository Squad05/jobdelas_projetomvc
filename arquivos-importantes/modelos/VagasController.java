package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Vagas;
import com.squad05.jobdelas.repository.VagasRepository;

@Controller
@RequestMapping("/")
public class VagasController {

    @Autowired
    private VagasRepository vagasRepository;

    @GetMapping("cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("/vagas/cadastro.html");

        modelAndView.addObject("vagas", new Vagas());
        return modelAndView;
    }

    @PostMapping("cadastrar")
    public ModelAndView cadastrar(Vagas vagas, @RequestParam("descricao") String descricao,
            @RequestParam("cep") String cep, @RequestParam("localizacao") String loclizacao, @RequestParam("funcao") String funcao, @RequestParam("statusvaga") String statusvaga) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");

        String vagaCompleta = descricao + cep + loclizacao + funcao + statusvaga;
        vagas.setDescricao(vagaCompleta);
        vagasRepository.save(vagas);

        return modelAndView;

    }
}
