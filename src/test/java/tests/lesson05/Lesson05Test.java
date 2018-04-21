package tests.lesson05;

import org.testng.annotations.Test;
import utils.PropertyReader;

public class Lesson05Test {

    @Test
    public void propertyTest() {
        System.out.println("The property: " + PropertyReader.getPropertyFromFile("properties/settings.properties", "timeout"));
    }
}
