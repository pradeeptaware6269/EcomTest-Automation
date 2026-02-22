package com.TestCase;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.JBK.Project_Base.BaseClass;
import com.JBK.project_Pages.RegisterPage;

public class RegisterPageTestCases extends BaseClass {
	@BeforeMethod
	public void openRegisterPage() {
		lp.clickregister();
	}

	@Test(priority = 0, dataProvider = "register_data", enabled = true)
	public void testRegister(String new_title, String new_firstName, String new_lastName, String new_email,
			long new_phone, long new_mobile, String new_password, String istrue) {

		register.title(new_title);
		register.first_name(new_firstName);
		register.last_name(new_lastName);
		register.email(new_email);
		register.phone(new_phone);
		register.mobile(new_mobile);
		register.password(new_password);
		register.checkbox1_termaCondition();
		register.checkbox2_Mailing();
		register.register_btn();

		if (istrue.equals("1")) {

			Assert.assertTrue(register.getSuccess().contains("Your email address has been added to our mailing list."),
					"Success message not displayed");

		} else if (istrue.equals("2")) {

			Assert.assertTrue(register.InvalideEmailMSG().contains("Please enter a valid email address."),
					"Invalid email validation failed");

		} else if (istrue.equals("3")) {

			Assert.assertTrue(true);

		} else if (istrue.equals("4")) {

			// Invalid phone
			Assert.assertTrue(true);

		} else if (istrue.equals("5")) {

			Assert.assertTrue(register.emptyFirstNameMSG().contains("Please enter your first name."),
					"Empty first name validation failed");

		} else if (istrue.equals("6")) {

			Assert.assertTrue(
					register.passwordErrorMSG().contains("Please enter at least 6 characters for your password."),
					"Password validation failed");
		}

	}

	@DataProvider(name = "register_data")
	public Object[][] data() {

		Object data[][] = {

				// Valid Data
				{ "Account", "Pradeep", "Taware", "pradeep@gmail.com", 8421077165L, 9876543210L, "Test@123", "1" },

				// Invalid Email
				{ "Account", "Ashitosh", "Patil", "ashugmail.com", 8421077165L, 9876543210L, "Test@123", "2" },

				// Invalid Phone (less digits)
				{ "Account", "Amit", "wagh", "amit@gmail.com", 84210771L, 9876543210L, "Test@123", "3" },

				// Invalid Mobile (more digits)
				{ "Account", "Sumit", "Thakre", "sumit@gmail.com", 8421077165L, 98765432101L, "Test@123", "4" },

				// Empty First Name
				{ "Account", "", "nale", "nale@gmail.com", 8421077165L, 9876543210L, "Test@123", "5" },

				// Weak Password
				{ "Account", "prathemesh", "More", "pathu@gmail.com", 8421077165L, 9876543210L, "12345", "6" } };

		return data;
	}

	@Test(priority = 1)
	public void verifyRegisterButton() {

		WebElement register_btn = RegisterPage.getRegister_btn();
		Assert.assertTrue(register_btn.isEnabled(), "Register Button not enabled");
	}

	@Test(priority = 2)
	public void verifyResetButton() {

		WebElement reset_btn = RegisterPage.getReset_btn();
		Assert.assertTrue(reset_btn.isEnabled(), "Reset Button not enabled");
	}

	@Test(priority = 3)
	public void verifyLoginHereLink() {

		WebElement loginhere = RegisterPage.getLoginHere_link();

		Assert.assertTrue(loginhere.isEnabled(), "Login Here link not Enabled");
	}

	@Test(priority = 4)
	public void verifyCheckboxes() {

		WebElement checkBox1 = RegisterPage.getCheckbox1_TermCondition();
		Assert.assertTrue(checkBox1.isSelected(), "Terms checkbox 1 Is already Selected");

		WebElement checkBox2 = RegisterPage.getCheckbox_mailing();
		Assert.assertTrue(checkBox2.isSelected(), "Mailing checkbox 2 is alrady Selected");
	}

	@Test(priority = 5)
	public void verifyHomeElement() {

		WebElement home = RegisterPage.getHome_element();
		Assert.assertTrue(home.isDisplayed());

	}

	@Test(priority = 5)
	public void verifyRegisterElement() {

		WebElement register = RegisterPage.getRegister_eleElement();
		Assert.assertTrue(register.isDisplayed());
	}

	@Test(priority = 6)
	public void verifyMyStore() {

		register.clickMyStore();
		Assert.assertEquals(register.myStoreSuccessMSG(), "Welcome to My Store");

	}

}