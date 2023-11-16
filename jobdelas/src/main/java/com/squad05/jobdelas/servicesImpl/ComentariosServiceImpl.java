package com.squad05.jobdelas.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad05.jobdelas.model.Comentario;
import com.squad05.jobdelas.model.Comentarios;
import com.squad05.jobdelas.repository.ComentariosRepository;

import com.squad05.jobdelas.services.ComentariosService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentariosServiceImpl implements ComentariosService {

    @Autowired
    private ComentariosRepository comentariosRepository;

    @Override
    public List<Comentarios> listarComentariosPorIdPostagem(Long idPostagem) {
        return comentariosRepository.encontrarComentariosPorPostagemID(idPostagem);
    }

}
