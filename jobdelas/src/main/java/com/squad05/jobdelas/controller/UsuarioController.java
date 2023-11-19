package com.squad05.jobdelas.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.services.EmailService;
import com.squad05.jobdelas.services.UsuariosService;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private EmailService emailService;

    @GetMapping("cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("jobdelas/cadastro.html");

        modelAndView.addObject("usuario", new Usuarios());
        return modelAndView;
    }

    @PostMapping("cadastrar")
    public ModelAndView cadastrar(Usuarios usuario, @RequestParam("nome") String primeiroNome,
            @RequestParam("sobrenome") String sobrenome) {
        ModelAndView modelAndView = new ModelAndView("redirect:/login");

        boolean emailExistente = usuariosService.verificarEmailExistente(usuario.getEmail());

        if (emailExistente) {
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

    @PostMapping("perfil/editar")
    public String atualizarUsuario(@RequestParam("descricao_curta") String novaDescricaoCurta, HttpSession session) {

        Usuarios usuarioLogado = (Usuarios) session.getAttribute("usuarioLogado");
        usuarioLogado.setDescricao_curta(novaDescricaoCurta);
        Usuarios usuarioAtualizado = usuariosService.atualizarUsuario(usuarioLogado.getId(), usuarioLogado);
        session.setAttribute("usuarioLogado", usuarioAtualizado);

        return "redirect:/perfil";

    }
    // @GetMapping("/deletar/{id}")
    // public String deletarUsuario(@PathVariable Long id) {
    // usuariosService.deletarUsuario(id);
    // return "redirect:/cadastro";
    // }

    @GetMapping("perfil")
    public ModelAndView perfil(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Usuarios usuarioLogado = (Usuarios) session.getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }

        modelAndView.addObject("usuarioLogado", usuarioLogado);
        modelAndView.setViewName("jobdelas/usuario/perfil.html");
        return modelAndView;
    }
}
