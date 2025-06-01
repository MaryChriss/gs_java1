# futureStack - ClimaESP

Sistema inteligente de monitoramento climático com base em dados coletados por dispositivos IoT e pesquisas por cidade. Inclui histórico de buscas e favoritos por usuário, com persistência em banco de dados e autenticação via JWT.

## 📋 Descrição da Solução

O ClimaESP permite o monitoramento e consulta de dados climáticos como **temperatura, umidade, chuva, vento** e **descrição do clima**, com base nas cidades pesquisadas pelos usuários.

Cada pesquisa por cidade é registrada em um histórico de buscas e pode ser favoritada para consultas futuras. Os dados são coletados por dispositivos **IoT** e armazenados no banco de dados.

A solução também implementa filtros com Spring Data ExampleMatcher, validação com Bean Validation, autenticação com JWT e documentação Swagger.

## Essa API permite:

- Consulta de dados climáticos por cidade
- Registro de histórico de pesquisas por usuário
- Marcar cidades como favoritas
- Cadastro e login de usuários com autenticação JWT
- Paginação, ordenação e filtros
- Validação de dados com Bean Validation

## Principais Endpoints (CRUD):

- 🌆 Dados Climáticos

Listar todos os dados
GET /dados

```
http://localhost:8080/dados
```

Listar por cidade + salvar no histórico (autenticado)
GET /dados?cidade=Campinas&idUsuario=1&page=0&size=10

```
http://localhost:8080/dados?cidade=Campinas&idUsuario=8&page=0&size=10
```

- 💾 Histórico de Pesquisas

Listar histórico do usuário
GET /historico/{idUsuario}

```
http://localhost:8080/historico/8
```

- ⭐ Favoritos

Favoritar cidade
POST /favoritos
Body (JSON):

```
{
  "idUsuario": 8,
  "cidade": "São Paulo",
  "latApi": -23.5505,
  "lonApi": -46.6333
}
```

Listar favoritos de um usuário
GET /favoritos/{idUsuario}

```
http://localhost:8080/favoritos/8
```

Remover favorito
DELETE /favoritos/{idFavorito}

```
http://localhost:8080/favoritos/8
```

- 👤 Usuário

Criar novo usuário
POST /users

```
{
  "nomeUser": "LauraSilva",
  "email": "laura@email.com",
  "password": "129056"
}
```

Login com JWT
POST /login

```
{
  "email": "maria@email.com",
  "password": "123456"
}
```

## 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot 
- Spring Web
- Spring Data JPA
- Spring Security + JWT
- Spring Validation (Bean Validation)
- Banco H2
- Lombok
- Swagger
- Oracle

## 🛠️ Como Rodar o Projeto Localmente

1. **Clone o repositório:**

```bash
DB_URL=jdbc:oracle:thin:@oracle.fiap.com.br:****:****
DB_USERNAME=RM******
DB_PASSWORD=******
```

2. **rode a aplicação**
Crie um arquivo .env com suas variáveis de ambiente

```bash
https://github.com/MaryChriss/gs_java1.git
cd gs_java1
```

4. **rode a aplicação**

## 🧠 Links
- Swagger
```
http://localhost:8080/swagger-ui/index.html#/
```

- Repositorio Front-End:
```
https://github.com/MaryChriss/gs-mobile1
```

- Integração com o front-end
  
## 👥 Integrantes

- Mariana Christina RM: 554773
- Gabriela Moguinho RM: 556143
- Henrique Maciel RM: 556480
