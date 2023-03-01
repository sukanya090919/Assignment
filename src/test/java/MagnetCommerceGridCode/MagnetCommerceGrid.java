package MagnetCommerceGridCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MagnetCommerceGrid {
    public WebDriver driver;
    public DesiredCapabilities desiredCapabilities;
    @Parameters({"browser"})
    @Test
    public void setUp(String browser) throws MalformedURLException {
        switch (browser){
            case "chrome":
                desiredCapabilities = new DesiredCapabilities();
                ChromeOptions chromeOptions=new ChromeOptions();
                desiredCapabilities.setCapability("browserName","chrome");
                chromeOptions.merge(desiredCapabilities);
                driver=new RemoteWebDriver(new URL(" http://172.18.3.134:4444"),chromeOptions);
                break;
            case "edge":
                desiredCapabilities = new DesiredCapabilities();
                EdgeOptions edgeOptions=new EdgeOptions();
                desiredCapabilities.setCapability("browserName","edge");
                edgeOptions.merge(desiredCapabilities);
                driver=new RemoteWebDriver(new URL(" http://172.18.3.134:4444"),edgeOptions);
                break;
        }
        driver.get("https://magento.softwaretestingboard.com/customer/account/");
    }

    @AfterTest
    public void stopSession()
    {
        driver.quit();
    }
}




