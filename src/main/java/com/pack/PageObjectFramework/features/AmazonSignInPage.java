package com.pack.PageObjectFramework.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pack.PageObjectFramework.xpaths.AmazonSignInXPath;

public class AmazonSignInPage {

	WebDriver driver;

	public AmazonSignInPage(WebDriver driver) {

		this.driver = driver;
	}

	By email = By.id(AmazonSignInXPath.EMAIL);
	By next = By.id(AmazonSignInXPath.CONTINUE);
	By password = By.id(AmazonSignInXPath.PASSWORD);
	By signin = By.id(AmazonSignInXPath.SIGNIN);

	public WebElement email() {
		return driver.findElement(email);
	}

	public WebElement next() {
		return driver.findElement(next);
	}

	public WebElement password() {
		return driver.findElement(password);
	}

	public WebElement signin() {
		return driver.findElement(signin);
	}

}
