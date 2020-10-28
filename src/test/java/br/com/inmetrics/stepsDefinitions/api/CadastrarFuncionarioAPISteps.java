package br.com.inmetrics.stepsDefinitions.api;

import org.junit.Assert;

import br.com.inmetrics.utils.Constantes;
import br.com.inmetrics.utils.Pessoa;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CadastrarFuncionarioAPISteps {

	private static RequestSpecification request;
	private static Response response;
	private static String requestJson;
	
	@Given("Eu configuro um endpoint POST")
	public void eu_configuro_um_endpoint_post() {
		RestAssured.baseURI = Constantes.POST_FUNCIONARIO;
	}

	@And("Eu configuro o header da requisição")
	public void eu_configuro_o_header_da_requisição() {
		request = RestCommonSteps.setRequestHeaders();
	}

	@And("Eu configuro o body da requisição")
	public void eu_configuro_o_body_da_requisição() {
		requestJson = Pessoa.generatePessoaJson();
		
		System.out.println(requestJson);
	}

	@When("Eu enviar a requisição HTTP")
	public void eu_enviar_a_requisição_http() {
		response = request.body(requestJson).post();
		
		System.out.println(response.body().asString());
	}

	@Then("Eu devo receber o código de resposta HTTP {int}")
	public void eu_devo_receber_o_código_de_resposta_http(int codigoResposta) {
		Assert.assertEquals(codigoResposta, response.getStatusCode());
	}
	
	@After
	public void resetRestAssured() {
		RestAssured.reset();
	}

}
