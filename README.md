# Sistema de Oficina Mecânica

<img width="1075" height="494" alt="image" src="https://github.com/user-attachments/assets/40dc5147-2b38-4156-bb11-f61b21b300cc" />

Sistema de gerenciamento para oficina mecânica, desenvolvido utilizando Java Swing, MySQL e JDBC, com foco em CRUD completo, modelagem relacional, e futura expansão para backend, análise de dados e dashboards.

---

# Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de praticar desenvolvimento de sistemas desktop utilizando Java, integração com banco de dados MySQL e modelagem relacional aplicada a um cenário real de uma oficina mecânica.

O sistema está sendo desenvolvido de forma progressiva, iniciando pela estrutura do banco de dados e evoluindo para funcionalidades completas de gerenciamento.

Atualmente o sistema já possui funcionalidades reais de CRUD para clientes utilizando Java Swing integrado ao MySQL.

O sistema possui entidades relacionadas a:

- Clientes
- Veículos
- Funcionários
- Ordens de Serviço
- Serviços
- Peças

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

- Cadastro de clientes
- Listagem dinâmica
- Atualização de clientes
- Integração com banco MySQL
- Validação de campos para cadastro
- Verificação de duplicidade
- Atualização automática da tabela

---

# Funcionalidades Planejadas

## Veículos
- Cadastro de veículos
- Relacionamento entre cliente e veículo
- Validação de placa

## Ordem de Serviço
- Abertura de ordens de serviço
- Controle de status
- Histórico de manutenção
- Serviços realizados

## Peças e Estoque
- Cadastro de peças
- Controle de estoque
- Relacionamento entre serviços e peças

---

# Estrutura do Banco de Dados

O banco foi modelado utilizando relacionamentos relacionais para representar um cenário real de oficina mecânica.

## Principais relacionamentos

- Um cliente pode possuir vários veículos
- Um veículo pode possuir várias ordens de serviço
- Uma ordem pode conter vários serviços
- Um serviço pode utilizar várias peças
- Uma ordem pode possuir vários funcionários responsáveis

---

# Objetivos do Projeto

- Praticar modelagem relacional
- Desenvolver lógica backend com Java
- Trabalhar integração com banco de dados
- Simular regras de negócio reais
- Evoluir futuramente para um sistema completo

---

# Futuras Melhorias

## Backend
- Implementação de padrão MVC
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

---

# Possíveis Análises Futuras

- Clientes com maior número de ordens
- Serviços mais executados
- Funcionários com maior produtividade
- Peças mais utilizadas
- Faturamento mensal
- Ticket médio por atendimento

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
├── build/
├── DER.png
├── screenshots/
├── docs/
├── nbproject/
└── database/
```
---

# Autor

**Pedro Henrique Silva do Carmo**  
LinkedIn: https://www.linkedin.com/in/pedroo-carmo
<br>
GitHub: https://https://github.com/PedroCarmo01
