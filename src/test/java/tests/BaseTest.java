package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    public String baseUrl = "http://book.theautomatedtester.co.uk";
    public WebDriverWait webDriverWait;
    int baseTimeout = 10;

    @BeforeClass
    public void start(){
        driver = new Driver().getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(baseTimeout, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, baseTimeout);
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
