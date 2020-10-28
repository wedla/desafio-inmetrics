package br.com.inmetrics.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaInicialPage {
	private WebDriver driver;
	private WebDriverWait driverWait;

	@FindBy(how = How.CLASS_NAME, using = "navbar-nav")
	private WebElement navbar;
	@FindBy(how = How.ID, using = "tabela")
	private WebElement gridFuncionarios;
	@FindBy(how = How.XPATH, using = "//div//div[2]//div//div[2]//label//input")
	private WebElement pesquisa;
	
	@FindBy(how = How.CLASS_NAME, using = "alert-success")
	private WebElement lblMensagemSucesso;
	
	private String warningClassName = "btn-warning";
	private String removeClassName = "btn-danger";
	
	public PaginaInicialPage(WebDriver driver, WebDriverWait driverWait) {
		this.driver = driver;
		this.driverWait = driverWait;
		
		PageFactory.initElements(this.driver, this);
	}

	public void realizarAcao(String acao) {
		List<WebElement> itens = navbar.findElements(By.tagName("li"));

		System.out.println("Tamanho do array: " + itens.size());

		for (int i = 1; i < itens.size(); i++) {
			System.out.println(itens.get(i).getText());
			if (itens.get(i).getText().toUpperCase().equals(acao.toUpperCase())) {
				itens.get(i).click();
				break;
			}
		}
	}
	
	public void waitForPaginaInicialCarregar() {
		this.driverWait.until(ExpectedConditions.visibilityOf(this.gridFuncionarios));
	}
	
	public void pesquisarUsuario(String nomeFuncionario) {
		this.driverWait.until(ExpectedConditions.visibilityOf(this.pesquisa));
		this.pesquisa.sendKeys(nomeFuncionario);
	}
	
	public void clickAcao(String acao) {
		List<WebElement> linhas = this.gridFuncionarios.findElements(By.xpath(".//tr//td//a//button"));
		
		for (int i = 0; i < linhas.size(); i++) {
			if ((acao.toLowerCase().equals("editar") && 
					linhas.get(i).getAttribute("class").toString().contains(this.warningClassName) 
					||
					acao.toLowerCase().equals("remover") && 
					linhas.get(i).getAttribute("class").toString().contains(this.removeClassName))) {
				linhas.get(i).click();
				break;
			} 
		}
	}
	
	public String getMensagemSucessoAlteraracao() {
		this.driverWait.until(ExpectedConditions.visibilityOf(this.lblMensagemSucesso));
		return this.lblMensagemSucesso.getText();
	}
}
