package com.MagnetoCommerce.MagnetCommercePages;

import com.SeleniumAction.SeleniumAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MagnetCommerceBagPage {
    public WebDriver driver;
    SeleniumAction seleniumActions;

    public MagnetCommerceBagPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumAction(driver);
    }

    @FindBy(xpath = "//span[text()='Add to Wish List']")
    WebElement wishlistButton;

    public String getHighestPrice() {
        List<WebElement> listofprices = driver.findElements(By.xpath("//span[@data-price-type='finalPrice']"));
        List<Float> allprices = new ArrayList<>();

        for (WebElement element : listofprices) {
            allprices.add(Float.parseFloat(element.getText().replace("$", "")));
        }
        Float highestprice = Collections.max(allprices);
        String highestpriceinString = highestprice.toString();
        System.out.println("Highest Amount in cart =::" + highestpriceinString);
        return highestpriceinString;

    }

    public String getItemName(String price) {
        String nameOfItem = driver.findElement(By.xpath("//span[@data-price-type='finalPrice']/span[contains(.,'" + price + "')]/parent::span/parent::span/parent::div/preceding-sibling::strong/a")).getText();
        System.out.println(nameOfItem);
        return nameOfItem;
    }

    public void addItemToWishList(String name) {
        WebElement selecteditemimage = driver.findElement(By.xpath("//img[@class='product-image-photo']/parent::span/parent::span/parent::a/following-sibling::div/strong/a[contains(.,'" + name + "')]"));
        SeleniumAction.hoverOnElements(selecteditemimage);
        SeleniumAction.clickOnElement(selecteditemimage);
        SeleniumAction.clickOnElement(wishlistButton);

    }
}


