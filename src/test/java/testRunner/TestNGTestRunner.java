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
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}

/*
tags = "@Smoke or @Regression"
tags = "@Smoke and @Regression"
tags = "@Smoke or not @Regression"
tags = "@Smoke and not @Regression"
*/

/* 
--> For Parallel Test Execution.
--> It Facilitate parallel execution at 'scenario' level.
--> The super class scenarios() returns a 2-D array of all the scenarios.
--> TestNG then executes all the scenarios in a separate thread(if parallel = true).
--> The scenarios and rows of the scenario outlines(Examples:) are executed in different threads.
*/

/*
* The default thread count of the dataprovider in parallel mode is 10. To
* change this the dataproviderthreadcount property needs to be added to the
* configuration section of the Surefire or Failsafe plugin in the POM
*/


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