package com.pack.PageObjectFramework.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pack.PageObjectFramework.xpaths.AmazonPaymentMethodXPath;

public class AmazonPaymentMethodPage {

	WebDriver driver;

	public AmazonPaymentMethodPage(WebDriver driver) {

		this.driver = driver;
	}

	By payOnDelivery = By.xpath(AmazonPaymentMethodXPath.PAY_ON_DELIVERY);
	By next = By.xpath(AmazonPaymentMethodXPath.CONTINUE);

	public By getPayOnDelivery() {
		return payOnDelivery;
	}

	public By getNext() {
		return next;
	}

	public WebElement payOnDelivery() {
		return driver.findElement(payOnDelivery);
	}

	public WebElement next() {
		return driver.findElement(next);
	}

}
