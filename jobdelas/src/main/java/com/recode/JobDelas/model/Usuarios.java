package com.recode.JobDelas.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Entity
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class Usuarios {
    @Id
    private String id;
    private String nome;
    private String email;
    private String senha;
    private String foto;
    private String resumo;
    private String telefone;
    private String linkDoPortfolio;

}
