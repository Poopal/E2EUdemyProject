package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;

public class VerifyTitleTest extends Base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException {
		driver = intializeDriver();
	}

	@Test
	public void verifyTitle() throws IOException {
		// Their are two ways of Accessing methods from different Class
		// 1. By using inheritance concept
		// 2. By creating object of that respected class
		driver.get(URL);
		HomePage hp = new HomePage(driver);
		WebElement link = hp.getLink();
		log.info("Home Page is login Link is available");
		Assert.assertEquals(link.getText(), "FEATURED COURSES");
		boolean status = hp.getNavigationBar().isDisplayed();
		log.info("Navigation bar is displayed");
		Assert.assertEquals(status, true);
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
