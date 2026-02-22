package com.JBK.project_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends Initialize {

	@FindBy(name = "search[keywords]")
	private static WebElement txtSerach;
	@FindBy(xpath = "//button[@type='submit']")
	private static WebElement btnSerach;
	@FindBy(linkText = "Login")
	private static WebElement linkLogin;
	@FindBy(linkText = "Register")
	private static WebElement linkRegister;

	@FindBy(xpath = "//h2[text()='Search results']")
	private static WebElement validProductText;
	@FindBy(xpath = "//li[text()='No products found.']")
	private static WebElement inValidProductText;

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	public void clickLogin() {
		linkLogin.click();
	}

	public void serachOurStore(String product) {
		txtSerach.sendKeys(product);
	}

	public void clickSearchButton() {
		btnSerach.click();
	}

	public String validProduct() {
		return validProductText.getText();
	}

	public String InValidProduct() {
		return inValidProductText.getText();
	}

	public void clickregister() {
		linkRegister.click();
	}

	// ================= HEADER =================

	@FindBy(id = "basket-summary")
	private WebElement basketBox;

	@FindBy(id = "box-currency")
	private WebElement currencyBox;

	@FindBy(name = "search[keywords]")
	private WebElement txtSearch;

	@FindBy(xpath = "//button[@title='Search']")
	private WebElement searchBtn;

	@FindBy(linkText = "Login")
	private WebElement loginBtn;

	@FindBy(linkText = "Register")
	private WebElement registerBtn;

	@FindBy(linkText = "Advanced Search")
	private WebElement advancedSearchBtn;

	@FindBy(xpath = "//a[@title='Home']")
	private WebElement homeBtn;

	@FindBy(linkText = "smart")
	private WebElement smartProduct;

	@FindBy(linkText = "Sale Items")
	private WebElement saleItems;

	// ================= BODY =================

	@FindBy(xpath = "//h1[text()='Welcome to My Store']")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//*[@id=\"content_homepage\"]/div/div[2]/div[1]/a[2]")
	private WebElement rightClick;
	
	@FindBy(xpath = "//*[@id=\"content_homepage\"]/div/div[2]/div[1]/a[1]")
	private WebElement leftclick;
	
	

	

	// ================= FOOTER =================

	@FindBy(linkText = "About Us")
	private WebElement aboutUs;

	@FindBy(linkText = "Terms and Conditions")
	private WebElement terms;

	@FindBy(linkText = "Returns Policy")
	private WebElement returns;

	@FindBy(linkText = "Privacy Policy")
	private WebElement privacy;

	@FindBy(linkText = "Contact Us")
	private WebElement contactUs;

	@FindBy(xpath = "//a[@title='Facebook']")
	private WebElement facebook;

	@FindBy(xpath = "//a[@title='Linkedin']")
	private WebElement linkedin;

	@FindBy(xpath = "//a[@title='Twitter']")
	private WebElement twitter;

	@FindBy(xpath = "//a[@title='Vimeo']")
	private WebElement vimeo;

	@FindBy(name = "subscribe")
	private WebElement subscribeTxt;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement subscribeBtn;

	@FindBy(linkText = "CubeCart")
	private WebElement cubeCartLink;

	@FindBy(xpath = "//*[@id=\"main_content\"]/div[1]/ul/li")
	private static WebElement emialSuccessMSG;

	@FindBy(xpath = "//*[@id=\"newsletter_email-error\"]")
	private static WebElement emailErrorMSG;

	public String emailError() {
		return emailErrorMSG.getText();
	}

	public String emailSUccessMSG() {
		return emialSuccessMSG.getText();

	}

	public void clickSearch() {
		searchBtn.click();
	}

	public void clickRegister() {
		registerBtn.click();
	}

	public void clickBasket() {
		basketBox.click();
	}

	public void clickHome() {
		homeBtn.click();
	}

	// ================= VALIDATION METHODS =================

	// Smart Product
	public boolean isSmartProductEnabled() {
		try {
			return smartProduct.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	// Sale Item
	public boolean isSaleItemEnable() {
		try {
			return saleItems.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	// Page Title
	public String getPageTitle() {
		try {
			return pageTitle.getText();
		} catch (Exception e) {
			return "";
		}
	}

	// Facebook
	public boolean isFacebookDisplayed() {
		try {
			return facebook.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// Linkedin
	public boolean isLinkedinDisplayed() {
		try {
			return linkedin.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// Twitter
	public boolean isTwitterDisplayed() {
		try {
			return twitter.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// Vimeo
	public boolean isVimeoDisplayed() {
		try {
			return vimeo.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// Subscribe Email
	public void enterSubscribeEmail(String email) {
		subscribeTxt.clear();
		subscribeTxt.sendKeys(email);
	}

	// Subscribe Button
	public void clickSubscribe() {
		subscribeBtn.click();
	}

	// CubeCart
	public boolean isCubeCartDisplayed() {
		try {
			return cubeCartLink.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean basketEnabled() {
		try {
			return basketBox.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

}
