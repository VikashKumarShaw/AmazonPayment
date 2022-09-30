package com.pack.PageObjectFramework.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pack.PageObjectFramework.xpaths.AmazonProductPageXPath;

public class AmazonProductPage {

	WebDriver driver;

	public AmazonProductPage(WebDriver driver) {

		this.driver = driver;
	}

	By buyNow = By.id(AmazonProductPageXPath.BUY_NOW);

	public WebElement buyNow() {
		return driver.findElement(buyNow);
	}

}
