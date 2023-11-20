package com.squad05.jobdelas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.squad05.jobdelas.model.Postagens;
import com.squad05.jobdelas.model.Tarefas;
import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.services.CurtidaService;
import com.squad05.jobdelas.services.PostagensService;
import com.squad05.jobdelas.services.TarefasService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class IndexAppController {

    @Autowired
    private PostagensService postagensService;

    @Autowired
    private TarefasService tarefasService;

    @Autowired
    private CurtidaService curtidaService;

    @GetMapping("jobdelas")
    public ModelAndView home(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        Usuarios usuarioLogado = (Usuarios) session.getAttribute("usuarioLogado");

        if (usuarioLogado == null) {
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }

        List<Tarefas> tarefas = tarefasService.listaTarefas(usuarioLogado.getId());
        modelAndView.addObject("tarefas", tarefas);

        List<Postagens> postagens = postagensService.listarTodasPostagens();

        for (Postagens postagem : postagens) {
            int curtidasTotal = curtidaService.contarCurtidasDaPostagem(postagem.getId());
            postagem.setCurtidas_total(curtidasTotal);
        }

        modelAndView.addObject("postagens", postagens);
        modelAndView.addObject("usuarioLogado", usuarioLogado);

        modelAndView.setViewName("jobdelas/index.html");
        return modelAndView;
    }

    @GetMapping("jbcompany")
    public ModelAndView homejbCompany() {
        ModelAndView modelAndView = new ModelAndView("jb_company/index.html");

        return modelAndView;
    }

    @GetMapping("sobre")
    public ModelAndView sobre() {
        ModelAndView modelAndView = new ModelAndView("jobdelas/sobre.html");

        return modelAndView;
    }

    @GetMapping("/")
    public ModelAndView redirectToSobre() {
        ModelAndView modelAndView = new ModelAndView("redirect:/sobre");
        return modelAndView;
    }
}
