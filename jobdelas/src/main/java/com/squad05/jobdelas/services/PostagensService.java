package com.squad05.jobdelas.services;

import java.util.List;

import com.squad05.jobdelas.model.Postagens;

public interface PostagensService {

    List<Postagens> listarTodasPostagens();

    List<Postagens> listarPostagensPorCategoria(String categoria);

    // Postagens cadastrarpostagens(Postagens postagens);

    // Postagens atualizarPostagens(Long id, Postagens postagensAtualizado);

    // void deletarPostagens(Long id);

    // Postagens pegarPostagensPorId(Long id);

}