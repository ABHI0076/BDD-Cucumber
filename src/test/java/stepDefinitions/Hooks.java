package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	/*
	@Before	--> Runs before each scenario.
	@After  --> Runs after each scenario.
	@BeforeStep	--> Runs before each step
	@AfterStep	--> Runs after each step.
	@BeforeAll	--> Runs before any scenario is run.
	@AfterAll	--> Runs after all scenario is run.
	
	CONDITIONAL HOOKS:
	
	Hooks can be conditionally selected for execution based on the tags of the scenario.
	
	Example:-
	
	@After("@browser and not @headless")
	*/
	
	// Runs after each scenario.
	@After
	public void teardown() throws IOException {
		testContextSetup.baseTest.webDriverManager().quit();
	}
	
	// Runs after each step.
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		// Below code executes after each step and checks if any step is failing or not. If failed means it will
		// take and attach the screenshot.
		// If we want to attach screenshot for each step then just remove the if condition in the code below.
		WebDriver driver = testContextSetup.baseTest.webDriverManager();
		if(scenario.isFailed()) {
		byte[] srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(srcFile, "image/png", "FailedScreen");
		}
		
	}

}
