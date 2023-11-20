package com.squad05.jobdelas.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad05.jobdelas.model.Candidaturas;
import com.squad05.jobdelas.repository.CandidaturasRepository;
import com.squad05.jobdelas.services.CandidaturasService;

@Service
public class CandidaturasServiceImpl implements CandidaturasService {

    @Autowired
    private CandidaturasRepository candidaturasRepository;

    @Override
    public Candidaturas cadastrarCandidaturas(Candidaturas candidaturas) {
        return candidaturasRepository.save(candidaturas);
    }

}
