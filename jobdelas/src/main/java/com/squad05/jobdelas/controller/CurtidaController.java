package com.squad05.jobdelas.controller;

import com.squad05.jobdelas.services.CurtidaService;
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

}
