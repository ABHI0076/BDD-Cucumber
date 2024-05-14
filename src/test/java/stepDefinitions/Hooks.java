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

	@After
	public void teardown() throws IOException {
		testContextSetup.baseTest.webDriverManager().quit();
	}

	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		WebDriver driver = testContextSetup.baseTest.webDriverManager();
		if(scenario.isFailed()) {
		byte[] srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(srcFile, "image/png", "FailedScreen");
		}
	}

}
