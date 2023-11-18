package com.squad05.jobdelas.servicesImpl;

import com.squad05.jobdelas.model.Curtida;
import com.squad05.jobdelas.repository.CurtidaRepository;
import com.squad05.jobdelas.services.CurtidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurtidaServiceImpl implements CurtidaService {

    @Autowired
    private CurtidaRepository curtidaRepository;

    // @Override
    // public void curtirPostagem(Long usuarioId, Long postagemId) {
    // if (curtidaRepository.existeByUsuarioEAndPostagemId(usuarioId, postagemId)) {
    // throw new IllegalStateException("Usuário já curtiu esta postagem.");
    // }

    // Curtida curtida = new Curtida();
    // curtida.setUsuario(new Usuario(usuarioId));
    // curtida.setPostagem(new Postagem(postagemId));
    // curtidaRepository.save(curtida);
    // }

    @Override
    public int contarCurtidasDaPostagem(Long postagemId) {
        return curtidaRepository.countByPostagensId(postagemId);
    }

}
