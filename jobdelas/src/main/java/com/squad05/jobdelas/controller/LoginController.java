package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.repository.UsuarioRepository;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository repo;
    private Object usuarioRepository;

    @GetMapping("login")
    public String login() {
        return "login/login.html";
    }

    @GetMapping("usuario")
    public ModelAndView perfil(Usuarios loginUsuario) {
        ModelAndView modelAndView = new ModelAndView("usuario/usuario.html");

        var login = this.repo.findByEmail(loginUsuario.getNome()).getId();
        modelAndView.addObject("usuario", login);
   
        System.out.println(login);
        return modelAndView;
    }
    // @GetMapping("/login")
    // public String login() {
    //     return "login/login.html";
    // }

    // @PostMapping
    // public String logar(Model model, Usuarios usuario, String lembrar) {
    //     Usuarios usuarioLogado = this.repo.Login(usuario.getEmail(), usuario.getSenha());
    //     if (usuarioLogado != null) {
    //         return "redirect:/";
    //     }
    //     model.addAttribute("erro", "Usuario ou senha invalidos");
    //     return "login/index";
    // }
}

