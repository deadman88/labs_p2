package TestStream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by stas on 16.08.2017.
 */
public class Main {
    public static void main(String[] args) {
        int x = 10;
        IntStream intStream = Stream.iterate(x, n -> n + 10).mapToInt(Integer::intValue).limit(10);
//        intStream.limit(10).forEach(System.out::println);
//        Stream<Integer> stream = intStream.boxed();
//        List<Integer> integerList = stream.collect(Collectors.toList());


    }
}
