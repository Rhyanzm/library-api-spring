# 📚 Library API - Gestão de Biblioteca com Segurança JWT

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Swagger](https://img.shields.io/badge/-Swagger-%23C1272D?style=for-the-badge&logo=swagger&logoColor=white)

## 💻 Sobre o Projeto
A **Library API** é uma solução robusta de back-end (RESTful) para gestão literária. O diferencial desta versão é a implementação de um sistema de **Autenticação e Autorização via JWT (JSON Web Token)**, garantindo que apenas usuários autenticados possam realizar alterações no acervo.

O projeto utiliza **Arquitetura em Camadas** e segue os princípios de Clean Code, com tratamento global de exceções e validações de DTOs.

## 🚀 Funcionalidades Principais
- **🔐 Segurança Avançada:** Sistema de Login e Registro com senhas criptografadas (BCrypt).
- **📖 Gestão de Livros:** CRUD completo (Create, Read, Update, Delete).
- **🛡️ Controle de Acesso:** Endpoints de leitura públicos e endpoints de escrita protegidos.
- **📑 Documentação Interativa:** Swagger UI configurado para testes em tempo real.

## 🛠️ Tecnologias Utilizadas
- **Java 17 & Spring Boot 3.4.3**
- **Spring Security & Auth0 Java JWT** (Segurança)
- **Spring Data JPA** (Persistência)
- **H2 Database / PostgreSQL** (Flexibilidade de Banco de Dados)
- **Springdoc OpenAPI 2.8.5** (Documentação)
- **Bean Validation** (Integridade de Dados)

## 📸 Demonstração e Documentação

### 1. Autenticação (JWT)
Para utilizar os recursos de escrita, é necessário registrar um usuário e obter o Token Bearer.
![Login e Registro](assets/auth-endpoints.png)

### 2. Autorização no Swagger
Insira o token gerado no botão **Authorize** para desbloquear os recursos protegidos.
![Swagger Authorization](assets/swagger-auth.png)

### 3. Gerenciamento de Livros
Interface intuitiva para visualização e manipulação do catálogo.
![Book CRUD](assets/books-endpoints.png)

## ⚙️ Como Executar

1. Clone o repositório:
   ```bash
   git clone [https://github.com/Rhyanzm/library-api-spring.git](https://github.com/Rhyanzm/library-api-spring.git)