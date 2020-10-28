@editarFuncionario
Feature: Editar usuário
Description: O objetivo desta feature é editar um usuário já cadastrado na base

	Background: 
		Given Eu realizei login com sucesso 
			And Eu estou na página inicial
			When Eu procurar por um funcionário
			And Eu clicar em editar
			Then Eu devo ver seus dados na tela de edição
			And Eu edito o campo de Cargo
			And Eu edito o campo de Tipo de Contratação

  @editarFuncionarioComSucesso
  Scenario: Editar um usuário com sucesso
    And Eu edito o campo de Salário com um valor válido
    When Eu clicar no botão Enviar para Enviar Alteração
    Then Eu devo ver a mensagem de sucesso de alteração
    
  @editarFuncionarioComSalarioInvalido
  Scenario: Editar um usuário com salário que estoura o campo
  	And Eu edito o campo de Salário com um valor inválido
    When Eu clicar no botão Enviar para Enviar Alteração
    Then Eu devo ver a mensagem de sucesso de alteração
 
