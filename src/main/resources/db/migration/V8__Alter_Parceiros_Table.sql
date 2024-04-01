ALTER TABLE parceiros
ADD COLUMN id_assinatura INT,
ADD FOREIGN KEY (id_assinatura) REFERENCES assinaturas(id);
