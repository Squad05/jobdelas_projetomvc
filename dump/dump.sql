CREATE DATABASE jobdelas;

CREATE TABLE usuarios (
id INTEGER AUTO_INCREMENT PRIMARY KEY,
nome varchar(255) NOT NULL,
email VARCHAR(255) UNIQUE NOT NULL,
senha VARCHAR(255) NOT NULL,
foto VARCHAR(255),
resumo TEXT,
telefone VARCHAR(20),
linkDoPortfolio VARCHAR(255)
);
    
    
CREATE TABLE educacao (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    userID INTEGER,
    instituicao VARCHAR(255),
    areaDeEstudo VARCHAR(255) NOT NULL,
    dataDeConclusao TIMESTAMP,
    FOREIGN KEY(userID) REFERENCES usuarios (id)
);
     
CREATE TABLE empresas (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    cnpj VARCHAR(18) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(255) UNIQUE NOT NULL,
    area_de_atuacao VARCHAR(255) NOT NULL,
    descricao VARCHAR(255)
);
     
CREATE TABLE vagas (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    empresa_anunciante INTEGER,
    descricao TEXT NOT NULL,
    cep VARCHAR(55),
    localizacao VARCHAR(255),
    funcao VARCHAR(255),
    status_vaga BOOLEAN NOT NULL,
    salario int not null,
    FOREIGN KEY(empresa_anunciante) REFERENCES empresas (id)
);
       
CREATE TABLE candidaturas (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    candidatoID INTEGER,
    FOREIGN KEY(candidatoID) REFERENCES usuarios (id)
    );
         
      
CREATE TABLE postagens (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    usuario_id INTEGER,
    categoria VARCHAR(255),
    conteudo TEXT NOT NULL,
    data_postagem DATETIME,
    FOREIGN KEY(usuario_id) REFERENCES usuarios (id)
);

CREATE TABLE comentarios (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    usuario_id INTEGER,
    conteudo TEXT NOT NULL,
    data_comentario DATETIME,
    FOREIGN KEY(usuario_id) REFERENCES usuarios (id)
);

CREATE TABLE postagem_comentario (
    postagem_id INTEGER,
    comentario_id INTEGER,
    PRIMARY KEY (postagem_id, comentario_id),
    FOREIGN KEY(postagem_id) REFERENCES postagens (id),
    FOREIGN KEY(comentario_id) REFERENCES comentarios (id)
);
        

CREATE TABLE tarefas (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    userID INTEGER,
    titulo VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    concluida BOOLEAN,
    FOREIGN KEY(userID) REFERENCES usuarios (id),

);
     


CREATE TABLE cursos (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    materia VARCHAR(255) NOT NULL,
    duracao VARCHAR(255) NOT NULL
);
    

create table aulas (
  id INTEGER AUTO_INCREMENT PRIMARY KEY, 
  cursoId INTEGER,
  titulo varchar(255) not null,
  link varchar(255) not null,
  descricao varchar(255) not null,
  FOREIGN KEY(cursoId) REFERENCES cursos(id)
);