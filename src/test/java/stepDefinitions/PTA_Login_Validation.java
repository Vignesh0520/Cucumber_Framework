package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.cucumber.java.en.When;
import pages.pojo.PracticeTestAutomation_LoginPage;

// Step definition class implementing login logic based on the feature file (PTA_LoginFeature.feature).

public class PTA_Login_Validation extends BaseClass {

	@When("I login with username {string} and password {string}")
	public void LoginPageValidationWithSingleInput(String username_data, String password_data) {

		System.out.println("\nLoginPageValidationWithSingleInput");
		browserLaunch("Chrome", "https://practicetestautomation.com/practice-test-login/");

		PracticeTestAutomation_LoginPage loginPage = new PracticeTestAutomation_LoginPage(getDriver());
		WebElement userName = loginPage.getUserName();
		WebElement password = loginPage.getPassword();
		WebElement submitBtn = loginPage.getSubmitBtn();
		WebElement usernameLabel = loginPage.getUsernameLabel();
		scrollIntoViewTrue(usernameLabel);
		userName.sendKeys(username_data);
		password.sendKeys(password_data);
		submitBtn.click();

		System.out.println("Login successful with username: " + username_data + " and password: " + password_data);
		closeAllBrowserWindow();
	}

	@When("I login using below credentials")
	public void LoginPageValidationWithMultipleInputs_DataTableWithoutHeaders(
			io.cucumber.datatable.DataTable dataTable) {

		System.out.println("\nLoginPageValidationWithMultipleInputs_DataTableWithoutHeaders");
		List<List<String>> inputCredentials = dataTable.asLists();
		for (List<String> rows : inputCredentials) {

			browserLaunch("Chrome", "https://practicetestautomation.com/practice-test-login/");

			String username_data = rows.get(0);
			String password_data = rows.get(1);

			PracticeTestAutomation_LoginPage loginPage = new PracticeTestAutomation_LoginPage(getDriver());
			WebElement userName = loginPage.getUserName();
			WebElement password = loginPage.getPassword();
			WebElement submitBtn = loginPage.getSubmitBtn();
			WebElement usernameLabel = loginPage.getUsernameLabel();
			scrollIntoViewTrue(usernameLabel);
			userName.sendKeys(username_data);
			password.sendKeys(password_data);
			submitBtn.click();

			System.out.println("Login successful with username: " + username_data + " and password: " + password_data);
			closeAllBrowserWindow();
		}
	}

	@When("I login using credentials with headers")
	public void LoginPageValidationWithMultipleInputs_DataTableWithHeaders(io.cucumber.datatable.DataTable dataTable) {

		System.out.println("\nLoginPageValidationWithMultipleInputs_DataTableWithHeaders");
		List<Map<String, String>> inputCredentials = dataTable.asMaps();
		for (Map<String, String> rows : inputCredentials) {

			browserLaunch("Chrome", "https://practicetestautomation.com/practice-test-login/");

			String username_data = rows.get("username");
			String password_data = rows.get("password");

			PracticeTestAutomation_LoginPage loginPage = new PracticeTestAutomation_LoginPage(getDriver());
			WebElement userName = loginPage.getUserName();
			WebElement password = loginPage.getPassword();
			WebElement submitBtn = loginPage.getSubmitBtn();
			WebElement usernameLabel = loginPage.getUsernameLabel();
			scrollIntoViewTrue(usernameLabel);
			userName.sendKeys(username_data);
			password.sendKeys(password_data);
			submitBtn.click();

			System.out.println("Login successful with username: " + username_data + " and password: " + password_data);
			closeAllBrowserWindow();

		}
	}

}
