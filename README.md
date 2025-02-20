# API Meta Book

Esta API permite gerenciar uma coleção de livros e suas respectivas críticas.

## Funcionalidades:

* Criar um novo livro (POST /api/books).
* Obter todos os livros (GET /api/books).
* Obter um livro específico (GET /api/books/{id}).
* Atualizar um livro (PUT /api/books/{id}).
* Excluir um livro (DELETE /api/books/{id}).
* Criar uma nova revisão (POST /api/reviews).
* Obter todas as revisões (GET /api/reviews).
* Obter uma revisão específica (GET /api/reviews/{id}).
* Atualizar uma revisão (PUT /api/reviews/{id}).
* Excluir uma revisão (DELETE /api/reviews/{id}).

## Como Executar:

1. Pré-requisitos: Java 21, Maven.
2. Clonar o repositório: `git clone <url_do_seu_repositorio>`
2. Construir o projeto: `mvn clean install`
3. Executar a aplicação: `mvn spring-boot:run`
4. Testar a API: Use o Postman ou uma ferramenta similar para testar os endpoints.
5. Testes unitários e de integração: Os testes estão incluídos no projeto, execute usando `mvn test`

## Tecnologias:

* Java 21
* Maven
* Spring Boot
* Spring Data JPA
* Google Cloud Natural Language API
* MySQL
* JUnit 5
* Mockito
* AssertJ

## Exemplo de Requisições:

* Criar um Novo Livro >
    Endpoint: `POST /api/books`; 
    Body: 
    `{
    "title": "O Senhor dos Anéis",
    "author": "J.R.R. Tolkien",
    "genre": "Fantasia",
    "description": "Uma história épica de aventura e amizade."
    }`
* Obter Todos os Livros >
    Endpoint: `GET /api/books`;
* Criar uma Nova Revisão >
  Endpoint: `POST /api/reviews`;
  Body:
  `{
    "book": {
        "id": 1
    },
    "reviewerName": "IA",
    "reviewText": ""
}`

PS: A API está configurada para gerar críticas usando a Google Cloud Natural Language API, que analisa o sentimento e cria uma crítica baseada em prompts fornecidos.

## Autor:

Paula Burke