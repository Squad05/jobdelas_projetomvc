package com.squad05.jobdelas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.squad05.jobdelas.model.Aulas;
import com.squad05.jobdelas.model.Cursos;
import com.squad05.jobdelas.services.AulasService;
import com.squad05.jobdelas.services.CursosService;

@Controller
@RequestMapping("/aulas")
public class AulasController {

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
        return "aprendizado/aulas";
    }

}