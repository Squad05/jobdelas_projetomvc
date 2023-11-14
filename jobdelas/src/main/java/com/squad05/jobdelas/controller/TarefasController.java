package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.squad05.jobdelas.model.Tarefas;
import com.squad05.jobdelas.repository.TarefasRepository;

@Controller
@RequestMapping("/")
public class TarefasController {

    @Autowired
    private TarefasRepository tarefasRepository;

    @GetMapping()
    public String listarTarefas(Model model) {
        // List<Tarefas> tarefas
        model.addAttribute("tarefa", new Tarefas());
        return "jobdelas";
    }

}
