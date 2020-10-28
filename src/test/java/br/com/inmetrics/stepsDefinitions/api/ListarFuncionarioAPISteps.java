package br.com.inmetrics.stepsDefinitions.api;

import org.junit.Assert;

import br.com.inmetrics.utils.Constantes;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ListarFuncionarioAPISteps {

	private static RequestSpecification request;
	private static Response response;

	@Given("Eu configuro o endpoint com um id de empregado válido")
	public void eu_configuro_o_endpoint_com_um_id_de_empregado_válido() {
		RestAssured.baseURI = String.format(Constantes.GET_FUNCIONARIO_POR_ID, Constantes.ID_EMPREGADO_VALIDO);
		request = RestCommonSteps.setRequestHeaders();
	}

	@Given("Eu configuro o endpoint com um id de empregado inválido")
	public void eu_configuro_o_endpoint_com_um_id_de_empregado_inválido() {
		RestAssured.baseURI = String.format(Constantes.GET_FUNCIONARIO_POR_ID, Constantes.ID_EMPREGADO_INVALIDO);
		request = RestCommonSteps.setRequestHeaders();
	}

	@Given("Eu configuro o endpoint para obter todos os funcionários")
	public void eu_configuro_o_endpoint_para_obter_todos_os_funcionários() {
		RestAssured.baseURI = Constantes.GET_TODOS_OS_FUNCIONARIOS;
		request = RestCommonSteps.setRequestHeaders();
	}

	@When("Eu enviar a requisição HTTP GET")
	public void eu_enviar_a_requisição_http_get() {
		response = request.get();
	}

	@Then("Eu devo receber o código de resposta HTTP {int} GET")
	public void eu_devo_receber_o_código_de_resposta_http_get(int codigoResposta) {
		Assert.assertEquals(codigoResposta, response.getStatusCode());
	}

	@And("Os dados do funcionário devem estar no corpo da resposta")
	public void os_dados_do_funcionário_devem_estar_no_corpo_da_resposta() {
		String bodyResponse = response.body().asString();
		System.out.println(bodyResponse);

		Assert.assertTrue(bodyResponse.contains(String.valueOf(Constantes.ID_EMPREGADO_VALIDO)));
	}

	@Then("Uma mensagem de erro no corpo da resposta")
	public void uma_mensagem_de_erro_no_corpo_da_resposta() {
		String bodyResponse = response.body().asString();
		System.out.println(bodyResponse);

		Assert.assertTrue(bodyResponse.contains(Constantes.MENSAGEM_ERRO_400_LIST_FUNCIONARIO_POR_ID));
	}

	@After
	public void resetRestAssured() {
		RestAssured.reset();
	}

}
