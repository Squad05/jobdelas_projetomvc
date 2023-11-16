package com.squad05.jobdelas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.squad05.jobdelas.model.Comentarios;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Long> {

    @Query("SELECT c FROM Comentarios c WHERE c.postagem.id = :idPostagem")
    List<Comentarios> encontrarComentariosPorPostagemID(@Param("idPostagem") Long idPostagem);

}