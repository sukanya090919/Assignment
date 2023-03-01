package com.Wait;

import com.CONSTANT.TimeWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWait {
    WebDriver driver;
    WebDriverWait webDriverWait;
    TimeWait timeWait;

    public SeleniumWait(WebDriver driver){
        timeWait = new TimeWait();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeWait.EXPLICITWAIT));
    }

    public WebElement waitForElementToBeClickable(WebElement element){
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}


