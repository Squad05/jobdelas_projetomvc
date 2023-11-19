package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Chat;
import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.repository.ChatRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    @GetMapping("/chat")
    public ModelAndView chat(HttpSession session) {
        Usuarios usuarioLogado = (Usuarios) session.getAttribute("usuarioLogado");
        ModelAndView modelAndView = new ModelAndView();

        if (usuarioLogado == null) {
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }
        modelAndView.setViewName("jobdelas/chat/chat.html");

        modelAndView.addObject("chat", chatRepository.findAll());

        return modelAndView;
    }

    @PostMapping("/enviar")
    public String enviarMensagem(HttpSession session,
            @RequestParam("mensagem") String mensagemParametro) {

        Usuarios usuarioLogado = (Usuarios) session.getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            return "redirect:/jobdelas/login";
        }

        if (!mensagemParametro.equals("")) {

            Chat chat = new Chat();
            chat.setNome(usuarioLogado.getNome());
            chat.setMensagem(mensagemParametro);

            chatRepository.save(chat);
        }

        return "redirect:/chat";
    }
}
