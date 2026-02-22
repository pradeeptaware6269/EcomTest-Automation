package com.JBK.project_Pages;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	public class LoginPage extends Initialize{

		
		@FindBy(id="login-username") private static WebElement txtEmail;
		@FindBy(id="login-password") private static WebElement txtPassword;
		@FindBy(xpath="//button[@name='submit']") private static WebElement btnLogin;
		
		@FindBy(xpath = "//small[@id=\"login-username-error\"]") private static WebElement usernameError;
		@FindBy(xpath = "//*[@id=\"main_content\"]/div[1]/ul/li") private static WebElement userPassError;
		
		public LoginPage(WebDriver driver)
		{
			super(driver);
		}
		
		
		
		public void enterEmail(String email)
		{
			txtEmail.sendKeys(email);
		}
		public void enterPassword(String password)
		{
			txtPassword.sendKeys(password);
		}
		public void clickLigin()
		{
			btnLogin.click();
		}
		public String userNameError()
		{
			return usernameError.getText();
		}
		public String userPassError()
		{
			return userPassError.getText();
		}
	}


