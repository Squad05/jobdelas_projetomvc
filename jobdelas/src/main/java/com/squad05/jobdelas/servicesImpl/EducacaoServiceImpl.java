package com.squad05.jobdelas.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad05.jobdelas.model.Educacao;
import com.squad05.jobdelas.repository.EducacaoRepository;
import com.squad05.jobdelas.services.EducacaoService;

@Service
public class EducacaoServiceImpl implements EducacaoService {

    @Autowired
    private EducacaoRepository educacaoRepository;

    @Override
    public Educacao cadastrarEducacao(Educacao educacao) {
        return educacaoRepository.save(educacao);
    }

}
