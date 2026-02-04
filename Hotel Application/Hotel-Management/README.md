# 🏨 Hotel Management Ecosystem - Microservices Journey

Este repositório centraliza o desenvolvimento de um ecossistema hoteleiro completo, focado na transição de uma arquitetura monolítica para **Microsserviços**. O projeto é dividido em três serviços independentes que se comunicam para gerenciar hotéis, avaliações e reservas.

---

## 🏗️ Arquitetura do Sistema

O ecossistema é composto por três módulos principais:

1.  **Hotel Management (Módulo Atual):** Gerenciamento de inventário, localização e disponibilidade.
2.  **Rating Service:** Sistema independente para gestão de avaliações e reputação.
3.  **Booking Service:** Processamento de reservas e integração de fluxos.



---

## 🚀 Tecnologias e Ferramentas
* **Back-end:** Java 21 & Spring Boot 3
* **Persistência:** Spring Data JPA & MySQL
* **Produtividade:** Lombok & Spring DevTools
* **Comunicação:** RestTemplate (Próxima fase: Feign Client)
* **Testes:** Postman para validação de endpoints REST

---

## 🏛️ Storytelling Técnico & Decisões de Projeto

Para garantir um código de nível profissional e pronto para escalabilidade, as seguintes decisões foram tomadas:

### 1. Padrão DTO (Data Transfer Objects)
Utilizei o desacoplamento total entre a Entidade JPA e a Camada de Apresentação.
* **Request DTO:** Garante que apenas os campos permitidos sejam enviados pelo cliente, protegendo o sistema contra *Mass Assignment* (envio de campos indesejados).
* **Response DTO:** Controla exatamente o que é retornado, evitando o vazamento de dados sensíveis do banco.

### 2. Fluxo de Trabalho (Layered Architecture)
O projeto segue uma hierarquia rigorosa:
* **Controller:** Porta de entrada, responsável apenas por receber requisições e validar DTOs.
* **Service:** Onde reside toda a inteligência. Faz o mapeamento entre DTOs e Entidades e executa as regras de negócio.
* **Repository:** Interface limpa para comunicação com o MySQL via JPA.

### 3. Tratamento de Exceções
Implementação de um **Global Exception Handler** para padronizar as respostas de erro da API, garantindo que o cliente receba mensagens claras e códigos HTTP semânticos (400, 404, 500, etc).

---

## 🗺️ Roadmap de Desenvolvimento

- [x] **Fase 1: Hotel Management**
    - [x] Configuração de Banco de Dados e JPA.
    - [x] Implementação de DTOs e validações.
    - [x] CRUD completo e tratamento de exceções.
- [ ] **Fase 2: Rating Service**
    - [ ] Criação do segundo microsserviço independente.
    - [ ] Sincronização de dados de reputação.
- [ ] **Fase 3: Booking Service**
    - [ ] Lógica de reservas e estados de disponibilidade.
- [ ] **Fase 4: Integração de Ecossistema**
    - [ ] Comunicação inter-serviços via `RestTemplate`.
    - [ ] Implementação de Service Discovery e API Gateway.

---

## 🚦 Como Executar

1. **Clone o repositório:** `git clone https://github.com/seu-usuario/hotel-ecosystem.git`
2. **Banco de Dados:** Crie o schema `hotel_management` no MySQL.
3. **Configuração:** Ajuste as credenciais no `application.yml`.
4. **Executar:** `mvn spring-boot:run`

---

### 👨‍💻 Autor
**Adelito Teca** - [LinkedIn](https://www.linkedin.com/in/adelito-teca/)
