package com.MagnetoCommerce.MagnetCommercePages;

import com.SeleniumAction.SeleniumAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MagnetCommerceGotoCartAndProceedToCheckout {
    public WebDriver driver;
    JavascriptExecutor jse;
    SeleniumAction seleniumActions;

    public MagnetCommerceGotoCartAndProceedToCheckout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        jse = (JavascriptExecutor) driver;
        seleniumActions = new SeleniumAction(driver);
    }

    @FindBy(xpath = "//span[@class='text']/..")
    WebElement cartButton;
    @FindBy(xpath="//span[text()='View and Edit Cart']")
    WebElement viewAndEditCartLink;

    @FindBy(xpath = "//div[@class='primary']//button[text()='Proceed to Checkout']")
    WebElement checkoutButton;

    @FindBy(xpath="//span[text()='New Address']")
    WebElement newAddressButton;



   public void clickOnCartAndProceedToCheckOut() throws InterruptedException {
       Thread.sleep(3000);
       SeleniumAction.clickOnElement(cartButton);

       Thread.sleep(2000);
       SeleniumAction.clickOnElement(checkoutButton);

       Thread.sleep(5000);
       //jse.executeScript("arguments[0].click()",newAddressButton);
       SeleniumAction.clickOnElement(newAddressButton);
       Thread.sleep(3000);


   }

   }
