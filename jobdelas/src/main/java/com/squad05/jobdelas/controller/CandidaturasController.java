package com.squad05.jobdelas.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.squad05.jobdelas.model.Candidaturas;
import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.model.Vagas;
import com.squad05.jobdelas.services.CandidaturasService;
import com.squad05.jobdelas.services.EmailService;
import com.squad05.jobdelas.services.VagasService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CandidaturasController {

    @Autowired
    private CandidaturasService candidaturasService;

    @Autowired
    private VagasService vagasService;

    @Autowired
    private EmailService emailService;

    @PostMapping("jobdelas/aplicar/vaga")
    public String cadastrarCandidatura(HttpSession session, @RequestParam("vagaId") Long vagaId) {
        Usuarios usuarioLogado = (Usuarios) session.getAttribute("usuarioLogado");

        Candidaturas candidaturas = new Candidaturas();
        candidaturas.setUsuarios(usuarioLogado);

        Vagas vagas = vagasService.pegarVagasPorId(vagaId);

        candidaturas.setVagas(vagas);

        candidaturasService.cadastrarCandidaturas(candidaturas);

        Map<String, Object> propriedades = new HashMap<>();
        propriedades.put("nome", usuarioLogado.getNome());
        propriedades.put("funcaoCandidatura", vagas.getFuncao());

        emailService.enviarEmailCandididatura(usuarioLogado.getEmail(), "Sua candidatura foi recebida com sucesso!",
                propriedades);

        return "redirect:/vagas";
    }
}
