package br.com.inmetrics.stepsDefinitions.api;

import br.com.inmetrics.utils.Constantes;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestCommonSteps {

	public static RequestSpecification setRequestHeaders() {
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Basic " + Constantes.TOKEN_API).header("Content-Type", "application/json");
		
		return request;
	}

}
