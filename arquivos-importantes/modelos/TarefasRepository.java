package com.squad05.jobdelas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.squad05.jobdelas.model.Tarefas;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas, Long> {

}