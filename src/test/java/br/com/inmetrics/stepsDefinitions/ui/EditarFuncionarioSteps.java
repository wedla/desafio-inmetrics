package br.com.inmetrics.stepsDefinitions.ui;

import org.junit.Assert;

import br.com.inmetrics.pageObjects.FuncionarioPage;
import br.com.inmetrics.pageObjects.LoginUsuarioPage;
import br.com.inmetrics.pageObjects.PaginaInicialPage;
import br.com.inmetrics.stepsDefinitions.WebDriverFactory;
import br.com.inmetrics.teste.support.TipoContratacao;
import br.com.inmetrics.utils.Constantes;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditarFuncionarioSteps {

	private WebDriverFactory driverFactory;

	private PaginaInicialPage paginaInicialPage;
	private LoginUsuarioPage loginUsuarioPage;
	private FuncionarioPage funcionarioPage;
	
	@Given("Eu realizei login com sucesso")
	public void eu_realizei_login_com_sucesso() {
		this.driverFactory = new WebDriverFactory();
		this.loginUsuarioPage = new LoginUsuarioPage(this.driverFactory.getDriver(),
				this.driverFactory.getDriverWait());

		this.loginUsuarioPage.Navegar();
		this.loginUsuarioPage.setUsuario(Constantes.USUARIO_PADRAO);
		this.loginUsuarioPage.setSenha(Constantes.SENHA_PADRAO);
		this.loginUsuarioPage.clickRealizarLogin();
	}

	@And("Eu estou na página inicial")
	public void eu_estou_na_página_inicial( ) {
		this.paginaInicialPage = new PaginaInicialPage(this.driverFactory.getDriver(),
				this.driverFactory.getDriverWait());
		
		this.paginaInicialPage.waitForPaginaInicialCarregar();
	}
	
	@When("Eu procurar por um funcionário")
	public void eu_procurar_por_um_funcionário() {
		this.paginaInicialPage.pesquisarUsuario(Constantes.FUNCIONARIO_PADRAO);
	}

	@And("Eu clicar em editar")
	public void eu_clicar_em_editar() {
		this.paginaInicialPage.clickAcao("editar");
	}

	@Then("Eu devo ver seus dados na tela de edição")
	public void eu_devo_ver_seus_dados_na_tela_de_edição() {
		this.funcionarioPage = new FuncionarioPage(this.driverFactory.getDriver());
		this.funcionarioPage.waitPaginaFuncionario();
	}

	@And("Eu edito o campo de Cargo")
	public void eu_edito_o_campo_de_cargo() {
		this.funcionarioPage.setCargo(Constantes.CARGO_PADRAO);
	}

	@And("Eu edito o campo de Salário com um valor válido")
	public void eu_edito_o_campo_de_salário_válido() {
		this.funcionarioPage.setSalario(Constantes.SALARIO_PADRAO);
	}

	@And("Eu edito o campo de Salário com um valor inválido")
	public void eu_edito_o_campo_de_salário_inválido() {
		String salarioInvalido = "4";

		for (int i = 0; i < 700; i++) {
			salarioInvalido += "0";
		}

		System.out.println(salarioInvalido);
		this.funcionarioPage.setSalario(salarioInvalido);
	}

	@And("Eu edito o campo de Tipo de Contratação")
	public void eu_edito_o_campo_de_tipo_de_contratação() {
		this.funcionarioPage.setTipoContratacao(TipoContratacao.PJ);
	}

	@When("Eu clicar no botão Enviar para Enviar Alteração")
	public void eu_clicar_no_botao_enviar() {
		this.funcionarioPage.clickEnviar();
	}

	@Then("Eu devo ver a mensagem de sucesso de alteração")
	public void eu_devo_ver_a_mensagem_de_sucesso_alteracao() {
		Assert.assertTrue(
				this.paginaInicialPage.getMensagemSucessoAlteraracao().contains(Constantes.MENSAGEM_SUCESSO_ALTERACAO));
	}

	@After
	public void closeDriver() {
		if (this.driverFactory != null) {
			this.driverFactory.quitDriver();
		}
	}

}
