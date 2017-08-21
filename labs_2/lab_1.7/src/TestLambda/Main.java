package TestLambda;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by stas on 14.08.2017.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] integers = new Integer[20];
        Random random = new Random();
        for (int i = 0; i < integers.length ; i++) {
            integers[i] = random.nextInt(1000);
        }
        System.out.println("Before sorting: " + Arrays.toString(integers));

        Arrays.sort(integers,(firstNumber, secondNumber) -> {
            return Integer.compare(firstNumber,secondNumber);
        });
        System.out.println("After sorting: " + Arrays.toString(integers));

        List<String> stringList = new ArrayList<>();
        stringList.add("Stas");
        stringList.add("Harbor");
        stringList.add("Old");
        stringList.add("Toad");
        stringList.add("Kat");

        System.out.println("Before sorting: " + stringList.toString());

        Collections.sort(stringList,(first,second) -> second.compareTo(first));

        System.out.println("After sorting: " + stringList.toString());

    }
}
