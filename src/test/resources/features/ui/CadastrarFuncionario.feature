#Author: your.email@your.domain.com

@cadastrarFuncionario
Feature: Cadastrar funcionário
Description: O objetivo desta feature é cadastrar um funcionário

	Background:
		Given Eu fiz login com sucesso
			When Eu cliquei no link Novo Funcionário
			Then Eu estou na página de cadastrar Novo Funcionário 
	
	@cadastrarFuncionarioFalhaCPF
  Scenario: Cadastrar um funcionário com falha por erro de CPF
	    And Eu insiro o campo de Nome
	    When Eu insiro o campo de CPF inválido
	    Then Eu devo ver um alerta que o CPF está inválido
	    
	@cancelarCadastro
	Scenario: Estar na tela de cadastro, mas cancelá-lo
		And Eu insiro o campo de Nome
		When Eu clico no botão de Cancelar
		Then Eu devo voltar a página inicial
	    
  @cadastrarFuncionarioSucesso
  Scenario: Cadastrar um funcionário com sucesso
    And Eu insiro o campo de Nome
    And Eu insiro o campo de CPF válido
    And Eu escolho o sexo
    And Eu insiro o campo de Admissão
    And Eu insiro o campo de Cargo
    And Eu insiro o campo de Salário
    And Eu seleciono o tipo de contratação
    When Eu clicar no botão Enviar
    Then Eu devo ver uma mensagem de sucesso 
    
  
