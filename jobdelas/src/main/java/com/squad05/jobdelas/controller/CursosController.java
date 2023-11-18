package com.squad05.jobdelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.squad05.jobdelas.model.Cursos;
import com.squad05.jobdelas.repository.CursosRepository;
import com.squad05.jobdelas.services.CursosService;

@Controller
public class CursosController {

    @Autowired
    private CursosService cursosService;

    @GetMapping("/cursos")
    public ModelAndView cursos() {
        ModelAndView modelAndView = new ModelAndView("jobdelas/aprendizado/cursos.html");

        modelAndView.addObject("cursos", cursosService.listarCursos());

        // modelAndView.addObject("cursos", cursosService.listarCursos());

        return modelAndView;
    }

    @GetMapping("jbcompany/cadastrar/curso")
    public ModelAndView cadastrarCursoView() {
        ModelAndView modelAndView = new ModelAndView("/jb_company/cadastrar-curso.html");
        modelAndView.addObject("cursos", new Cursos()); // Adicionando o objeto cursos ao modelo

        return modelAndView;
    }

    @PostMapping("jbcompany/cadastrar/curso")
    public String cadastrarCurso(@RequestParam String materia, @RequestParam String duracao,
            @RequestParam String descricao) {

        Cursos curso = new Cursos();
        curso.setMateria(materia);
        curso.setDescricao(descricao);
        curso.setDuracao(duracao);

        cursosService.cadastrarCurso(curso);

        return "redirect:/jbcompany/cadastrar/aula";
    }

    @GetMapping("jbcompany/listar/curso")
    public ModelAndView listarCursosView() {
        ModelAndView modelAndView = new ModelAndView("/jb_company/listar-cursos.html");
        modelAndView.addObject("cursos", cursosService.listarCursos());

        return modelAndView;
    }

    // @GetMapping("/editar/{id}")
    // public ModelAndView editarCurso(@PathVariable Long id) {
    // ModelAndView modelAndView = new ModelAndView("");

    // Cursos cursos = cursosService.atualizarCurso(id, null);
    // modelAndView.addObject("curso", cursos);

    // return modelAndView;
    // }

    // @PostMapping("/atualizar")
    // public String atualizarCurso(@ModelAttribute Cursos cursos) {

    // cursosService.cadastrarCurso(cursos);

    // return "redirect:/cursos";
    // }
    @PostMapping("jbcompany/deletar/curso/{id}")
    public String deletarCurso(@PathVariable Long id, RedirectAttributes attributes) {
        try {
            cursosService.deletarCurso(id);
            return "redirect:/jbcompany/listar/curso";
        } catch (DataIntegrityViolationException e) {
            attributes.addAttribute("erro", "Não é possível excluir o curso, pois existem aulas associadas a ele.");
            return "redirect:/jbcompany/listar/curso";
        }

    }

}
