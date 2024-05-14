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