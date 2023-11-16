package com.squad05.jobdelas.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad05.jobdelas.model.Vagas;
import com.squad05.jobdelas.repository.VagasRepository;
import com.squad05.jobdelas.services.VagasService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.transaction.annotation.Transactional;

@Service
public class VagasServiceImpl implements VagasService {

    @Autowired
    private VagasRepository vagasRepository;

    @Override
    public List<Vagas> listarVagas() {
        return vagasRepository.findAll();
    }

    @Override
    public Vagas cadastrarVagas(Vagas vagas) {
        return vagasRepository.save(vagas);
    }

    @Override
    public Vagas atualizarVagas(Long id, Vagas vagasAtualizado) {
        Vagas vagaExiste = vagasRepository.findById(id).orElse(null);

        if (vagaExiste != null && vagasAtualizado != null) {
            vagaExiste.setCep(vagasAtualizado.getCep());
            vagaExiste.setDescricao(vagasAtualizado.getDescricao());
            vagaExiste.setEmpresas(vagasAtualizado.getEmpresas());
            vagaExiste.setFuncao(vagasAtualizado.getFuncao());
            vagaExiste.setLocalizacao(vagasAtualizado.getLocalizacao());
            return vagasRepository.save(vagaExiste);
        } else {
            throw new EntityNotFoundException("Vaga com ID " + id + " não encontrada");
        }
    }

    @Override
    public void deletarVagas(Long id) {
        vagasRepository.deleteById(id);
    }

    @Override
    public Vagas pegarVagasPorId(Long id) {
        return vagasRepository.findById(id).orElse(null);
    }

}
