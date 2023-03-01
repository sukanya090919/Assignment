package com.MagnetoCommerce.BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class MagnetoCommerceBasePages {
    public WebDriver driver;

    @BeforeSuite
    public void initializeReportAndWebDriver(){
        System.out.println("Report is Intailzed");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeTest
    public void launchApplication()
    {
        driver.get("https://magento.softwaretestingboard.com/customer/account/");
    }

//    @AfterSuite
//    public void quitSession(){
//        driver.quit();

    }


