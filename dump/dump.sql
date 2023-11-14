CREATE DATABASE jobdelas;

CREATE TABLE usuarios (
id SERIAL PRIMARY KEY,
nome varchar(255) NOT NULL,
email VARCHAR(255) UNIQUE NOT NULL,
senha VARCHAR(255) NOT NULL,
foto VARCHAR(255),
resumo TEXT,
telefone VARCHAR(20),
linkDoPortfolio VARCHAR(255)
);
    
    
CREATE TABLE educacao (
    id SERIAL PRIMARY KEY,
    userID INTEGER REFERENCES usuarios(id),
    instituicao VARCHAR(255),
    areaDeEstudo VARCHAR(255) NOT NULL,
    dataDeConclusao TIMESTAMP
     );
     
CREATE TABLE empresas (
    id SERIAL PRIMARY KEY,
    cnpj VARCHAR(18) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(255) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    areaDeAtuacao VARCHAR(255) NOT NULL,
    descricao VARCHAR(255)
     );
     
CREATE TABLE vagas (
    id SERIAL PRIMARY KEY,
    experienciaNecessaria varchar(255),
    empresaAnuciante INTEGER REFERENCES empresas(id),
    descricao TEXT NOT NULL,
    cep VARCHAR(55),
    localizacao VARCHAR(255),
    funcao VARCHAR(255),
    statusVaga BOOLEAN NOT NULL
    );
       
CREATE TABLE candidaturas (
    id SERIAL PRIMARY KEY,
    candidatoID INTEGER REFERENCES usuarios(id)
    );
         
      
CREATE TABLE postagens (
    id SERIAL PRIMARY KEY,
    userID INTEGER REFERENCES usuarios(id),
    categoria VARCHAR(255),
    conteudo TEXT NOT NULL,
    dataPostagem TIMESTAMP
);
        
CREATE TABLE comentarios (
    id SERIAL PRIMARY KEY,
    postID INTEGER REFERENCES postagens(id),
    userID INTEGER REFERENCES usuarios(id),
    conteudo TEXT NOT NULL,
    dataComentario TIMESTAMP
);
        
        
CREATE TABLE notificacoes (
    id SERIAL PRIMARY KEY,
    userID INTEGER REFERENCES usuarios(id),
    mensagem VARCHAR(255) NOT NULL,
    dataNotificacao TIMESTAMP,
    lida BOOLEAN
);
       
CREATE TABLE tarefas (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER REFERENCES usuarios(id),
    titulo VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    concluida BOOLEAN 
);
     
     
CREATE TABLE mensagens (
    id SERIAL PRIMARY KEY,
    remetenteID INTEGER REFERENCES usuarios(id),
    destinatarioID INTEGER REFERENCES usuarios(id),
    mensagem TEXT,
    dataDeEnvio TIMESTAMP,
    lida BOOLEAN
);

CREATE TABLE cursos (
    id SERIAL PRIMARY KEY,
    materia VARCHAR(255) NOT NULL,
    duracao VARCHAR(255) NOT NULL
);
     