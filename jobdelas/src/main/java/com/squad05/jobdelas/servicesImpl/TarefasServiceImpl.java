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

    @Override
    public Tarefas criarTarefa(Tarefas tarefas) {
        return tarefasRepository.save(tarefas);
    }

    @Override
    public void deletarTarefa(Long id) {
        tarefasRepository.deleteById(id);
    }

    @Override
    public Tarefas atualizarTarefas(Long id, Tarefas tarefaAtualizada) {
        Tarefas tarefa = tarefasRepository.findById(id).orElse(null);

        tarefa.setTitulo(tarefaAtualizada.getTitulo());
        tarefa.setDescricao(tarefaAtualizada.getDescricao());

        return tarefasRepository.save(tarefaAtualizada);
    }

}
