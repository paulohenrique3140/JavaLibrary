# JavaLibrary - Sistema de Gerenciamento de Biblioteca

<p align="center">
  <img width="460" height="300" src="/JavaLibrary_Logo.PNG">
</p>
   

Este projeto Java implementa um sistema simples de gerenciamento de biblioteca que permite aos usuários interagir com a coleção de livros da biblioteca e o registro de usuários. O sistema é projetado para ser executado por meio do console e fornece funcionalidades como adicionar livros à biblioteca, exibir a coleção, procurar livros, registrar usuários e gerenciar o status do usuário.

## Estrutura do Projeto
O projeto está organizado nos seguintes pacotes:

`1. application`

Program.java: A classe principal que contém a interface do usuário baseada em console. Permite aos usuários interagir com o sistema de biblioteca e gerenciamento de usuários.

`2. model.entities`

Book.java: Representa um livro com atributos como ISBN, título, autor, ano de lançamento, gênero e estado. Inclui métodos para obter e definir informações do livro.

User.java: Representa um usuário da biblioteca com atributos como ID do usuário, nome, email, número de telefone, status e uma lista de livros emprestados. Inclui métodos para gerenciar os livros do usuário.

Library.java: Gerencia a coleção de livros da biblioteca, incluindo adicionar livros, exibir a coleção, procurar livros, emprestar livros e lidar com a devolução de livros.

UserManagement.java: Gerencia o registro de usuários, incluindo adicionar usuários, exibir usuários, procurar usuários e atualizar o status do usuário.

`3. model.enums`

BookGenre.java: Enumera vários gêneros de livros.

BookState.java: Enumera os possíveis estados de um livro (Bom, Ruim, Inválido).

UserStatus.java: Enumera os possíveis status de um usuário (Ativo, Inativo, Vip).

`4. model.exceptions`

LibraryException.java: Classe de exceção personalizada para lidar com exceções relacionadas à biblioteca.

UserManagementException.java: Classe de exceção personalizada para lidar com exceções relacionadas ao gerenciamento de usuários.

`5. service`

LibraryService.java: Fornece métodos utilitários para a biblioteca, incluindo operações relacionadas a livros, como verificar a existência de livros e encontrar livros pelo nome ou autor.

UserManagementService.java: Fornece métodos utilitários para o gerenciamento de usuários, incluindo verificar a existência de usuários e encontrar usuários por email.

# Como Executar
1. Clone o repositório para sua máquina local.
2. Abra o projeto em seu IDE Java preferido.
3. Execute o arquivo Program.java.

# Funcionalidades

`Gerenciamento da Biblioteca`
- Adicionar livros à coleção da biblioteca;
- Exibir livros disponíveis, indisponíveis ou todos na coleção;
- Procurar livros por título, autor ou ISBN;
- Emprestar livros para usuários;
- Devolver livros e atualizar seu estado.

`Gerenciamento de Usuários`
- Registrar usuários com um ID único, nome, email, número de telefone e status;
- Exibir usuários ativos, inativos, VIP ou todos;
- Procurar usuários por email;
- Atualizar informações do usuário, incluindo email, número de telefone e status.

# Contribuições

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, sinta-se à vontade para abrir um problema ou criar uma solicitação de pull.
