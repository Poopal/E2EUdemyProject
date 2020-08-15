package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.xpath("//input[@type='email']");
	By password = By.id("user_password");
	By login = By.xpath("//input[@type='submit']");
	By forgotPassword = By.cssSelector("[href*='password/new']");

	public WebElement getUserName() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement academyLogin() {
		return driver.findElement(login) ;
	}
	
	public ForgotPassword getForgotPassword() {
		driver.findElement(forgotPassword).click();
		ForgotPassword fp = new ForgotPassword(driver);
		return fp;
	}

}
