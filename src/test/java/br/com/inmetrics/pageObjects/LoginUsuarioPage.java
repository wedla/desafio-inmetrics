package br.com.inmetrics.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.inmetrics.utils.Constantes;

public class LoginUsuarioPage {
	
	private WebDriver driver;
	private WebDriverWait driverWait;
	
	@FindBy(how = How.NAME, using = "username")
	private WebElement usuario;
	@FindBy(how = How.NAME, using = "pass")
	private WebElement senha;
	@FindBy(how = How.CLASS_NAME, using = "login100-form-btn")
	private WebElement btnEntre;
	@FindBy(how = How.CLASS_NAME, using = "alert-danger")
	private WebElement lblErrorUsuarioInvalido;
	
	public LoginUsuarioPage(WebDriver driver, WebDriverWait driverWait) {
		this.driver = driver;
		this.driverWait = driverWait;
		
		PageFactory.initElements(this.driver, this);
	}
	
	public void Navegar() {
		this.driver.get(Constantes.PAGINA_LOGIN);
		
		this.driverWait.until(ExpectedConditions.visibilityOf(this.usuario));
	}
	
	public void setUsuario(String usuario) {
		this.usuario.sendKeys(usuario);
	}
	
	public void setSenha(String senha) {
		this.senha.sendKeys(senha);
	}
	
	public void clickRealizarLogin() {
		this.btnEntre.click();
	}
	
	public boolean isUsuarioLogado() {
		try {
			this.driverWait.until(ExpectedConditions.urlContains(Constantes.PAGINA_INICIAL));
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	
	public String getMensagemFalhaLogin() {
		System.out.println("Mensagem: " + this.lblErrorUsuarioInvalido.getText().trim());
		return this.lblErrorUsuarioInvalido.getText().trim();
	}
}
