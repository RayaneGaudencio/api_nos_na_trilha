CREATE TABLE assinaturas (
     id INT AUTO_INCREMENT PRIMARY KEY,
     tipo VARCHAR(10) CHECK (tipo IN ('SIMPLES', 'SILVER', 'GOLD')),
     valor DECIMAL(10, 2),
     qtd_roteiros INT
);
