#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@loginUsuario
Feature: Realizar login no sistema
Description: O objetivo desta feature é realizar o login do usuário

	Background: 
		Given Eu estou na página de login

  @loginSucesso
  Scenario: Redirecionar o usuário com sucesso para a página inicial
    And Eu insiro um usuário válido
    And Eu insiro uma senha senha válida
    When Eu clicar no botão de Entre
    Then Eu devo ser redirecionada para a página inicial do sistema
    
  @loginUsuarioInvalido
  Scenario: Mostrar ao usuário uma mensagem de erro ao inserir usuário inválido
    And Eu insiro um usuário inválido
    And Eu insiro uma senha senha válida
    When Eu clicar no botão de Entre
    Then Eu devo ver uma mensagem de erro
    
  @loginSenhaInvalida
  Scenario: Mostrar ao usuário uma mensagem de erro ao inserir senha inválida
    And Eu insiro um usuário válido
    And Eu insiro uma senha senha inválida
    When Eu clicar no botão de Entre
    Then Eu devo ver uma mensagem de erro

