package com.JBK.project_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LandingPage extends Initialize{
	
	@FindBy(name="search[keywords]") private static WebElement txtSerach;
	@FindBy(xpath="//button[@type='submit']") private static WebElement btnSerach;
	@FindBy(linkText ="Login") private static WebElement linkLogin;
	@FindBy(linkText = "Register") private static WebElement linkRegister;
	
	@FindBy(xpath="//h2[text()='Search results']") private static WebElement validProductText;
	@FindBy(xpath="//li[text()='No products found.']")private static WebElement inValidProductText;
	
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
	}
	public void clickLogin()
	{
		linkLogin.click();
	}
	public void serachOurStore(String product)
	{
		txtSerach.sendKeys(product);
	}
	public void clickSearchButton()
	{
		btnSerach.click();
	}
	
	public String validProduct()
	{
		return validProductText.getText();
	}
	public String InValidProduct()
	{
		return inValidProductText.getText();
	}
	
	
	public void clickregister()
	{
		linkRegister.click();
	}
}
