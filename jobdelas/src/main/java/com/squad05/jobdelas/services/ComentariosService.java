package com.squad05.jobdelas.services;

import java.util.List;

import com.squad05.jobdelas.model.Comentarios;

public interface ComentariosService {

    List<Comentarios> listarComentariosPorIdPostagem(Long idPostagem);

}
