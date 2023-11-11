package com.squad05.jobdelas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class TarefasController {
    @GetMapping("tarefas")
    public ModelAndView tarefas() {
        ModelAndView modelAndView = new ModelAndView("/usuario/tarefas.html");

        return modelAndView;
    }

    @GetMapping("tarefa")
    public ModelAndView tarefa() {
        ModelAndView modelAndView = new ModelAndView("/usuario/tarefas.html");

        return modelAndView;
    }
}
