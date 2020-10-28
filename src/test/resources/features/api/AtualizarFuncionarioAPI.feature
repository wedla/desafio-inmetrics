@atualizarFuncionario
Feature: Atualizar dados de funcionário
Description: O objetivo desta feature é poder fazer a alteração de dados do usuário

  @atualizarFuncionarioComSucesso
  Scenario: Atualizar funcionário com sucesso
    Given Eu configuro um endpoint PUT com parâmetro de usuário válido
    And Eu configuro o body da requisição PUT
    When Eu enviar a requisição HTTP PUT
    Then Eu devo receber o código de resposta HTTP 202 PUT
    
  @atualizarFuncionarioComFalha
  Scenario: Executar endpoint passando usuário inexistente como parâmetro
    Given Eu configuro um endpoint PUT com parâmetro de usuário inválido
    And Eu configuro o body da requisição PUT 
    When Eu enviar a requisição HTTP PUT
    Then Eu devo receber o código de resposta HTTP 400 PUT

