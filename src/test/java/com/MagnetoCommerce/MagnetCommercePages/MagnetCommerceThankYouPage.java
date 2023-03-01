package com.MagnetoCommerce.MagnetCommercePages;

import com.SeleniumAction.SeleniumAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MagnetCommerceThankYouPage {
    public WebDriver driver;
    SeleniumAction seleniumActions;

    public MagnetCommerceThankYouPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumAction(driver);
    }

    @FindBy(xpath="//a[@class='order-number']/strong")
    WebElement getOrderNumber;

    @FindBy(xpath="//span[text()='February 27, 2023']")
    WebElement dateOfPurchase;
    @FindBy(xpath = "//div[contains(@class,'billing-address-details')]")
    WebElement addressBox;

    public void getOrderIDAndVerify()
    {
        String orderId=getOrderNumber.getText();

        System.out.println("Order Id==="+orderId);
        seleniumActions.clickOnElement(getOrderNumber);
        Assert.assertTrue(getOrderNumber.isDisplayed());
        Assert.assertTrue(dateOfPurchase.isDisplayed());
        Assert.assertTrue(addressBox.isDisplayed());

    }

}
