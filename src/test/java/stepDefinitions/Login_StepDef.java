package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.*;
import pages.Home_Page;
import pages.Login_Page;
import pages.PageObjectManager;
import utils.BaseTest;
import utils.TestContextSetup;

public class Login_StepDef {
	Login_Page loginPage;
	Home_Page homePage;
	TestContextSetup testContextSetup;

	public Login_StepDef(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("User navigate to the {string}")
	public void user_navigate_to_the(String url) {
		loginPage = testContextSetup.pageObjectManager.getLoginPage();
		testContextSetup.basePage.launchURL(url);
	}

	@Given("User navigate to the URL using prop file")
	public void user_navigate_to_the_url_using_prop_file() {
		loginPage = testContextSetup.pageObjectManager.getLoginPage();
		String url = testContextSetup.baseTest.getPropertiesInstance().getProperty("QAUrl");
		System.out.println("URL form prop file is: "+url);
		testContextSetup.basePage.launchURL(url);
	}

	@When("User submit the {string} and {string}")
	public void user_enters_the_and(String userName, String pwd) {
		loginPage = testContextSetup.pageObjectManager.getLoginPage();
		loginPage.loginToApp(userName, pwd);
	}

	@Then("User should login successfully")
	public void user_should_login_successfully() {
		homePage = testContextSetup.pageObjectManager.getHomePage();
		homePage.verifyHomePageLogo();
	}

	@And("User validate the home page {string}")
	public void user_validate_the_home_page(String string) {
		homePage = testContextSetup.pageObjectManager.getHomePage();
		homePage.verifyHomePageTitle(string);
	}

	@When("User logout from the application")
	public void user_logout_from_the_application() {
		homePage = testContextSetup.pageObjectManager.getHomePage();
		homePage.logout();
//		homePage.teardown();
	}
}
