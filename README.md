```markdown
# FórumHub

## 💻 Sobre o projeto
FórumHub é uma API REST desenvolvida em Spring Boot para um fórum de discussão, permitindo a criação, listagem, atualização e exclusão de tópicos.

## 🎆 Funcionalidades
- CRUD de tópicos
- Validação de tópicos duplicados (mesmo título e mensagem)
- Verificação de ID ao detalhar um tópico

## 💾 Tecnologias
As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:
- Java 17
- Spring Boot 3
- Spring Security
- JWT (JSON Web Token)
- Maven
- MySQL
- Hibernate
- Flyway
- Lombok

## 🔒 Autenticação
Para interagir com a API, é necessário autenticar-se. Implementamos um sistema de autenticação utilizando tokens JWT (JSON Web Token):
1. Acesse a rota `http://localhost:8080/login` para obter um token JWT válido.
2. O token JWT deve ser incluído no cabeçalho de autorização de todas as requisições subsequentes.
3. Utilize a biblioteca JWT.io para gerenciar tokens JWT na sua aplicação.

Funcionalidades Opcionais
Implementação de rotas adicionais para gerenciamento de usuários e respostas: /usuario, /respostas
Documentação interativa da API utilizando Swagger
Um fórum é um espaço onde todos os participantes de uma plataforma podem colocar suas perguntas sobre determinados assuntos.

Sabemos para que serve o fórum e como ele se apresenta, mas você já se perguntou como ele funciona internamente? Como as informações são armazenadas? Como os dados são manipulados para relacionar um tópico com suas respostas, ou como os usuários estão ligados às respostas de um tópico?

Esse é o nosso desafio com o FórumHub: replicar esse processo no nível do back end, criando uma API REST usando Spring.

Nossa API se concentrará especificamente nos tópicos, permitindo aos usuários:

Criar um novo tópico
Listar todos os tópicos criados
Visualizar um tópico específico
Atualizar um tópico
Deletar um tópico
Essas operações são conhecidas como CRUD (CREATE, READ, UPDATE, DELETE), e são muito semelhantes ao que foi desenvolvido no LiterAlura, mas agora de forma completa, incluindo as operações de UPDATE e DELETE, utilizando um framework que facilitará bastante nosso trabalho.

Em resumo, nosso objetivo com este desafio é implementar uma API REST com as seguintes funcionalidades:

API com rotas implementadas seguindo as melhores práticas do modelo REST
Validações realizadas conforme as regras de negócio
Implementação de uma base de dados relacional para persistência das informações
Serviço de autenticação/autorização para restringir o acesso às informações
```
