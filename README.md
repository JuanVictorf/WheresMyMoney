# 💸 Where’s My Money

## 📌 Visão Geral

**Where’s My Money** é uma aplicação backend focada no controle financeiro pessoal, permitindo que usuários registrem, consultem, atualizem e removam transações financeiras. O objetivo do projeto é servir como um **MVP funcional** e também como um **projeto de portfólio**, seguindo boas práticas de arquitetura, design de APIs REST e padrões amplamente utilizados no ecossistema Java/Spring.

O sistema foi pensado para evoluir futuramente com um frontend em **Vite + React**.

---

## 🎯 Objetivos do Projeto

* Registrar gastos financeiros por usuário
* Consultar histórico de transações
* Atualizar transações (total ou parcialmente)
* Remover transações
* Manter código limpo, organizado e escalável
* Aplicar boas práticas (DTOs, Mapper, Service Layer, Exception Handling)

---

## 🧱 Arquitetura Utilizada

O projeto segue uma **arquitetura em camadas**, inspirada em padrões amplamente recomendados por fontes como Baeldung e projetos reais de mercado.

```
Controller  ->  Service  ->  Repository  ->  Database
     |           |
     |           -> Regras de negócio
     -> DTO / ApiResponse / HTTP
```

### Camadas

* **Controller**: Responsável apenas por lidar com HTTP (request/response)
* **Service**: Contém regras de negócio e orquestra operações
* **Repository**: Acesso a dados via Spring Data JPA
* **Model (Entity)**: Representação das tabelas do banco
* **DTO**: Objetos de entrada e saída da API
* **Mapper**: Conversão entre DTOs e entidades
* **Exception Handler**: Tratamento centralizado de erros

---

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **Hibernate**
* **PostgreSQL** (via Docker)
* **Lombok**
* **Maven**

---

## 🗃️ Modelo de Domínio

### 👤 User

Representa o usuário do sistema.

Principais atributos:

* id
* nome
* email
* createDate (automático)
* updateDate (automático)

---

### 💳 Transaction

Representa uma transação financeira.

Principais atributos:

* id
* user (ManyToOne)
* amount
* description
* type
* category
* dateTransaction
* createDate (automático)
* updateDate (automático)

---

## 🔄 Ciclo de Vida das Entidades

As datas de criação e atualização são controladas automaticamente pela própria entidade:

* **@PrePersist** → define `createDate`
* **@PreUpdate** → define `updateDate`

Isso garante:

* Consistência
* Menos código no service
* Menos risco de erro

---

## 📦 DTOs

O projeto utiliza DTOs para evitar o acoplamento direto entre API e entidades JPA.

### Exemplos:

* `UserCreateDTO`
* `UserResponseDTO`
* `TransactionCreateDTO`
* `TransactionUpdateDTO`
* `TransactionResponseDTO`

Cada DTO possui uma responsabilidade clara:

* **CreateDTO** → Entrada de dados
* **UpdateDTO** → Atualização de dados
* **ResponseDTO** → Saída da API

---

## 🔁 Mappers

Os mappers são responsáveis por converter DTOs ↔ Entidades.

Benefícios:

* Código reutilizável
* Controller mais limpo
* Responsabilidades bem separadas

Exemplo de responsabilidades:

* `toEntity(CreateDTO)`
* `toResponseDTO(Entity)`
* `toResponseDTOList(List<Entity>)`

---

## 🌐 API Response (Padrão de Retorno)

Todas as respostas da API seguem um padrão único:

```json
{
  "message": "Mensagem descritiva",
  "data": {}
}
```

Isso facilita:

* Consumo no frontend
* Padronização de erros
* Evolução da API

Classe base:

* `ApiResponse<T>`

---

## ⚠️ Tratamento de Exceções

O projeto utiliza um **GlobalExceptionHandler** com `@ControllerAdvice`.

Responsabilidades:

* Capturar exceções de negócio
* Retornar mensagens claras
* Definir status HTTP corretos

Exemplos de erros tratados:

* Usuário não encontrado
* Transação não encontrada
* Email já existente

---

## 🔄 Atualizações (PUT vs PATCH)

### PUT (Atualização Completa)

* Recebe todos os campos obrigatórios
* Substitui o estado atual do recurso

### PATCH (Atualização Parcial)

* Atualiza apenas os campos enviados
* Campos nulos são ignorados

O projeto atualmente utiliza **PUT**, mas está preparado para evoluir para PATCH.

---

## 📡 Endpoints (Exemplos)

### Criar Usuário

```
POST /users
```

### Criar Transação

```
POST /transactions
```

### Buscar Transações por Usuário

```
GET /transactions?userId=1
```

### Atualizar Transação

```
PUT /transactions/{id}
```

### Deletar Transação

```
DELETE /transactions/{id}
```

---

## 🧪 Boas Práticas Aplicadas

* Controllers finos
* Services responsáveis por regras
* Entidades não expostas na API
* DTOs bem definidos
* Mapper explícito (sem reflexão)
* Exceções centralizadas
* Datas automáticas
* Código legível e sustentável

---

## 📄 Observação Final

Este projeto foi desenvolvido com foco em **qualidade de código**, **boas práticas** e **aprendizado contínuo**, sendo ideal tanto como MVP quanto como projeto de portfólio.

---

💡 *Where’s My Money — saiba exatamente para onde seu dinheiro está indo.*
