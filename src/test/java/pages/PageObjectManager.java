package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import utils.BaseTest;

public class PageObjectManager {

	public WebDriver driver;
	public Login_Page loginPage;
	public Home_Page homePage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public Login_Page getLoginPage(){
		loginPage = new Login_Page(driver);
		return loginPage;
	}
	
	public Home_Page getHomePage(){
		homePage = new Home_Page(driver);
		return homePage;
	}
}
