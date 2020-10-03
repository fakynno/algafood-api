insert into estado (nome) values ('São Paulo');
insert into estado (nome) values ('Rio de Janeiro');
insert into estado (nome) values ('Paraná');
insert into estado (nome) values ('Rio Grande do Sul');
insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');
insert into cozinha (nome) values ('Brasileira');
insert into cozinha (nome) values ('Americana');
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Take Thai Cozinha', 6, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Indian food', 2, 2);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Restaurante meu bom Baiano', 7, 2);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Rekanto da Feijuca', 3, 3);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('BOJF - Best of Junk Food', 6, 2);
insert into forma_pagamento (nome) values ('dinheiro');
insert into forma_pagamento (nome) values ('cheque');
insert into forma_pagamento (nome) values ('cartao de debito');
insert into forma_pagamento (nome) values ('cartao de credito');
insert into forma_pagamento (nome) values ('QR Code pic pay');
insert into permissao (nome, descricao) values ('gravar', 'permite gravar os dados no banco');
insert into permissao (nome, descricao) values ('consultar', 'permite consultar os dados no banco');
insert into cidade (nome, estado_id) values ('Curitiba', 3);
insert into cidade (nome, estado_id) values ('Limeira', 1);
insert into cidade (nome, estado_id) values ('Assis', 1);
insert into cidade (nome, estado_id) values ('Macaé', 2);