package br.com.inmetrics.stepsDefinitions.ui;

import org.junit.Assert;

import br.com.inmetrics.pageObjects.LoginUsuarioPage;
import br.com.inmetrics.pageObjects.PaginaInicialPage;
import br.com.inmetrics.stepsDefinitions.WebDriverFactory;
import br.com.inmetrics.utils.Constantes;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RemoverFuncionarioSteps {
	
	private WebDriverFactory driverFactory;
	
	private PaginaInicialPage paginaInicialPage;
	private LoginUsuarioPage loginUsuarioPage;
	
	@Given("Eu fiz login com sucesso para remover")
	public void eu_realizei_login_com_sucesso_para_remover() {
		this.driverFactory = new WebDriverFactory();
		this.loginUsuarioPage = new LoginUsuarioPage(this.driverFactory.getDriver(),
				this.driverFactory.getDriverWait());

		this.loginUsuarioPage.Navegar();
		this.loginUsuarioPage.setUsuario(Constantes.USUARIO_PADRAO);
		this.loginUsuarioPage.setSenha(Constantes.SENHA_PADRAO);
		this.loginUsuarioPage.clickRealizarLogin();
	}
	
	
	@When("Eu procurar por um funcionário fake")
	public void eu_procurar_por_um_funcionário_fake() {
		this.paginaInicialPage = new PaginaInicialPage(this.driverFactory.getDriver(), this.driverFactory.getDriverWait());
		
		this.paginaInicialPage.pesquisarUsuario(Constantes.FUNCIONARIO_FAKE);
	}
	
	@And("Eu clicar em remover")
	public void eu_clicar_em_remover() {
		this.paginaInicialPage.clickAcao("remover");
	}
	
	@Then("Eu devo ver uma mensagem de sucesso de remoção") 
	public void eu_devo_ver_uma_mensagem_de_sucesso_de_remocao() {
		Assert.assertTrue(this.paginaInicialPage.getMensagemSucessoAlteraracao().contains(Constantes.MENSAGEM_SUCESSO_REMOCAO));
	}
	
	@After
	public void quitDriver() {
		if (this.driverFactory != null) {
			this.driverFactory.quitDriver();
		}
	}
}
