package com.squad05.jobdelas.services;

import java.util.List;

import com.squad05.jobdelas.model.Tarefas;

public interface TarefasService {

    List<Tarefas> listaTarefas(Long usuarioId);
}