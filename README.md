# 📚 Library API - Gestão de Biblioteca

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/postgresql-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

## 💻 Sobre o Projeto
A **Library API** é um sistema de back-end desenvolvido (RESTful API) para o gerenciamento de livros de uma biblioteca. O projeto permite a criação, leitura, atualização e exclusão (CRUD) de registros literários, garantindo a persistência de dados de forma segura e eficiente.

Este projeto foi desenvolvido com foco em boas práticas de engenharia de software, utilizando arquitetura em camadas (Controller, Service, Repository) e validação de dados.

## 🚀 Funcionalidades
- **Cadastrar Livro:** Adiciona um novo livro ao catálogo com validação de campos.
- **Listar Livros:** Retorna todos os livros cadastrados.
- **Buscar por ID:** Retorna os detalhes de um livro específico.
- **Atualizar Livro:** Modifica as informações de um livro existente.
- **Deletar Livro:** Remove um livro do banco de dados.

## 🛠️ Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3** (Web, Data JPA, Validation)
- **PostgreSQL** (Banco de Dados Relacional)
- **Docker & Docker Compose** (Containerização do Banco de Dados)
- **Springdoc OpenAPI / Swagger** (Documentação da API)
- **Maven** (Gerenciamento de Dependências)

## 📸 Demonstração da API

*Abaixo estão as interfaces da nossa documentação via Swagger:*

**1. Interface Geral do Swagger**
![Swagger Interface](assets/swagger-home.png)

**2. Criação de um Livro (POST - 201 Created)**
![POST Request](assets/swagger-post.png)

**3. Listagem de Livros (GET - 200 OK)**
![GET Request](assets/swagger-get.png)

## ⚙️ Como Executar o Projeto Localmente

### Pré-requisitos
- Java 17+
- Maven
- Docker

### Passos
1. Clone este repositório:
   ```bash
   git clone [https://github.com/SEU_USUARIO/library-api-spring.git](https://github.com/SEU_USUARIO/library-api-spring.git)
