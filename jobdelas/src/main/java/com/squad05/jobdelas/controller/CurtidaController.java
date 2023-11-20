package com.squad05.jobdelas.controller;

import com.squad05.jobdelas.model.Curtida;
import com.squad05.jobdelas.model.Postagens;
import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.services.CurtidaService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curtida")
public class CurtidaController {
    @Autowired
    private CurtidaService curtidaService;

    @GetMapping("/contar")
    public int contarCurtidasDaPostagem(@RequestParam Long postagemId) {
        return curtidaService.contarCurtidasDaPostagem(postagemId);
    }

    @PostMapping("/curtir")
    public String curtir(@RequestParam("postagemId") Postagens postagemId, HttpSession session) {
        Curtida curtida = new Curtida();
        Usuarios usuarioLogado = (Usuarios) session.getAttribute("usuarioLogado");

        if (usuarioLogado != null) {
            curtida.setUsuarios(usuarioLogado);
            curtida.setPostagens(postagemId);

            curtidaService.curtirPostagem(curtida);
        }

        return "redirect:/jobdelas";

    }

}
