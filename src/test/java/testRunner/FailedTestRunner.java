package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failed_scenarios.txt", glue = {
		"stepDefinitions" }, monochrome = true,plugin = { "pretty",
				"html:target/htmlReport/Regression.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"})

public class FailedTestRunner extends AbstractTestNGCucumberTests {

	// For Parallel Test Execution.
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
