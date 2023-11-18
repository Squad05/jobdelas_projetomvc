package com.squad05.jobdelas.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.squad05.jobdelas.services.AulasService;
import com.squad05.jobdelas.model.Aulas;
import com.squad05.jobdelas.repository.AulasRepository;
import org.springframework.stereotype.Service;

@Service
public class AulasServiceImpl implements AulasService {

    @Autowired
    private final AulasRepository aulasRepository;

    public AulasServiceImpl(AulasRepository aulasRepository) {
        this.aulasRepository = aulasRepository;
    }

    @Override
    public List<Aulas> listarAulasPorCursoId(Long cursoId) {
        return aulasRepository.findAllByCursoId(cursoId);
    }

    @Override
    public Aulas cadastrarAula(Aulas aulas) {
        return aulasRepository.save(aulas);
    }

    @Override
    public Aulas atualizarAula(Long id, Aulas aulaAtualizada) {
        Aulas aulaExiste = aulasRepository.findById(id).orElse(null);
        if (aulaExiste != null) {
            aulaExiste.setCurso(aulaAtualizada.getCurso());
            aulaExiste.setDescricao(aulaAtualizada.getDescricao());
            aulaExiste.setLink(aulaAtualizada.getLink());
            aulaExiste.setTitulo(aulaAtualizada.getTitulo());

            return aulasRepository.save(aulaExiste);

        } else {
            throw new RuntimeException("Aula " + aulaAtualizada.getTitulo() + " não encontrada");
        }
    }

    @Override
    public void deletarAula(Long id) {
        aulasRepository.deleteById(id);
    }

    @Override
    public Aulas pegarAulaPorId(Long id) {
        return aulasRepository.findById(id).orElse(null);
    }

}
