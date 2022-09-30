package com.pack.PageObjectFramework.featureTest;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pack.PageObjectFramework.InvokeBrowser;
import com.pack.PageObjectFramework.constants.AmazonSignInConstants;
import com.pack.PageObjectFramework.constants.ApplicationConstants;
import com.pack.PageObjectFramework.constants.PaymentMethodPageConstants;
import com.pack.PageObjectFramework.constants.PlaceYourOrderConstants;
import com.pack.PageObjectFramework.constants.ProductPageConstants;
import com.pack.PageObjectFramework.constants.SearchPageConstants;
import com.pack.PageObjectFramework.data.AmazonHomePageTestData;
import com.pack.PageObjectFramework.data.AmazonSignInTestData;
import com.pack.PageObjectFramework.features.AmazonHomePage;
import com.pack.PageObjectFramework.features.AmazonMobileSearchPage;
import com.pack.PageObjectFramework.features.AmazonPaymentMethodPage;
import com.pack.PageObjectFramework.features.AmazonPlaceYourOrderPage;
import com.pack.PageObjectFramework.features.AmazonProductPage;
import com.pack.PageObjectFramework.features.AmazonSignInPage;
import com.pack.PageObjectFramework.utility.MyScreenRecorder;
import com.pack.PageObjectFramework.utility.Utilities;

public class AmazonPlaceOrder extends InvokeBrowser {

	public WebDriver driver;

	public static Logger log = LogManager.getLogger(AmazonPlaceOrder.class);

	@BeforeTest
	public void initializeBrowser() throws Exception {

		try {
			MyScreenRecorder.startRecording(ApplicationConstants.AMAZON_PAYMENT_RECORDING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver = initializeDriver();
		driver.get(ApplicationConstants.ECOMMERCE_URL);
		Assert.assertTrue(driver.getTitle().contains(ApplicationConstants.SITE_TITLE));
		log.info("URL Triggered Successfully");
	}

	@Test(priority = 1, dataProvider = "searchData", dataProviderClass = AmazonHomePageTestData.class)
	public void searchForItem(String searchItem) {

		AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
		amazonHomePage.searchInputBox().sendKeys(searchItem);
		log.info("The text " + '"' + searchItem + '"' + " is entered into the search box");
		amazonHomePage.searchButton().click();
		log.info("Search button is clicked");
	}

	@Test(priority = 2)
	public void searchResult() throws InterruptedException {

		AmazonMobileSearchPage amazonMobileSearchPage = new AmazonMobileSearchPage(driver);
		Assert.assertTrue(driver.getTitle().contains(SearchPageConstants.PAGE_TITLE));
		log.info("Navigated to Search Result Page");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				amazonMobileSearchPage.SearchResult());
		TimeUnit.SECONDS.sleep(2);
		amazonMobileSearchPage.SearchResult().click();
		log.info("Product icon is clicked");
	}

	@Test(priority = 3)
	public void buyNow() {

		AmazonProductPage amazonProductPage = new AmazonProductPage(driver);
		Utilities.switchToNewWindow(driver);
		Assert.assertTrue(driver.getTitle().contains(ProductPageConstants.PAGE_TITLE));
		log.info("Navigated to Desired product Page");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", amazonProductPage.buyNow());
		amazonProductPage.buyNow().click();
		log.info("Buy Now button is clicked");
	}

	@Test(priority = 4, dataProvider = "signIn", dataProviderClass = AmazonSignInTestData.class)
	public void signIn(String email, String password) {

		AmazonSignInPage amazonSignInPage = new AmazonSignInPage(driver);
		Assert.assertTrue(driver.getTitle().contains(AmazonSignInConstants.PAGE_TITLE));
		log.info("Navigated to Sign In Page");
		amazonSignInPage.email().sendKeys(email);
		log.info("The text " + '"' + email + '"' + " is entered into the email box");
		amazonSignInPage.next().click();
		log.info("Continue button is clicked");
		amazonSignInPage.password().sendKeys(password);
		log.info("The text " + '"' + password + '"' + " is entered into the password box");
		amazonSignInPage.signin().click();
		log.info("SignIn button is clicked");
	}

	@Test(priority = 5)
	public void paymentMethod() {

		AmazonPaymentMethodPage amazonPaymentMethodPage = new AmazonPaymentMethodPage(driver);
		Utilities.customWait(driver, amazonPaymentMethodPage.getPayOnDelivery());
		Assert.assertTrue(driver.getTitle().contains(PaymentMethodPageConstants.PAGE_TITLE));
		log.info("Navigated to Payment Method Page");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				amazonPaymentMethodPage.payOnDelivery());
		amazonPaymentMethodPage.payOnDelivery().click();
		log.info("Pay on delivery radio button is clicked");
		amazonPaymentMethodPage.next().click();
		log.info("Continue button is clicked");
	}

	@Test(priority = 6)
	public void placeYourOrder() {

		AmazonPlaceYourOrderPage amazonPlaceYourOrderPage = new AmazonPlaceYourOrderPage(driver);
		Utilities.customWait(driver, amazonPlaceYourOrderPage.getPlaceYourOrder());
		Assert.assertTrue(driver.getTitle().contains(PlaceYourOrderConstants.PAGE_TITLE));
		log.info("Navigated to Place your order Page");
	}

	@AfterTest
	public void teardown() throws Exception {

		driver.quit();
		log.info("The Browser is closed");
		try {
			MyScreenRecorder.stopRecording();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
