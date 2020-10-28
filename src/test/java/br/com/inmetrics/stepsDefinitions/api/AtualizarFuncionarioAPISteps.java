package br.com.inmetrics.stepsDefinitions.api;

import br.com.inmetrics.utils.Constantes;
import br.com.inmetrics.utils.Pessoa;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class AtualizarFuncionarioAPISteps {

	private static RequestSpecification request;
	private static Response response;
	private static String requestJson;

	@Given("Eu configuro um endpoint PUT com parâmetro de usuário válido")
	public void eu_configuro_um_endpoint_put_com_parâmetro_de_usuário_válido() {
		RestAssured.baseURI = String.format(Constantes.PUT_FUNCIONARIO, Constantes.ID_EMPREGADO_VALIDO);

		request = RestCommonSteps.setRequestHeaders();
	}

	@Given("Eu configuro um endpoint PUT com parâmetro de usuário inválido")
	public void eu_configuro_um_endpoint_put_com_parâmetro_de_usuário_inválido() {
		RestAssured.baseURI = String.format(Constantes.PUT_FUNCIONARIO, Constantes.ID_EMPREGADO_INVALIDO);

		request = RestCommonSteps.setRequestHeaders();
	}

	@And("Eu configuro o body da requisição PUT")
	public void eu_configuro_o_body_da_requisição_put() {
		requestJson = Pessoa.generatePessoaJson();

		System.out.println(requestJson);
	}

	@When("Eu enviar a requisição HTTP PUT")
	public void eu_enviar_a_requisição_http_put() {
		response = request.body(requestJson).put();
	}

	@Then("Eu devo receber o código de resposta HTTP {int} PUT")
	public void eu_devo_receber_o_código_de_resposta_http_put(int codigoResposta) {
		Assert.assertEquals(codigoResposta, response.getStatusCode());
	}

}
