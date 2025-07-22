package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {
	
	@BeforeAll
	public static void globalSetup() {
	    System.out.println("Run once - Before all scenarios");
	}
	
	@Before
	public void setUp() {
	    System.out.println("Launching browser...");
	}
	
	@Before("@regression")
	public void beforeRegressionScenarios() {
	    System.out.println("Setup for regression scenarios only...");
	}
	
	@BeforeStep
	public void beforeStep() {
	    System.out.println("Before each step...");
	}
	
	public void afterStep() {
	    System.out.println("After each step...");
	}
	
	@After("@regression")
	public void afterRegressionScenarios() {
	    System.out.println("Teardown for regression scenarios only...");
	}
	
	@After
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	        TakesScreenshot ts = (TakesScreenshot) getDriver();
	        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
	        scenario.attach(screenshot, "image/png", "Failed Scenario Screenshot");
	    }
	    System.out.println("Closing browser...");
	}
	
	@AfterAll
	public static void globalTeardown() {
	    System.out.println("Run once - After all scenarios");
	}

}
