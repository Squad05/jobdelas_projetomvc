package com.squad05.jobdelas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import com.squad05.jobdelas.model.Chat;


@Controller
public class ChatController {
   // @MessageMapping
   // @SendTo("/chat")

    public Chat sendMessage( Chat message){
        return message;
    }
    
}
