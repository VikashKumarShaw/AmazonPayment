package com.pack.PageObjectFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.pack.PageObjectFramework.constants.ApplicationConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokeBrowser {
	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(ApplicationConstants.PROPERTY_FILE_PATH);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String browserName = prop.getProperty("browser");
		if (browserName.equals(ApplicationConstants.CHROME)) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeoption =  new ChromeOptions();
			chromeoption.addArguments("--incognito");
			driver = new ChromeDriver(chromeoption);
		} else if (browserName.equals(ApplicationConstants.FIREFOX)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals(ApplicationConstants.EDGE)) {
			WebDriverManager.edgedriver();
			driver = new EdgeDriver();
		} else {
			WebDriverManager.iedriver();
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(ApplicationConstants.GLOBAL_TMEOUT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

}
