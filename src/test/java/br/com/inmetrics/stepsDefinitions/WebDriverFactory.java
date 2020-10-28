package br.com.inmetrics.stepsDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverFactory {
	public WebDriver driver;
	public WebDriverWait driverWait;
	
	public WebDriverFactory() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driverWait = new WebDriverWait(this.driver, 30);
	}
	
	public void quitDriver() {
		if (getDriver() != null) {
			this.driver.close();
			this.driver.quit();
		}
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public WebDriverWait getDriverWait() {
		return this.driverWait;
	}
}
