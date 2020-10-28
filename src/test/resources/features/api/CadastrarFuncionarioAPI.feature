@cadastrarFuncionarioAPI
Feature: Cadastrar funcionário através de API 
Description: O objetivo desta feature é cadastrar um funcionário

  @cadastrarFuncionarioAPIComSucesso
  Scenario: Cadastrar funcionário com sucesso
    Given Eu configuro um endpoint POST
    And Eu configuro o header da requisição
    And Eu configuro o body da requisição 
    When Eu enviar a requisição HTTP
    Then Eu devo receber o código de resposta HTTP 202
