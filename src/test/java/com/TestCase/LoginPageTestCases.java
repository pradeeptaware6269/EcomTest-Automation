package com.TestCase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.JBK.Project_Base.BaseClass;

public class LoginPageTestCases extends BaseClass {

	@Test(dataProvider = "loginData")
	public void testLogin(String userName, String passWord, String istrue) {
		lp.clickLogin();
		login.enterEmail(userName);
		login.enterPassword(passWord);
		login.clickLigin();

		// For Valide data
		if (istrue.equals("1")) {
			Assert.assertEquals(driver.getCurrentUrl(), "https://javabykiran.in/other/CC/index.php?_a=account");
		}
		// For Invalide Username
		else if (istrue.equals("2")) {
			Assert.assertEquals(login.userNameError(), "Please enter a valid email address.");

		}
		// For Invalide Password && invalide Username Also
		else if (istrue.equals("3")) {
			Assert.assertEquals(login.userPassError(), "Invalid username or password");
		}
		// For Empty
		else if (istrue.equals("4")) {
			Assert.assertEquals(login.userNameError(), "Please enter a valid email address.");

		}

	}

	@DataProvider(name = "loginData")
	public Object[][] provideData1() {

		Object[][] data = { { "iranna@gmail.com", "Iranna@123", "1" }, { "test12321d", "wrongpass", "2" },
				{ "pradeep@gmail.com", "pradeep@123", "3" }, { "", "", "4" } };

		return data;
	}

}
