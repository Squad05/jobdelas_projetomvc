package com.squad05.jobdelas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.squad05.jobdelas.model.Postagens;
import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.services.PostagensService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class IndexAppController {

    @Autowired
    private PostagensService postagensService;

    @GetMapping("jobdelas")
    public ModelAndView home(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("jobdelas/index.html");

        Usuarios usuarioLogado = ((Usuarios) session.getAttribute("usuarioLogado"));

        if (usuarioLogado != null) {
            List<Postagens> postagens = postagensService.listarTodasPostagens();
            modelAndView.addObject("postagens", postagens);
            modelAndView.addObject("usuarioLogado", usuarioLogado);
        }
        return modelAndView;

    }

    @GetMapping("jbcompany")
    public ModelAndView homejbComapny() {
        ModelAndView modelAndView = new ModelAndView("jb_company/index.html");

        return modelAndView;
    }
}
