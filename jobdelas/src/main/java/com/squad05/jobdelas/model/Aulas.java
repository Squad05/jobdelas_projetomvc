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

public class Aulas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String curso;
    private String titulo;
    private String link;
    private String descricao;


    public Aulas(){
        
    }

    // getters e setters
    // construtor vazio e com todos os atributos
}
