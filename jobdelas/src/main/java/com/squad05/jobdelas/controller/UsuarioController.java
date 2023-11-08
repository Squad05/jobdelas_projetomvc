package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.repository.UsuarioRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Controller
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("/usuario/cadastro.html");

        modelAndView.addObject("usuario", new Usuarios());
        return modelAndView;
    }

    @PostMapping("cadastrar")
    public ModelAndView cadastrar(Usuarios usuario, @RequestParam("nome") String primeiroNome,
            @RequestParam("sobrenome") String sobrenome) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");

        var usuarioEncontrado = this.usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioEncontrado != null) {
            modelAndView.setViewName("/usuario/cadastro.html");
            modelAndView.addObject("usuario", usuario);
            modelAndView.addObject("erro", "Usuario já existente");
            return modelAndView;
        }

        String nomeCompleto = primeiroNome + " " + sobrenome;
        usuario.setNome(nomeCompleto);
        // O `withDefault` indica que está usandoa a biblitoeca do BCrypt,
        // `hashToString´ gera o valor do hash , 12 é o custo da função, quanto maior,
        // mais seguro. E o `toCharArray´ converte a senha em array de caracteres
        var senhaCriptografa = BCrypt.withDefaults().hashToString(12, usuario.getSenha().toCharArray());
        usuario.setSenha(senhaCriptografa);

        usuarioRepository.save(usuario);
        return modelAndView;

    }
}
