package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By login = By.cssSelector("a[href*='sign_in']");
	By courses = By.xpath("//div[@class='text-center']/h2");
	By navigationBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	

	public LoginPage login() {
		driver.findElement(login).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	
	public WebElement getLink() {
		return driver.findElement(courses);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navigationBar);
	}

}
