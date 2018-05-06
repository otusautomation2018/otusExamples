package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    public static String driverName;

    public WebDriver createFireFoxDriver() {
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public WebDriver createOperaDriver() {
        OperaDriver driver = new OperaDriver();
        return driver;
    }

    public WebDriver createChromeDriver() {
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public WebDriver createSafariDriver() {
        WebDriver driver = new SafariDriver();
        return driver;
    }

    public WebDriver getDriver() {
//        driverName = System.getProperty("webDriver");
//        driverName = PropertyReader.getPropertyFromFile("properties/settings.properties", "webDriver");
        if (driverName == null) driverName = "chrome";
        switch (driverName){
            case "chrome": return createChromeDriver();
            case "firefox": return createFireFoxDriver();
            case "opera": return createOperaDriver();
            case "safari": return createSafariDriver();
            default: return createChromeDriver();
        }
    }
}
