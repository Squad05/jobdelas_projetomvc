package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.repository.UsuarioRepository;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository repo;

    @GetMapping("/login")
    public String login() {
        return "login/login.html";
    }

    @PostMapping("/login")
    public String logar(Model model, Usuarios usuario, String lembrar) {
        try {
            Usuarios usuarioLogado = this.repo.Login(usuario.getEmail(), usuario.getSenha());
            if (usuarioLogado != null) {
                return "redirect:/";
            }
            model.addAttribute("erro", "Usuário ou senha inválidos");
        } catch (Exception e) {
            model.addAttribute("erro", "Ocorreu um erro durante o login");
        }
        return "login/index";
    }
}

