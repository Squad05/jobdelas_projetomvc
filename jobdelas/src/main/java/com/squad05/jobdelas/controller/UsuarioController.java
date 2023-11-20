package com.squad05.jobdelas.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.services.EmailService;
import com.squad05.jobdelas.services.UsuariosService;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.http.HttpSession;


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
            modelAndView.setViewName("jobdelas/cadastro.html");
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
    public String atualizarUsuario(@ModelAttribute Usuarios usuarioAtualizado, HttpSession session) {

        Usuarios usuarioLogado = (Usuarios) session.getAttribute("usuarioLogado");

        usuarioLogado.setNome(usuarioAtualizado.getNome());
        usuarioLogado.setEmail(usuarioAtualizado.getEmail());
        usuarioLogado.setSenha(usuarioAtualizado.getSenha());
        usuarioLogado.setFoto(usuarioAtualizado.getFoto());
        usuarioLogado.setResumo(usuarioAtualizado.getResumo());
        usuarioLogado.setTelefone(usuarioAtualizado.getTelefone());
        usuarioLogado.setLink_do_portfolio(usuarioAtualizado.getLink_do_portfolio());
        usuarioLogado.setDescricao_curta(usuarioAtualizado.getDescricao_curta());

        if (!usuarioAtualizado.getSenha().isEmpty()) {
            var senhaCriptografada = BCrypt.withDefaults().hashToString(12, usuarioAtualizado.getSenha().toCharArray());
            usuarioLogado.setSenha(senhaCriptografada);
        }

        usuariosService.atualizarUsuario(usuarioLogado.getId(), usuarioLogado);

        session.setAttribute("usuarioLogado", usuarioLogado);
        usuariosService.atualizarUsuario(usuarioLogado.getId(), usuarioLogado);

        session.setAttribute("usuarioLogado", usuarioLogado);

        return "redirect:/perfil";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
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
