create table tb_cidade (
    id_cidade bigint not null primary key,
    nome varchar(50) not null,
    qtd_habitantes bigint
);

insert into tb_cidade
    (id_cidade, nome, qtd_habitantes)
values
    (1, 'São Paulo', 123963372),
    (2, 'Rio de Janeiro', 6748000),
    (3, 'Fortaleza', 2687000),
    (4, 'Salvador', 2900319),
    (5, 'Belo Horizonte', 2722000),
    (6, 'Porto Alegre', 1500000),
    (7, 'Porto Velho', 539354),
    (8, 'Palmas', 306296),
    (9, 'Recife', 1683461),
    (10, 'Natal', 890480),
    (11, 'Brasília', 3094325);
