package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import utils.BaseTest;

public class BasePage {
	public WebDriver driver;
	public BasePage(WebDriver driver){
		this.driver=driver;
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


	public void launchURL(String url) {
		driver.navigate().to(url);
		waitforPageLoad(10);
	}

	public void click(WebElement ele) {
		waitforVisibilityOfElement(ele);
		waitforElementToBeClickable(ele);
		ele.click();
	}

	public void sendkeys(WebElement ele, String str) {
		waitforVisibilityOfElement(ele);
		waitforElementToBeClickable(ele);
		ele.sendKeys(str);
	}

	public void waitforPageLoad(int seconds) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
	}
	public void waitforElementToBeClickable(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public void waitforVisibilityOfElement(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}	

}
