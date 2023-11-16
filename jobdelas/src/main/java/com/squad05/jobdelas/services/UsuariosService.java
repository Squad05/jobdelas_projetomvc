package com.squad05.jobdelas.services;

import java.util.List;

import com.squad05.jobdelas.model.Usuarios;

public interface UsuariosService {

    List<Usuarios> listarUsuarios();

    Usuarios pegarUsuarioPorId(Long id);

    Usuarios salvarUsuario(Usuarios usuario);

    Usuarios atualizarUsuario(Long id, Usuarios usuarioAtualizado);

    void deletarUsuario(Long id);

    boolean verificarEmailExistente(String email);

    Usuarios encontrarPorEmail(String email);

}