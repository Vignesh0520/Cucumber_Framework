package stepDefinitions;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.pojo.AdactinHotelSearchPage;
import pages.pojo.AdactinHotelSearchResults;
import pages.pojo.AdactinLoginPage;

public class AdactinHotelReservationSystem extends BaseClass {

	AdactinLoginPage adactinLoginPage;
	AdactinHotelSearchPage adactinHotelSearchPage;
	AdactinHotelSearchResults adactinHotelSearchResults;

	// AdactinLoginPage --> https://adactinhotelapp.com/

	@Given("The user is on the Adactin login page")
	public void the_user_is_on_the_adactin_login_page() {

		browserLaunch("Chrome", "https://adactinhotelapp.com/");

	}

	@When("The user logs in with username {string} and password {string}")
	public void the_user_logs_in_with_username_and_password(String usernameInput, String passwordInput) {

		adactinLoginPage = new AdactinLoginPage(getDriver());
		WebElement username = adactinLoginPage.getUsername();
		WebElement password = adactinLoginPage.getPassword();
		WebElement loginBtn = adactinLoginPage.getLoginBtn();
		username.sendKeys(usernameInput);
		password.sendKeys(passwordInput);
		loginBtn.click();

	}

	@Then("The user should be logged in successfully")
	public void the_user_should_be_logged_in_successfully() throws InterruptedException {

		staticWait(250);
		@Nullable
		String currentUrl = getDriver().getCurrentUrl();
		String expectedUrl = "https://adactinhotelapp.com/SearchHotel.php";
		Assert.assertEquals(currentUrl, expectedUrl);
		System.out.println("User Logged in successfully");

	}

	// Adactin hotel search page --> https://adactinhotelapp.com/SearchHotel.php

	@Given("The user is on the Adactin hotel search page")
	public void the_user_is_on_the_adactin_hotel_search_page() throws InterruptedException {

		staticWait(250);
		@Nullable
		String currentUrl = getDriver().getCurrentUrl();
		String expectedUrl = "https://adactinhotelapp.com/SearchHotel.php";
		Assert.assertEquals(currentUrl, expectedUrl);
		System.out.println("User is on Adactin hotel search page");

	}

	@When("The user selects the location as {string}, hotel as {string}, and room type as {string}")
	public void the_user_selects_the_location_as_hotel_as_and_room_type_as(String location, String hotel,
			String roomtype) throws InterruptedException {

		adactinHotelSearchPage = new AdactinHotelSearchPage(getDriver());

		WebElement location2 = adactinHotelSearchPage.getLocation();
		WebElement hotel2 = adactinHotelSearchPage.getHotel();
		WebElement roomType2 = adactinHotelSearchPage.getRoomType();
		WebElement noOfRooms = adactinHotelSearchPage.getNoOfRooms();
		WebElement checkInDate = adactinHotelSearchPage.getCheckInDate();
		WebElement checkOutDate = adactinHotelSearchPage.getCheckOutDate();
		WebElement adultCount = adactinHotelSearchPage.getAdultCount();
		WebElement childrenCount = adactinHotelSearchPage.getChildrenCount();
		WebElement searchBtn = adactinHotelSearchPage.getSearchBtn();

		Select locationSelect = new Select(location2);
		List<WebElement> locationsOptions = locationSelect.getOptions();
		System.out.println("\nLocation lists are : ");
		for (WebElement locationList : locationsOptions) {
			String hotelLocation = locationList.getText();
			System.out.println(hotelLocation);
		}
		locationSelect.selectByVisibleText(location); // location --> Sydney

		Select hotelSelect = new Select(hotel2);
		List<WebElement> hotelOptions = hotelSelect.getOptions();
		System.out.println("\nHotel lists in " + location + " are : ");
		for (int i = 0; i < hotelOptions.size(); i++) {
			String hotelName = hotelOptions.get(i).getText();
			System.out.println(hotelName);
		}
		hotelSelect.selectByVisibleText(hotel); // hotel --> Hotel Creek

		Select roomTypeSelect = new Select(roomType2);
		List<WebElement> roomTypeOptions = roomTypeSelect.getOptions();
		System.out.println("\nRoom Type lists in " + hotel + " are : ");
		for (WebElement type : roomTypeOptions) {
			String hotelRoomType = type.getText();
			System.out.println(hotelRoomType);
		}
		roomTypeSelect.selectByVisibleText(roomtype); // roomtype --> Super Deluxe

		Select noOfRoomsSelect = new Select(noOfRooms);
		System.out.println("\nNumber of rooms lists available in Hotel Creek are : ");
		List<WebElement> noOfRoomsOptions = noOfRoomsSelect.getOptions();
		for (WebElement number : noOfRoomsOptions) {
			String noOfRoomsBooking = number.getText();
			System.out.println(noOfRoomsBooking);
		}
		noOfRoomsSelect.selectByVisibleText("5 - Five");

		checkInDate.sendKeys("05/08/2025");

		checkOutDate.sendKeys("07/08/2025");

		Select adultCountSelect = new Select(adultCount);
		System.out.println("\nNumber of adults allowed list available in Hotel Creek are : ");
		List<WebElement> adultCountOptions = adultCountSelect.getOptions();
		for (WebElement count : adultCountOptions) {
			String adultCountAvailable = count.getText();
			System.out.println(adultCountAvailable);
		}
		adultCountSelect.selectByVisibleText("2 - Two");

		Select childrenCountSelect = new Select(childrenCount);
		System.out.println("\nNumber of children allowed in Hotel Creek are : ");
		List<WebElement> childrenCountOptions = childrenCountSelect.getOptions();
		for (WebElement childCount : childrenCountOptions) {
			String childCountAllowed = childCount.getText();
			System.out.println(childCountAllowed);
		}
		childrenCountSelect.selectByVisibleText("1 - One");

		staticWait(1000);
		searchBtn.click();

	}

	// Search Results - Select hotel and continue

	@Given("The hotel search results are displayed")
	public void the_hotel_search_results_are_displayed() {

		WebElement searchResults = findElementByXpath("//td[text()='Select Hotel ']");
		boolean displayed = searchResults.isDisplayed();
		Assert.assertTrue(displayed);
		System.out.println("Search results are displayed");

	}

	@When("The user selects a hotel from the list and clicks on the Continue button")
	public void the_user_selects_a_hotel_from_the_list_and_clicks_on_the_continue_button() {

		adactinHotelSearchResults = new AdactinHotelSearchResults(getDriver());
		WebElement radioButton = adactinHotelSearchResults.getRadioButton();
		WebElement continueButton = adactinHotelSearchResults.getContinueButton();
		radioButton.click();
		continueButton.click();

	}

	@Then("The user should be navigated to the hotel booking page")
	public void the_user_should_be_navigated_to_the_hotel_booking_page() throws InterruptedException {

		staticWait(250);
		@Nullable
		String currentUrl = getDriver().getCurrentUrl();
		String expectedUrl = "https://adactinhotelapp.com/BookHotel.php";
		Assert.assertEquals(currentUrl, expectedUrl);
		System.out.println("User is on Adactin hotel booking page");
		closeAllBrowserWindow();
	}

}
