@cadastrarUsuarioTest

Feature: Cadastrar novo usuário
Description: O objetivo desta feature é cadastrar um usuário

	Background:
		Given Eu estou na página de cadastro 

	Scenario: Redirecionar usuário para página de login após cadastro bem sucedido
		And Eu inserir um novo campo de usuário
		And Eu inserir o campo de senha
		And Eu inserir o campo de confirmação de senha
		When Eu clicar no botão de cadastrar
		Then Eu devo ser redirecionada para a tela de login
		
	Scenario: Mostrar mensagem de erro ao tentar cadastrar usuário que já está na base
		And Eu inserir um campo já existente de usuário
		And Eu inserir o campo de senha
		And Eu inserir o campo de confirmação de senha
		When Eu clicar no botão de cadastrar
		Then Eu devo ser notificada de que o usuário já está cadastrado na base

