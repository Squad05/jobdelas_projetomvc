package com.squad05.jobdelas.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad05.jobdelas.model.Postagens;
import com.squad05.jobdelas.repository.PostagemRepository;
import com.squad05.jobdelas.repository.UsuarioRepository;
import com.squad05.jobdelas.services.PostagensService;

@Service
public class PostagensServiceImpl implements PostagensService {

    @Autowired
    private PostagemRepository postagemRepository;

    @Override
    public List<Postagens> listarTodasPostagens() {
        return postagemRepository.findAll();
    }

    @Override
    public List<Postagens> listarPostagensPorCategoria(String categoria) {
        return null;

    }

}
