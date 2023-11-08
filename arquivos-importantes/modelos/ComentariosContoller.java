package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Comentarios;
import com.squad05.jobdelas.repository.ComentariosRepository;

@Controller
@RequestMapping("/")
public class ComentariosController {

    @Autowired
    private ComentariosRepository comentariosRepository;

    @GetMapping("cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("/comentarios/cadastro.html");

        modelAndView.addObject("comentarios", new Comentarios());
        return modelAndView;
    }

   @PostMapping("cadastrar")
    public ModelAndView cadastrar(Comentarios comentarios, @RequestParam("conteudo") String conteudo,
            @RequestParam("data") String data) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");

        String comentarioCompleto = conteudo + " " + data;
        comentarios.setConteudo(comentarioCompleto);
        comentariosRepository.save(comentarios);

        return modelAndView;

    }
}
