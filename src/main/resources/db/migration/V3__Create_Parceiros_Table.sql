create table parceiros(
    id bigint not null auto_increment primary key,
    nome varchar(100) not null,
    email varchar(100) not null,
    senha varchar(50) not null,
    numero_telefone varchar(30) not null,
    porte int not null,
    identificador varchar(30) not null
)