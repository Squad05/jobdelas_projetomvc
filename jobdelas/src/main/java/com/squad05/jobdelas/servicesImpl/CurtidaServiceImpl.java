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

    @Override
    public Curtida curtirPostagem(Curtida curtida) {
        return curtidaRepository.save(curtida);
    }

    @Override
    public int contarCurtidasDaPostagem(Long postagemId) {
        return curtidaRepository.countByPostagensId(postagemId);
    }

}
