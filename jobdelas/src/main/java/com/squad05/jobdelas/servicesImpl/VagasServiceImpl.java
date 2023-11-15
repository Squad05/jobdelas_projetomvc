package com.squad05.jobdelas.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad05.jobdelas.model.Vagas;
import com.squad05.jobdelas.repository.VagasRepository;
import com.squad05.jobdelas.services.VagasService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class VagasServiceImpl implements VagasService {

    @Autowired
    private VagasRepository cursosRepository;

    @Override
    public List<Vagas> listarVagas() {
        return vagasRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Vagas cadastrarVagas(Vagas vagas) {
        return vagasRepository.save(vagas);
    }

    @Override
    @Transactional(readOnly = true)
    public Vagas pegarVagasPorId(Long id) {
        return vagasRepository.findById(id).orElse(null);
    }

    @Override
    public Vagas atualizarVagas(Long id, Vagas vagasAtualizado) {
        Vagas vagasExiste = vagasRepository.findById(id).orElse(null);
        if (vagasExiste != null) {
            vagasExiste.setStatusVaga(vagasAtualizado.getStatusVaga());            
            return vagasRepository.save(vagasExiste);
        } else {
            throw new RuntimeException("Vagas " + vagasAtualizado.getStatusVaga() + " Vaga não encontrada.");

        }
    }

    @Override
    public void deletarVagas(Long id) {
        vagasRepository.deleteById(id);
    }

}

