package com.squad05.jobdelas.controller;

import com.squad05.jobdelas.services.CurtidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curtida")
public class CurtidaController {

    private final CurtidaService curtidaService;

    @Autowired
    public CurtidaController(CurtidaService curtidaService) {
        this.curtidaService = curtidaService;
    }

    @PostMapping("/curtir")
    public void curtirPostagem(@RequestParam Long usuarioId, @RequestParam Long postagemId) {
        curtidaService.curtirPostagem(usuarioId, postagemId);
    }

    @PostMapping("/contar")
    public int contarCurtidasDaPostagem(@RequestParam Long postagemId) {
        return curtidaService.contarCurtidasDaPostagem(postagemId);
    }

}
