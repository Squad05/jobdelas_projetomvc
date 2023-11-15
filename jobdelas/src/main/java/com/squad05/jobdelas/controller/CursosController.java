package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.squad05.jobdelas.model.Cursos;
import com.squad05.jobdelas.repository.CursosRepository;

@Controller
@RequestMapping("/cursos")
public class CursosController {

    @Autowired
    private CursosRepository cursosRepository;

    @GetMapping
    public ModelAndView cursos() {
        ModelAndView modelAndView = new ModelAndView("/aprendizado/cursos.html");

        modelAndView.addObject("cursos", cursosRepository.findAll());

        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrarCurso(@RequestParam String materia, @RequestParam String duracao) {
        Cursos curso = new Cursos();
        curso.setMateria(materia);
        curso.setDuracao(duracao);

        cursosRepository.save(curso);

        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarCurso(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/aprendizado/editar-curso.html");

        Cursos cursos = cursosRepository.findById(id).orElse(null);
        modelAndView.addObject("curso", cursos);

        return modelAndView;
    }

    @PostMapping("/atualizar")
    public String atualizarCurso(@ModelAttribute Cursos cursos) {

        cursosRepository.save(cursos);

        return "redirect:/cursos";
    }

    @GetMapping("/deletar/{id}")
    public String deletarCurso(@PathVariable Long id) {

        cursosRepository.deleteById(id);

        return "redirect:/cursos";
    }

}
