package com.squad05.jobdelas.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad05.jobdelas.model.Empresas;
import com.squad05.jobdelas.repository.EmpresasRepository;
import com.squad05.jobdelas.services.EmpresasService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresasServiceImpl implements EmpresasService {

    @Autowired
    private EmpresasRepository empresasRepository;

    @Override
    public List<Empresas> listarEmpresas() {
        return empresasRepository.findAll();
    }

    @Override
    @Transactional
    public Empresas cadastrarEmpresa(Empresas empresas) {
        return empresasRepository.save(empresas);
    }

}
