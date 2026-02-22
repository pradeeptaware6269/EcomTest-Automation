package com.TestCase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.JBK.Project_Base.BaseClass;

public class LandingPageTestCases extends BaseClass {

	// =====================================
	// Subscribe Email Test
	// =====================================

	@Test(priority = 1, dataProvider = "emailData", enabled = true)
	public void subscribedMail(String email, String isTrue) {

		lp.enterSubscribeEmail(email);
		lp.clickSubscribe();

		System.out.println("Subscribed Email : " + email);

		// VALID EMAIL
		if (isTrue.equals("1")) {
			Assert.assertTrue(lp.emailSUccessMSG().contains("Your email address has been added to our mailing list."),
					"Valid email subscription failed");
		}

		// INVALID EMAIL
		else if (isTrue.equals("2")) {
			Assert.assertTrue(lp.emailError().contains("Please enter a valid email address."),
					"Invalid email validation failed");
		}
	}

	@DataProvider(name = "emailData")
	public Object[][] emailData() {

		return new Object[][] { { "test@gmail.com", "1" }, { "automation@test.com", "1" }, { "demo12234", "2" } };
	}

	// =====================================
	// Search Product Test
	// =====================================

	@Test(priority = 2, dataProvider = "td", enabled = true)
	public void searchProduct(String product, String isValid) {

		lp.serachOurStore(product);
		lp.clickSearchButton();

		if (isValid.equals("1")) {
			Assert.assertEquals(lp.validProduct(), "Product Found,Search results", "Valid product search failed");
		}

		else if (isValid.equals("2")) {
			Assert.assertEquals(lp.InValidProduct(), "No products found.", "Invalid product search validation failed");
		}
	}

	@DataProvider(name = "td")
	public Object[][] testData() {

		return new Object[][] { { "laptop", "1" }, { "Mobile", "1" }, { "rocket", "2" }, { "gmail.com", "2" },
				{ "12345", "2" } };
	}
//Footer

	@Test(priority = 3)
	public void verifyLinkedin() {
		Assert.assertTrue(lp.isLinkedinDisplayed(), "LinkedIn icon not displayed");
	}

	@Test(priority = 4)
	public void verifyFacebook() {
		Assert.assertTrue(lp.isFacebookDisplayed(), "Facebook icon not displayed");
	}

	@Test(priority = 5)
	public void verifyTwitter() {
		Assert.assertTrue(lp.isTwitterDisplayed(), "Twitter icon not displayed");
	}

	@Test(priority = 6)
	public void verifyVimeo() {
		Assert.assertTrue(lp.isVimeoDisplayed(), "Vimeo icon not displayed");
	}

	@Test(priority = 7)
	public void verifyCubeCart() {
		Assert.assertTrue(lp.isCubeCartDisplayed(), "CubeCart link not displayed");
	}

	// Header Section Validation

	@Test(priority = 8)
	public void verifySmartProduct() {
		Assert.assertTrue(lp.isSmartProductEnabled(), "Smart product not enabled");
	}

	@Test(priority = 9)
	public void verifySaleItem() {
		Assert.assertTrue(lp.isSaleItemEnable(), "Sale item not enabled");
	}

	@Test(priority = 10)
	public void verifyBasket() {
		Assert.assertTrue(lp.basketEnabled(), "Basket option not enabled");
	}
}