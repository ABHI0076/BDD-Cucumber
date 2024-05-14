package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pages.BasePage;
import pages.PageObjectManager;

public class TestContextSetup {
	public PageObjectManager pageObjectManager;
	public BaseTest baseTest;
	public BasePage basePage;

	public TestContextSetup() throws IOException {
		baseTest = new BaseTest();
		pageObjectManager = new PageObjectManager(baseTest.webDriverManager());
		basePage = new BasePage(baseTest.webDriverManager());
	}

}
