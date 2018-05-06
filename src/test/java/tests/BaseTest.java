package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    int baseTimeout = 5;

    @BeforeClass
    public void beforeClass(){
        driver = Driver.getInstance();
        driver.manage().timeouts().implicitlyWait(baseTimeout, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, baseTimeout);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    protected WebDriver getWebDriver() {
        return driver;
    }
}
