package br.com.inmetrics.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.inmetrics.teste.support.TipoContratacao;

public class FuncionarioPage {

	private WebDriver driver;
	private WebDriverWait driverWait;

	@FindBy(how = How.ID, using = "inputNome")
	private WebElement nome;
	@FindBy(how = How.ID, using = "cpf")
	private WebElement documento;
	@FindBy(how = How.ID, using = "slctSexo")
	private WebElement sexo;
	@FindBy(how = How.ID, using = "inputAdmissao")
	private WebElement dataAdmissao;
	@FindBy(how = How.ID, using = "inputCargo")
	private WebElement cargo;
	@FindBy(how = How.ID, using = "dinheiro")
	private WebElement salario;

	@FindBy(how = How.ID, using = "clt")
	private WebElement tipoContratacaoCLT;
	@FindBy(how = How.ID, using = "pj")
	private WebElement tipoContratacaoPJ;

	@FindBy(how = How.CLASS_NAME, using = "cadastrar-form-btn")
	private WebElement btnEnviar;
	@FindBy(how = How.CLASS_NAME, using = "cancelar-form-btn")
	private WebElement btnCancelar;

	public FuncionarioPage(WebDriver driver) {
		this.driver = driver;
		driverWait = new WebDriverWait(this.driver, 5);

		PageFactory.initElements(this.driver, this);
	}

	public void waitPaginaFuncionario() {
		driverWait.until(ExpectedConditions.visibilityOf(this.nome));
	}

	public void setNome(String nome) {
		this.nome.sendKeys(nome);
	}

	public void setDocumento(String documento) {
		System.out.println("CPF: " + documento);

		this.documento.sendKeys(documento);
		this.documento.sendKeys(Keys.TAB);
	}

	public void setSexo(String sexo) {
		Select seletor = new Select(this.sexo);

		seletor.selectByVisibleText(sexo);

	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao.clear();
		this.dataAdmissao.sendKeys(dataAdmissao);
	}

	public void setCargo(String cargo) {
		this.cargo.clear();
		this.cargo.sendKeys(cargo);
	}

	public void setSalario(String salario) {
		this.salario.clear();
		this.salario.sendKeys(salario);
	}

	public void setTipoContratacao(TipoContratacao tipoContratacao) {
		if (tipoContratacao.equals(TipoContratacao.CLT)) {
			this.tipoContratacaoCLT.click();

		} else {
			this.tipoContratacaoPJ.click();
		}
	}

	public void clickEnviar() {
		this.btnEnviar.click();
	}
	
	public void clickCancelar() {
		this.btnCancelar.click();
	}

	public boolean isAlertaDocumentoErro() {
		try {
			Alert alert = driverWait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
			return true;
		} catch (Throwable e) {
			return false;
		}
	}
}
