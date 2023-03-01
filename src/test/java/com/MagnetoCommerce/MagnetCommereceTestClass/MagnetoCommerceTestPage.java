package com.MagnetoCommerce.MagnetCommereceTestClass;

import com.MagnetoCommerce.BasePage.MagnetoCommerceBasePages;
import com.MagnetoCommerce.MagnetCommercePages.*;
import com.ReadFromFiles.ReadDataFromJSON;
import com.SeleniumAction.SeleniumAction;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class MagnetoCommerceTestPage extends MagnetoCommerceBasePages {

    public MagnetCommerceLoginPage magnetoCommerceLoginPage;
    public MagnetCommerceHomePage magnetoCommerceHomePage;
    public MagnetCommerceBagPage bagPage;
    public MagnetCommerceWishListPages magnetCommerceWishListPage;
    public MagnetCommerceGotoCartAndProceedToCheckout gotoCartAndProceedToCheckout;
    public MagnetCommerceShippingAddress shippingAddress;
    public MagnetCommerceThankYouPage thankYouPage;
    public ReadDataFromJSON readFromJSON;

    @BeforeClass
    public void initalizePages() {
        magnetoCommerceLoginPage = new MagnetCommerceLoginPage(driver);
        magnetoCommerceHomePage = new MagnetCommerceHomePage(driver);
        bagPage = new MagnetCommerceBagPage(driver);
        magnetCommerceWishListPage = new MagnetCommerceWishListPages(driver);
        gotoCartAndProceedToCheckout = new MagnetCommerceGotoCartAndProceedToCheckout(driver);
        shippingAddress = new MagnetCommerceShippingAddress(driver);
        thankYouPage = new MagnetCommerceThankYouPage(driver);
        readFromJSON = new ReadDataFromJSON();

    }


    @Test
    public void userLoginIntoApplication() throws InterruptedException {
        magnetoCommerceLoginPage.loginMagnetoCommerce("sukanyakumari19@gmail.com", "Suk@ny@19");
    }

    @Test
    public void selectItemAndVerifyCartIsEmpty() throws InterruptedException {
        magnetoCommerceLoginPage.loginMagnetoCommerce("sukanyakumari19@gmail.com", "Suk@ny@19");
        magnetoCommerceHomePage.selectAnItemFromHomePage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Click on cart and verify cart is empty
        WebElement cartButton = driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/checkout/cart/']"));
        SeleniumAction.clickOnElement(cartButton);
        WebElement emptyCartMessage = driver.findElement(By.xpath("//strong[text()='You have no items in your shopping cart.']"));
        Assert.assertTrue(emptyCartMessage.isDisplayed());
    }

    @Test
    public void VerifyWishListItem() throws InterruptedException, IOException, ParseException {
        magnetoCommerceLoginPage.loginMagnetoCommerce("sukanyakumari19@gmail.com", "Suk@ny@19");
        magnetoCommerceHomePage.selectAnItemFromHomePage();
        String nameofiteminbagpage = bagPage.getItemName(bagPage.getHighestPrice());
        System.out.println("Item name in cart" + bagPage.getItemName(bagPage.getHighestPrice()));
        bagPage.addItemToWishList(bagPage.getItemName(bagPage.getHighestPrice()));
        // magnetCommerceWishListPage.addItemToAddToCart(bagPage.getItemName(bagPage.getHighestPrice()));
        gotoCartAndProceedToCheckout.clickOnCartAndProceedToCheckOut();
        //magnetCommerceWishListPage.addItemToAddToCart(bagPage.getItemName(bagPage.getHighestPrice()));
        magnetCommerceWishListPage.addItemToAddToCart();


//        //verify WishlistIsEmpty After Adding Item TO Cart
//       WebElement verifyWishListAfterAddingItemToCart = driver.findElement(By.xpath("//span[text()='You have no items in your wish list.']"));
//       verifyWishListAfterAddingItemToCart.getText();
//       Assert.assertTrue(verifyWishListAfterAddingItemToCart.isDisplayed());
//

//        //Fill the Shipping Address
        shippingAddress.fillAddress("Motivity", "Hyderabad", "3698745214", "235646", "Ameerpet");
        //shippingAddress.fillAllCheckoutDetails();
        shippingAddress.enterCountryAndState();
        shippingAddress.shippingMethod();
        shippingAddress.clickOnPlaceOrder();
        shippingAddress.clickOnNextButton();
        shippingAddress.clickOnPlaceOrder();
        thankYouPage.getOrderIDAndVerify();

    }
}


