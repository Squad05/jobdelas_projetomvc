package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.repository.UsuarioRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.validation.Valid;

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
    @Valid
    @PostMapping("cadastrar")
    public ModelAndView cadastrar(Usuarios usuario, @RequestParam("nome") String primeiroNome,
            @RequestParam("sobrenome") String sobrenome ) {
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

    @GetMapping("editar")
    public ModelAndView editarUsuario() {
        ModelAndView modelAndView = new ModelAndView("/usuario/usuario.html");

        modelAndView.addObject("usuario", new Usuarios());
        return modelAndView;
    }

    @PutMapping("editar")
    public ModelAndView atualizarUsuario(@ModelAttribute("usuario") Usuarios usuario,
            @RequestParam("resumo") String resumo,
            @RequestParam("telefone") String telefone, @RequestParam("portfolio") String portfolio,
            @RequestParam("nome") String nome, @RequestParam("email") String email,
            @RequestParam("senha") String senha) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");

        try {
            // Verifica se o usuário com o ID fornecido existe no banco de dados
            var usuarioExistente = usuarioRepository.findById(usuario.getId());

            if (usuarioExistente.isPresent()) {
                // Atualize os campos do usuário com os valores passados
                Usuarios usuarioAtualizado = usuarioExistente.get();
                usuarioAtualizado.setResumo(resumo);
                usuarioAtualizado.setTelefone(telefone);
                usuarioAtualizado.setLinkDoPorfolio(portfolio);
                usuarioAtualizado.setNome(nome);
                usuarioAtualizado.setEmail(email);

                // Atualize a senha criptografada se necessário
                if (!senha.isEmpty()) {
                    var senhaCriptografada = BCrypt.withDefaults().hashToString(12, senha.toCharArray());
                    usuarioAtualizado.setSenha(senhaCriptografada);
                }

                // Salve as alterações no banco de dados
                usuarioRepository.save(usuarioAtualizado);
            } else {
                modelAndView.addObject("erro", "Usuário não encontrado");
            }

        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.addObject("erro", "Ocorreu um erro ao atualizar o usuário");
        }

        return modelAndView;
    }
}
