package com.pack.PageObjectFramework.utility;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pack.PageObjectFramework.constants.ApplicationConstants;

public class Utilities {
	
	public static Logger log = LogManager.getLogger(Utilities.class);

	public void tryClick(By by, int noOfTry, WebDriver driver) throws Exception {
		for (int i = 0; i < noOfTry; i++) {
			try {
				driver.findElement(by).click();
				break;
			} catch (Exception exe) {
				Thread.sleep(1000);
			}
		}
	}

	public static void customWait(WebDriver driver, By by) {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public String takeScreenShot(WebDriver driver, String testCaseName) {

		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File source = screenShot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty(ApplicationConstants.BASE_DIRECTORY)
				+ ApplicationConstants.SCREENSHOT_PATH + testCaseName + ApplicationConstants.SCREENSHOT_FORMAT;
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}
	
	public static void switchToNewWindow(WebDriver driver) {
		try {
		Set<String> windows =  driver.getWindowHandles();
		String currentWindow = driver.getWindowHandle();
		
		for(String window : windows) {
			if(!currentWindow.equals(window)) {
				driver.switchTo().window(window);
				log.info("The switch to new window is successful");
			}
		}
		}catch (Exception e) {
			log.info("The switch to new window is failed" + "\n" + e);
			Assert.assertTrue(false);
		}
	}

}
