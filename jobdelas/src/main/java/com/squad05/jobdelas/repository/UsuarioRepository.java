package com.squad05.jobdelas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.squad05.jobdelas.model.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    Usuarios findByEmail(String email);

}
