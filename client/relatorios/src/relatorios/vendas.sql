create table regiao (
    uf char(2) primary key,
    nome varchar(30) not null
);

create table produto (
    id integer primary key,
    nome varchar(30) not null,
    preco decimal(14,2) not null
);

create table vendas (
    uf char(2) not null,
    produto integer not null,
    qtde integer not null,
    primary key (uf, produto),
    foreign key (uf) references regiao (uf),
    foreign key (produto) references produto (id)
);

insert into regiao values ('RJ', 'Rio de Janeiro');

insert into regiao values ('PR', 'Paraná');

insert into regiao values ('SP', 'São Paulo');

insert into regiao values ('MG', 'Minas Gerais');


insert into produto values (1, 'Monitor 23"', 300.00);

insert into produto values (2, 'CPU 2.5Ghz', 500.00);

insert into produto values (3, 'DVD-Writer', 800.00);

insert into vendas values ('PR', 1, 2);

insert into vendas values ('PR', 2, 4);

insert into vendas values ('PR', 3, 6);

insert into vendas values ('RJ', 1, 5);

insert into vendas values ('RJ', 2, 3);

insert into vendas values ('RJ', 3, 6);

insert into vendas values ('SP', 1, 9);

insert into vendas values ('SP', 2, 8);

insert into vendas values ('SP', 3, 4);

insert into vendas values ('MG', 1, 12);

insert into vendas values ('MG', 2, 2);

insert into vendas values ('MG', 3, 1);

