package pages.pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinHotelSearchPage {

	// Adactin hotel search page --> https://adactinhotelapp.com/SearchHotel.php

	public AdactinHotelSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@name='location']")
	private WebElement location;

	@FindBy(name = "hotels")
	private WebElement hotel;

	@FindBy(id = "room_type")
	private WebElement roomType;

	@FindBy(name = "room_nos")
	private WebElement noOfRooms;

	@FindBy(name = "datepick_in")
	private WebElement checkInDate;

	@FindBy(name = "datepick_out")
	private WebElement checkOutDate;

	@FindBy(id = "adult_room")
	private WebElement adultCount;

	@FindBy(id = "child_room")
	private WebElement childrenCount;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement searchBtn;

	public WebElement getLocation() {
		return location;
	}

	public void setLocation(WebElement location) {
		this.location = location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public void setHotel(WebElement hotel) {
		this.hotel = hotel;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public void setRoomType(WebElement roomType) {
		this.roomType = roomType;
	}

	public WebElement getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(WebElement noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(WebElement checkInDate) {
		this.checkInDate = checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(WebElement checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public WebElement getAdultCount() {
		return adultCount;
	}

	public void setAdultCount(WebElement adultCount) {
		this.adultCount = adultCount;
	}

	public WebElement getChildrenCount() {
		return childrenCount;
	}

	public void setChildrenCount(WebElement childrenCount) {
		this.childrenCount = childrenCount;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(WebElement searchBtn) {
		this.searchBtn = searchBtn;
	}

}
