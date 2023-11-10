package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.repository.UsuarioRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Código para login
    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("/login/login.html");
        modelAndView.addObject("usuario", new Usuarios());
        return modelAndView;
    }

    @PostMapping("login")
    public ModelAndView login(String email, String senha) {
        ModelAndView modelAndView = new ModelAndView("redirect:/cadastrar");

        // Procura o usuário pelo email
        var usuarioEncontrado = this.usuarioRepository.findByEmail(email);

        if (usuarioEncontrado == null) {
            modelAndView.setViewName("/login/login.html");
            modelAndView.addObject("erro", "Usuário não encontrado");
            return modelAndView;
        }

        // Verifica a senha usando a biblioteca BCrypt
        if (BCrypt.verifyer().verify(senha.toCharArray(), usuarioEncontrado.getSenha()).verified) {
            // Senha válida, pode prosseguir com a lógica de login
            // ...

            // Exemplo de como você pode usar o usuário logado
            modelAndView.addObject("usuarioLogado", usuarioEncontrado);
        } else {
            modelAndView.setViewName("/login/login.html");
            modelAndView.addObject("erro", "Senha incorreta");
        }

        return modelAndView;
    }
}
