package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;

	public WebDriver webDriverManager() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/Global.properties");
		getPropertiesInstance().load(fis);
		
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
		//To read browser provided at run time in Maven, use Java ternary Operator concept.
		// result = testCondition ? value1 : value2
		
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		
		if (driver == null) {
			if (browser.trim().equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			} else if (browser.trim().equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			} else if (browser.trim().equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			}
		}
		return driver;
	}
	public Properties getPropertiesInstance() {
		if(prop==null) {
		prop = new Properties();
		}
		return prop;
	}

}
