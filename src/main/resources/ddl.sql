CREATE TABLE produtos (
    id_produto UUID PRIMARY KEY,
    categoria VARCHAR(255),
    quantidade INTEGER,
    lote VARCHAR(255),
    data_validade DATE,
    data_fabricacao DATE,
    fabricante VARCHAR(255),
    nome_produto VARCHAR(255),
    data_cadastro TIMESTAMP
)