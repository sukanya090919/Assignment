package com.MagnetoCommerce.MagnetCommercePages;

import com.SeleniumAction.SeleniumAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MagnetCommerceHomePage {
    public WebDriver driver;
    SeleniumAction seleniumActions;

    public MagnetCommerceHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumAction(driver);
    }

    @FindBy(xpath = "//span[text()='Gear']")
    WebElement selectGearOption;

    @FindBy(xpath = "//ol//a[text()='Bags']")
    WebElement selectBagsOption;


    public void selectAnItemFromHomePage() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(selectGearOption).click().build().perform();

        Thread.sleep(3000);
        //select bags
        selectBagsOption.click();
       // action.moveToElement(selectBagsOption).click();
       // SeleniumActions.clickOnElement(selectBagsOption);
        Thread.sleep(3000);
    }
}










