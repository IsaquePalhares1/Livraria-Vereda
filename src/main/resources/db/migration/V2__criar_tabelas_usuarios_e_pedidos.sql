CREATE TABLE usuarios (

    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    telefone VARCHAR(15)

);

CREATE TABLE enderecos(

    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(100),
    bairro VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado CHAR(2) NOT NULL,
    cep CHAR(8) NOT NULL,
    FOREIGN KEY(usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE   

);


CREATE TABLE pedidos(

    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    endereco_id BIGINT NOT NULL,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDENTE',
    valor_total NUMERIC(10, 2) NOT NULL DEFAULT 0 CHECK (valor_total >= 0),
    FOREIGN KEY(usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY(endereco_id) REFERENCES enderecos(id)

);


CREATE TABLE itens_pedido(

    pedido_id BIGINT NOT NULL,
    livro_id BIGINT NOT NULL,
    PRIMARY KEY(pedido_id, livro_id),
    quantidade SMALLINT NOT NULL CHECK(quantidade > 0),
    preco_unitario NUMERIC(10, 2) NOT NULL CHECK(preco_unitario >= 0),
    FOREIGN KEY(pedido_id) REFERENCES pedidos(id) ON DELETE CASCADE,
    FOREIGN KEY(livro_id) REFERENCES livros(id)

);
