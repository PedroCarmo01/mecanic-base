# Sistema de Oficina Mecânica

<img width="1075" height="494" alt="image" src="https://github.com/user-attachments/assets/40dc5147-2b38-4156-bb11-f61b21b300cc" />

Sistema de gerenciamento para oficina mecânica, desenvolvido utilizando Java, Java Swing, MySQL e JDBC, com foco no aprendizado de desenvolvimento backend, modelagem relacional e futura análise de dados gerados pelo sistema.

---

# Sobre o Projeto

O projeto MecanicBase surgiu inicialmente com o foco na estrutura de um banco de dados relacional para uma oficina mecânica.

Conforme foi evoluindo o projeto, a ideia de ser apenas uma modelagem do banco passou a se tornar um sistema desktop funcional utilizando Java Swing integrado ao MySQL.

Além do desenvolvimento, o objetivo principal é futuramente utilizar os dados que serão gerados pelo sistema para estudos e análises.

O sistema está sendo desenvolvido de forma progressiva, iniciando pela estrutura do banco de dados e evoluindo para funcionalidades completas de gerenciamento.

Este projeto também está sendo utilizado principalmente para aprofundar meus conhecimentos.

---

# Tecnologias Utilizadas

- Java
- Java Swing
- JDBC
- MySQL
- SQL
- MySQL Workbench

---

# Funcionalidades Implementadas

## Clientes
- Cadastro de clientes
- Atualização dos registros
- Exclusão de clientes
- Listagem de clientes
- Validação de campos
- Verificação de duplicidade
- Atualização automática da tabela

## Veículos
- Cadastro de veículos
- Integração entre telas (seleção de cliente para vínculo com veículo)
- Validação de campos
- Atualização automática da tabela

## Banco de Dados
- Modelagem Relacional completa
- Relacionamentos entre entidades
- Estrutura normalizada
- Utilização de chaves primárias e estrangeiras

---

# Estrutura do Banco de Dados

O banco foi modelado utilizando relacionamentos entre entidades para representar um cenário real de oficina mecânica.

## Principais relacionamentos

- Um cliente pode possuir vários veículos
- Um veículo pode possuir várias ordens de serviço
- Uma ordem pode conter vários serviços
- Um serviço pode utilizar várias peças
- Uma ordem pode possuir vários funcionários responsáveis

## Principais entidades

- Clientes
- Veículos
- Funcionários
- Ordens de Serviço
- Serviços
- Peças

---

# Objetivos do Projeto

## Desenvolvimento Java
- Praticar lógica de programação
- Integração com o banco de dados
- Desenvolver CRUDs completos
- Aplicar MVC

## Banco de Dados
- Desenvolver modelagem relacional
- Treinar relacionamentos entre tabelas
- Criar consultas SQL
- Estruturar dados de forma organizada

## Análise de Dados
O principal objetivo do projeto futuramente é utilizar os dados para fazer estudos e análises.

Possíveis análises futuras:
- Clientes com maior número de ordens
- Serviços mais executados
- Funcionários com maior produtividade
- Peças mais utilizadas
- Faturamento mensal
- Ticket médio por atendimento

---

# Futuras Melhorias

## Backend
- Refatoração e melhoria de padrão MVC
- Criação de API REST com Spring Boot
- Sistema de autenticação
- Controle de usuários

## Análise de Dados
- Relatórios analíticos
- Consultas SQL analíticas
- Exportação para Excel
- Indicadores operacionais

## BI e Dashboards
- Integração com Power BI
- Análise de produtividade
- Dashboards financeiros
- Indicadores gerenciais

## Interface
- Melhorias visuais no Java Swing
- Menu principal
- Navegação entre telas
- Interface administrativa

## Front-end Web
Futuramente o projeto também pode evoluir para uma aplicação web.

---

# Como Executar

1. Clone o repositório
2. Abra o projeto na IDE Java
3. Configure a conexão com MySQL
4. Execute o banco de dados
5. Rode a aplicação Java

---

# Estrutura do Repositório

```text
📦 mecanic-base/
│
├── src/
│      ├── model/
│      ├── repository/
│      ├── view/
│      ├── util/
│    
├── database/
├── screenshots/
├── docs/
├── nbproject/
└── build/
```
---

# Autor

**Pedro Henrique Silva do Carmo**  
LinkedIn: https://www.linkedin.com/in/pedroo-carmo
<br>
GitHub: https://github.com/PedroCarmo01
