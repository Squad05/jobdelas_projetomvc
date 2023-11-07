package com.squad05.jobdelas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squad05.jobdelas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
