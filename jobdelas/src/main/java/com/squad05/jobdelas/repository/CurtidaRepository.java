package com.squad05.jobdelas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.squad05.jobdelas.model.Curtida;

public interface CurtidaRepository extends JpaRepository<Curtida, Long> {

    // boolean existeByUsuariosIdEPostagensId(Long usuarioId, Long postagemId);

    int countByPostagensId(Long postagemId);
}
