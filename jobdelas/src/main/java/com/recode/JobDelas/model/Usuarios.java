package com.recode.JobDelas.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class Usuarios {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String foto;
    private String resumo;
    private String telefone;
    private String linkDoPortfolio;

}
