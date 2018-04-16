package tests.lesson04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Lesson04Test extends BaseTest {
    String uri = "/chapter1";

    @Test
    public void useSelectTest() {
        driver.get(baseUrl + uri);

        WebElement selectElement = driver.findElement(By.id("selecttype"));
        Select select = new Select(selectElement);
        select.selectByValue("Selenium Grid");
    }

    @Test
    public void useWaitTest() {
        driver.get(baseUrl + uri);

        String expectedText = "The following text has been loaded from another page on this site. It has been " +
                "loaded in an asynchronous fashion so that we can work through the AJAX section of this chapter";

        WebElement linkAjax = driver.findElement(By.id("loadajax"));
        linkAjax.click();

        WebElement textAreaAjax = driver.findElement(By.cssSelector("div[id='ajaxdiv'] > p"));

        webDriverWait.until(
                ExpectedConditions.textToBePresentInElement(textAreaAjax, expectedText));

        assertTrue(textAreaAjax.isDisplayed());
        assertEquals(textAreaAjax.getText(), expectedText);
    }

    @Test
    public void useSiblingTest(){
        String uri = "/chapter2";
        driver.get(baseUrl + uri);

        WebElement buttonSibling = driver.findElement(By.xpath("//*[@id='but1']/following-sibling::input"));
        buttonSibling.click();

        assertTrue(buttonSibling.isDisplayed());
    }
}
