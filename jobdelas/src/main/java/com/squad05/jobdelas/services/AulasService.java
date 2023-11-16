package com.squad05.jobdelas.services;

import java.util.List;

import com.squad05.jobdelas.model.Aulas;

public interface AulasService {

    List<Aulas> listarAulasPorCursoId(Long cursoId);

    Aulas cadastrarAula(Aulas aulas);

    Aulas atualizarAula(Long id, Aulas aulaAtualizada);

    void deletarAula(Long id);

    Aulas pegarAulaPorId(Long id);

}