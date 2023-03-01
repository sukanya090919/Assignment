package com.MagnetoCommerce.MagnetCommereceTestClass;

import com.MagnetoCommerce.BasePage.MagnetoCommerceBasePages;
import com.MagnetoCommerce.MagnetCommercePages.*;
import com.SeleniumAction.SeleniumAction;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MagnetCommerceLamdaTest extends MagnetoCommerceBasePages {
    public MagnetCommerceLoginPage magnetoCommerceLoginPage;
    public MagnetCommerceHomePage magnetoCommerceHomePage;
    public MagnetCommerceBagPage bagPage;
    public MagnetCommerceWishListPages magnetCommerceWishListPage;
    public MagnetCommerceGotoCartAndProceedToCheckout gotoCartAndProceedToCheckout;
    public MagnetCommerceShippingAddress shippingAddress;
    public MagnetCommerceThankYouPage thankYouPage;




    @BeforeTest
    public void setUpLamdaTest() throws InterruptedException, IOException, ParseException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        desiredCapabilities.setCapability("browserName", "chrome");
        desiredCapabilities.setCapability("platform", "win10");
        desiredCapabilities.setCapability("browserVersion", "108");
        desiredCapabilities.setCapability("build", "QA");
        desiredCapabilities.setCapability("project", "Magnet Commerce");

        try {
            driver = new RemoteWebDriver(new URL("https://sukanyakumari2085:QY39Dp2lRZ5lSJJMnvSKiCyL6JqyCLUPqS0qmZGxcJXSZoIdaB@hub.lambdatest.com/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        driver.get("https://magento.softwaretestingboard.com/customer/account/");
    }
    @BeforeClass
    public void initalizePages() {
        magnetoCommerceLoginPage = new MagnetCommerceLoginPage(driver);
        magnetoCommerceHomePage = new MagnetCommerceHomePage(driver);
        bagPage = new MagnetCommerceBagPage(driver);
        magnetCommerceWishListPage = new MagnetCommerceWishListPages(driver);
        gotoCartAndProceedToCheckout = new MagnetCommerceGotoCartAndProceedToCheckout(driver);
        shippingAddress = new MagnetCommerceShippingAddress(driver);
        thankYouPage = new MagnetCommerceThankYouPage(driver);
    }

        @Test
        public void userLoginIntoApplication () throws InterruptedException {
            magnetoCommerceLoginPage.loginMagnetoCommerce("sukanyakumari19@gmail.com", "Suk@ny@19");
        }

        @Test
        public void selectItemAndVerifyCartIsEmpty () throws InterruptedException {
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
        public void VerifyWishListItem () throws InterruptedException, IOException, ParseException {
            magnetoCommerceLoginPage.loginMagnetoCommerce("sukanyakumari19@gmail.com", "Suk@ny@19");
            magnetoCommerceHomePage.selectAnItemFromHomePage();
            String nameofiteminbagpage = bagPage.getItemName(bagPage.getHighestPrice());
            System.out.println("Item name in cart" + bagPage.getItemName(bagPage.getHighestPrice()));
            bagPage.addItemToWishList(bagPage.getItemName(bagPage.getHighestPrice()));
            // magnetCommerceWishListPage.addItemToAddToCart(bagPage.getItemName(bagPage.getHighestPrice()));
            gotoCartAndProceedToCheckout.clickOnCartAndProceedToCheckOut();
            //magnetCommerceWishListPage.addItemToAddToCart(bagPage.getItemName(bagPage.getHighestPrice()));
            magnetCommerceWishListPage.addItemToAddToCart();


        //verify WishlistIsEmpty After Adding Item TO Cart
       WebElement verifyWishListAfterAddingItemToCart = driver.findElement(By.xpath("//span[text()='You have no items in your wish list.']"));
       verifyWishListAfterAddingItemToCart.getText();
       Assert.assertTrue(verifyWishListAfterAddingItemToCart.isDisplayed());


        //Fill the Shipping Address
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








