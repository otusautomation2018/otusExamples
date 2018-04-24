package tests.lesson05;

import org.testng.annotations.Test;
import utils.PropertyReader;
import utils.builders.Person;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Lesson05Test {

    @Test
    public void propertyTest() {
        String property = PropertyReader.getPropertyFromFile("properties/settings.properties", "timeout");
        System.out.println("The property: " + property);
        assertEquals("10", property, "ERROR: property not equal 10");
    }

    @Test
    public void usePageObjectTest(){

    }

    @Test
    public void useBuilderTest() {
        String city = "NY";
        String firstName = "John";

        Person person =
                new Person.
                        PersonBuilder("","","")
                        .city(city)
                        .firstName(firstName)
                        .isEmployed(true)
                        .isFemale(false)
                        .createPerson();

        assertEquals(person.city, city);
        assertEquals(person.firstName, firstName);
        assertTrue(person.isEmployed);
        assertFalse(person.isFemale);
    }
}
