package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/featureFiles", glue = {
		"stepDefinitions" }, dryRun = false, monochrome = true, tags = "@Smoke or @Regression", plugin = { "pretty",
				"html:target/htmlReport/Regression.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	// For Parallel Test Execution.
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}

// TERMINAL EXECUTION

// To run from command line:(This will take preferences over CucumberOptions)

/* 1. mvn test
   2. mvn test -Dcucumber.filter.tags="@Smoke"
   3. mvn test -Dcucumber.glue=""
   4. mvn test -Dcucumber.feature=""
   5. mvn test -Dcucumber.plugin=""
   6. mvn test -Dcucumber.execution.dry-run="true"
   7. etc(Follow official documentation) */

// We can provide browser parameter as well.

/* 1. mvn test -Dcucumber.filter.tags="@Smoke" -Dbrowser=chrome
 * 2. mvn test -Dbrowser=chrome
 */

// JENKINS


/* 1. Start server from terminal(Macbook)--> brew services start jenkins-lts
 * 2. Start server from terminal(Windows)--> java -jar jenkins.war -httpPort=8080
 */