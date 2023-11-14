package com.squad05.jobdelas.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.repository.UsuarioRepository;
import com.squad05.jobdelas.services.EmailService;
import com.squad05.jobdelas.services.UsuariosService;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmailService emailService;

    @GetMapping("cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("/login/cadastro.html");

        modelAndView.addObject("usuario", new Usuarios());
        return modelAndView;
    }

    @PostMapping("cadastrar")
    public ModelAndView cadastrar(Usuarios usuario, @RequestParam("nome") String primeiroNome,
            @RequestParam("sobrenome") String sobrenome) {
        ModelAndView modelAndView = new ModelAndView("redirect:/login");

        var usuarioEncontrado = this.usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioEncontrado != null) {
            modelAndView.setViewName("/login/cadastro.html");
            modelAndView.addObject("usuario", usuario);
            modelAndView.addObject("erro", "Email já existente");
            return modelAndView;
        }

        String nomeCompleto = primeiroNome + " " + sobrenome;
        usuario.setNome(nomeCompleto);
        var senhaCriptografa = BCrypt.withDefaults().hashToString(12, usuario.getSenha().toCharArray());
        usuario.setSenha(senhaCriptografa);

        usuariosService.salvarUsuario(usuario);

        Map<String, Object> propriedades = new HashMap<>();
        propriedades.put("nome", usuario.getNome());

        emailService.enviarEmailHtml(usuario.getEmail(), "Bem vinda ao JobDelas", propriedades);
        return modelAndView;

    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {

        Usuarios usuario = usuariosService.pegarUsuarioPorId(id);
        model.addAttribute("usuario", usuario);
        return "editarUsuario";
    }

    @PostMapping("editar/{id}")
    public String atualizarUsuario(@PathVariable Long id, @ModelAttribute("usuario") Usuarios usuario) {
        usuariosService.deletarUsuario(id);

        return "redirect:/index";
    }

    @GetMapping("/deletar/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        usuariosService.deletarUsuario(id);

        return "redirect:/cadastro";
    }

    @GetMapping("perfil")
    public ModelAndView perfil() {
        ModelAndView modelAndView = new ModelAndView("/usuario/perfil.html");

        return modelAndView;
    }
}
