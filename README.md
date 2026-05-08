# Sistema de Oficina Mecânica

<img width="1075" height="494" alt="image" src="https://github.com/user-attachments/assets/40dc5147-2b38-4156-bb11-f61b21b300cc" />

Sistema de modelagem de banco de dados para gerenciamento de oficina mecânica, desenvolvido com foco em organização relacional, controle de ordens de serviço e futura expansão para backend, análise de dados e dashboards.

---

# Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de praticar modelagem de banco de dados relacional utilizando SQL, simulando o funcionamento de uma oficina mecânica.

O sistema possui entidades relacionadas a:

- Clientes
- Veículos
- Funcionários
- Ordens de Serviço
- Serviços
- Peças

Além disso, o projeto foi estruturado pensando em futuras expansões para aplicações backend em Java, dashboards analíticos e integração com ferramentas de análise de dados.

---

# Tecnologias Utilizadas

- MySQL
- SQL
- MySQL Workbench

---

# Funcionalidades Modeladas

- Cadastro de clientes
- Cadastro de veículos
- Controle de funcionários
- Controle de peças
- Cadastro de serviços
- Gerenciamento de ordens de serviço
- Relacionamento entre serviços e peças
- Relacionamento entre ordens e funcionários

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
- Desenvolver lógica de banco de dados
- Simular regras de negócio reais
- Evoluir futuramente para um sistema completo

---

# Futuras Melhorias

## Backend
- Integração com Java utilizando JDBC
- Desenvolvimento de CRUD completo
- Implementação de padrão MVC
- Criação de API backend

## Análise de Dados
- Consultas analíticas em SQL
- Relatórios de faturamento
- Análise de serviços mais realizados
- Indicadores operacionais

## BI e Dashboards
- Integração com Power BI
- Exportação de dados para Excel
- Dashboards gerenciais
- Indicadores financeiros

## Frontend
- Interface web para gerenciamento
- Painel administrativo
- Sistema completo de oficina mecânica

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

1. Abra o MySQL Workbench
2. Execute o arquivo `MecanicBase.sql`
3. O banco de dados será criado automaticamente

---

# Estrutura do Repositório

```text
📦 mecanic-base/
│
├── MecanicBase.sql
├── README.md
├── DER.png
└── screenshots/
```
---

# Autor

**Pedro Henrique Silva do Carmo**  
LinkedIn: https://www.linkedin.com/in/pedroo-carmo
<br>
GitHub: https://https://github.com/PedroCarmo01
