package com.TestCase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.JBK.Project_Base.BaseClass;

public class LandingPageTestCases extends BaseClass {

	@Test(dataProvider = "td", enabled = true)
	public void searchproduct(String product, String isValid) {

		lp.serachOurStore(product);
		lp.clickSearchButton();

		// For valide data
		if (isValid.equals("1")) {
			Assert.assertEquals(lp.validProduct(), "Product Found,Search results");
		}
		// For Invalide Data
		else if (isValid.equals("2")) {
			Assert.assertEquals(lp.InValidProduct(), "No products found.");
		}
	}

	@DataProvider(name = "td")
	public Object[][] testData() {

		Object data[][] = { { "laptop", "1" }, { "Mobile", "1" }, { "rocket", "2" }, { "gmail.com", "2" },
				{ "12345", "2" } };

		return data;
	}
}