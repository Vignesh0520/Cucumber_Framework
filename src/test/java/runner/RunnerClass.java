package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\vigne\\eclipse-workspace\\Cucumber_Framework\\src\\test\\resources\\features\\Feature.feature", 
		glue = "stepDefinitions", 
		dryRun = true, 
		monochrome = true
		)
public class RunnerClass {

}
