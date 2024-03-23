<a name="readme-top"></a>

# Introdução

O Usuario Service é responsável por gerenciar os usuários do sistema, oferecendo funcionalidades essenciais para a autenticação e controle de acesso. Ele permite a criação de usuários com login, senha e perfil (role).

No sistema, existem dois tipos de perfil (roles): **User**, destinada aos usuários comuns, e **Admin**, reservada para usuários com privilégios administrativos. Os usuários com a função de 'Admin' possuem permissões adicionais, como cadastrar produtos e gerenciar o estoque.

Além disso, o Usuario Service oferece a funcionalidade de autenticação para os usuários cadastrados. Para garantir a segurança da autenticação, o sistema utiliza o JWT (JSON Web Token) em conjunto com o Spring Security.


## Sumário
* [Instruções](#instrucoes)
* [Funcionalidades de Usuario Service](#funcionalidades-de-usuario-service)


## Instruções

- Maven: Para build do projeto. **Para buildar:** mvn clean install
- Foi utilizado Lombok, Validation e MySql, portanto é necessário adicionar os plugins na IDE

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

### Funcionalidades de Usuario Service

>[ Base URL: http://localhost:porta ] 

`Substitua <porta> pela porta atribuída dinamicamente pelo ambiente.`

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``  
`*Para criar Usuario`

```
	/usuarios
```
<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:9999/usuarios' \
--header 'Content-Type: application/json' \
--data '{
    "login": "user3",
    "password": "abc",
    "role": "USER"
}'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Será retornado o id de usuario.`

```
4
```

</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

### ``POST``
`*Para autenticar usuario`

```
	/usuarios/login
```

<details>
  <summary>Exemplo Request:</summary>

```
curl --location 'http://localhost:35405/usuarios/login' \
--header 'idUsuario: 4' \
--header 'Content-Type: application/json' \
--data '{
    "login": "user3",
    "password": "abc"
}'
```
</details>

<details>
  <summary>Exemplo Responses:</summary>

200 - _OK_
`- Será retornado o token JWT`

```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyUm9sZSI6IlVTRVIiLCJ1c2VySWQiOjR9.oEsjAYmS3bo0YzS9q34rKR2UJ__WB7tA8qN8mPKM1Lc"
}
```

401 - _Unauthorized_

```
{
    "code": "usuario.credenciaisInvalida",
    "message": "Usuário ou senha inválido"
}
```
</details>

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>

---------

<a name="tecnologias"></a>
## 📍️ Tecnologias

- Padrão REST na construção das rotas e retornos
- SLF4J para registro de logs
- Utilização de código limpo e princípios **SOLID**
- Boas práticas da Linguagem/Framework
- Clean architecture
- Banco de Dados MySql
- Token JWT
- Spring Security

<p align="right">(<a href="#readme-top">Ir ao topo</a>)</p>



