
-- POSTGRESQL
-- Adicionando coluna
ALTER TABLE nome_da_tabela ADD COLUMN nova_coluna tipo_da_coluna;

-- Removendo coluna
ALTER TABLE nome_da_tabela DROP COLUMN coluna_a_remover;

-- Removendo todos os dados e restricoes da coluna
ALTER TABLE nome_da_tabela DROP COLUMN coluna_a_remover CASCADE;

-- Alterando valor da sequencia atribuindo a uma PK
ALTER TABLE NOME_DA_TABELA ALTER COLUMN CODIGO_PK SET DEFAULT NEXTVAL('CODIGO_PK_SEQ'::REGCLASS);


-- Adcionando restricoes
ALTER TABLE nome_da_tabela ADD restricao;

ALTER TABLE nome_da_tabela ADD CHECK(coluna > 0);
ALTER TABLE nome_da_tabela ADD UNIQUE(coluna);
ALTER TABLE nome_da_tabela ADD PRIMARY KEY(nome_da_coluna);
ALTER TABLE nome_da_tabela ADD FOREIGN KEY(nome_da_coluna) REFERENCES tabela_referenciada;

-- Para o caso da restricao de nao-nulo
ALTER TABLE nome_da_tabela ALTER COLUMN nome_da_coluna SET NOT NULL;

-- Removendo restricoes
ALTER TABLE nome_da_tabela DROP CONSTRAINT nome_da_restricao;

-- Da mesma forma que adicionar uma restricao nao-nulo
ALTER TABLE nome_da_tabela ATER COLUMN nome_da_coluna DROP NOT NULL;

-- Alterar o valor padrao
ALTER TABLE nome_da_tabela ALTER COLUMN nome_da_coluna SET DEFAULT valor_padrao;


-- Alterando o tipo de dado de uma coluna
ALTER TABLE nome_da_tabela ALTER COLUMN nome_da_coluna TYPE novo_tipo;

-- Renomear uma coluna
ALTER TABLE nome_da_tabela RENAME COLUMN nome_da_coluna TO novo_nome;

-- Renomear uma tabela
ALTER TABLE nome_da_tabela RENAME TO novo_nome;

-- Removendo tabelas
DROP TABLE nome_da_tabela;

-- Removendo tabelas caso existam objetos que referenciem esta tabela
DROP TABLE nome_da_tabela CASCADE;




-- MYSQL
-- Renomeado coluna
alter table nome_da_tabela minha_tabela rename minha_tabela_novo_nome;

-- Removendo coluna
alter table nome_da_tabela drop nome_da_coluna

-- Inserindo uma nova coluna
alter table nome_da_tabela add nome_da_coluna text not null

-- Inserindo depois de uma coluna
alter table nome_da_tabela add nome_da_coluna text not null after nome_da_coluna

-- Inserir no inicio da tabela
alter table nome_da_tabela add nome_da_coluna text not null first