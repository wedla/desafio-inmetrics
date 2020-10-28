package br.com.inmetrics.pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastrarUsuarioPage {
	
	private final String PAGINA_INICIAL = "http://www.inmrobo.tk/accounts/login/";
	private final String PAGINA_CADASTRO = "http://www.inmrobo.tk/accounts/signup/";
	
	@FindBy(how = How.NAME, using = "username")
	private WebElement usuario;
	@FindBy(how = How.NAME, using = "pass")
	private WebElement senha;
	@FindBy(how = How.NAME, using = "confirmpass")
	private WebElement confirmacaoSenha;
	@FindBy(how = How.CLASS_NAME, using = "login100-form-btn")
	private WebElement btnCadastrar;
	@FindBy(how = How.XPATH, using = "//div[@class='p-t-10 p-b-1']//span[1]//div[1]")
	private WebElement lblUsuarioCadastrado;
	
	private WebDriver driver;
	private WebDriverWait driverWait;
	
	public CadastrarUsuarioPage(WebDriver driver, WebDriverWait driverWait) {
		this.driver = driver; 
		this.driverWait = driverWait;
		
        PageFactory.initElements(driver, this);
	}
	
	public void Navegar() {
		this.driver.get(PAGINA_CADASTRO);
		this.driverWait.until(ExpectedConditions.visibilityOf(this.usuario));
	}
	
	public void setUsuario(String usuario) {
		this.usuario.sendKeys(usuario);
	}
	
	public void setSenha(String senha) {
		this.senha.sendKeys(senha);
	}
	
	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha.sendKeys(confirmacaoSenha);
	}
	
	public void clickCadastrarUsuario() {
		this.btnCadastrar.click();
	}
	
	public boolean isCadastroSucesso() {
		try {
			this.driverWait.until(ExpectedConditions.urlContains(this.PAGINA_INICIAL));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public String getLabelErroUsuarioCadastrado() {
		return this.lblUsuarioCadastrado.getText().trim();
	}
	
	public boolean CadastrarUsuario(String usuario, String senha, String confirmacaoSenha) {
		this.usuario.sendKeys(usuario);
		this.senha.sendKeys(senha);
		this.confirmacaoSenha.sendKeys(confirmacaoSenha);
		
		this.btnCadastrar.click();
		
		try {
			this.driverWait.until(ExpectedConditions.urlContains(this.PAGINA_INICIAL));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
}
