package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.repository.UsuarioRepository;
import com.squad05.jobdelas.services.UsuariosService;
import at.favre.lib.crypto.bcrypt.BCrypt;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("jobdelas/login.html");
        modelAndView.addObject("usuario", new Usuarios());
        return modelAndView;
    }

    @PostMapping("login")
    public ModelAndView login(String email, String senha, String cargo) {
        ModelAndView modelAndView = new ModelAndView("redirect:/jobdelas");

        var usuarioEncontrado = usuariosService.encontrarPorEmail(email);

        if (usuarioEncontrado == null) {
            modelAndView.setViewName("jobdelas/login.html");
            modelAndView.addObject("erro", "Email ou senha incorretos");
            return modelAndView;
        }

        if (BCrypt.verifyer().verify(senha.toCharArray(), usuarioEncontrado.getSenha()).verified) {
            modelAndView.addObject("usuarioLogado", usuarioEncontrado);
        } else {
            modelAndView.setViewName("jobdelas/login.html");
            modelAndView.addObject("erro", "Email ou senha incorretos");
        }

        return modelAndView;
    }
}
