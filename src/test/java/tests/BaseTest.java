package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    public String baseUrl = "http://book.theautomatedtester.co.uk";

    @BeforeClass
    public void start(){
        driver = new Driver().getDriver("chrome");
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
