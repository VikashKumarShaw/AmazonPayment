package com.pack.PageObjectFramework.data;

import org.testng.annotations.DataProvider;

public class AmazonHomePageTestData {
	@DataProvider(name = "searchData")
	public Object[] SearchData() {

		return new Object[] { "Redmi mobile" };

	}

}
