package br.com.inmetrics.teste.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:reports/test-report"}, 
	features = "src/test/resources/features/api",
	glue = { "br.com.inmetrics.stepsDefinitions.api" })
public class RunCucumberaAPITest {
}