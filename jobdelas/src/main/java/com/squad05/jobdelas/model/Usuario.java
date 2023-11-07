package com.squad05.jobdelas.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Usuario {

    private long id;
    private String nome;
    private String email;
    private String senha;
    private String foto;
    private String resumo;
    private String telefone;
    private String linkDoPorfolio;
}