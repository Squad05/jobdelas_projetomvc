package com.squad05.jobdelas.controller;

import com.squad05.jobdelas.model.Aulas;
import com.squad05.jobdelas.model.Cursos;
import com.squad05.jobdelas.repository.AulasRepository;
import com.squad05.jobdelas.repository.CursosRepository;
import com.squad05.jobdelas.services.AulasService;
import com.squad05.jobdelas.services.CursosService;

import java.util.List;

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

    @Autowired
    private AulasService aulasService;

    @Autowired
    private CursosService cursosService;

    @GetMapping("/{cursoId}")
    public String mostrarAulasDoCurso(@PathVariable Long cursoId, Model model) {
        List<Aulas> aulasDoCurso = aulasService.listarAulasPorCursoId(cursoId);
        Cursos curso = cursosService.pegarCursoPorId(cursoId);

        model.addAttribute("curso", curso);
        model.addAttribute("aulas", aulasDoCurso);
        return "jobdelas/aprendizado/aulas";
    }

    @PostMapping("/adicionar")
    public String adicionarAula(@RequestParam Long cursoId, @RequestParam String titulo, @RequestParam String link,
            @RequestParam String descricao) {
        Cursos curso = cursosService.pegarCursoPorId(cursoId);

        if (curso != null) {
            Aulas aula = new Aulas();
            aula.setCurso(curso);
            aula.setTitulo(titulo);
            aula.setLink(link);
            aula.setDescricao(descricao);

            aulasService.cadastrarAula(aula);
        }

        return "redirect:/aulas";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarAula(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("");

        Aulas aula = aulasService.pegarAulaPorId(id);
        modelAndView.addObject("aula", aula);
        modelAndView.addObject("cursos", cursosService.listarCursos());

        return modelAndView;
    }

    @PostMapping("/atualizar")
    public String atualizarAula(@RequestParam Long id, @RequestParam Long cursoId, @RequestParam String titulo,
            @RequestParam String link, @RequestParam String descricao) {

        Aulas aula = aulasService.pegarAulaPorId(id);

        if (aula != null) {
            Cursos curso = cursosService.pegarCursoPorId(cursoId);

            if (curso != null) {
                aula.setCurso(curso);
                aula.setTitulo(titulo);
                aula.setLink(link);
                aula.setDescricao(descricao);

                aulasService.cadastrarAula(aula);
            }
        }

        return "redirect:/aulas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarAula(@PathVariable Long id) {
        aulasService.deletarAula(id);
        return "redirect:/aulas";
    }

}