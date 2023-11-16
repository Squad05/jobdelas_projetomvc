package com.squad05.jobdelas.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad05.jobdelas.model.Usuarios;
import com.squad05.jobdelas.repository.UsuarioRepository;
import com.squad05.jobdelas.services.UsuariosService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuarios> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuarios pegarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Usuarios salvarUsuario(Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuarios atualizarUsuario(Long id, Usuarios usuarioAtualizado) {
        Usuarios usuarioExiste = usuarioRepository.findById(id).orElse(null);
        if (usuarioExiste != null) {
            usuarioExiste.setNome(usuarioAtualizado.getNome());
            usuarioExiste.setEmail(usuarioAtualizado.getEmail());
            usuarioExiste.setSenha(usuarioAtualizado.getSenha());
            usuarioExiste.setFoto(usuarioAtualizado.getFoto());
            usuarioExiste.setResumo(usuarioAtualizado.getResumo());
            usuarioAtualizado.setLinkDoPorfolio(usuarioAtualizado.getLinkDoPorfolio());

            return usuarioRepository.save(usuarioExiste);
        } else {
            throw new RuntimeException("Usuario não encontrado.");
        }
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public boolean verificarEmailExistente(String email) {
        Usuarios usuarioEncontrado = usuarioRepository.findByEmail(email);
        return usuarioEncontrado != null;
    }

    @Override
    public Usuarios encontrarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public Optional<Usuarios> buscarUsuarioPorEmail(String email) {
        return Optional.ofNullable(usuarioRepository.findByEmail(email));
    }
}
