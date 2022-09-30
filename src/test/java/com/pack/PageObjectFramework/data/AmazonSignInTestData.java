package com.pack.PageObjectFramework.data;

import org.testng.annotations.DataProvider;

import com.pack.PageObjectFramework.constants.AmazonSignInConstants;

public class AmazonSignInTestData {

	@DataProvider(name = "signIn")
	public Object[][] SearchData() {

		return new Object[][] { { AmazonSignInConstants.EMAIL, AmazonSignInConstants.PASSWORD} };

	}

}
