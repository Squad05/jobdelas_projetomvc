package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.ui.Model;
import com.squad05.jobdelas.model.Comentarios;
import com.squad05.jobdelas.services.ComentariosService;

@Controller
@RequestMapping("comentarios")
public class ComentariosController {

    @Autowired
    private ComentariosService comentariosService;

    @GetMapping("/{postId}")
    public String getComentariosByPostId(@PathVariable Long postId, Model model) {
        List<Comentarios> comentarios = comentariosService.listarComentariosPorIdPostagem(postId);
        model.addAttribute("comentarios", comentarios);
        return "modal-comentarios";

    }
}
