package com.JBK.project_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Initialize {
	@FindBy(linkText = "Login here")
	private static WebElement loginHere_link;

	@FindBy(xpath = "//input[@name=\"title\"]")
	private static WebElement title;
	@FindBy(xpath = "//input[@name=\"first_name\"]")
	private static WebElement firstName;
	@FindBy(xpath = "//input[@name=\"last_name\"]")
	private static WebElement lastNamElement;
	@FindBy(xpath = "//input[@name=\"email\"]")
	private static WebElement email;
	@FindBy(xpath = "//input[@name=\"phone\"]")
	private static WebElement phone;
	@FindBy(xpath = "//input[@name=\"mobile\"]")
	private static WebElement mobile;
	@FindBy(xpath = "//input[@id=\"password\"]")
	private static WebElement password;
	@FindBy(xpath = "//input[@id=\"passconf\"]")
	private static WebElement confermPassword;
	@FindBy(xpath = "//input[@id=\"terms\"]")
	private static WebElement checkbox1_TermCondition;
	@FindBy(xpath = "//input[@id=\"mailing\"]")
	private static WebElement checkbox_mailing;
	@FindBy(xpath = "//input[@id=\"register_submit\"]")
	private static WebElement register_btn;
	@FindBy(xpath = "//button[@type=\"reset\"]")
	private static WebElement reset_btn;
	
	@FindBy(xpath = "//*[@id=\"main_content\"]/div[1]/ul/li") private static WebElement registerSuccess;
	
	@FindBy(xpath = "//*[@id=\"email-error\"]") private static WebElement invalideEmail;
	
	@FindBy(xpath = "//*[@id=\"email-error\"]") private static WebElement dupliateEmail;
	@FindBy(xpath = "//*[@id=\"first_name-error\"]") private static WebElement emptynameError;
	@FindBy(xpath = "//*[@id=\"password-error\"]") private static WebElement passwordError;
	
	@FindBy(xpath = "//*[@id=\"element-breadcrumbs\"]/ul/li[1]/a/span[2]") private static WebElement home_element;
	@FindBy(xpath = "//*[@id=\"element-breadcrumbs\"]/ul/li[2]/a/span") private static WebElement register_eleElement;
	
	@FindBy(xpath = "//*[@id=\"box-navigation\"]/section/ul/li[1]/a/svg/use") private static WebElement myStore;
	@FindBy(xpath = "//*[@id=\"content_homepage\"]/h1") private static WebElement myStoreMSG;
	public String myStoreSuccessMSG()
	
	{
		return myStoreMSG.getText();
	}
	
	public void clickMyStore()
	{
		myStore.click();
	}
	public static WebElement getHome_element() {
		return home_element;
	}

	public static void setHome_element(WebElement home_element) {
		RegisterPage.home_element = home_element;
	}

	public static WebElement getRegister_eleElement() {
		return register_eleElement;
	}

	public static void setRegister_eleElement(WebElement register_eleElement) {
		RegisterPage.register_eleElement = register_eleElement;
	}

	public String getSuccess()
	{
		return registerSuccess.getText();
	}

	public String InvalideEmailMSG()
	{
		return invalideEmail.getText();
	}
	public String passwordErrorMSG()
	{
		return passwordError.getText();
	}
	public String emptyFirstNameMSG()
	{
		return emptynameError.getText();
	}
	
	public String duplicateEmialMSG()
	{
		return dupliateEmail.getText();
	}
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public void title(String new_title) {
		title.sendKeys(new_title);

	}

	public void first_name(String new_firstname) {
		firstName.sendKeys(new_firstname);
	}

	public void last_name(String new_lastname) {
		lastNamElement.sendKeys(new_lastname);
	}

	public void email(String new_email) {
		email.sendKeys(new_email);
	}

	public void phone(long new_phone) {

		String phoneStr = String.valueOf(new_phone);

		if (!phoneStr.matches("\\d{10}")) {
			throw new IllegalArgumentException("Phone number must be exactly 10 digits");
		}

		phone.clear();
		phone.sendKeys(phoneStr);
	}

	public void mobile(long new_mobile) {

		String mobileStr = String.valueOf(new_mobile);

		if (!mobileStr.matches("\\d{10}")) {
			throw new IllegalArgumentException("Mobile number must be exactly 10 digits");
		}

		mobile.clear();
		mobile.sendKeys(mobileStr);
	}

	public void password(String new_password)

	{
		password.sendKeys(new_password);
		confermPassword.sendKeys(new_password);
	}
	
	public void register_btn()
	{
		register_btn.click();
	}
	public void reset_btn() {
		reset_btn.click();
	}
	public void checkbox1_termaCondition()
	{
		checkbox1_TermCondition.click();
	}
	public void checkbox2_Mailing()
	{
		checkbox_mailing.click();
	}

	public static WebElement getLoginHere_link() {
		return loginHere_link;
	}

	public static void setLoginHere_link(WebElement loginHere_link) {
		RegisterPage.loginHere_link = loginHere_link;
	}

	public static WebElement getCheckbox1_TermCondition() {
		return checkbox1_TermCondition;
	}

	public static void setCheckbox1_TermCondition(WebElement checkbox1_TermCondition) {
		RegisterPage.checkbox1_TermCondition = checkbox1_TermCondition;
	}

	public static WebElement getCheckbox_mailing() {
		return checkbox_mailing;
	}

	public static void setCheckbox_mailing(WebElement checkbox_mailing) {
		RegisterPage.checkbox_mailing = checkbox_mailing;
	}

	public static WebElement getRegister_btn() {
		return register_btn;
	}

	public static void setRegister_btn(WebElement register_btn) {
		RegisterPage.register_btn = register_btn;
	}

	public static WebElement getReset_btn() {
		return reset_btn;
	}

	public static void setReset_btn(WebElement reset_btn) {
		RegisterPage.reset_btn = reset_btn;
	}
	

}
