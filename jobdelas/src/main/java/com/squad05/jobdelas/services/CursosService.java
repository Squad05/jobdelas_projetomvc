package com.squad05.jobdelas.services;

import java.util.List;

import com.squad05.jobdelas.model.Cursos;

public interface CursosService {

    List<Cursos> listarCursos();

    Cursos cadastrarCurso(Cursos curso);

    Cursos atualizarCurso(Long id, Cursos cursoAtualizado);

    void deletarCurso(Long id);

    Cursos pegarCursoPorId(Long id);

}
