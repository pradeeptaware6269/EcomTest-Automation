package com.JBK.project_Pages;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.PageFactory;

	public class Initialize {

		public Initialize(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	}

