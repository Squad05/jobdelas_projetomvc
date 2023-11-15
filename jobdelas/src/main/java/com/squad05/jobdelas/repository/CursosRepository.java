package com.squad05.jobdelas.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.squad05.jobdelas.model.Cursos;

public interface CursosRepository extends JpaRepository<Cursos, Long> {

    @Query("SELECT c FROM Cursos c WHERE c.id IN :cursoIDs")
    List<Cursos> buscarCursosPorIds(@Param("cursoIDs") Set<Long> cursoIDs);

}
