package com.SeleniumAction;

import com.Wait.SeleniumWait;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumAction {
    public static WebDriver driver;

    public SeleniumAction(WebDriver driver) {
        this.driver = driver;
        SeleniumWait SeleniumWaits = new SeleniumWait(driver);
    }

    /**
     * click on elements
     *
     * @param element
     */
    public static boolean clickOnElement(WebElement element) {
        boolean flag = false;
        try {
            element.click();
            flag = true;
        } catch (NoSuchElementException | ElementNotInteractableException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (StaleElementReferenceException see) {
            System.out.println(see.toString());
            flag = false;
        }
        return flag;
    }

    public static boolean hoverOnElements(WebElement element) {
        boolean flag = false;
        Actions action = new Actions(driver);
        try {
            action.moveToElement(element).build().perform();
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (ElementNotInteractableException eic) {
            System.out.println(eic.toString());
            flag = false;
        }
        return flag;
    }



    /**
     * enter value on text field
     *
     * @Param element
     * @Param data
     */
    public boolean enterValueOnTextField(WebElement element, String data) {
        boolean flag = false;
        try {
            element.sendKeys(data);
            flag = true;
        } catch (NoSuchElementException nse) {
            System.out.println(nse.toString());
            flag = false;
        } catch (StaleElementReferenceException see) {
            System.out.println(see.toString());
            flag = false;
        } catch (ElementNotInteractableException eie) {
            System.out.println(eie.toString());
            flag = false;
        }
        return flag;
    }

    /**
     * Select an item from the list
     * @param element
     * @param data
     * @param typeSelect
     * @return
     */
    public boolean selectValueFromDropDown(WebElement element, String data, String typeSelect){
        try{
            Select select = new Select(element);
            switch (typeSelect){
                case "index":
                    select.selectByIndex(Integer.parseInt(data));
                    break;
                case "value":
                    select.selectByValue(data);
                    break;
                case "text":
                    select.selectByVisibleText(data);
                    break;
            }
            return true;
        }catch (Exception e){

            return false;
        }
    }

    /**
     * click on elements
     *
     * @param by
     * @return
     */
    public boolean clickOnElement(By by) {
        try {
            driver.findElement(by).click();
            return true;
        } catch (Exception e) {

            return false;
        }
    }
}




