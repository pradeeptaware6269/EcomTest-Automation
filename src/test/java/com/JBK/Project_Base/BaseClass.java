package com.JBK.Project_Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.JBK.project_Pages.LandingPage;
import com.JBK.project_Pages.LoginPage;
import com.JBK.project_Pages.RegisterPage;

public class BaseClass {

    public WebDriver driver;
    public LandingPage lp;
    public LoginPage login;
    public RegisterPage register;

    @BeforeMethod
    @Parameters({"browser","url"})
    public void setUp(String brName, String URL) {

        if (brName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

        } else if (brName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else if (brName.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();

        } else {
            throw new IllegalArgumentException("Invalid Browser Name");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(3));

        driver.get(URL);

        lp = new LandingPage(driver);
        login = new LoginPage(driver);
        register = new RegisterPage(driver);
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}