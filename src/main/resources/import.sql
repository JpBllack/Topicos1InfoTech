-- Inserção de dados na tabela 'estado'
INSERT INTO estado (nome, sigla) VALUES ('Tocantins', 'TO');
INSERT INTO estado (nome, sigla) VALUES ('Goiás', 'GO');
INSERT INTO estado (nome, sigla) VALUES ('Rio de Janeiro', 'RJ');
INSERT INTO estado (nome, sigla) VALUES ('São Paulo', 'SP');

-- Inserção de dados na tabela 'cidade'
INSERT INTO cidade (dataInclusao, id, usuario_estado, nome) VALUES ('2023-11-28 17:52:21.615056', 1, 1, 'Palmas');
INSERT INTO cidade (dataInclusao, id, usuario_estado, nome) VALUES ('2023-11-28 17:52:21.615056', 2, 2, 'Goiania');
INSERT INTO cidade (dataInclusao, id, usuario_estado, nome) VALUES ('2023-11-28 17:52:21.615056', 3, 1, 'Araguaina');

INSERT INTO cidade (dataInclusao, id, usuario_estado, nome) VALUES ('2023-11-29 17:52:21.615056', 4, 1, 'TESTE');

-- Inserção de dados na tabela 'categoria'

INSERT INTO categoria (nome) VALUES ('SmartPhone');
INSERT INTO categoria (nome) VALUES ('Tv');
INSERT INTO categoria (nome) VALUES ('Console');
INSERT INTO categoria (nome) VALUES ('Pc');

INSERT INTO categoria (nome) VALUES ('Teste');



-- Inserção de dados na tabela 'produto'
INSERT INTO produto (dataInclusao, quantidade_estoque, valor, categoria_produto, descricao, nome) VALUES ('2023-11-28 18:03:57.903875', 122, 3900, 1, 'aaaaaaaaaaaaaaaaaa', 'Iphone 13 128gb');
INSERT INTO produto (dataInclusao, quantidade_estoque, valor, categoria_produto, descricao, nome) VALUES ('2023-11-28 18:03:57.903875', 50, 5500, 1, 'iphone 14 sdsdsadsadsadsdsadsds', 'Iphone 14 256gb');
INSERT INTO produto (dataInclusao, quantidade_estoque, valor, categoria_produto, descricao, nome) VALUES ('2023-11-28 18:03:57.903875', 95, 3000, 1, 'Xiaomi mi 11 aaaaaaaaaaaaa', 'Xiaomi mi 11 512gb');
INSERT INTO produto (dataInclusao, quantidade_estoque, valor, categoria_produto, descricao, nome) VALUES ('2023-11-28 18:03:57.903875', 20, 5200, 4, 'pc', 'Xeon e5 2670 RTX 2060 Super 8gb 16gb');

-- Inserção de dados na tabela 'avaliacao'
INSERT INTO avaliacao (nota, comentario, produto_avaliacao) VALUES (5, 'Muito bom', 1);
INSERT INTO avaliacao (nota, comentario) VALUES (4, 'Gostei, comprarei novamente');
INSERT INTO avaliacao (nota, comentario) VALUES (1, 'Golpe!!!!!!!!!');

-- Inserção de dados na tabela 'usuario'
INSERT INTO usuario (id, dataInclusao, cpf, email, login, nome, senha) VALUES ('sdas-asdasdsas-aasd23234','2023-11-28 18:03:57.903875', '05415887105', 'joao@gmail.com', 'joaojoao', 'joao', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');
INSERT INTO usuario (id, dataInclusao, cpf, email, login, nome, senha) VALUES ('sdgg3434-aasd23234','2023-11-28 18:07:39.904241', '12345678901', 'maria@gmail.com', 'mariamaria', 'Maria', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');
INSERT INTO usuario (id, dataInclusao, cpf, email, login, nome, senha) VALUES ('213sdfdsas-aasd23234','2023-11-28 18:07:47.500390', '23456789012', 'joao@gmail.com', 'joaojoao', 'João', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');
INSERT INTO usuario (id, dataInclusao, cpf, email, login, nome, senha) VALUES ('sdd32hsd23234','2023-11-28 18:07:53.952613', '34567890123', 'ana@gmail.com', 'anaana', 'Ana', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');
INSERT INTO usuario (id, dataInclusao, cpf, email, login, nome, senha) VALUES ('234342sdsas-afdsfsd23234','2023-11-28 18:07:59.345242', '45678901234', 'pedro@gmail.com', 'pedropedro', 'Pedro', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');
INSERT INTO usuario (id, dataInclusao, cpf, email, login, nome, senha) VALUES ('kdsafst4322sd23234','2023-11-28 18:08:04.895422', '56789012345', 'carla@gmail.com', 'carlacarla', 'Carla', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');

-- teste
INSERT INTO usuario (id, dataInclusao, cpf, email, login, nome, senha) VALUES ('testestestesteste','2023-11-28 18:08:04.895422', '56789012345', 'teste@gmail.com', 'testeste', 'Carla', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');
INSERT INTO usuario_perfil(perfil, id_usuario) VALUE (2, 'testestestesteste');
INSERT INTO usuario_perfil(perfil, id_usuario) VALUE (1, 'testestestesteste');
INSERT INTO usuario (id, dataInclusao, cpf, email, login, nome, senha) VALUES ('testestestesteste2','2023-11-28 18:08:04.895422', '00000000000', 'teste2@gmail.com', 'testeste2', 'TEstte', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==');
INSERT INTO usuario_perfil(perfil, id_usuario) VALUE (2, 'testestestesteste2');

-- Inserção de dados na tabela 'usuario_perfil'
INSERT INTO usuario_perfil(perfil, id_usuario) VALUE (2, 'sdas-asdasdsas-aasd23234');
INSERT INTO usuario_perfil(perfil, id_usuario) VALUE (1, 'sdas-asdasdsas-aasd23234');
INSERT INTO usuario_perfil(perfil, id_usuario) VALUE (1, 'sdgg3434-aasd23234');
INSERT INTO usuario_perfil(perfil, id_usuario) VALUE (1, '213sdfdsas-aasd23234');
INSERT INTO usuario_perfil(perfil, id_usuario) VALUE (1, 'sdd32hsd23234');
INSERT INTO usuario_perfil(perfil, id_usuario) VALUE (2, 'sdd32hsd23234');
INSERT INTO usuario_perfil(perfil, id_usuario) VALUE (1, '234342sdsas-afdsfsd23234');
INSERT INTO usuario_perfil(perfil, id_usuario) VALUE (1, 'kdsafst4322sd23234');

-- Inserção de dados na tabela 'telefone'
INSERT INTO telefone(CodigoArea, numero, telefone_usuario) VALUES ('63', '984255465', 'sdas-asdasdsas-aasd23234');
INSERT INTO telefone(CodigoArea, numero, telefone_usuario) VALUES ('63', '984545458', 'sdgg3434-aasd23234');
INSERT INTO telefone(CodigoArea, numero, telefone_usuario) VALUES ('63', '985253658', '213sdfdsas-aasd23234');
INSERT INTO telefone(CodigoArea, numero, telefone_usuario) VALUES ('94', '992322585', 'sdd32hsd23234');
INSERT INTO telefone(CodigoArea, numero, telefone_usuario) VALUES ('63', '999568525', '234342sdsas-afdsfsd23234');

-- Inserção de dados na tabela 'endereco'
INSERT INTO endereco (endereco_cidade, bairro, numero, complemento, usuario_endereco) VALUES (1, 'quadra 403', '23', 'casa', 'sdas-asdasdsas-aasd23234');
INSERT INTO endereco (endereco_cidade, bairro, numero, complemento, usuario_endereco) VALUES (1, 'quadra 405', '30', 'casa', 'sdgg3434-aasd23234');
INSERT INTO endereco (endereco_cidade, bairro, numero, complemento, usuario_endereco) VALUES (1, 'quadra 403', '24', 'servico', 'sdgg3434-aasd23234');
INSERT INTO endereco (endereco_cidade, bairro, numero, complemento, usuario_endereco) VALUES (1, 'quadra 403', '244', 'casa', '234342sdsas-afdsfsd23234');

-- teste
INSERT INTO endereco (endereco_cidade, bairro, numero, complemento, usuario_endereco) VALUES (1, 'teste', 'tt', 'teste', 'sdas-asdasdsas-aasd23234');

-- Inserção de dados na tabela 'pagamento'
INSERT INTO pagamento (id, pago, valor, tipo) VALUES (1, true, 11000, 'boleto');
INSERT INTO pagamento (id, pago, valor, tipo) VALUES (2, true, 16500, 'pix');
INSERT INTO pagamento (id, pago, valor, tipo) VALUES (3, true, 3900, 'cartao');


-- Inserção de dados nas tabelas 'boletobancario', 'cartaocredito', 'pixpagamento' para **Teste**

INSERT INTO pagamento (id, pago, valor, tipo) VALUES (4, true, 3900, 'boleto');
INSERT INTO pagamento (id, pago, valor, tipo) VALUES (5, true, 0000, 'cartao');
INSERT INTO pagamento (id, pago, valor, tipo) VALUES (6, true, 0000, 'pix');
INSERT INTO boletobancario (banco, numeroBoleto, id) VALUES ('TESTE', 'PARA TESTES', 4);
INSERT INTO cartaocredito (bandeiraCartao, cvv, numeroCartao ,id) VALUES ('Test', 'ttt','test test test test', 5);
INSERT INTO pixpagamento (chave, id) VALUES ('tstestestestestestestestestestestestestes', 6);


-- Inserção de dados nas tabelas 'boletobancario', 'cartaocredito', 'pixpagamento'
INSERT INTO boletobancario (banco, numeroBoleto, id) VALUES ('', '23535556535df5d6sf5565d65f6sd5fd5sf', 1);
INSERT INTO cartaocredito (bandeiraCartao, cvv, numeroCartao ,id) VALUES ('VISA', '645','5546 5225 8886 2246', 3);
INSERT INTO pixpagamento (chave, id) VALUES ('asdsdassdasdsdsdawdadawasdhghkihossfdfs', 2);


-- Inserção de dados na tabela 'venda'
INSERT INTO venda (valorTotal, endereco_venda, venda_pagamento) VALUES (11000, 1, 1);
INSERT INTO venda (valorTotal, endereco_venda, venda_pagamento) VALUES (16500, 2, 2);
INSERT INTO venda (valorTotal, endereco_venda, venda_pagamento) VALUES (3900, 2, 3);

-- teste
INSERT INTO venda (valorTotal, endereco_venda) VALUES (3900, 2);

-- Inserção de dados na tabela 'itemvenda'
INSERT INTO itemvenda (quantidade, valorTotal, valorUnitario, produto_itemvenda, venda_itemvenda) VALUES (2, 11000, 5500, 2, 1);
INSERT INTO itemvenda (quantidade, valorTotal, valorUnitario, produto_itemvenda, venda_itemvenda) VALUES (3, 16500, 5500, 2, 2);
INSERT INTO itemvenda (quantidade, valorTotal, valorUnitario, produto_itemvenda, venda_itemvenda) VALUES (1,3900, 3900, 1, 3);

-- teste
INSERT INTO itemvenda (quantidade, valorTotal, valorUnitario, produto_itemvenda, id) VALUES (1,3900, 3900, 1, 4);
INSERT INTO itemvenda (quantidade, valorTotal, valorUnitario, produto_itemvenda, id) VALUES (1,3900, 3900, 1, 5);
