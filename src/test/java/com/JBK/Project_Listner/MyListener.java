package com.JBK.Project_Listner;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.JBK.Project_Base.BaseClass;

public class MyListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test case execution started: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("Test Case Failed: " + result.getName());

		Object currentClass = result.getInstance();

		WebDriver driver = ((BaseClass) currentClass).driver;

		if (driver == null) {
			System.out.println("Driver is NULL !");
			return;
		} else {

			String path = System.getProperty("user.dir") + File.separator + "ScreenShot" + File.separator
					+ result.getName() + ".png";

			try {
				TakesScreenshot tks = (TakesScreenshot) driver;
				File source = tks.getScreenshotAs(OutputType.FILE);
				File target = new File(path);

				FileHandler.copy(source, target);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case is Skipped: " + result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Execution completed !!");
	}
}