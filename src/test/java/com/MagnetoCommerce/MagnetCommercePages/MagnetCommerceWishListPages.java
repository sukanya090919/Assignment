package com.MagnetoCommerce.MagnetCommercePages;

import com.SeleniumAction.SeleniumAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MagnetCommerceWishListPages {
    public WebDriver driver;
    SeleniumAction seleniumActions;

    public MagnetCommerceWishListPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumAction(driver);
    }
    @FindBy(xpath="//span[text()='Add All to Cart']")
    WebElement addAllToCart;

    public void addItemToAddToCart() {

        SeleniumAction.clickOnElement(addAllToCart);

    }
}

