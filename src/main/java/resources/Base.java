package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	
	public WebDriver driver;
	public Properties prop;
	public String URL;
	public WebDriver intializeDriver() throws IOException {
		
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		URL = prop.getProperty("url");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\2905p\\Downloads\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver = new ChromeDriver();
			
			//HeadLess Browser
//			ChromeOptions options = new ChromeOptions();
//			driver = new ChromeDriver(options);
//			options.addArguments("headless");
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.FirefoxDriver.driver",
					"C:\\Users\\2905p\\Downloads\\chromedriver_win32\\FirefoxDriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			 driver = new FirefoxDriver();	
		}
		else if(browserName.equalsIgnoreCase("internetExplorer")) {
			System.setProperty("webdriver.InternetExplorerDriver.driver",
					"C:\\Users\\2905p\\Downloads\\chromedriver_win32\\InternetExplorerDriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			 driver = new InternetExplorerDriver();
		}
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	return driver;
	}
	
	public void takeScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE );
		String destinationFile = System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		FileUtils.copyFile(src, new File(destinationFile));
		
	}
	
	
}
