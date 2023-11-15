package com.squad05.jobdelas.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad05.jobdelas.model.Cursos;
import com.squad05.jobdelas.repository.CursosRepository;
import com.squad05.jobdelas.services.CursosService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class CursosServiceImpl implements CursosService {

    @Autowired
    private CursosRepository cursosRepository;

    @Override
    public List<Cursos> listarCursos() {
        return cursosRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cursos cadastrarCurso(Cursos curso) {
        return cursosRepository.save(curso);
    }

    @Override
    @Transactional(readOnly = true)
    public Cursos pegarCursoPorId(Long id) {
        return cursosRepository.findById(id).orElse(null);
    }

    @Override
    public Cursos atualizarCurso(Long id, Cursos cursoAtualizado) {
        Cursos cursoExiste = cursosRepository.findById(id).orElse(null);
        if (cursoExiste != null) {
            cursoExiste.setMateria(cursoAtualizado.getMateria());
            cursoExiste.setDuracao(cursoAtualizado.getDuracao());
            cursoExiste.setDescricao(cursoAtualizado.getDescricao());
            return cursosRepository.save(cursoExiste);
        } else {
            throw new RuntimeException("Curso " + cursoAtualizado.getMateria() + " não encontrada.");

        }
    }

    @Override
    public void deletarCurso(Long id) {
        cursosRepository.deleteById(id);
    }

}
