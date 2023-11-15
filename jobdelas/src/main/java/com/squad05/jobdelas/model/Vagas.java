package com.squad05.jobdelas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Vagas {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Empresas empresaAnunciante;
    private String experienciaNecessaria;
    private String descricao;
    private String cep;
    private String localizacao;
    private String funcao;
    private Boolean statusVaga;

    public Vagas() {
        
    }
}
