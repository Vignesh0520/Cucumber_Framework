package pages.pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeTestAutomation_LoginPage {
	
	// Page Object Model (POM) class for the Practice Test Automation Login Page
	
	public PracticeTestAutomation_LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement submitBtn;

	@FindBy(xpath = "//label[text()='Username']")
	private WebElement usernameLabel;

	public WebElement getUserName() {
		return userName;
	}

	public void setUserName(WebElement userName) {
		this.userName = userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void setSubmitBtn(WebElement submitBtn) {
		this.submitBtn = submitBtn;
	}

	public WebElement getUsernameLabel() {
		return usernameLabel;
	}

	public void setUsernameLabel(WebElement usernameLabel) {
		this.usernameLabel = usernameLabel;
	}
}
