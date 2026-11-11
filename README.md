#Proffy Mobile – Recuperação de Senha

Aluna: Milena Gomes Andrade  
Curso: Sistemas de Informação  
Turma: 6º período  
Instituição: UEMG – Unidade Ituiutaba  
Ano: 2026

## Sobre o projeto

Este projeto consiste na implementação de uma tela de recuperação de senha para o aplicativo Proffy, desenvolvido em Android Studio utilizando Kotlin e XML.

## Funcionalidades implementadas

- Tela de recuperação de senha com campo para preenchimento do e-mail.
- Validação do formato do e-mail utilizando `Patterns.EMAIL_ADDRESS`.
- Alteração do estado e da aparência do botão conforme a validade do e-mail informado.
- Exibição de mensagem de erro para e-mails inválidos.
- Navegação da tela de login para a tela de recuperação de senha.
- Redirecionamento para a tela de conclusão após o envio de um e-mail válido.
- Botão para retornar à tela de login após a conclusão.

## Implementação

A validação do e-mail é realizada em Kotlin, verificando se o campo está preenchido e se apresenta um formato válido. Quando a validação é aprovada, o botão é habilitado e seu texto muda de "Entrar" para "Enviar".

A navegação entre as telas é realizada por meio de Intents, conectando a tela de login à recuperação de senha e, posteriormente, à tela de conclusão.

## Tecnologias utilizadas

- Kotlin
- XML
- Android Studio
- Android View Binding
