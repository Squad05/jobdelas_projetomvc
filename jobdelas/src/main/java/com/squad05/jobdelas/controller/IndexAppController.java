package com.squad05.jobdelas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.squad05.jobdelas.model.Postagens;
import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.services.PostagensService;
import com.squad05.jobdelas.services.UsuariosService;

@Controller
@RequestMapping("/")
public class IndexAppController {

    @Autowired
    private PostagensService postagensService;

    @GetMapping("jobdelas")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index.html");
        List<Postagens> postagens = postagensService.listarTodasPostagens();

        modelAndView.addObject("postagens", postagens);
        return modelAndView;
    }
}
