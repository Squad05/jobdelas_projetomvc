package com.squad05.jobdelas.services;

import java.util.List;

import com.squad05.jobdelas.model.Empresas;

public interface EmpresasService {

    List<Empresas> listarEmpresas();

    Empresas cadastrarEmpresa(Empresas empresas);

}
