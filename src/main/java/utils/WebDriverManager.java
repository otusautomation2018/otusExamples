package utils;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    private static WebDriver driver;

    public static WebDriver getInstance() {
        if(driver == null) {
            driver = new Driver().getDriver();
        }
        return driver;
    }
}
