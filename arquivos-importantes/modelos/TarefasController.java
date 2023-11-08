package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Tarefas;
import com.squad05.jobdelas.repository.TarefasRepository;

@Controller
@RequestMapping("/")
public class TarefasController {

    @Autowired
    private TarefasRepository postagensRepository;

    @GetMapping("cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("/tarefas/cadastro.html");

        modelAndView.addObject("tarefas", new Tarefas());
        return modelAndView;
    }

    @PostMapping("cadastrar")
    public ModelAndView cadastrar(Tarefas tarefas, @RequestParam("titulo") String titulo,
            @RequestParam("descricao") String descricao, @RequestParam("concluida") String concluida) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");

        String tarefaCompleta = titulo + descricao + concluida;
        tarefas.setTitulo(tarefaCompleta);
        postagensRepository.save(tarefas);

        return modelAndView;

    }
}