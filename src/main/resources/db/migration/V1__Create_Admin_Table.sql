create table admins(
    id bigint not null auto_increment primary key,
    nome  varchar(100) not null,
    email varchar(100) not null,
    senha varchar(50)  not null
)