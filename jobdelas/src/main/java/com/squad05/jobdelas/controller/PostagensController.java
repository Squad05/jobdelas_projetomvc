package com.squad05.jobdelas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Postagens;
import com.squad05.jobdelas.services.PostagensService;

@Controller
@RequestMapping("/teste")
public class PostagensController {

    @Autowired
    private PostagensService postagensService;

    @GetMapping
    public String listarPostagens(Model model) {
        List<Postagens> postagens = postagensService.listarTodasPostagens();

        model.addAttribute("postagens", postagens);
        return "teste";
    }

}
