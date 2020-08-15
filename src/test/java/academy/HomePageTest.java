package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePageTest extends Base {

	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void setUp() throws IOException {
		driver = intializeDriver();
		log.info("Driver is initialized");	
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException {

		// Their are two ways of Accessing methods from different Class
		// 1. By using inheritance concept
		// 2. By creating object of that respected class

		driver.get(URL);
		log.info("URL is Launched");
		HomePage hp = new HomePage(driver);
		LoginPage lp= hp.login();
		lp.getUserName().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.academyLogin().click();
		log.info("LogIn into the Application");
		
		ForgotPassword fp = lp.getForgotPassword();
		fp.Username().sendKeys("abc123@gmail.com");
		fp.sendInstruction().click();
	}

	@DataProvider
	public Object[][] getData() {
		// row stands for how many set of data we want to test for
		// column stands for values per each test Case
		Object[][] data = new Object[2][2];

		data[0][0] = "test1@gmail.com";
		data[0][1] = "12345";
		data[1][0] = "test2@gmail.com";
		data[1][1] = "98765";

		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
