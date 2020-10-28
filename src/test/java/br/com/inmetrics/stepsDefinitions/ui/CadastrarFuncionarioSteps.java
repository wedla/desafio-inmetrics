package br.com.inmetrics.stepsDefinitions.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Assert;

import com.github.javafaker.Faker;

import br.com.inmetrics.pageObjects.FuncionarioPage;
import br.com.inmetrics.pageObjects.LoginUsuarioPage;
import br.com.inmetrics.pageObjects.PaginaInicialPage;
import br.com.inmetrics.stepsDefinitions.WebDriverFactory;
import br.com.inmetrics.teste.support.TipoContratacao;
import br.com.inmetrics.utils.Constantes;
import br.com.inmetrics.utils.GeneratorDocumento;
import br.com.inmetrics.utils.Sexo;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CadastrarFuncionarioSteps {

	private WebDriverFactory driverFactory;

	private LoginUsuarioPage loginUsuarioPage;
	private PaginaInicialPage paginaInicialPage;
	private FuncionarioPage cadastrarFuncionarioPage;
	private Faker faker;
	private GeneratorDocumento geradorDocumento;

	@Given("Eu fiz login com sucesso")
	public void eu_fiz_login_com_sucesso() {
		this.driverFactory = new WebDriverFactory();
		this.loginUsuarioPage = new LoginUsuarioPage(this.driverFactory.getDriver(),
				this.driverFactory.getDriverWait());

		this.loginUsuarioPage.Navegar();
		this.loginUsuarioPage.setUsuario(Constantes.USUARIO_PADRAO);
		this.loginUsuarioPage.setSenha(Constantes.SENHA_PADRAO);
		this.loginUsuarioPage.clickRealizarLogin();
	}

	@When("Eu cliquei no link Novo Funcionário")
	public void eu_cliquei_no_link_novo_funcionário() {
		this.paginaInicialPage = new PaginaInicialPage(this.driverFactory.getDriver(),
				this.driverFactory.getDriverWait());

		this.paginaInicialPage.waitForPaginaInicialCarregar();
		this.paginaInicialPage.realizarAcao("Novo Funcionário");
	}

	@Then("Eu estou na página de cadastrar Novo Funcionário")
	public void eu_estou_na_página_de_cadastrar_novo_funcionário() {
		this.cadastrarFuncionarioPage = new FuncionarioPage(this.driverFactory.getDriver());

		this.cadastrarFuncionarioPage.waitPaginaFuncionario();
	}

	@Then("Eu insiro o campo de Nome")
	public void eu_insiro_o_campo_de_nome() {
		this.faker = new Faker();

		this.cadastrarFuncionarioPage.setNome(faker.name().fullName());
	}

	@Then("Eu insiro o campo de CPF válido")
	public void eu_insiro_o_campo_de_cpf_valido() {
		this.geradorDocumento = new GeneratorDocumento();

		this.cadastrarFuncionarioPage.setDocumento(geradorDocumento.cpf(true));
	}

	@Then("Eu escolho o sexo")
	public void eu_escolho_o_sexo() {
		Sexo[] sexos = Sexo.values();
		Random random = new Random();

		this.cadastrarFuncionarioPage.setSexo(sexos[random.nextInt(sexos.length)].getNome());
	}

	@Then("Eu insiro o campo de Admissão")
	public void eu_insiro_o_campo_de_admissão() throws ParseException {
		Date date = new Date();

		System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(date));

		this.cadastrarFuncionarioPage.setDataAdmissao(new SimpleDateFormat("dd-MM-yyyy").format(date));
	}

	@Then("Eu insiro o campo de Cargo")
	public void eu_insiro_o_campo_de_cargo() {
		this.cadastrarFuncionarioPage.setCargo("Analista de Teste");
	}

	@Then("Eu insiro o campo de Salário")
	public void eu_insiro_o_campo_de_salário() {
		this.cadastrarFuncionarioPage.setSalario("400000");
	}

	@Then("Eu seleciono o tipo de contratação")
	public void eu_seleciono_o_tipo_de_contratação() {
		this.cadastrarFuncionarioPage.setTipoContratacao(TipoContratacao.CLT);
	}

	@When("Eu clicar no botão Enviar")
	public void eu_clicar_no_botão_enviar() {
		this.cadastrarFuncionarioPage.clickEnviar();
	}

	@Then("Eu devo ver uma mensagem de sucesso")
	public void eu_devo_ver_uma_mensagem_de_sucesso() {
		Assert.assertTrue(
				this.paginaInicialPage.getMensagemSucessoAlteraracao().contains(Constantes.MENSAGEM_SUCESSO_CADASTRO));
	}

	@When("Eu insiro o campo de CPF inválido")
	public void eu_insiro_o_campo_de_cpf_inválido() {
		this.cadastrarFuncionarioPage.setDocumento(Constantes.CPF_INVALIDO);
	}

	@Then("Eu devo ver um alerta que o CPF está inválido")
	public void eu_devo_ver_um_alerta_que_o_cpf_está_inválido() {
		Assert.assertTrue(this.cadastrarFuncionarioPage.isAlertaDocumentoErro());
	}

	@When("Eu clico no botão de Cancelar")
	public void eu_clico_no_botão_de_cancelar() {
		this.cadastrarFuncionarioPage.clickCancelar();
	}

	@Then("Eu devo voltar a página inicial")
	public void eu_devo_voltar_a_página_inicial() {
		this.paginaInicialPage.waitForPaginaInicialCarregar();
	}

	@After
	public void closeDriver() {
		if (this.driverFactory != null) {
			this.driverFactory.quitDriver();
		}

	}

}
