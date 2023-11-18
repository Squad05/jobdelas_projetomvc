package com.squad05.jobdelas.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.squad05.jobdelas.model.Postagens;
import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.services.PostagensService;

@Controller
@RequestMapping("/postagens")
public class PostagensController {

    @Autowired
    private PostagensService postagensService;

    @PostMapping("/cadastrar")
    public String cadastrarPostagen(@RequestParam("usuario_id") Usuarios usuarioId,
            @RequestParam("conteudo") String conteudo) {

        Postagens novaPostagem = new Postagens();

        novaPostagem.setConteudo(conteudo);
        novaPostagem.setData_postagem(LocalDateTime.now());
        novaPostagem.setUsuarios(usuarioId);

        postagensService.cadastrarpostagens(novaPostagem);

        return "redirect:/jobdelas";

    }

}
