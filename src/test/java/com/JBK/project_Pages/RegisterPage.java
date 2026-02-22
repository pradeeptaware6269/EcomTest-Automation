package com.JBK.project_Pages;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;


	public class RegisterPage extends Initialize{

		
		@FindBy(linkText = "Login here") private static WebElement linkLogin;
		
		public RegisterPage(WebDriver driver)
		{
			super(driver);
		}
		
		public void clickLoginHere()
		{
			linkLogin.click();
			
		//	Assert.assertEquals(, null);
		}
		

	}


