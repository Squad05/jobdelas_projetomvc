package com.squad05.jobdelas.services;

import com.squad05.jobdelas.model.Curtida;

public interface CurtidaService {

    int contarCurtidasDaPostagem(Long postagemId);

    Curtida curtirPostagem(Curtida curtida);

}
