package com.recode.JobDelas.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@EqualsAndHashCode
@Data
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
