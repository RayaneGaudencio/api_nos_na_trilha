CREATE TABLE endereco(
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      logradouro VARCHAR(100),
      bairro VARCHAR(100),
      cep VARCHAR(10),
      numero VARCHAR(10),
      complemento VARCHAR(255),
      cidade VARCHAR(100),
      uf VARCHAR(2),
      parceiro_id BIGINT,
      FOREIGN KEY (parceiro_id) REFERENCES parceiros(id)
)
