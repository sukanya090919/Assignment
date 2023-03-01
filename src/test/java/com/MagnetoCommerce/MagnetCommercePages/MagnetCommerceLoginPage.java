package com.MagnetoCommerce.MagnetCommercePages;

import com.SeleniumAction.SeleniumAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MagnetCommerceLoginPage {
    public WebDriver driver;
    SeleniumAction seleniumActions;

    public MagnetCommerceLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumAction(driver);
    }

    @FindBy(id = "email")
    WebElement usernameInputBox;

    @FindBy(id = "pass")
    WebElement passwordInputBox;

    @FindBy(xpath = "//button[@class='action login primary']/span[text()='Sign In']")
    WebElement signInButton;

    public void loginMagnetoCommerce(String username, String password) throws InterruptedException {
        seleniumActions.enterValueOnTextField(usernameInputBox, username);
        seleniumActions.enterValueOnTextField(passwordInputBox, password);
        seleniumActions.clickOnElement(signInButton);


    }
}
