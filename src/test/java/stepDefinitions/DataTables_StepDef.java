package stepDefinitions;

import java.io.IOException;
import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.BasePage;
import pages.Home_Page;
import pages.Login_Page;
import pages.PageObjectManager;
import utils.BaseTest;
import utils.TestContextSetup;

public class DataTables_StepDef{
	BasePage basePage;
	Login_Page loginPage;
	Home_Page homePage;
	TestContextSetup testContextSetup;


	public DataTables_StepDef(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("User navigate to the URL")
	public void user_navigate_to_the_url(DataTable dataTable) {
		loginPage = testContextSetup.pageObjectManager.getLoginPage();
		loginPage.launchURL(dataTable.asList().get(0));
	}

	@When("User sign in to the application")
	public void user_sign_in_to_the_application(DataTable dataTable){
		List<String> ls = dataTable.row(0);
		loginPage = testContextSetup.pageObjectManager.getLoginPage();
		loginPage.loginToApp(ls.get(0), ls.get(1));
	}

	@Then("User validate the home page")
	public void user_validate_the_home_page(DataTable dataTable){
		homePage = testContextSetup.pageObjectManager.getHomePage();
		homePage.verifyHomePageTitle(dataTable.asList().get(0));
	}

}
