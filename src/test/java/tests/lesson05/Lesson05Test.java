package tests.lesson05;

import org.testng.annotations.Test;
import utils.PropertyReader;

public class Lesson05Test {

    @Test(enabled = false)
    public void propertyTest() {
//        Не работает
        System.out.println("The property: " + PropertyReader.getPropertyFromFile("properties/settings.properties", "timeout"));
    }
}
