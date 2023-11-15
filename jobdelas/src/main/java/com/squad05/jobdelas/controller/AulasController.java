package com.squad05.jobdelas.controller;

import com.squad05.jobdelas.model.Aulas;
import com.squad05.jobdelas.model.Cursos;
import com.squad05.jobdelas.repository.AulasRepository;
import com.squad05.jobdelas.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/aulas")
public class AulasController {

    @Autowired
    private AulasRepository aulasRepository;

    @Autowired
    private CursosRepository cursosRepository;

    @GetMapping
    public ModelAndView aulas() {
        ModelAndView modelAndView = new ModelAndView("/aprendizado/cadastraraula.html");

        modelAndView.addObject("aulas", aulasRepository.findAll());
        modelAndView.addObject("cursos", cursosRepository.findAll());

        return modelAndView;
    }

    @PostMapping("/adicionar")
    public String adicionarAula(@RequestParam Long cursoId, @RequestParam String titulo, @RequestParam String link,
            @RequestParam String descricao) {
        // Lógica para adicionar aula ao banco de dados
        Cursos curso = cursosRepository.findById(cursoId).orElse(null);

        if (curso != null) {
            Aulas aula = new Aulas();
            aula.setCurso(curso);
            aula.setTitulo(titulo);
            aula.setLink(link);
            aula.setDescricao(descricao);

            aulasRepository.save(aula);
        }

        return "redirect:/aulas";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarAula(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/aprendizado/editar-aula.html");

        Aulas aula = aulasRepository.findById(id).orElse(null);
        modelAndView.addObject("aula", aula);
        modelAndView.addObject("cursos", cursosRepository.findAll());

        return modelAndView;
    }

    @PostMapping("/atualizar")
    public String atualizarAula(@RequestParam Long id, @RequestParam Long cursoId, @RequestParam String titulo,
            @RequestParam String link, @RequestParam String descricao) {
        Aulas aula = aulasRepository.findById(id).orElse(null);

        if (aula != null) {
            Cursos curso = cursosRepository.findById(cursoId).orElse(null);
            if (curso != null) {
                aula.setCurso(curso);
                aula.setTitulo(titulo);
                aula.setLink(link);
                aula.setDescricao(descricao);

                aulasRepository.save(aula);
            }
        }

        return "redirect:/aulas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAula(@PathVariable Long id) {
        aulasRepository.deleteById(id);
        return "redirect:/aulas";
    }

}
