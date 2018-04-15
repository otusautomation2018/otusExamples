package tests.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import tests.Driver;
import tests.TestListener;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Listeners(TestListener.class)
public class SomeTest {
    WebDriver driver;
    String baseUrl = "http://book.theautomatedtester.co.uk";

    @BeforeClass
    public void start(){
        driver = new Driver().getDriver("chrome");
    }

    @Test(groups = {"regression", "smoke"})
    public void radiobuttonTest() {

        String uri = "/chapter1";

        driver.get(baseUrl + uri);

        WebElement radioButton = driver.findElement(By.id("radiobutton"));
        radioButton.click();

        assertTrue(radioButton.isSelected());
    }

    @Test(groups = {"regression"})
    public void clickLinkTest() {

        String uri = "/chapter1";

        driver.get(baseUrl + uri);

        WebElement homePageLink = driver.findElement(By.linkText("Home Page"));
        homePageLink.click();

        WebElement chapterOneLink = driver.findElement(By.linkText("Chapter1"));
        String chapterOneLinkText = chapterOneLink.getText();

        assertEquals(chapterOneLinkText, "Chapter1", "link not found");
        assertFalse(driver.getCurrentUrl().contains(uri));
    }

    @Test(dataProvider = "lesson3_data_provider")
    public void dataProviderTest(String parameterOne, String parameterTwo) {
        assertEquals((Integer) (Integer.valueOf(parameterOne) + 1), Integer.valueOf(parameterTwo));
    }

    @DataProvider(name = "lesson3_data_provider")
    public Object[][] dataProvider() {
        return new Object[][] {{"1", "2"},{"3", "4"}};
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }
}
