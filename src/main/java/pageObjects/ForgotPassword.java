package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	public ForgotPassword(WebDriver driver) {
		this.driver=driver;
	}
	
	WebDriver driver;

	By getEMail = By.id("user_email");
	By sendButton = By.cssSelector("input[value='Send Me Instruction']");
	
	public WebElement Username() {
		return driver.findElement(getEMail);
	}
	
	public WebElement sendInstruction() {
		return driver.findElement(sendButton);
	}
	
	
}
