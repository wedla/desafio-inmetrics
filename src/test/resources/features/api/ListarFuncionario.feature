@listarFuncionarios
Feature: Listar informações do funcionário
Description: O objetivo desta feature é listar todos os funcionários ou os dados de um funcionário ao passar seu Id como parâmetro
	
	@listarFuncionarioPorIdValido
  Scenario: Listar dados de funcionário com sucesso
  	Given Eu configuro o endpoint com um id de empregado válido
  	When Eu enviar a requisição HTTP GET
    Then Eu devo receber o código de resposta HTTP 202 GET
   	And Os dados do funcionário devem estar no corpo da resposta
   	
  @listarFuncionarioPorIdInvalido
  Scenario: Mostrar falha ao consultar usuário inexistente
  	Given Eu configuro o endpoint com um id de empregado inválido
  	When Eu enviar a requisição HTTP GET
    Then Eu devo receber o código de resposta HTTP 400 GET
   	And Uma mensagem de erro no corpo da resposta
   	
  @listarTodosOsFuncionarios
  Scenario: Listar todos os funcionários na base
  	Given Eu configuro o endpoint para obter todos os funcionários
  	When Eu enviar a requisição HTTP GET
    Then Eu devo receber o código de resposta HTTP 200 GET