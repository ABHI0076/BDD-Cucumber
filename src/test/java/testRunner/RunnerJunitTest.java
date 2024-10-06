package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/featureFiles", glue = {
		"stepDefinitions" }, dryRun = false, monochrome = true, stepNotifications = true, plugin = { "pretty",
				"html:target/htmlReport/Regression.html" })
public class RunnerJunitTest {

}

/*
 * Cucumber can be executed in parallel using JUnit and Maven test execution
 * plugins. In JUnit the feature files are run in parallel rather than
 * scenarios, which means all the scenarios in a feature file will be executed
 * by the same thread. You can use either Maven Surefire or Failsafe plugin to
 * execute the runners.(Execute from pom.xml)
 */