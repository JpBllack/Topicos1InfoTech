-- Inserção de dados na tabela 'estado'
INSERT INTO estado (nome, sigla) VALUES ('Tocantins', 'TO');
INSERT INTO estado (nome, sigla) VALUES ('Goiás', 'GO');
INSERT INTO estado (nome, sigla) VALUES ('Rio de Janeiro', 'RJ');
INSERT INTO estado (nome, sigla) VALUES ('São Paulo', 'SP');

-- Inserção de dados na tabela 'categoria'
INSERT INTO categoria (nome) VALUES ('SmartPhone');
INSERT INTO categoria (nome) VALUES ('Tv');
INSERT INTO categoria (nome) VALUES ('Console');
INSERT INTO categoria (nome) VALUES ('Pc');

-- Inserção de dados na tabela 'avaliacao'
INSERT INTO avaliacao (nota, comentario) VALUES (5, 'Muito bom');
INSERT INTO avaliacao (nota, comentario) VALUES (4, 'Gostei, comprarei novamente');
INSERT INTO avaliacao (nota, comentario) VALUES (1, 'Golpe!!!!!!!!!');

-- Inserção de dados na tabela 'produto'
INSERT INTO produto (dataInclusao, quantidade_estoque, valor, categoria_produto, descricao, nome) VALUES ('2023-11-28 18:03:57.903875', 122, 3900, 1, 'aaaaaaaaaaaaaaaaaa', 'Iphone 13 128gb');
INSERT INTO produto (dataInclusao, quantidade_estoque, valor, categoria_produto, descricao, nome) VALUES ('2023-11-28 18:03:57.903875', 50, 5500, 1, 'iphone 14 sdsdsadsadsadsdsadsds', 'Iphone 14 256gb');
INSERT INTO produto (dataInclusao, quantidade_estoque, valor, categoria_produto, descricao, nome) VALUES ('2023-11-28 18:03:57.903875', 95, 3000, 1, 'Xiaomi mi 11 aaaaaaaaaaaaa', 'Xiaomi mi 11 512gb');
INSERT INTO produto (dataInclusao, quantidade_estoque, valor, categoria_produto, descricao, nome) VALUES ('2023-11-28 18:03:57.903875', 20, 5200, 4, 'pc', 'Xeon e5 2670 RTX 2060 Super 8gb 16gb');

-- Inserção de dados na tabela 'usuario'
INSERT INTO usuario (dataInclusao, cpf, email, login, nome, senha) VALUES ('2023-11-28 18:03:57.903875', '05562849259', 'joao@gmail.com', 'joaojoao', 'joao', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');
INSERT INTO usuario (dataInclusao, cpf, email, login, nome, senha) VALUES ('2023-11-28 18:07:39.904241', '12345678901', 'maria@gmail.com', 'mariamaria', 'Maria', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');
INSERT INTO usuario (dataInclusao, cpf, email, login, nome, senha) VALUES ('2023-11-28 18:07:47.500390', '23456789012', 'joao@gmail.com', 'joaojoao', 'João', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');
INSERT INTO usuario (dataInclusao, cpf, email, login, nome, senha) VALUES ('2023-11-28 18:07:53.952613', '34567890123', 'ana@gmail.com', 'anaana', 'Ana', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');
INSERT INTO usuario (dataInclusao, cpf, email, login, nome, senha) VALUES ('2023-11-28 18:07:59.345242', '45678901234', 'pedro@gmail.com', 'pedropedro', 'Pedro', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');
INSERT INTO usuario (dataInclusao, cpf, email, login, nome, senha) VALUES ('2023-11-28 18:08:04.895422', '56789012345', 'carla@gmail.com', 'carlacarla', 'Carla', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');
