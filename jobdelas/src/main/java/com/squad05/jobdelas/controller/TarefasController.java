package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.squad05.jobdelas.model.Tarefas;
import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.services.TarefasService;

@Controller
@RequestMapping("/tarefas")
public class TarefasController {

@Autowired
private TarefasService tarefasService;


// @PostMapping("/cadastrar")
// public String cadastrarTarefa(@RequestParam("usuario_id")
// Usuarios usuarioId, @RequestParam("titulo") String titulo, @RequestParam("descricao" String descricao)) {
//     Tarefas novaTarefa = new Tarefas();
    
// }
}
