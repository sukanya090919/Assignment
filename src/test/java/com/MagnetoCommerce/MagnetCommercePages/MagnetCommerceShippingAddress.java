package com.MagnetoCommerce.MagnetCommercePages;

import com.ReadFromFiles.ReadDataFromJSON;
import com.SeleniumAction.SeleniumAction;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MagnetCommerceShippingAddress {
    public WebDriver driver;
    SeleniumAction seleniumActions;
    ReadDataFromJSON readFromJSON;

    public MagnetCommerceShippingAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumAction(driver);
        readFromJSON=new ReadDataFromJSON();

    }

    @FindBy(css="input[name='company']")
    WebElement companyInputBox;

    @FindBy(css="input[name='street[0]']")
    WebElement streetAddressInputBox;

    @FindBy(css="input[name='city']")
    WebElement cityInputBox;

    @FindBy(css="input[name='postcode']")
    WebElement postalCodeInputBox;

    @FindBy(css="input[name='telephone']")
    WebElement phoneNumberInputBox;

    @FindBy(xpath = "//span[text()='Ship here']")
    WebElement shipHereButton;

    @FindBy(xpath = "//span[@class='counter-number']")
    WebElement nextButton;
    @FindBy(xpath = "//span[text()='Place Order']")
    WebElement placeOrderButton;




    public void fillAllCheckoutDetails() throws InterruptedException, IOException, ParseException {
        seleniumActions.enterValueOnTextField(companyInputBox, ReadDataFromJSON.readFile("Company"));
        seleniumActions.enterValueOnTextField(streetAddressInputBox, ReadDataFromJSON.readFile("StreetAddress"));
        seleniumActions.enterValueOnTextField(cityInputBox, ReadDataFromJSON.readFile("City"));
        seleniumActions.enterValueOnTextField(phoneNumberInputBox, ReadDataFromJSON.readFile("PhoneNumber"));
        seleniumActions.enterValueOnTextField(postalCodeInputBox, ReadDataFromJSON.readFile("Zip/PostalCode"));
    }
    public void enterCountryAndState()
    {
       WebElement selectCountry=driver.findElement(By.xpath("//div[@id='shipping-new-address-form']//select[@name='country_id']"));
       seleniumActions.selectValueFromDropDown(selectCountry,"India","text");
       WebElement selectState = driver.findElement(By.xpath("//div[@id='shipping-new-address-form']//select[@name='region_id']"));
       seleniumActions.selectValueFromDropDown(selectState,"Telangana","text");
    }
    public void shippingMethod()
    {
        WebElement shippingMethods=driver.findElement(By.xpath("//input[@name='ko_unique_2']"));
        seleniumActions.clickOnElement(shippingMethods);
    }

     public void fillAddress(String company,String city,String phone,String zipcode,String strtaddress)
     {
         companyInputBox.sendKeys(company);
         cityInputBox.sendKeys(city);
         phoneNumberInputBox.sendKeys(phone);
         postalCodeInputBox.sendKeys(zipcode);
         streetAddressInputBox.sendKeys(strtaddress);
     }
    public void clickOnPlaceOrder()
    {
        seleniumActions.clickOnElement(shipHereButton);
    }
    public void clickOnNextButton()
    {
        seleniumActions.clickOnElement(nextButton);
    }
    public void placeOrderButton()
    {
        seleniumActions.clickOnElement(placeOrderButton);
    }

}



