package com.squad05.jobdelas.servicesImpl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.squad05.jobdelas.repository.CursosRepository;
import com.squad05.jobdelas.services.AulasService;
import com.squad05.jobdelas.services.CursosService;
import com.squad05.jobdelas.model.Aulas;
import com.squad05.jobdelas.model.Cursos;
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

}
