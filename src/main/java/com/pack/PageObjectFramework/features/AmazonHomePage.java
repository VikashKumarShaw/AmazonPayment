package com.pack.PageObjectFramework.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pack.PageObjectFramework.xpaths.AmazonHomePageXpath;

public class AmazonHomePage {
	WebDriver driver;

	public AmazonHomePage(WebDriver driver) {

		this.driver = driver;
	}

	By searchInputBox = By.id(AmazonHomePageXpath.SEARCH_INPUT_BOX);
	By searchButton = By.id(AmazonHomePageXpath.SEARCH_BUTTON);

	public WebElement searchInputBox() {
		return driver.findElement(searchInputBox);
	}

	public WebElement searchButton() {
		return driver.findElement(searchButton);
	}
}
