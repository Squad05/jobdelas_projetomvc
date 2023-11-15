package com.squad05.jobdelas.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.squad05.jobdelas.model.Aulas;

@Repository
public interface AulasRepository extends JpaRepository<Aulas, Long> {

    List<Aulas> findAllByCursoId(Long cursoId);

    // podemos adicionar métodos personalizados aqui se necessário
}
