package com.squad05.jobdelas.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad05.jobdelas.model.Tarefas;
import com.squad05.jobdelas.repository.TarefasRepository;
import com.squad05.jobdelas.services.TarefasService;

@Service
public class TarefasServiceImpl implements TarefasService {

    @Autowired
    private TarefasRepository tarefasRepository;

    @Override
    public List<Tarefas> listaTarefas(Long usuarioId) {
        return tarefasRepository.findAllByUsuarioId(usuarioId);
    }
}
