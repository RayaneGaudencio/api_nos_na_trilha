CREATE TABLE roteiros (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    preco BIGINT NOT NULL,
    qtd_vagas INT NOT NULL,
    data_inicio DATE NOT NULL,
    horario_saida VARCHAR(255),
    transporte VARCHAR(255),
    categoria ENUM('TRILHA', 'ESCALADA', 'PRAIA', 'PONTO_TURISTICO', 'CACHOEIRA', 'RIO', 'SITIO_ARQ'),
    alojamento VARCHAR(255),
    descricao TEXT,
    requisitos TEXT,
    atracoes_atv TEXT,
    id_parceiro BIGINT REFERENCES parceiros(id)
);