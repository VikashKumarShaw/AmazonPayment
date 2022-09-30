package com.pack.PageObjectFramework.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonPlaceYourOrderPage {

	WebDriver driver;

	public AmazonPlaceYourOrderPage(WebDriver driver) {

		this.driver = driver;
	}

	By placeYourOrder = By.id("placeYourOrder");
	
	public WebElement placeYourOrder() {
		return driver.findElement(placeYourOrder);
	}

	public By getPlaceYourOrder() {
		return placeYourOrder;
	}

}
