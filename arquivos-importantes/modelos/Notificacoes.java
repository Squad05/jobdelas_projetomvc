package com.squad05.jobdelas.model;

import java.security.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
public class Notificacoes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Usuarios userId;
    private String mensagem;
    private Timestamp dataNotificacao;
    private Boolean lida;

    public Notificacoes() {

    }
}