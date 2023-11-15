package com.squad05.jobdelas.services;

import java.util.List;

import com.squad05.jobdelas.model.Comentarios;


public interface ComentariosService {

    List<Comentarios> listarComentarios();

    Comentarios cadastrarcomentarios(Comentarios comentarios);

    Comentarios atualizarComentarios(Long id, Comentarios comentariosAtualizado);

    void deletarComentarios(Long id);

    Comentarios pegarComentariosPorId(Long id);

}
