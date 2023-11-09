package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Postagens;
import com.squad05.jobdelas.repository.PostagensRepository;

@Controller
@RequestMapping("/")
public class PostagensController {

    @Autowired
    private PostagensRepository postagensRepository;

    @GetMapping("cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("/postagens/cadastro.html");

        modelAndView.addObject("postagens", new Postagens());
        return modelAndView;
    }

    @PostMapping("cadastrar")
    public ModelAndView cadastrar(Postagens postagens, @RequestParam("conteudo") String conteudo,
            @RequestParam("data") String data) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");

        postagens.setConteudo(postagemCompleta);
        postagensRepository.save(postagens);

        return modelAndView;

    }
}
