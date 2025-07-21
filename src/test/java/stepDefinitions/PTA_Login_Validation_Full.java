package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.pojo.PracticeTestAutomation_LoginPage;

// Step definition class for Practice Test Automation login validation
public class PTA_Login_Validation_Full extends BaseClass {

	public String browserName;
	public String url;

	// Step to load browser and URL from properties file
	@Given("User is on the login page")
	public void browserLaunch() throws IOException {
		Properties properties = new Properties();
		String filePath = "C:\\Users\\vigne\\eclipse-workspace\\Cucumber_Framework\\src\\test\\resources\\config\\config.properties";
		FileInputStream fileInputStream = new FileInputStream(filePath);
		properties.load(fileInputStream);
		String browserName = properties.getProperty("BrowserName");
		this.browserName = browserName;
		String url = properties.getProperty("PTA_Login_URL");
		this.url = url;
	}

	// Step to perform login with given username and password (single user)
	@When("User enters {string} and {string}")
	public void loginValidationForGivenSingleUser(String username_data, String password_data)
			throws InterruptedException {

		// Launch browser with loaded browserName and url
		browserLaunch(browserName, url);

		// Initialize login page object
		PracticeTestAutomation_LoginPage loginPage = new PracticeTestAutomation_LoginPage(getDriver());
		WebElement userName = loginPage.getUserName();
		WebElement password = loginPage.getPassword();
		WebElement submitBtn = loginPage.getSubmitBtn();
		WebElement usernameLabel = loginPage.getUsernameLabel();

		// Scroll to username label for visibility
		scrollIntoViewTrue(usernameLabel);

		// Enter credentials and submit
		userName.sendKeys(username_data);
		password.sendKeys(password_data);
		submitBtn.click();

		// Validate the resulting URL based on credentials
		String currentUrl = getDriver().getCurrentUrl();
		String expectedUrl;
		if (username_data.equals("incorrectUser") || password_data.equals("incorrectPassword")) {
			expectedUrl = "https://practicetestautomation.com/practice-test-login/";
		} else {
			expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
		}
		Assert.assertEquals(expectedUrl, currentUrl);

		System.out.println("Validated with username: " + username_data + " and password: " + password_data);
	}

	// Step to perform login with given username and password (multiple users)
	@When("User enters with {string} and {string}")
	public void loginValidationForGivenMultipleUser(String username_data, String password_data)
			throws InterruptedException {

		// Launch browser with loaded browserName and url
		browserLaunch(browserName, url);

		// Initialize login page object
		PracticeTestAutomation_LoginPage loginPage = new PracticeTestAutomation_LoginPage(getDriver());
		WebElement userName = loginPage.getUserName();
		WebElement password = loginPage.getPassword();
		WebElement submitBtn = loginPage.getSubmitBtn();
		WebElement usernameLabel = loginPage.getUsernameLabel();

		// Scroll to username label for visibility
		scrollIntoViewTrue(usernameLabel);

		// Enter credentials and submit
		userName.sendKeys(username_data);
		password.sendKeys(password_data);
		submitBtn.click();

		// Validate the resulting URL based on credentials
		String currentUrl = getDriver().getCurrentUrl();
		String expectedUrl;
		if (username_data.equals("incorrectUser") || password_data.equals("incorrectPassword")) {
			expectedUrl = "https://practicetestautomation.com/practice-test-login/";
		} else {
			expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
		}
		Assert.assertEquals(expectedUrl, currentUrl);

		System.out.println("Validated with username: " + username_data + " and password: " + password_data);
	}

	// Step to close all browser windows
	@Then("Close the browser")
	public void close_the_browser() {
		closeAllBrowserWindow();
	}

}
