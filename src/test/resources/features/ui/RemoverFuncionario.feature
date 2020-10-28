@removerFuncionario
Feature: Remover funcionário
Description: O objetivo desta feature é remover funcionário(s)

	Background:
		Given Eu fiz login com sucesso para remover
			When Eu procurar por um funcionário fake
			And Eu clicar em remover

  @removerFuncionarioSucesso
  Scenario: Remover funcionário com sucesso
    Then Eu devo ver uma mensagem de sucesso de remoção

  
