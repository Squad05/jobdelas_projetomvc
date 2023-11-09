package com.squad05.jobdelas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.squad05.jobdelas.model.Usuarios;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    Usuarios findByEmail(String email);

    void save(Optional<Usuarios> usuarioExistente);

    @Query(value = "select * from usuarios where email = :email and senha = :senha", nativeQuery = true)
    public Usuarios Login(String email, String senha);

}
