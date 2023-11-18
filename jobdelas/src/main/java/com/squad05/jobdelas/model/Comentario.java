// package com.squad05.jobdelas.model;

// import java.time.LocalDateTime;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
// import lombok.Data;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @Entity
// public class Comentario {

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long id;

// @ManyToOne
// @JoinColumn(name = "usuario_id")
// private Usuarios usuarios;

// @ManyToOne
// @JoinColumn(name = "postagem_id")

// private String conteudo;

// private LocalDateTime data_comentario;

// }
