package com.squad05.jobdelas.services;

import java.util.List;
import java.util.Set;

import com.squad05.jobdelas.model.Aulas;
import com.squad05.jobdelas.model.Usuarios;

public interface AulasService {

    List<Aulas> listarAulasPorCursoId(Long cursoId);

}