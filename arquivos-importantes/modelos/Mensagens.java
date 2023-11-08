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
public class Mensagens {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Usuarios remententeId;
    private Usuarios destinatarioId;
    private String mensagem;
    private Timestamp dataDeEnvio;
    private Boolean lida;

    public Mensagens() {

    }
}
