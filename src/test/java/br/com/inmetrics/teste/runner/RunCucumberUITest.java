package br.com.inmetrics.teste.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:reports/test-report"}, 
	features = "src/test/resources/features/ui",
	glue = { "br.com.inmetrics.stepsDefinitions.ui" })
public class RunCucumberUITest {
}