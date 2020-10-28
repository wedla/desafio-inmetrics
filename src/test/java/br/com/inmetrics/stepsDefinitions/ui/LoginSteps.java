package br.com.inmetrics.stepsDefinitions.ui;

import org.junit.Assert;

import br.com.inmetrics.pageObjects.LoginUsuarioPage;
import br.com.inmetrics.stepsDefinitions.WebDriverFactory;
import br.com.inmetrics.utils.Constantes;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private WebDriverFactory driverFactory;
	private LoginUsuarioPage loginUsuarioPage;
	
	@Given("Eu estou na página de login")
	public void givenStatement() {
		this.driverFactory = new WebDriverFactory();
		this.loginUsuarioPage = new LoginUsuarioPage(this.driverFactory.getDriver(), this.driverFactory.getDriverWait());

		this.loginUsuarioPage.Navegar();

	}

	@And("Eu insiro um usuário válido")
	public void andInserirUsuarioValido() {
		this.loginUsuarioPage.setUsuario(Constantes.USUARIO_PADRAO);
	}
	
	@And("Eu insiro um usuário inválido")
	public void andInserirUsuarioInValido() {
		this.loginUsuarioPage.setUsuario(Constantes.USUARIO_INVALIDO);
	}

	@And("Eu insiro uma senha senha válida")
	public void andInsirirSenhaValida() {
		this.loginUsuarioPage.setSenha(Constantes.SENHA_PADRAO);
	}
	
	@And("Eu insiro uma senha senha inválida")
	public void andInsirirSenhaInvalida() {
		this.loginUsuarioPage.setSenha(Constantes.SENHA_INVALIDA);
	}

	@When("Eu clicar no botão de Entre")
	public void whenStatement() {
		this.loginUsuarioPage.clickRealizarLogin();
	}

	@Then("Eu devo ser redirecionada para a página inicial do sistema")
	public void thenStatementSucess() {
		Assert.assertTrue(this.loginUsuarioPage.isUsuarioLogado());
	}
	
	@Then("Eu devo ver uma mensagem de erro")
	public void thenStatementFailure() {
		Assert.assertTrue(this.loginUsuarioPage.getMensagemFalhaLogin().contains(Constantes.MENSAGEM_ERRO_LOGIN));
	}
	
	@After
	public void closeDriver() {
		if (this.driverFactory != null) {
			this.driverFactory.quitDriver();
		}
	}

}
