package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.squad05.jobdelas.model.Tarefas;
import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.services.TarefasService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/tarefas")
public class TarefasController {

    @Autowired
    private TarefasService tarefasService;

    @PostMapping("/cadastrar")
    public String cadastrarTarefa(HttpSession session, @RequestParam("titulo") String titulo,
            @RequestParam("descricao") String descricao) {
        Tarefas novaTarefa = new Tarefas();
        Usuarios usuarioLogado = (Usuarios) session.getAttribute("usuarioLogado");

        novaTarefa.setUsuario(usuarioLogado);
        novaTarefa.setTitulo(titulo);
        novaTarefa.setDescricao(descricao);
        tarefasService.criarTarefa(novaTarefa);
        return "redirect:/jobdelas";
    }

    @PostMapping("/deletar/{id}")
    public String deletarTarefa(@PathVariable Long id) {

        tarefasService.deletarTarefa(id);

        return "redirect:/jobdelas";

    }
}
