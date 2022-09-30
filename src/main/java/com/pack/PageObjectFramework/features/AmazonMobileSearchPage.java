package com.pack.PageObjectFramework.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pack.PageObjectFramework.xpaths.AmazonSearchResultXPath;

public class AmazonMobileSearchPage {

	WebDriver driver;

	public AmazonMobileSearchPage(WebDriver driver) {

		this.driver = driver;
	}

	By searchResult = By.xpath(AmazonSearchResultXPath.SEARCH_RESULT);

	public WebElement SearchResult() {
		return driver.findElement(searchResult);
	}

}
