# Teste Técnico 🚀

Projeto desenvolvido como parte de um teste técnico, utilizando Java com Spring Boot para a construção da API e Angular para o frontend. O objetivo do projeto é realizar o cadastro de usuários e realizar consultas de dados de endereços através da API do ViaCEP, utilizando Spring Cloud para integrar o serviço externo.

## Tecnologias Utilizadas 🛠️

- **Backend**: Java com Spring Boot (Versão 11)
- **Frontend**: Angular
- **WebService**: ViaCEP (consultas de endereços) 🌐
- **Spring Cloud**: Para integração com WebService do ViaCEP ☁️
- **Node.js**: Versão 8.x (recomendado usar o NVM para gerenciar as versões do Node.js)

## Como Executar o Projeto 🚀

### Angular 🌱
`nvm install 8.9`

`npm i`

`npm run start`

### Spring Boot ⚙️

1. Certifique-se de que a versão do Java utilizada é a **Java 11**.


## Dificuldades encontradas ⚠️
Durante o desenvolvimento, enfrentei o seguinte erro:
`Table "CLIENTS" already exists; SQL statement` 🛑

O problema ocorreu ao tentar conectar o JPA com o arquivo data.sql, o que resultou em um conflito devido à tentativa de criar tabelas que já existiam no banco de dados.

Para contornar essa situação, optei por renomear as tabelas e criar uma nova entidade no banco de dados, a fim de garantir que o processo de persistência funcionasse corretamente(por hora).