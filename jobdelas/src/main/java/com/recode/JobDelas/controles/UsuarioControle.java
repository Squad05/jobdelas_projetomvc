package com.recode.JobDelas.controles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioControle {

    @GetMapping("/usuario")
    public ModelAndView detalharUsuario() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
}
