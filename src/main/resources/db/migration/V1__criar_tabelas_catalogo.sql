CREATE TABLE livros(

    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR (50) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    descricao TEXT NOT NULL,
    data_publicacao DATE,
    preco NUMERIC(10, 2) NOT NULL,
    quantidade_estoque INT NOT NULL DEFAULT 0 CHECK (quantidade_estoque >=0)

);



CREATE TABLE trilhas(

    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE,
    descricao TEXT NOT NULL

);


CREATE TABLE trilhas_livros(

    trilha_id BIGINT NOT NULL,
    livro_id BIGINT NOT NULL,
    ordem SMALLINT NOT NULL,
    justificativa TEXT,
    PRIMARY KEY(trilha_id, livro_id),
    FOREIGN KEY(trilha_id) REFERENCES trilhas(id) ON DELETE CASCADE,
    FOREIGN KEY(livro_id) REFERENCES livros(id),
    UNIQUE(trilha_id, ordem)

);
