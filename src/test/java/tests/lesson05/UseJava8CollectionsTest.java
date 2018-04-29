package tests.lesson05;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UseJava8CollectionsTest {

    @Test
    public void defaultDatatest() {
        ArrayList<Float> priceFlightsList = createFloatList();

        printArrayList(priceFlightsList, "defaultDatatest: default array: ");
    }

    @Test
    public void test() {
        ArrayList<Float> priceFlightsList = createFloatList();

        Collections.sort(priceFlightsList, Float::compareTo);

        printArrayList(priceFlightsList, "Use java 9:");
    }

    @Test
    public void testJ9Comparator() {
        ArrayList<Float> priceFlightsList = createFloatList();

        Collections.sort(priceFlightsList, Comparator.naturalOrder());

        printArrayList(priceFlightsList, "testJ9Comparator: Use java 9:");
    }

    @Test
    public void testJ9Streams() {
        ArrayList<Float> priceFlightsList = createFloatList();

        priceFlightsList.stream().parallel().sorted();

        printArrayList(priceFlightsList, "testJ9Streams: Use java 9:");
    }

    @Test
    public void testJ9StreamsP() {
        ArrayList<Float> priceFlightsList = createFloatList();

        priceFlightsList.stream().parallel().sorted(Comparator.naturalOrder());

        printArrayList(priceFlightsList, "testJ9StreamsP: Use java 9:");
    }

    @Test
    public void testJ8() {
        ArrayList<Float> priceFlightsList = createFloatList();
        printArrayList(sortUseJava8(priceFlightsList), "testJ8: Use java 8:");
    }

    public ArrayList createFloatList(){
        ArrayList<Float> priceFlightsList = new ArrayList<>();
        priceFlightsList.add((float) 2.4);
        priceFlightsList.add((float) 1.4);
        priceFlightsList.add((float) 0.98);
        priceFlightsList.add((float) 5.4);
        priceFlightsList.add((float) 6.0);
        priceFlightsList.add((float) 3.1);
        priceFlightsList.add((float) 1.1);
        return priceFlightsList;
    }

    public ArrayList sortUseJava8(ArrayList list) {
        ArrayList<Float> priceFlightsList = list;
        Collections.sort(priceFlightsList, (o1, o2) -> o1.compareTo(o2));
        return list;
    }

    public void printArrayList(ArrayList list, String text){
        System.out.println("============================");
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println("DEBUG");
        System.out.println(text);
        list.forEach(System.out::println);
        System.out.println();
        System.out.println("DEBUG");
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println("============================");
    }
}
