package br.com.inmetrics.stepsDefinitions.ui;

import org.junit.Assert;

import br.com.inmetrics.pageObjects.CadastrarUsuarioPage;
import br.com.inmetrics.stepsDefinitions.WebDriverFactory;
import br.com.inmetrics.utils.Constantes;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CadastrarUsuarioSteps {

	private CadastrarUsuarioPage cadastrarUsuarioPage;
	private WebDriverFactory driverFactory;

	@Given("^Eu estou na página de cadastro$")
	public void givenStatment() {
		this.driverFactory = new WebDriverFactory();
		this.cadastrarUsuarioPage = new CadastrarUsuarioPage(this.driverFactory.getDriver(), this.driverFactory.getDriverWait());

		this.cadastrarUsuarioPage.Navegar();
	}

	@And("^Eu inserir um novo campo de usuário$")
	public void andInserirCampoNovoUsuario() {
		String usuario = "" + (int) (Math.random() * Integer.MAX_VALUE);
		String email = "username" + usuario + "@email.com";

		this.cadastrarUsuarioPage.setUsuario(email);
	}
	
	@And("^Eu inserir um campo já existente de usuário$")
	public void andInserirCampoExistenteUsuario() {
		this.cadastrarUsuarioPage.setUsuario(Constantes.USUARIO_PADRAO);
	}

	@And("^Eu inserir o campo de senha$")
	public void andInserirCampoSenha() {
		this.cadastrarUsuarioPage.setSenha(Constantes.SENHA_PADRAO);
	}

	@And("^Eu inserir o campo de confirmação de senha$")
	public void andInserirCampoConfirmacaoSenha() {
		this.cadastrarUsuarioPage.setConfirmacaoSenha(Constantes.SENHA_PADRAO);
	}

	@When("^Eu clicar no botão de cadastrar$")
	public void whenStatement() {
		this.cadastrarUsuarioPage.clickCadastrarUsuario();
	}

	@Then("^Eu devo ser redirecionada para a tela de login$")
	public void thenStatmentSuccess() {
		Assert.assertTrue(this.cadastrarUsuarioPage.isCadastroSucesso());
	}

	@Then("Eu devo ser notificada de que o usuário já está cadastrado na base")
	public void thenStatmentFailure() {
		Assert.assertEquals(Constantes.MENSAGEM_ERRO_CADASTRO_USUARIO, this.cadastrarUsuarioPage.getLabelErroUsuarioCadastrado());
	}
	
	@After
	public void closeDriver() {
		if (this.driverFactory != null) {
			this.driverFactory.quitDriver();
		}
	}

}