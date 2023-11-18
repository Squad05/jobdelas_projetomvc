package com.squad05.jobdelas.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.squad05.jobdelas.model.Postagens;
import com.squad05.jobdelas.repository.PostagemRepository;
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

    public void deletarPostagens(Long id) {
        postagemRepository.deleteById(id);
    }

    @Override
    public Postagens cadastrarpostagens(Postagens postagens) {
        return postagemRepository.save(postagens);
    }

    // @Override
    // public Postagens cadastrarpostagens(Postagens postagens) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'cadastrarpostagens'");
    // }

    // @Override
    // public Postagens atualizarPostagens(Long id, Postagens postagensAtualizado) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'atualizarPostagens'");
    // }

}
