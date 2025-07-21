package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// Cucumber runner class to execute the feature file using JUnit.

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "C:\\Users\\vigne\\eclipse-workspace\\Cucumber_Framework\\src\\test\\resources\\features\\PTA_LoginFeature_Full.feature", 
	glue = "stepDefinitions", 
	dryRun = false, 
	monochrome = true,
	tags = "@regression",
	plugin = {
		"pretty", 
		"html:C:\\Users\\vigne\\eclipse-workspace\\Cucumber_Framework\\target\\cucumber-reports.html", 
		"json:C:\\Users\\vigne\\eclipse-workspace\\Cucumber_Framework\\target\\cucumber.json"
	}
)
public class RunnerClass {

}
