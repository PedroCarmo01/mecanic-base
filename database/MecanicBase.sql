-- CRIANDO O BANCO DE DADOS
create database mecanic_base;
use mecanic_base;

-- =========================
-- CRIAÇÃO DAS TABELAS
-- =========================

-- Um cliente pode ter vários veículos
create table cliente(
	id int auto_increment primary key,
    cpf varchar(11) unique not null,
	nome varchar(300) not null,
    telefone varchar(11),
    email varchar(300),
    ativo boolean default true
);

-- Um ou vários veículos possuem apenas um cliente
create table veiculo(
	placa varchar(7) not null,
    id_cliente int,
    marca varchar(100) not null,
    modelo varchar(100) not null,
    ano year not null,
    cor varchar(50),
    tipo varchar(50),
    combustivel varchar(100),
    constraint pk_veiculo primary key (placa),
    constraint fk_id_cliente foreign key (id_cliente) references cliente(id)
);

-- Um perfil pode ser de vários funcionários
create table perfil(
	id_perfil int auto_increment primary key,
    nome varchar(100) not null,
    permissoes text
);

-- Um ou vários funcionários possuem 1 perfil
-- Um ou vários funcionários podem realizar N ordens de serviço
create table funcionario(
	id_funcionario int auto_increment primary key,
    perfil_id int,
    nome varchar(300) not null,
    cpf decimal(11) unique not null,
    telefone decimal(11) not null,
    email varchar(300) not null,
    senha varchar(500) not null,
    ativo boolean default true,
    constraint fk_perfil foreign key (perfil_id) references perfil(id_perfil)
);

-- Um status pertence a uma ou várias ordens de serviço
create table status(
	id_status int auto_increment primary key,
    status varchar(70) not null,
    descricao text
);

-- Uma ou várias ordens de serviço podem ser realizadas por N funcionários
-- Uma ou várias ordens de serviço podem realizar vários serviços
-- Uma ou várias ordens de serviço são de apenas um veículo
-- Uma ou várias ordens de serviço são de apenas um cliente
-- Uma ou várias ordens de serviço possuem apenas um status
create table ordem_de_servico (
	id_os int auto_increment primary key,
    cliente_id int,
    placa_veiculo varchar(7),
    data_abertura date,
    data_fechamento date,
    diagnostico text,
    status_os int,
    constraint fk_cliente foreign key (cliente_id) references cliente(id),
    constraint fk_placa_vei foreign key (placa_veiculo) references veiculo(placa),
    constraint fk_status foreign key (status_os) references status(id_status)
);

-- Um ou vários serviços podem ser feitos em uma ou várias ordens de serviço
-- Um ou vários serviços podem utilizar várias peças
create table servico(
	id_servico int auto_increment primary key,
    nome_servico varchar(200) not null,
    descricao text not null,
    valor_medio decimal(10,2) not null,
    tempo_medio time not null,
    data_de_registro date not null
);

-- Várias peças podem ser usada em vários serviços
create table peca(
	id_peca int auto_increment primary key,
    nome varchar(300),
    valor decimal(10,2),
    quantidade_estoque int default 0
);

-- Relacionamento N:N: ordem_servico - servico
create table servico_realizado(
	ordemS int,
    serv_id int,
    nome_servico varchar(100),
    descricao text not null,
    valor_mao_obra decimal(10,2),
    tempo_execucao time,
    date_registro date,
    constraint pk_servico_realizado primary key (ordemS, serv_id),
    constraint fk_ordemS foreign key (ordemS) references ordem_de_servico(id_os),
    constraint fk_servico_r foreign key (serv_id) references servico(id_servico)
);

-- Relacionamento N:N: servico - peca
create table servico_peca(
	id_do_serv int,
    id_peca_usada int,
    quantidade_usada int default 1,
    constraint pk_servico_peca primary key (id_do_serv, id_peca_usada),
    constraint fk_id_do_serv foreign key (id_do_serv) references servico(id_servico),
    constraint fk_peca_uso foreign key (id_peca_usada) references peca(id_peca)
);

-- Relacionamento N:N: ordem_servico - funcionario
create table ordem_funcionario (
	id_ordem_os int,
    id_func int,
    funcao_na_os varchar(200),
    horas_trabalhadas time,
    constraint pk_ordem_funcionario primary key (id_ordem_os, id_func),
    constraint fk_ordem_id_os foreign key (id_ordem_os) references ordem_de_servico(id_os),
    constraint fk_funcionario_fez foreign key (id_func) references funcionario(id_funcionario)
);
