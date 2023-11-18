package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Chat;
import com.squad05.jobdelas.repository.ChatRepository;

@Controller
public class ChatController {

    @Autowired
    private ChatRepository chatRepository;

    @GetMapping("/chat")
    public ModelAndView chat() {

        ModelAndView modelAndView = new ModelAndView("jobdelas/chat/index.html");
        modelAndView.addObject("chat", chatRepository.findAll());

        return modelAndView;
    }

    @PostMapping("/enviar")
    public String enviarMensagem(@RequestParam("nome") String nomeParametro,
            @RequestParam("mensagem") String mensagemParametro) {

        if (!nomeParametro.equals("") && !mensagemParametro.equals("")) {

            Chat chat = new Chat();
            chat.setNome(nomeParametro);
            chat.setMensagem(mensagemParametro);

            chatRepository.save(chat);
        }

        return "redirect:/chat";
    }
}
