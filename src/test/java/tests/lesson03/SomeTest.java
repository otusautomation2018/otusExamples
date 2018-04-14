package tests.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.Driver;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SomeTest {
    WebDriver driver;
    String baseUrl = "http://book.theautomatedtester.co.uk";

    @BeforeClass
    public void start(){
        driver = new Driver().getDriver("chrome");
    }

    @Test
    public void radiobuttonTest() {

        String uri = "/chapter1";

        driver.get(baseUrl + uri);

        WebElement radioButton = driver.findElement(By.id("radiobutton"));
        radioButton.click();

        assertTrue(radioButton.isSelected());
    }

    @Test
    public void clickLinkTest() {

        String uri = "/chapter1";

        driver.get(baseUrl + uri);

        WebElement homePageLink = driver.findElement(By.linkText("Home Page"));
        homePageLink.click();

        assertFalse(driver.getCurrentUrl().contains(uri));
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
