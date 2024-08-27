# Projeto conta digital - infnet
### Este projeto foi desenvolvido durante o primeiro módulo do curso de engenharia de software do instituto infnet, com a finalidade de por em prática alguns conhecimentos obtidos, como por exemplo:
- Herança, polimorfismo, abstração e encapsulamento
- Coleções: Uso de ArrayLists, Maps
- Repository pattern: Separação da aplicação em camadas de service, repository e controllers, promovendo o separation of concerns.
- Mapeamento de relacionamentos one to many, one to one... utilizando anotações
- Diferença entre os fetch modes eager e lazy, operações em cascata, orphan removals...
- Mapeamento das entidades e persistencia com Spring data
- Criação de uma camada front-end se comunicando com um @Controller através do Spring MVC
- Criação de endpoints usando o recurso RestController e seus devidos tipos de mapeamentos GetMapping, PostMapping...

## Diagrama de classes em UML da aplicação:

![image](https://github.com/user-attachments/assets/edb26269-eb24-4ebb-9f30-ffd07f69daf2)

## Instruções para testar o projeto:
#### 1. Clonar em sua máquina local:
     git clone https://github.com/gabpesouza/Infnet-JavaDigitalAccountApp.git
#### 2. Acessar diretório do projeto e compilar para baixar as dependências:
     mvn clean install
#### 3. Iniciar a aplicação
     mvn spring-boot:run

#### Pronto! Aplicação estará rodando em http://localhost:8080

## Documentação dos endpoints:
1. [Cartão de Crédito](#cartão-de-crédito)
2. [Cartão de Débito](#cartão-de-débito)
3. [Conta Digital](#conta-digital)
4. [Pix](#pix)

## Cartão de Crédito

### Listar Cartões de Crédito

- **Método:** GET
- **URL:** `http://localhost:8080/credit-card/list`

### Obter Cartão de Crédito por ID

- **Método:** GET
- **URL:** `http://localhost:8080/credit-card/{id}`
- **Exemplo:** `http://localhost:8080/credit-card/1`

### Criar Cartão de Crédito

- **Método:** POST
- **URL:** `http://localhost:8080/credit-card/create`
- **Body:**
    ```json
    {
        "number": "111111111111",
        "securityCode": "555",
        "expirationDate": "2030-05-01",
        "holderName": "generic holder 2",
        "limit": 30000.0,
        "interestRate": 2.5
    }
    ```

### Deletar Cartão de Crédito

- **Método:** DELETE
- **URL:** `http://localhost:8080/credit-card/{id}/delete`
- **Exemplo:** `http://localhost:8080/credit-card/1/delete`

## Cartão de Débito

### Listar Cartões de Débito

- **Método:** GET
- **URL:** `http://localhost:8080/debit-card/list`

### Obter Cartão de Débito por ID

- **Método:** GET
- **URL:** `http://localhost:8080/debit-card/{id}`
- **Exemplo:** `http://localhost:8080/debit-card/1`

### Criar Cartão de Débito

- **Método:** POST
- **URL:** `http://localhost:8080/debit-card/create`
- **Body:**
    ```json
    {
        "number": "5163791269201600",
        "securityCode": "543",
        "expirationDate": "2026-05-23",
        "holderName": "generic holder",
        "dailyWithdrawalLimit": 1000.0,
        "overdraftLimit": 1500.0
    }
    ```

### Deletar Cartão de Débito

- **Método:** DELETE
- **URL:** `http://localhost:8080/debit-card/{id}/delete`
- **Exemplo:** `http://localhost:8080/debit-card/1/delete`

## Conta Digital

### Listar Contas Digitais

- **Método:** GET
- **URL:** `http://localhost:8080/digital-account/list`

### Obter Conta Digital por ID

- **Método:** GET
- **URL:** `http://localhost:8080/digital-account/{id}`
- **Exemplo:** `http://localhost:8080/digital-account/1`

### Criar Conta Digital

- **Método:** POST
- **URL:** `http://localhost:8080/digital-account/create`
- **Body:**
    ```json
    {
        "provider": "meu banco teste",
    }
    ```

### Deletar Conta Digital

- **Método:** DELETE
- **URL:** `http://localhost:8080/digital-account/{id}/delete`
- **Exemplo:** `http://localhost:8080/digital-account/1/delete`

## Pix

### Listar Chaves Pix

- **Método:** GET
- **URL:** `http://localhost:8080/pix/list`

### Obter Chave Pix por ID

- **Método:** GET
- **URL:** `http://localhost:8080/pix/{id}`
- **Exemplo:** `http://localhost:8080/pix/1`

### Criar Chave Pix

- **Método:** POST
- **URL:** `http://localhost:8080/pix/create`
- **Body:**
    ```json
    {
        "key": "49578037813",
        "keyType": "CPF"
    }
    ```

### Deletar Chave Pix

- **Método:** DELETE
- **URL:** `http://localhost:8080/pix/{id}/delete`
- **Exemplo:** `http://localhost:8080/pix/3/delete`

### Obter Chaves Pix por Tipo de Chave

- **Método:** GET
- **URL:** `http://localhost:8080/pix/key-type/{tipo}`
- **Exemplo:** `http://localhost:8080/pix/key-type/cpf`

### Listar Chaves Pix Ordenadas por Valor Decrescente

- **Método:** GET
- **URL:** `http://localhost:8080/pix/amount/sorted`
