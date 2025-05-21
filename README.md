## Cadastro de Pessoas - STI-UFF
Este projeto é um sistema de cadastro de pessoas desenvolvido como parte do treinamento de estágio na STI-UFF. O sistema permite criar, listar, editar e deletar registros de pessoas, com validações específicas para cada campo.
Esse repositório é a continuação do  [Exercicio STI: Página de cadastro](https://github.com/RafaelaAbrahao/exercicio-cadastro?tab=readme-ov-file#exercicio-sti-página-de-cadastro).

## Tecnologias

- **Backend**:
    - Spring Boot (Web, Data JDBC, Thymeleaf)
    - MySQL (via Docker)
    - Lombok
    - DevTools

- **Frontend**:
    - Thymeleaf
    - Bootstrap 5
    - JavaScript

## Funcionalidades

- CRUD:
    - Cadastro de novas pessoas
    - Listagem de todas as pessoas cadastradas
    - Edição de registros existentes
    - Exclusão de registros

- Validações:
    - Campos obrigatórios
    - Idade entre 17 e 100 anos
    - Nome com máximo de 250 caracteres
    - Data de início do curso deve ser posterior ao ano de nascimento (calculado a partir da idade)

## Fluxo de Navegação

1. **Listagem**: `/cadastro` - Lista todas as pessoas cadastradas
2. **Novo Cadastro**: `/cadastro/new` - Formulário para cadastrar nova pessoa
3. **Edição**: `/cadastro/{id}` - Formulário para editar/excluir pessoa existente


