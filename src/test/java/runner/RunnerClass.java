package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import Reporting.JVM_Report;

// Cucumber runner class to execute the feature file using JUnit.

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\vigne\\eclipse-workspace\\Cucumber_Framework\\src\\test\\resources\\features", 
		glue = "stepDefinitions", 
		dryRun = false, 
		monochrome = true, 
		tags = "@regression", 
		plugin = {	
				"pretty",
				"html:C:\\Users\\vigne\\eclipse-workspace\\Cucumber_Framework\\target\\cucumber-html-report\\cucumber-reports.html",
				"json:C:\\Users\\vigne\\eclipse-workspace\\Cucumber_Framework\\target\\cucumber-report\\cucumber.json" })
public class RunnerClass {

	@AfterClass
	public static void createJVMReport() {

		// Generate JVM report after all tests are executed
		String jsonFilePath = "C:\\Users\\vigne\\eclipse-workspace\\Cucumber_Framework\\target\\cucumber-report\\cucumber.json";
		String reportOutputPath = "C:\\Users\\vigne\\eclipse-workspace\\Cucumber_Framework\\target\\cucumber-jvm-report";
		JVM_Report.generateJVMReport(jsonFilePath, reportOutputPath);

	}

}
