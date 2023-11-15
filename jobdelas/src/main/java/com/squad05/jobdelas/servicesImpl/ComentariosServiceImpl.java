package com.squad05.jobdelas.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad05.jobdelas.model.Comentarios;
import com.squad05.jobdelas.repository.ComentariosRepository;

import com.squad05.jobdelas.services.ComentariosService;


import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentariosServiceImpl implements ComentariosService {

    @Autowired
    private ComentariosRepository comentariosRepository;

    @Override
    public List<Comentarios> listarComentarios() {
        return comentariosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Comentarios cadastrarComentarios(Comentarios comentarios) {
        return comentariosRepository.save(comentarios);
    }

    @Override
    @Transactional(readOnly = true)
    public Comentarios pegarComentariosPorId(Long id) {
        return comentariosRepository.findById(id).orElse(null);
    }

    @Override
    public Comentarios atualizarComentarios(Long id, Comentarios comentariosAtualizado) {
        Comentarios comentariosExiste = comentariosRepository.findById(id).orElse(null);
        if (comentariosExiste != null) {
            comentariosExiste.setConteudo(comentariosAtualizado.getConteudo());            
            return comentariosRepository.save(comentariosExiste);
        } else {
            throw new RuntimeException("Comentarios " + comentariosAtualizado.getConteudo() + " Comentário não encontrado.");

        }
    }

    @Override
    public void deletarComentarios(Long id) {
        comentariosRepository.deleteById(id);
    }

}

