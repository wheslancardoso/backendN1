# Projeto CRUD Full Stack - Java Spring Boot e Angular
Feito por: Wheslan Cardoso, João Lucas Alves, Heitor Silva Guedes
Este projeto implementa uma aplicação CRUD (Create, Read, Update, Delete) completa, utilizando Java Spring Boot para o backend e Angular para o frontend, com MySQL como banco de dados.

## Tecnologias Utilizadas

**Backend:**
*   Java 17
*   Spring Boot 3.2.5 (com Spring Data JPA, Spring Web)
*   Maven (para gerenciamento de dependências e build)
*   MySQL (banco de dados relacional)

**Frontend:**
*   Angular v17.3 (Core: ^17.3.0, CLI: ^17.3.17)
*   Node.js e npm (para o ambiente Angular e gerenciamento de pacotes do frontend)
*   HTML, CSS (Bootstrap para estilização básica), TypeScript

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em seu sistema:
*   **Java JDK 17 ou superior:** [OpenJDK](https://openjdk.java.net/) ou [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
*   **Maven:** [Apache Maven](https://maven.apache.org/download.cgi) (geralmente vem com o Spring Boot Initializr via `mvnw`, mas ter o Maven global pode ser útil)
*   **Node.js e npm:** [Node.js](https://nodejs.org/) (npm é instalado junto com o Node.js)
*   **Angular CLI:** Instalado globalmente após o Node.js. Para instalar a versão que usamos (ou a mais recente):
    ```bash
    npm install -g @angular/cli
    ```
*   **MySQL Server:** [MySQL Community Server](https://dev.mysql.com/downloads/mysql/)
*   Um cliente MySQL como [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) ou DBeaver para gerenciar o banco de dados.

## Configuração do Banco de Dados

1.  **Crie um banco de dados (schema) no MySQL.** Por exemplo, você pode nomeá-lo `crud_db`.
    ```sql
    CREATE DATABASE crud_db;
    ```
2.  **Configure as credenciais do banco de dados no backend.**
    Abra o arquivo `backend/src/main/resources/application.properties` e atualize as seguintes propriedades conforme sua configuração do MySQL:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/crud_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
    spring.datasource.username=SEU_USUARIO_MYSQL
    spring.datasource.password=SUA_SENHA_MYSQL
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```
    *   Substitua `crud_db` se você usou um nome diferente para o schema.
    *   Substitua `SEU_USUARIO_MYSQL` e `SUA_SENHA_MYSQL` pelas suas credenciais do MySQL.
    *   `spring.jpa.hibernate.ddl-auto=update` permite que o Hibernate crie/atualize as tabelas automaticamente com base nas suas entidades Java.

## Como Executar o Backend

1.  **Navegue até a pasta do backend:**
    ```bash
    cd backend
    ```
2.  **Execute a aplicação Spring Boot usando o Maven Wrapper:**
    *   No Linux/macOS:
        ```bash
        ./mvnw spring-boot:run
        ```
    *   No Windows (Prompt de Comando ou PowerShell):
        ```bash
        .\mvnw.cmd spring-boot:run
        ```
3.  O backend estará rodando na porta `8080` por padrão (ex: `http://localhost:8080`).

## Como Executar o Frontend

1.  **Navegue até a pasta do frontend:**
    ```bash
    cd frontend/crud-frontend
    ```
2.  **Instale as dependências do Node.js (se for a primeira vez ou se `node_modules` não existir):**
    ```bash
    npm install
    ```
3.  **Inicie o servidor de desenvolvimento do Angular:**
    ```bash
    ng serve
    ```
    (Você também pode usar `ng serve -o` para abrir automaticamente no seu navegador padrão).
4.  O frontend estará rodando na porta `4200` por padrão (ex: `http://localhost:4200`).

## Estrutura do Projeto

O projeto é dividido em duas pastas principais na raiz:
*   `backend/`: Contém o projeto Spring Boot (código Java, `pom.xml`, configurações).
*   `frontend/`: Contém o projeto Angular (`crud-frontend/` com os componentes, serviços, etc.).

## Endpoints da API (Backend)

A API do backend expõe os seguintes endpoints principais (baseados em `/api/items`):
*   `GET /api/items`: Retorna todos os itens.
*   `GET /api/items/{id}`: Retorna um item específico pelo seu ID.
*   `POST /api/items`: Cria um novo item.
*   `PUT /api/items/{id}`: Atualiza um item existente.
*   `DELETE /api/items/{id}`: Exclui um item.

---
Este `README.md` deve fornecer uma boa base para o seu grupo.
