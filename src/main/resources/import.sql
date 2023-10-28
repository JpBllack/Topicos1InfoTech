-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

insert into estado (nome, sigla) values('Tocantins', 'TO');
insert into estado (nome, sigla) values('Goiás', 'GO');
insert into estado (nome, sigla) values('Rio de Janeiro', 'RJ');
insert into estado (nome, sigla) values('São Paulo', 'SP');

insert into cidade (nome, id_estado) values('Palmas', 1);
insert into cidade (nome, id_estado) values('Paraiso', 1);
insert into cidade (nome, id_estado) values('Porto Nacional', 1);
insert into cidade (nome, id_estado) values('Goiania', 2);
insert into cidade (nome, id_estado) values('Rio de Janeiro', 3);
insert into cidade (nome, id_estado) values('São Paulo', 4);

 
insert into usuario (nome, login, senha) values ('John Smith', 'jsmith', '123');
insert into usuario (nome, login, senha) values ('Will Smith', 'Will', '456');
insert into usuario (nome, login, senha) values ('Jaden Smith', 'Jaden', '789');

insert into categoria (nome) values ('Cabos e Adptadores');
insert into categoria (nome) values ('Fone de ouvido');
insert into categoria (nome) values ('Mouse');
insert into categoria (nome) values ('hardware');


insert into produto (nome, descricao, preco, categoria) VALUES ('Cabo HDMI 2.0', 'Cabo HDMI de alta velocidade', 19.99, 'Cabos e Adaptadores');
insert into produto (nome, descricao, preco, categoria) VALUES ('Fone de Ouvido Bluetooth', 'Fone de ouvido sem fio com cancelamento de ruído', 79.99, 'Fone de Ouvido');
insert into produto (nome, descricao, preco, categoria) VALUES ('Mouse Óptico USB', 'Mouse óptico com fio para computadores', 14.99, 'Mouse');
insert into produto (nome, descricao, preco, categoria) VALUES ('Placa de Vídeo GeForce RTX 3080', 'Placa de vídeo de alto desempenho para jogos', 699.99, 'Hardware');








