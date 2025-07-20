package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// Cucumber runner class to execute the feature file using JUnit.

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\vigne\\eclipse-workspace\\Cucumber_Framework\\src\\test\\resources\\features\\PTA_LoginFeature.feature", 
				 glue = "stepDefinitions", 
				 dryRun = false, 
				 monochrome = true)
public class RunnerClass {

}
